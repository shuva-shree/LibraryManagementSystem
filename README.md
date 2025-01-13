### Object-Oriented Design Documentation with SOLID Principles and Design Patterns
![LibraryManagement](https://github.com/user-attachments/assets/47ef779e-489c-4881-a164-879da0e8b526)


---

### **1. Overview**
This design implements a library management system adhering to **object-oriented principles**, **SOLID principles**, and appropriate **design patterns** for scalability, maintainability, and modularity.

---

### **2. Key Components and Their Roles**

#### **2.1. `Book` Interface**
- **Purpose**: Provides a contract for book-related classes to implement.
- **SOLID Principle**: *Interface Segregation Principle* (ISP): Ensures `Book` defines only the necessary methods for book-related operations.
- **Design Pattern**: None.
- Methods:
String getTitle()
String getAuthor()
String getISBN()
int getPublicationYear()


---

#### **2.2. `PhysicalBook` Class**
- **Purpose**: Implements the `Book` interface, representing a specific type of book.
- **SOLID Principle**: 
  - *Single Responsibility Principle* (SRP): Manages book-specific attributes and behaviors.
  - *Open/Closed Principle* (OCP): Can be extended to include other book types (e.g., `DigitalBook`) without modifying existing code.
- **Design Pattern**: None.
Attributes:
String title
String author
String ISBN
int publicationYear
Methods:
Getters and setters for each attribute.
---

#### **2.3. `Patron` Interface**
- **Purpose**: Defines behaviors for library patrons.
- **SOLID Principle**: ISP: Ensures only relevant methods for patrons are defined.
- **Design Pattern**: None.
- Methods:
String getName()
String getPatronID()
List<Book> getBorrowedBooks()
void setBorrowedBooks(ArrayList<Book> arrayList)

---

#### **2.4. `LibraryPatron` Class**
- **Purpose**: Implements the `Patron` interface, representing an individual library patron.
- **SOLID Principle**: 
  - SRP: Handles only the details and behaviors of a patron.
  - OCP: Easily extendable for different types of patrons (e.g., `CorporatePatron` or `GuestPatron`).
- **Design Pattern**: None.
- Attributes:
String name
String patronID
List<Book> borrowedBooks
Methods:
Getters and setters for all attributes.


---

#### **2.5. `LibraryInventory` Class**
- **Purpose**: Manages books in the library's inventory.
- **SOLID Principle**: 
  - SRP: Focused on inventory-specific operations such as adding, removing, and searching books.
  - OCP: Allows for additional inventory operations (e.g., categorization) without modifying existing code.
- **Design Pattern**: 
  - *Repository Pattern*: Centralizes the management of book objects in the inventory.
- **Attributes**:
Set<Book> books (stores all available books in the library).
Methods:
boolean isAvailable(Book book): Checks if a book is available.
void addBook(Book book): Adds a book to the inventory.
void removeBook(Book book): Removes a book from the inventory.
void updateBook(Book oldBook, Book newBook): Replaces an old book with a new one.
List<Book> searchBooksByTitle(String title): Searches for books by title.
List<Book> searchBooksByAuthor(String author): Searches for books by author.
Book searchBooksByISBN(String ISBN): Searches for a book by its ISBN.


---

#### **2.6. `LibraryPatronManagement` Class**
- **Purpose**: Manages patron-related operations.
- **SOLID Principle**:
  - SRP: Focused solely on managing patron data.
  - OCP: Extendable to add new functionalities like patron status or penalties.
- **Design Pattern**: 
  - *Repository Pattern*: Centralized management of patrons.
  - Attributes:
Map<String, Patron> patrons (maps patron IDs to their corresponding patron objects).
Methods:
void addPatron(Patron patron): Adds a new patron.
void updatePatron(Patron patron): Updates an existing patron's details.
Patron getPatronByID(String patronID): Retrieves a patron by their ID.

---

#### **2.7. `LendingProcess` Class**
- **Purpose**: Manages book lending and returning processes.
- **SOLID Principle**: 
  - SRP: Dedicated to book lending and return processes.
  - Dependency Inversion Principle (DIP): Depends on abstractions (`LibraryInventory` and `LibraryPatronManagement`) rather than concrete implementations.
- **Design Pattern**:
  - *Service Layer Pattern*: Encapsulates the logic for lending and returning books.
  - Attributes:
LibraryInventory inventory: Reference to the library's inventory system.
LibraryPatronManagement patronManagement: Reference to the patron management system.
Methods:
boolean checkOut(Patron patron, Book book): Allows a patron to check out a book if available.
boolean returnBook(Patron patron, Book book): Allows a patron to return a book.


---

#### **2.8. `BookFactory` Class**
- **Purpose**: Creates `Book` objects.
- **SOLID Principle**: 
  - SRP: Handles object creation logic for books.
  - OCP: Extendable to support additional book types without modifying existing methods.
- **Design Pattern**: 
  - *Factory Pattern*: Encapsulates the instantiation of book objects.

---

#### **2.9. `PatronFactory` Class**
- **Purpose**: Creates `Patron` objects.
- **SOLID Principle**: 
  - SRP: Focused on creating patron instances.
  - OCP: Extendable to include new patron types.
- **Design Pattern**: 
  - *Factory Pattern*: Encapsulates the instantiation of patron objects.

---

### **3. Design Patterns Usage**

1. **Factory Pattern**:
   - Used in `BookFactory` and `PatronFactory` to create objects without exposing instantiation logic.
   - Simplifies code and adheres to the *Open/Closed Principle*.


---

### **4. SOLID Principles in Detail**

1. **Single Responsibility Principle (SRP)**:
   - Each class and interface has a single, well-defined purpose (e.g., `LibraryInventory` manages books, `LibraryPatronManagement` handles patrons).

2. **Open/Closed Principle (OCP)**:
   - The system can be extended with new functionality (e.g., new book types or patron types) without modifying existing code.

3. **Liskov Substitution Principle (LSP)**:
   - Subtypes (`PhysicalBook`, `LibraryPatron`) can replace their parent types (`Book`, `Patron`) without altering the correctness of the program.

4. **Interface Segregation Principle (ISP)**:
   - Interfaces (`Book`, `Patron`) are designed to include only relevant methods, ensuring that implementing classes do not require unused methods.

5. **Dependency Inversion Principle (DIP)**:
   - High-level modules (`LendingProcess`) depend on abstractions (`LibraryInventory`, `LibraryPatronManagement`), not concrete implementations.

---

### **5. System Workflow with Patterns**

1. **Creating Objects**:
   - Use `BookFactory.createBook()` and `PatronFactory.createPatron()` to instantiate books and patrons, ensuring consistency and encapsulation.

2. **Adding Books and Patrons**:
   - Add books via `LibraryInventory.addBook()`.
   - Add patrons via `LibraryPatronManagement.addPatron()`.

3. **Lending and Returning Books**:
   - Use `LendingProcess.checkOut()` and `LendingProcess.returnBook()` to handle lending processes, leveraging the `Service Layer Pattern`.

4. **Searching and Managing Inventory**:
   - Use repository methods in `LibraryInventory` and `LibraryPatronManagement` to search, add, or update records.

---

### **6. Benefits of the Design**

1. **Adherence to SOLID Principles**:
   - Ensures the system is extensible, maintainable, and robust.

2. **Use of Design Patterns**:
   - Simplifies object creation and logic encapsulation, reducing coupling and improving code readability.

3. **Scalability**:
   - Easy to add new features, such as digital books or advanced search criteria.

4. **Testability**:
   - Modular design allows for isolated testing of components.

This documentation showcases a well-structured and maintainable system using best practices in object-oriented design.
