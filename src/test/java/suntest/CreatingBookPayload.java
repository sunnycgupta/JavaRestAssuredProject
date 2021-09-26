package suntest;

public class CreatingBookPayload {

	private String name;
	private String isbn;
	private int aisle;
	private String author;
	
	public CreatingBookPayload(String name, String isbn, int aisle, String author) {
		super();
		this.name = name;
		this.isbn = isbn;
		this.aisle = aisle;
		this.author = author;
	}
	
	public String getName() {
		return name;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public int getAisle() {
		return aisle;
	}
	
	public String getAuthor() {
		return author;
	}
	
}
