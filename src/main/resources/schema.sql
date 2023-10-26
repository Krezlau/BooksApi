drop table if exists Books;

create table Books(
    id int not null auto_increment,
    title varchar(255) not null,
    sinopsis varchar(255) not null,
    funFacts varchar(255) not null,
    rating decimal not null,
    primary key (id)
)