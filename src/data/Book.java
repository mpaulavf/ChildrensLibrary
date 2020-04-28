package data;

import java.awt.image.*;
import java.util.*;

public class Book implements Comparable<Book> {
	
	private String name;
	private String code = "";
	private String authorName;
	private ArrayList<String> genres;
	private String picturePath;
	
	public Book(String name, String code, String authorName, ArrayList<String> genres,
			String picturePath) {
		super();
		this.name = name;
		this.code = code;
		this.authorName = authorName;
		this.genres = genres;
		this.picturePath = picturePath;
	}

	public Book(String name, String code, String authorName, ArrayList<String> genres) {
		super();
		this.name = name;
		this.code = code;
		this.authorName = authorName;
		this.genres = genres;
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
	
	public ArrayList<String> getGenres() {
		return genres;
	}
	public void setGenres(ArrayList<String> genres) {
		this.genres = genres;
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