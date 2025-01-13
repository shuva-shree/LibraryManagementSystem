package library.inventory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import library.book.Book;

public class LibraryInventory {

	private Set<Book> books;
	
	
	public LibraryInventory() {
		this.books = new HashSet<>();
	}
	
	public boolean isAvailable(Book book) {
		if(books.contains(book)) {
			return true;
		}
		return false;
	}
	
	public void addBook(Book book) {
		books.add(book);
	}
	
	public void removeBook(Book book) {
		books.remove(book);
	}
	
	public void updateBook(Book oldBook, Book newBook) { 
		if (books.remove(oldBook)) {
			books.add(newBook); 
			} 
	}
	
	public List<Book> searchBooksByTitle(String title){
		List<Book> result = new ArrayList<>(); 
		for (Book book : books) { 
			if (book.getTitle().equalsIgnoreCase(title)) { 
				result.add(book); 
				} 
			} 
		return result;
	}
	
	public List<Book> searchBooksByAuthor(String author){
		List<Book> result = new ArrayList<>(); 
		for (Book book : books) { 
			if (book.getTitle().equalsIgnoreCase(author)) { 
				result.add(book); 
				} 
			} 
		return result;
	}
	
	public Book searchBooksByISBN(String ISBN) { 
		for (Book book : books) { 
			if (book.getISBN().equalsIgnoreCase(ISBN)) { 
				return book; 
			} 
		} 
	return null; 
	}
	
}
