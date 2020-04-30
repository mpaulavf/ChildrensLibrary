package com.example.childrenslibrayapp.objects;

public class Book implements Comparable<Book> {

    private String title;
    private String code = "";
    private String authorName;
    private String genre;
    private String picturePath;

    public Book(String title, String code, String authorName, String genre,
                String picturePath) {
        super();
        this.title = title;
        this.code = code;
        this.authorName = authorName;
        this.genre = genre;
        this.picturePath = picturePath;
    }

    public Book(String title, String code, String authorName, String genre) {
        super();
        this.title = title;
        this.code = code;
        this.authorName = authorName;
        this.genre = genre;
        picturePath = "drawable-v24/libro_no_disponible.png";
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", code='" + code + '\'' +
                ", authorName='" + authorName + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }

    public Book() {
        super();
        this.title = "";
        this.code = "";
        this.authorName = "";
        this.genre = "";
        picturePath = "drawable-v24/libro_no_disponible.png";
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
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
