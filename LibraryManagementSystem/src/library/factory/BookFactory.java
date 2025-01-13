package library.factory;

import library.book.Book;
import library.book.PhysicalBook;
import library.patron.LibraryPatron;

public class BookFactory {
	
	    public static Book createBook(String title, String author, String ISBN, int publicationYear) {
	        return new PhysicalBook(title, author, ISBN, publicationYear);
	    }
	}

	
