package guru.springframework.spring5webapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Publisher {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	private String addressLine;
	private String city;
	private String state;
	private String zip;
	@OneToMany
	@JoinColumn(name = "publisher_id")
	private Set<Book> books = new HashSet<>();


	public Publisher()
	{
	}

	public Publisher(String name, String addressLine, String city, String state, String zip)
	{
		this.name = name;
		this.addressLine = addressLine;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public Set<Book> getBooks()
	{
		return books;
	}

	public void setBooks(Set<Book> books)
	{
		this.books = books;
	}
	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Publisher publisher = (Publisher) o;

		return Objects.equals(id, publisher.id);
	}

	@Override
	public int hashCode()
	{
		return id != null ? id.hashCode() : 0;
	}

	@Override
	public String toString()
	{
		return "Publisher{" +
				"id=" + id +
				", name='" + name + '\'' +
				", addressLine='" + addressLine + '\'' +
				", city='" + city + '\'' +
				", state='" + state + '\'' +
				", zip='" + zip + '\'' +
				'}';
	}
}
