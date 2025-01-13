package library.book;

public class PhysicalBook implements Book{
	private String title;
	private String author;
	private String ISBN;
	private int publicationYear;
	
	
	public PhysicalBook(String title, String author, String iSBN, int publicationYear) {
		super();
		this.title = title;
		this.author = author;
		ISBN = iSBN;
		this.publicationYear = publicationYear;
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


	public String getISBN() {
		return ISBN;
	}


	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}


	public int getPublicationYear() {
		return publicationYear;
	}


	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}
	
	
}
