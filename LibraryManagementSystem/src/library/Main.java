
package library;

//import java.util.logging.Logger;

import library.book.Book;
import library.factory.BookFactory;
import library.factory.PatronFactory;
import library.inventory.LibraryInventory;
import library.management.LendingProcess;
import library.management.LibraryPatronManagement;
import library.patron.Patron;

public class Main {
//    private static final Logger logger = LoggerConfig.getLogger();

    public static void main(String[] args) {
        // Initialize Inventory and Patron Management
        LibraryInventory inventory = new LibraryInventory();
        LibraryPatronManagement patronManagement = new LibraryPatronManagement();

        // Initialize Lending Process
        LendingProcess lendingProcess = new LendingProcess(inventory, patronManagement);

        // Create some books
        Book book1 = BookFactory.createBook("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565", 1925);
        Book book2 = BookFactory.createBook("To Kill a Mockingbird", "Harper Lee", "9780061120084", 1960);
        Book book3 = BookFactory.createBook("1984", "George Orwell", "9780451524935", 1949);

        // Add books to inventory
        inventory.addBook(book1);
        inventory.addBook(book2);
        inventory.addBook(book3);

        // Create some patrons
        Patron patron1 = PatronFactory.createPatron("Alice", "P1001");
        Patron patron2 = PatronFactory.createPatron("Bob", "P1002");

        // Add patrons to patron management
        patronManagement.addPatron(patron1);
        patronManagement.addPatron(patron2);

        // Perform some operations
//        logger.info("Library Management System started");
        System.out.println("Library Management System started");

        // Checkout a book
        if (lendingProcess.checkOut(patron1, book1)) {
        	System.out.println("Book checked out successfully: " + book1.getTitle());
//            logger.info("Book checked out successfully: " + book1.getTitle());
        } else {
        	System.out.println("Failed to checkout book: " + book1.getTitle());
//            logger.warning("Failed to checkout book: " + book1.getTitle());
        }

        // Return a book
        if (lendingProcess.returnBook(patron1, book1)) {
        	System.out.println("Book returned successfully: " + book1.getTitle());
//            logger.info("Book returned successfully: " + book1.getTitle());
        } else {
        	System.out.println("Failed to return book: " + book1.getTitle());
//            logger.warning("Failed to return book: " + book1.getTitle());
        }

        // Search for books
        System.out.println("Searching for books by author 'George Orwell': " + inventory.searchBooksByAuthor("George Orwell"));
//        logger.info("Searching for books by author 'George Orwell': " + inventory.searchBooksByAuthor("George Orwell"));

        // Update a book
        Book updatedBook = BookFactory.createBook("Nineteen Eighty-Four", "George Orwell", "9780451524935", 1949);
        inventory.updateBook(book3, updatedBook);

        // Log the updated inventory
//        logger.info("Updated Inventory: " + inventory.searchBooksByAuthor("George Orwell"));
    }
}
