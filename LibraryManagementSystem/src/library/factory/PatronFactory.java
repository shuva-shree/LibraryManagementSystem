package library.factory;

import java.util.ArrayList;

import library.patron.LibraryPatron;
import library.patron.Patron;

public class PatronFactory {
	
	    public static Patron createPatron(String name, String patronID) {
	        return new LibraryPatron(name, patronID, new ArrayList<>());
	    }
	

}
