package library.management;
import java.util.HashMap;
import java.util.Map;

import  library.patron.Patron;

public class LibraryPatronManagement {
	
	private Map<String, Patron> patrons;
	
	public LibraryPatronManagement() { 
		this.patrons = new HashMap<>(); 
	} 
	public void addPatron(Patron patron) { 
		patrons.put(patron.getPatronID(), patron); 
	} 
	public void updatePatron(Patron patron) { 
		patrons.put(patron.getPatronID(), patron); 
	} 
	
	public Patron getPatronByID(String patronID) { 
		return patrons.get(patronID); 
	}
}
