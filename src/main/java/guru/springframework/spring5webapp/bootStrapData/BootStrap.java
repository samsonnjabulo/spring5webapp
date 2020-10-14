package guru.springframework.spring5webapp.bootStrapData;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrap implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository    bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrap(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository= publisherRepository;
    }



    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");


        Publisher pub = new Publisher("Njabulo","36 Bonamix","Durban","KZN","800");
        publisherRepository.save(pub);


        Author eric = new Author("Njabulo","shongwe");
        Book bonakele = new Book("Bonakele","isbn205");

        eric.getBooks().add(bonakele);
        bonakele.getAuthors().add(eric);

        bonakele.setPublisher(pub);
        pub.getBooks().add(bonakele);

        authorRepository.save(eric);
        bookRepository.save(bonakele);
        publisherRepository.save(pub);

       /* System.out.println("Number of books :"+ bookRepository.count());
        System.out.println("Number of authors :"+ authorRepository.count());
        System.out.println("Number of Publishers :"+ publisherRepository.count());*/
    }
}
