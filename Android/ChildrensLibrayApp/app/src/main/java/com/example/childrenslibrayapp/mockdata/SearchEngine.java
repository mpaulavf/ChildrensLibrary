package com.example.childrenslibrayapp.mockdata;

import android.content.Context;

import com.example.childrenslibrayapp.objects.Book;
import com.example.childrenslibrayapp.objects.Search;
import com.example.childrenslibrayapp.structures.Node;
import com.example.childrenslibrayapp.structures.SinglyLinkedList;

public class SearchEngine {

    Context context;

    public SearchEngine(Context context) {
        this.context = context;
    }

    public SinglyLinkedList <Book> allBooks = new SinglyLinkedList <Book> ();
    public SinglyLinkedList <Book> booksByAuthor = new SinglyLinkedList <Book>();
    public SinglyLinkedList <Book> booksByTitle = new SinglyLinkedList <Book>();
    public SinglyLinkedList <Book> booksByGenre = new SinglyLinkedList <Book>();
    public SinglyLinkedList <Book> booksByCode = new SinglyLinkedList <Book>();


    public SearchEngine(Search search) {
        searchBy(search);
    }

    public SinglyLinkedList <Book> getAllBooks() { return allBooks; }


    public void setAllBooks(SinglyLinkedList <Book> allBooks) { this.allBooks = allBooks; }

    public SinglyLinkedList <Book> searchBy(Search search) {
        ObjectReader tempBooks = new ObjectReader(context);
        tempBooks.readBooks(allBooks);
        String tempSearch = search.getTempSearch();
        String category = search.getCategory();
        if (allBooks.head == null) return null;
        Node temp = allBooks.head;
        Book aux = (Book) temp.data;
        while(true) {
            if (temp.next != null) {
                switch (category) {
                    case "Autor":
                        String authorName = aux.getAuthorName();
                        if (tempSearch == authorName.toLowerCase() || tempSearch == authorName) booksByAuthor.insertNodeAtTail(aux);
                        break;
                    case "Titulo":
                        String title = aux.getTitle();
                        if (tempSearch == title.toLowerCase() || tempSearch == title) booksByTitle.insertNodeAtTail(aux);
                        break;
                    case "Genero":
                        String genre = aux.getGenre();
                        if (tempSearch == genre.toLowerCase() || tempSearch == genre) booksByGenre.insertNodeAtTail(aux);
                        break;
                    case "Codigo":
                        String code = aux.getCode();
                        if (tempSearch == code.toLowerCase() || tempSearch == code) booksByCode.insertNodeAtTail(aux);
                        break;
                    default:
                        break;
                }
                temp = temp.next;
            } else {
                switch (category) {
                    case "Author":
                        return booksByAuthor;
                    case "Name":
                        return booksByTitle;
                    case "Genero":
                        return booksByGenre;
                    case "Code":
                        return booksByCode;
                    default:
                        return null;
                }
            }
            return null;
        }
    }

}
