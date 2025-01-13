package library.patron;

import java.util.ArrayList;
import java.util.List;

import library.book.Book;

public class LibraryPatron implements Patron{
	private String name;
	private String patronID;
	private List<Book> borrowedBooks;
	
	
	
	public LibraryPatron(String name, String patronID, List<Book> borrowedBooks) {
		super();
		this.name = name;
		this.patronID = patronID;
		this.borrowedBooks = borrowedBooks;
	}
	
	
	

	public String getName() { return name; } 
	public void setName(String name) { this.name = name; }
	public String getPatronID() { return patronID; } 
	public void setPatronID(String patronID) { this.patronID = patronID; } 
	public List<Book> getBorrowedBooks() { return borrowedBooks; }




	@Override
	public void setBorrowedBooks(ArrayList arrayList) {
		// TODO Auto-generated method stub
		
	}

}
