package com.example.childrenslibrayapp.objects;

import com.example.childrenslibrayapp.R;

public class Book implements Comparable<Book> {

    private String title;
    private String code = "";
    private String authorName;
    private String genre;
    private int imgLibro;

    public Book(String title, String code, String authorName, String genre,
                int imgLibro) {
        super();
        this.title = title;
        this.code = code;
        this.authorName = authorName;
        this.genre = genre;
        this.imgLibro = imgLibro;
    }

    public Book(String title, String code, String authorName, String genre) {
        super();
        this.title = title;
        this.code = code;
        this.authorName = authorName;
        this.genre = genre;
        this.imgLibro = R.drawable.libro_no_disponible;
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
        imgLibro = R.drawable.libro_no_disponible;
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

    public int getImgLibro() {
        return imgLibro;
    }
    public void setImgLibro(int imgLibro) {
        this.imgLibro = imgLibro;
    }

    @Override
    public int compareTo(Book book) {
        return this.code.compareTo(book.getCode());
    }

}
