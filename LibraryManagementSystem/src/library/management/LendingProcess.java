package library.management;

import java.util.ArrayList;

import library.book.Book;
import library.inventory.LibraryInventory;
import library.patron.Patron;

public class LendingProcess {
	private LibraryInventory inventory; 
	private LibraryPatronManagement patronManagement;
	
	public LendingProcess(LibraryInventory inventory, LibraryPatronManagement patronManagement) {
		super();
		this.inventory = inventory;
		this.patronManagement = patronManagement;
	}
	
	public boolean checkOut(Patron patron, Book book) {
		if (inventory.searchBooksByISBN(book.getISBN()) != null) { 
			inventory.removeBook(book); 
			if (patron.getBorrowedBooks() == null) { 
				patron.setBorrowedBooks(new ArrayList<>()); // Ensure the list is not null }
			}
			patron.getBorrowedBooks().add(book) ;
//			logger.info("Book checked out: " + book.getTitle() + " by " + patron.getName()); 
			return true; 
		}
//		logger.warning("Book checkout failed: " + book.getTitle()); 
		return false;
	}
	
	public boolean returnBook(Patron patron, Book book) { 
		if (patron.getBorrowedBooks() == null) { 
			patron.setBorrowedBooks(new ArrayList<>()); // Ensure the list is not null }
		}
		if (patron.getBorrowedBooks().remove(book)) { 
			inventory.addBook(book); 
//			logger.info("Book returned: " + book.getTitle() + " by " + patron.getName()); 
			return true; 
		} 
//		logger.warning("Book return failed: " + book.getTitle()); 
		return false; 
	}
	
	
}
