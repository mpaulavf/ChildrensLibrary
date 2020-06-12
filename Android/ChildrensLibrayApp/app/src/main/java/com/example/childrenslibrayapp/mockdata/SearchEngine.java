package com.example.childrenslibrayapp.mockdata;

import android.content.Context;

import com.example.childrenslibrayapp.objects.Book;
import com.example.childrenslibrayapp.objects.Search;
import com.example.childrenslibrayapp.structures.DynamicArray;
import com.example.childrenslibrayapp.structures.Node;
import com.example.childrenslibrayapp.structures.SinglyLinkedList;

public class SearchEngine {

    Context context;

    public SearchEngine(Context context) {
        this.context = context;
    }

    public DynamicArray <Book> allBooks = new DynamicArray <Book> ();
    public DynamicArray <Book> booksByAuthor = new DynamicArray <Book>();
    public DynamicArray <Book> booksByTitle = new DynamicArray <Book>();
    public DynamicArray <Book> booksByGenre = new DynamicArray <Book>();
    public DynamicArray <Book> booksByCode = new DynamicArray <Book>();


    public SearchEngine(Search search) {
        try {
            searchBy(search);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DynamicArray <Book> getAllBooks() { return allBooks; }


    public void setAllBooks(DynamicArray <Book> allBooks) { this.allBooks = allBooks; }

    public DynamicArray <Book> searchBy(Search search) throws Exception {
        ObjectReader tempBooks = new ObjectReader(context);
        ObjectWriter ow = new ObjectWriter(context);
        tempBooks.readBooks(allBooks);
        String tempSearch = search.getTempSearch();
        String category = search.getCategory();
        if (allBooks.getSize() == 0) return null;
        //Node temp = allBooks.head;
        //Book aux = (Book) temp.data;

        for (int i=0; i<allBooks.getSize(); i++){
            if (allBooks.getVal(i+1) != null) {
                switch (category) {
                    case "Autor":
                        String authorName = allBooks.getVal(i).getAuthorName();
                        if (tempSearch == authorName.toLowerCase() || tempSearch == authorName) booksByAuthor.pushBack(allBooks.getVal(i));
                        break;
                    case "Titulo":
                        String title = allBooks.getVal(i).getTitle();
                        if (tempSearch == title.toLowerCase() || tempSearch == title) booksByTitle.pushBack(allBooks.getVal(i));
                        break;
                    case "Genero":
                        String genre = allBooks.getVal(i).getGenre();
                        if (tempSearch == genre.toLowerCase() || tempSearch == genre) booksByGenre.pushBack(allBooks.getVal(i));
                        break;
                    case "Codigo":
                        String code = allBooks.getVal(i).getCode();
                        if (tempSearch == code.toLowerCase() || tempSearch == code) booksByCode.pushBack(allBooks.getVal(i));
                        break;
                    default:
                        break;
                }
            } else {
                switch (category) {
                    case "Autor":
                        ow.exportBooks(booksByAuthor);
                        return booksByAuthor;
                    case "Titulo":
                        ow.exportBooks(booksByTitle);
                        return booksByTitle;
                    case "Genero":
                        ow.exportBooks(booksByGenre);
                        return booksByGenre;
                    case "Codigo":
                        ow.exportBooks(booksByCode);
                        return booksByCode;
                    default:
                        return null;
                }
            }
        }

        /*
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
        }*/
        return null;
    }



}
