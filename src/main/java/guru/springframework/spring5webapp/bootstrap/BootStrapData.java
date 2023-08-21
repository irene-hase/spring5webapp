package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData  implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;


	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
	                     PublisherRepository publisherRepository)
	{
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void run(String... args) throws Exception
	{
		Publisher publisherHD = new Publisher("Springer Verlag", "Tiergarstenstraße 17", "Heidelberg", "BW", "69121");
		publisherRepository.save(publisherHD);

		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design", "123123");
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		ddd.setPublisher(publisherHD);
		publisherHD.getBooks().add(ddd);
		authorRepository.save(eric);
		bookRepository.save(ddd);

		Author rod = new Author("Rod", "Johnson");
		Book noEJB = new Book("Expert One-on-One J2EE Development Without EJB", "978-0-764-57390-3");
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		noEJB.setPublisher(publisherHD);
		publisherHD.getBooks().add(noEJB);
		authorRepository.save(rod);
		bookRepository.save(noEJB);
		publisherRepository.save(publisherHD);


		System.out.println("Started in Bootstrap");
		System.out.println("Number of books: "+ bookRepository.count());
		System.out.println("Number of publishers: "+ publisherRepository.count());
		System.out.println("Number of books of HD publisher: "+ publisherHD.getBooks().size());
	}
}
