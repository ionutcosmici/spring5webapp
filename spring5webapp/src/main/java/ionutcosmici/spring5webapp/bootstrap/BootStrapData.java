package ionutcosmici.spring5webapp.bootstrap;

import ionutcosmici.spring5webapp.domain.Author;
import ionutcosmici.spring5webapp.domain.Book;
import ionutcosmici.spring5webapp.domain.Publisher;
import ionutcosmici.spring5webapp.repositories.AuthorRepository;
import ionutcosmici.spring5webapp.repositories.BookRepository;
import ionutcosmici.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("Carturesti");
        publisher.setCity("Bucharest");
        publisher.setState("RO");

        publisherRepository.save(publisher);

        System.out.println("Publisher Count: " + publisherRepository.count());

        Author john = new Author("John","Digweed");
        Book parade = new Book("Street Parade","123");
        john.getBooks().add(parade);
        parade.getAuthors().add(john);

        parade.setPublisher(publisher);
        publisher.getBooks().add(parade);

        authorRepository.save(john);
        bookRepository.save(parade);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("Java Development without EJB", "7891");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher number of Books: " + publisher.getBooks().size());


    }
}
