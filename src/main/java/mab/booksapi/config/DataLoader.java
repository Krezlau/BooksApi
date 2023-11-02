package mab.booksapi.config;

import lombok.AllArgsConstructor;
import mab.booksapi.models.Author;
import mab.booksapi.models.Book;
import mab.booksapi.repositories.IAuthorRepository;
import mab.booksapi.repositories.IBooksRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class DataLoader implements ApplicationRunner {
    private final IBooksRepository booksRepository;
    private final IAuthorRepository authorRepository;

    public void run(ApplicationArguments args) {
        if (booksRepository.count() > 0) return;
        List<Author> a = new ArrayList<>();
        a.add(Author.builder()
                        .name("J. R. R.")
                        .surname("Tolkien")
                        .about("John Ronald Reuel Tolkien, CBE FRSL was an English writer, poet, philologist, and academic.")
                        .photo("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d4/J._R._R._Tolkien%2C_ca._1925.jpg/270px-J._R._R._Tolkien%2C_ca._1925.jpg")
                .build());
        a.add(Author.builder()
                        .name("J. K.")
                        .surname("Rowling")
                        .about("Joanne Rowling CH, OBE, HonFRSE, FRCPE, FRSL, better known by her pen name J. K. Rowling, is a British author, philanthropist, film producer, television producer, and screenwriter.")
                        .photo("https://upload.wikimedia.org/wikipedia/commons/thumb/5/5d/J._K._Rowling_2010.jpg/270px-J._K._Rowling_2010.jpg")
                .build());
        a.add(Author.builder()
                        .name("Stephen")
                        .surname("King")
                        .about("Stephen Edwin King is an American author of horror, supernatural fiction, suspense, crime, science-fiction, and fantasy novels. His books have sold more than 350 million copies, and many have been adapted into films, television series, miniseries, and comic books.")
                        .photo("https://upload.wikimedia.org/wikipedia/commons/thumb/e/e3/Stephen_King%2C_Comicon.jpg/270px-Stephen_King%2C_Comicon.jpg")
                .build());
        a.add(Author.builder()
                        .name("George R. R.")
                        .surname("Martin")
                        .about("George Raymond Richard Martin, also known as GRRM, is an American novelist and short story writer, screenwriter, and television producer. He is the author of the series of epic fantasy novels A Song of Ice and Fire, which was adapted into the Emmy Award-winning HBO series Game of Thrones.")
                        .photo("https://upload.wikimedia.org/wikipedia/commons/thumb/9/93/George_R._R._Martin_2019.jpg/270px-George_R._R._Martin_2019.jpg")
                .build());
        authorRepository.saveAll(a);

        List<Book> b = new ArrayList<>();
        b.add(Book.builder()
                        .title("The Lord of the Rings")
                        .author(a.get(0))
                        .synopsis("The Lord of the Rings is an epic high fantasy novel by the English author and scholar J. R. R. Tolkien. Set in Middle-earth, the world at some distant time in the past, the story began as a sequel to Tolkien's 1937 children's book The Hobbit, but eventually developed into a much larger work.")
                        .funFacts("The Lord of the Rings is a sequel to Tolkien's 1937 novel The Hobbit. It was published in three volumes in 1954 and 1955. The story's titular character is the Dark Lord Sauron of Mordor.")
                        .cover("https://upload.wikimedia.org/wikipedia/en/thumb/8/8e/The_Lord_of_the_Rings_The_Fellowship_of_the_Ring_%282001%29_theatrical_poster.jpg/220px-The_Lord_of_the_Rings_The_Fellowship_of_the_Ring_%282001%29_theatrical_poster.jpg")
                .build());
        b.add(Book.builder()
                        .title("The Hobbit")
                        .author(a.get(0))
                        .synopsis("The Hobbit, or There and Back Again is a children's fantasy novel by English author J. R. R. Tolkien. It was published on 21 September 1937 to wide critical acclaim, being nominated for the Carnegie Medal and awarded a prize from the New York Herald Tribune for best juvenile fiction.")
                        .funFacts("The Hobbit is set within Tolkien's fictional universe and follows the quest of home-loving Bilbo Baggins, the titular hobbit, to win a share of the treasure guarded by Smaug the dragon. Bilbo's journey takes him from light-hearted, rural surroundings into more sinister territory.")
                        .cover("https://upload.wikimedia.org/wikipedia/en/thumb/3/30/Hobbit_cover.JPG/220px-Hobbit_cover.JPG")
                .build());
        b.add(Book.builder()
                        .title("Harry Potter and the Philosopher's Stone")
                        .author(a.get(1))
                        .synopsis("Harry Potter and the Philosopher's Stone is a fantasy novel written by British author J. K. Rowling. The first novel in the Harry Potter series and Rowling's debut novel, it follows Harry Potter, a young wizard who discovers his magical heritage on his eleventh birthday, when he receives a letter of acceptance to Hogwarts School of Witchcraft and Wizardry.")
                        .funFacts("Harry Potter and the Philosopher's Stone is a fantasy novel written by British author J. K. Rowling. The first novel in the Harry Potter series and Rowling's debut novel, it follows Harry Potter, a young wizard who discovers his magical heritage on his eleventh birthday, when he receives a letter of acceptance to Hogwarts School of Witchcraft and Wizardry.")
                        .cover("https://upload.wikimedia.org/wikipedia/en/thumb/b/bf/Harry_Potter_and_the_Philosopher%27s_Stone_1st_edition_front_cover.jpg/220px-Harry_Potter_and_the_Philosopher%27s_Stone_1st_edition_front_cover.jpg")
                .build());
        b.add(Book.builder()
                        .title("Harry Potter and the Chamber of Secrets")
                        .author(a.get(1))
                        .synopsis("Harry Potter and the Chamber of Secrets is a fantasy novel written by British author J. K. Rowling and the second novel in the Harry Potter series. The plot follows Harry's second year at Hogwarts School of Witchcraft and Wizardry, during which a series of messages on the walls of the school's corridors warn that the \"Chamber of Secrets\" has been opened and that the \"heir of Slytherin\" would kill all pupils who do not come from all-magical families.")
                        .funFacts("Harry Potter and the Chamber of Secrets is a fantasy novel written by British author J. K. Rowling and the second novel in the Harry Potter series. The plot follows Harry's second year at Hogwarts School of Witchcraft and Wizardry, during which a series of messages on the walls of the school's corridors warn that the \"Chamber of Secrets\" has been opened and that the \"heir of Slytherin\" would kill all pupils who do not come from all-magical families.")
                        .cover("https://upload.wikimedia.org/wikipedia/en/thumb/c/c0/Harry_Potter_and_the_Chamber_of_Secrets.jpg/220px-Harry_Potter_and_the_Chamber_of_Secrets.jpg")
                .build());
        b.add(Book.builder()
                        .title("Harry Potter and the Prisoner of Azkaban")
                        .author(a.get(1))
                        .synopsis("Harry Potter and the Prisoner of Azkaban is a fantasy novel written by British author J. K. Rowling and is the third in the Harry Potter series. The book follows Harry Potter, a young wizard, in his third year at Hogwarts School of Witchcraft and Wizardry.")
                        .funFacts("Harry Potter and the Prisoner of Azkaban is a fantasy novel written by British author J. K. Rowling and is the third in the Harry Potter series. The book follows Harry Potter, a young wizard, in his third year at Hogwarts School of Witchcraft and Wizardry.")
                        .cover("https://upload.wikimedia.org/wikipedia/en/thumb/a/a0/Harry_Potter_and_the_Prisoner_of_Azkaban.jpg/220px-Harry_Potter_and_the_Prisoner_of_Azkaban.jpg")
                .build());
        b.add(Book.builder()
                        .title("Harry Potter and the Goblet of Fire")
                        .author(a.get(1))
                        .synopsis("Harry Potter and the Goblet of Fire is a fantasy novel written by British author J. K. Rowling and the fourth novel in the Harry Potter series. It follows Harry Potter, a wizard in his fourth year at Hogwarts School of Witchcraft and Wizardry, and the mystery surrounding the entry of Harry's name into the Triwizard Tournament, in which he is forced to compete.")
                        .funFacts("Harry Potter and the Goblet of Fire is a fantasy novel written by British author J. K. Rowling and the fourth novel in the Harry Potter series. It follows Harry Potter, a wizard in his fourth year at Hogwarts School of Witchcraft and Wizardry, and the mystery surrounding the entry of Harry's name into the Triwizard Tournament, in which he is forced to compete.")
                        .cover("https://upload.wikimedia.org/wikipedia/en/thumb/b/b6/Harry_Potter_and_the_Goblet_of_Fire_cover.png/220px-Harry_Potter_and_the_Goblet_of_Fire_cover.png")
                .build());
        b.add(Book.builder()
                        .title("Harry Potter and the Order of the Phoenix")
                        .author(a.get(1))
                        .synopsis("Harry Potter and the Order of the Phoenix is a fantasy novel written by British author J. K. Rowling and the fifth novel in the Harry Potter series. It follows Harry Potter's struggles through his fifth year at Hogwarts School of Witchcraft and Wizardry, including the surreptitious return of the antagonist Lord Voldemort, O.W.L. exams, and an obstructive Ministry of Magic.")
                        .funFacts("Harry Potter and the Order of the Phoenix is a fantasy novel written by British author J. K. Rowling and the fifth novel in the Harry Potter series. It follows Harry Potter's struggles through his fifth year at Hogwarts School of Witchcraft and Wizardry, including the surreptitious return of the antagonist Lord Voldemort, O.W.L. exams, and an obstructive Ministry of Magic.")
                        .cover("https://upload.wikimedia.org/wikipedia/en/thumb/7/70/Harry_Potter_and_the_Order_of_the_Phoenix.jpg/220px-Harry_Potter_and_the_Order_of_the_Phoenix.jpg")
                .build());
        b.add(Book.builder()
                        .title("Harry Potter and the Half-Blood Prince")
                        .author(a.get(1))
                        .synopsis("Harry Potter and the Half-Blood Prince is a fantasy novel written by British author J. K. Rowling and the sixth and penultimate novel in the Harry Potter series. Set during Harry Potter's sixth year at Hogwarts, the novel explores the past of Harry's nemesis, Lord Voldemort, and Harry's preparations for the final battle against Voldemort alongside his headmaster and mentor Albus Dumbledore.")
                        .funFacts("Harry Potter and the Half-Blood Prince is a fantasy novel written by British author J. K. Rowling and the sixth and penultimate novel in the Harry Potter series. Set during Harry Potter's sixth year at Hogwarts, the novel explores the past of Harry's nemesis, Lord Voldemort, and Harry's preparations for the final battle against Voldemort alongside his headmaster and mentor Albus Dumbledore.")
                        .cover("https://upload.wikimedia.org/wikipedia/en/thumb/b/b5/Harry_Potter_and_the_Half-Blood_Prince_cover.png/220px-Harry_Potter_and_the_Half-Blood_Prince_cover.png")
                .build());
        b.add(Book.builder()
                        .title("Harry Potter and the Deathly Hallows")
                        .author(a.get(1))
                        .synopsis("Harry Potter and the Deathly Hallows is a fantasy novel written by British author J. K. Rowling and the seventh and final novel of the Harry Potter series. It was released on 21 July 2007 in the United Kingdom by Bloomsbury Publishing, in the United States by Scholastic, and in Canada by Raincoast Books.")
                        .funFacts("Harry Potter and the Deathly Hallows is a fantasy novel written by British author J. K. Rowling and the seventh and final novel of the Harry Potter series. It was released on 21 July 2007 in the United Kingdom by Bloomsbury Publishing, in the United States by Scholastic, and in Canada by Raincoast Books.")
                        .cover("https://upload.wikimedia.org/wikipedia/en/thumb/a/a9/Harry_Potter_and_the_Deathly_Hallows.jpg/220px-Harry_Potter_and_the_Deathly_Hallows.jpg")
                .build());
        b.add(Book.builder()
                        .title("The Shining")
                        .author(a.get(2))
                        .synopsis("The Shining is a horror novel by American author Stephen King. Published in 1977, it is King's third published novel and first hardback bestseller: the success of the book firmly established King as a preeminent author in the horror genre.")
                        .funFacts("The Shining is a horror novel by American author Stephen King. Published in 1977, it is King's third published novel and first hardback bestseller: the success of the book firmly established King as a preeminent author in the horror genre.")
                        .cover("https://upload.wikimedia.org/wikipedia/en/thumb/4/4c/Shiningnovel.jpg/220px-Shiningnovel.jpg")
                .build());
        b.add(Book.builder()
                        .title("It")
                        .author(a.get(2))
                        .synopsis("It is a 1986 horror novel by American author Stephen King. It was his 22nd book, and his 17th novel written under his own name. The story follows the experiences of seven children as they are terrorized by an evil entity that exploits the fears of its victims to disguise itself while hunting its prey.")
                        .funFacts("It is a 1986 horror novel by American author Stephen King. It was his 22nd book, and his 17th novel written under his own name. The story follows the experiences of seven children as they are terrorized by an evil entity that exploits the fears of its victims to disguise itself while hunting its prey.")
                        .cover("https://upload.wikimedia.org/wikipedia/en/thumb/5/5a/It_cover.jpg/220px-It_cover.jpg")
                .build());
        b.add(Book.builder()
                        .title("The Stand")
                        .author(a.get(2))
                        .synopsis("The Stand is a post-apocalyptic dark fantasy novel written by American author Stephen King and first published in 1978 by Doubleday. The plot centers on a pandemic of a weaponized strain of influenza that kills almost the entire world population.")
                        .funFacts("The Stand is a post-apocalyptic dark fantasy novel written by American author Stephen King and first published in 1978 by Doubleday. The plot centers on a pandemic of a weaponized strain of influenza that kills almost the entire world population.")
                        .cover("https://upload.wikimedia.org/wikipedia/en/thumb/9/96/The_Stand_cover.jpg/220px-The_Stand_cover.jpg")
                .build());
        b.add(Book.builder()
                        .title("The Dark Tower: The Gunslinger")
                        .author(a.get(2))
                        .synopsis("The Dark Tower: The Gunslinger is a fantasy novel by American author Stephen King, the first volume in the Dark Tower series. The Gunslinger was first published in 1982 as a fix-up novel, joining five short stories that had been published between 1978 and 1981.")
                        .funFacts("The Dark Tower: The Gunslinger is a fantasy novel by American author Stephen King, the first volume in the Dark Tower series. The Gunslinger was first published in 1982 as a fix-up novel, joining five short stories that had been published between 1978 and 1981.")
                        .cover("https://upload.wikimedia.org/wikipedia/en/thumb/9/98/Gunslinger.jpg/220px-Gunslinger.jpg")
                .build());
        b.add(Book.builder()
                        .title("The Dark Tower: The Drawing of the Three")
                        .author(a.get(2))
                        .synopsis("The Dark Tower: The Drawing of the Three is a fantasy novel by American writer Stephen King, the second book in The Dark Tower series, published by Grant in 1987. The series was inspired by Childe Roland to the Dark Tower Came by Robert Browning.")
                        .funFacts("The Dark Tower: The Drawing of the Three is a fantasy novel by American writer Stephen King, the second book in The Dark Tower series, published by Grant in 1987. The series was inspired by Childe Roland to the Dark Tower Came by Robert Browning.")
                        .cover("https://upload.wikimedia.org/wikipedia/en/thumb/4/4a/DrawingoftheThree.jpg/220px-DrawingoftheThree.jpg")
                .build());
        b.add(Book.builder()
                        .title("The Dark Tower: The Waste Lands")
                        .author(a.get(2))
                        .synopsis("The Dark Tower: The Waste Lands is a fantasy novel by American writer Stephen King, the third book of The Dark Tower series. The original limited edition hardcover featuring full-color illustrations by Ned Dameron was published in 1991 by Grant.")
                        .funFacts("The Dark Tower: The Waste Lands is a fantasy novel by American writer Stephen King, the third book of The Dark Tower series. The original limited edition hardcover featuring full-color illustrations by Ned Dameron was published in 1991 by Grant.")
                        .cover("https://upload.wikimedia.org/wikipedia/en/thumb/6/6b/Wastelands.jpg/220px-Wastelands.jpg")
                .build());

        booksRepository.saveAll(b);
    }
}
