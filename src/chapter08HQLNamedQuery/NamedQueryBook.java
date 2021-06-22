package chapter08HQLNamedQuery;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
@NamedQuery(name = "allBooks", query = "from NamedQueryBook"),
@NamedQuery(name = "bookTitles", query = "select title from NamedQueryBook"),
@NamedQuery(name = "bookById", query = "from NamedQueryBook where id<:idValue")
})
public class NamedQueryBook {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private String author;
	
		
	@Override
	public String toString() {
		return "NamedQueryBook [id=" + id + ", title=" + title + ", author=" + author + "]";
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	
}
