package mab.booksapi.services;

import lombok.AllArgsConstructor;
import mab.booksapi.models.dtos.SearchableEntityDTO;
import mab.booksapi.repositories.IAuthorRepository;
import mab.booksapi.repositories.IBooksRepository;
import me.xdrop.fuzzywuzzy.FuzzySearch;
import me.xdrop.fuzzywuzzy.model.BoundExtractedResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class SearchService {
    
    private final IBooksRepository booksRepository;
    private final IAuthorRepository authorRepository;
    
    public List<SearchableEntityDTO> search(String query) {
        List<SearchableEntityDTO> entities = new ArrayList<>();
        entities.addAll(booksRepository.findAll().stream()
                .map(SearchableEntityDTO::fromBook)
                .toList());
        entities.addAll(authorRepository.findAll().stream()
                .map(SearchableEntityDTO::fromAuthor)
                .toList());
        
        List<SearchableEntityDTO> result = new ArrayList<>();
        List<BoundExtractedResult<SearchableEntityDTO>> results = FuzzySearch.extractTop(
                query, entities, SearchableEntityDTO::getSearchableProperty, 10);
        results.sort((o1, o2) -> (int) (o2.getScore() - o1.getScore()));
        
        for (var res : results) {
            if (res.getScore() > 50)
                result.add(res.getReferent());
        }
        
        return result;
    }
}
