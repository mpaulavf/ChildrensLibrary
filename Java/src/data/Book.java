package data;

public class Book implements Comparable<Book> {
	
	private String name;
	private String code = "";
	private String authorName;
	private String genre;
	private String picturePath;
	
	public Book(String name, String code, String authorName, String genre,
			String picturePath) {
		super();
		this.name = name;
		this.code = code;
		this.authorName = authorName;
		this.genre = genre;
		this.picturePath = picturePath;
	}

	public Book(String name, String code, String authorName, String genre) {
		super();
		this.name = name;
		this.code = code;
		this.authorName = authorName;
		this.genre = genre;
		picturePath = "Resources/BookImgs/default.png";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPicturePath() {
		return picturePath;
	}
	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

	@Override
	public int compareTo(Book book) {
		return this.code.compareTo(book.getCode());
	}

}