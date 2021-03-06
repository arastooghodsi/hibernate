package chapter08HQLNamedQuery;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class BookCategory {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String myBookCategory;
	
	@OneToMany(mappedBy = "bookCategory")
	private List<NamedQueryBook> books = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMyBookCategory() {
		return myBookCategory;
	}

	public void setMyBookCategory(String myBookCategory) {
		this.myBookCategory = myBookCategory;
	}

	public List<NamedQueryBook> getBooks() {
		return books;
	}

	public void setBooks(List<NamedQueryBook> books) {
		this.books = books;
	}
	
	
	
}
