package library.patron;

import java.util.ArrayList;
import java.util.List;

import library.book.Book;

public interface Patron {
	String getName(); 
	String getPatronID(); 
	List<Book> getBorrowedBooks();
	void setBorrowedBooks(ArrayList arrayList);
}
