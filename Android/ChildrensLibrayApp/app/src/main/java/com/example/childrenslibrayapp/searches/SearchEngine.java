package com.example.childrenslibrayapp.searches;

import android.content.Context;

import com.example.childrenslibrayapp.mockdata.Datos;
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

    Datos datos = Datos.getInstance();

    public DynamicArray <Book> allBooksArray = datos.getAllBooksArray();
    public SinglyLinkedList<Book> allBooksList = new SinglyLinkedList <Book> ();

    public DynamicArray <Book> booksByAuthorArray = new DynamicArray <Book>();
    public SinglyLinkedList <Book> booksByAuthorList = new SinglyLinkedList <Book>();

    public DynamicArray <Book> booksByTitleArray = new DynamicArray <Book>();
    public SinglyLinkedList <Book> booksByTitleList = new SinglyLinkedList <Book>();

    public DynamicArray <Book> booksByGenreArray = new DynamicArray <Book>();
    public SinglyLinkedList <Book> booksByGenreList = new SinglyLinkedList <Book>();

    public DynamicArray <Book> booksByCodeArray = new DynamicArray <Book>();
    public SinglyLinkedList <Book> booksByCodeList = new SinglyLinkedList<Book>();


    public SearchEngine(Search search) {
        try {
            arraySearchBy(search);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DynamicArray <Book> getAllBooksList() { return allBooksArray; }


    public void setAllBooksList(DynamicArray <Book> allBooksList) { this.allBooksArray = allBooksList; }

    public void arraySearchBy(Search search) throws Exception {
        //ObjectReader tempBooks = new ObjectReader(context);
        //ObjectWriter ow = new ObjectWriter(context);
        //tempBooks.readBooks(allBooks);
        String tempSearch = search.getTempSearch();
        String category = search.getCategory();
        //if (allBooksArray.getSize() == 0) return null;
        //Node temp = allBooks.head;
        //Book aux = (Book) temp.data;

        for (int i = 0; i< allBooksArray.getSize(); i++){
            if (allBooksArray.getVal(i+1) != null) {
                switch (category) {
                    case "Autor":
                        String authorName = allBooksArray.getVal(i).getAuthorName();
                        if (tempSearch.toLowerCase().equals(authorName.toLowerCase())) booksByAuthorArray.pushBack(allBooksArray.getVal(i));
                        break;
                    case "Titulo":
                        String title = allBooksArray.getVal(i).getTitle();
                        if (tempSearch.toLowerCase().equals(title.toLowerCase())) booksByTitleArray.pushBack(allBooksArray.getVal(i));
                        break;
                    case "Genero":
                        String genre = allBooksArray.getVal(i).getGenre();
                        if (tempSearch.toLowerCase().equals(genre.toLowerCase())) booksByGenreArray.pushBack(allBooksArray.getVal(i));
                        break;
                    case "Codigo":
                        String code = allBooksArray.getVal(i).getCode();
                        if (tempSearch.equals(code)) booksByCodeArray.pushBack(allBooksArray.getVal(i));
                        break;
                    default:
                        break;
                }
            } else {
                switch (category) {
                    case "Autor":
                        datos.setByAuthorArray(booksByAuthorArray);
                        //return booksByAuthorArray;
                    case "Titulo":
                        datos.setByTitleArray(booksByTitleArray);
                        //return booksByTitleArray;
                    case "Genero":
                        datos.setByGenreArray(booksByGenreArray);
                        //return booksByGenreArray;
                    case "Codigo":
                        datos.setByCodeArray(booksByCodeArray);
                        //return booksByCodeArray;
                    default:
                        //return null;
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
    }

    public void listSearchBy(Search search){
        String tempSearch = search.getTempSearch();
        String category = search.getCategory();

        //if (allBooksArray.getSize() == 0) return null;
        Node temp = allBooksList.head;
        Book aux = (Book) temp.data;


        while(true) {
            if (temp.next != null) {
                switch (category) {
                    case "Autor":
                        String authorName = aux.getAuthorName();
                        if (tempSearch == authorName.toLowerCase() || tempSearch == authorName) booksByAuthorList.insertNodeAtTail(aux);
                        break;
                    case "Titulo":
                        String title = aux.getTitle();
                        if (tempSearch == title.toLowerCase() || tempSearch == title) booksByTitleList.insertNodeAtTail(aux);
                        break;
                    case "Genero":
                        String genre = aux.getGenre();
                        if (tempSearch == genre.toLowerCase() || tempSearch == genre) booksByGenreList.insertNodeAtTail(aux);
                        break;
                    case "Codigo":
                        String code = aux.getCode();
                        if (tempSearch == code.toLowerCase() || tempSearch == code) booksByCodeList.insertNodeAtTail(aux);
                        break;
                    default:
                        break;
                }
                temp = temp.next;
            } else {
                switch (category) {
                    case "Author":
                        //return booksByAuthor;
                    case "Name":
                        //return booksByTitle;
                    case "Genero":
                        //return booksByGenre;
                    case "Code":
                        //return booksByCode;
                    default:
                        //return null;
                }
            }
            //return null;
        }
    }



}
