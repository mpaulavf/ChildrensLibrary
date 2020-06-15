package com.example.childrenslibrayapp.searches;

import android.content.Context;

import com.example.childrenslibrayapp.mockdata.Datos;
import com.example.childrenslibrayapp.objects.Book;
import com.example.childrenslibrayapp.objects.Search;
import com.example.childrenslibrayapp.structures.DynamicArray;
import com.example.childrenslibrayapp.structures.ListBST;
import com.example.childrenslibrayapp.structures.Node;
import com.example.childrenslibrayapp.structures.SinglyLinkedList;

public class SearchEngine {

    Context context;

    public SearchEngine(Context context) {
        this.context = context;
    }

    private Datos datos = Datos.getInstance();

    private DynamicArray <Book> allBooksArray = datos.getAllBooksArray();
    private SinglyLinkedList<Book> allBooksList = datos.getAllBooksList();
    ListBST<Book> allBooksBST = datos.getAllBooksBST();

    private DynamicArray <Book> booksByAuthorArray = new DynamicArray <Book>();
    private SinglyLinkedList <Book> booksByAuthorList = new SinglyLinkedList <Book>();
    private ListBST<Book> booksByAuthorBST = new ListBST<Book>();

    private DynamicArray <Book> booksByTitleArray = new DynamicArray <Book>();
    private SinglyLinkedList <Book> booksByTitleList = new SinglyLinkedList <Book>();
    private ListBST<Book> booksByTitleBST = new ListBST<Book>();

    private DynamicArray <Book> booksByGenreArray = new DynamicArray <Book>();
    private SinglyLinkedList <Book> booksByGenreList = new SinglyLinkedList <Book>();
    private ListBST<Book> booksByGenreBST = new ListBST<Book>();

    private DynamicArray <Book> booksByCodeArray = new DynamicArray <Book>();
    private SinglyLinkedList <Book> booksByCodeList = new SinglyLinkedList<Book>();
    private ListBST<Book> booksByCodeBST = new ListBST<Book>();



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

        datos.setByAuthorArray(new DynamicArray<Book>());
        datos.setByTitleArray(new DynamicArray<Book>());
        datos.setByGenreArray(new DynamicArray<Book>());
        datos.setByCodeArray(new DynamicArray<Book>());

        String tempSearch = search.getTempSearch();
        String category = search.getCategory();


        for (int i = 0; i < allBooksArray.getSize(); i++) {
            if (allBooksArray.getVal(i + 1) != null) {
                switch (category) {
                    case "Autor":
                        String authorName = allBooksArray.getVal(i).getAuthorName();
                        if (tempSearch.toLowerCase().equals(authorName.toLowerCase()))
                            booksByAuthorArray.pushBack(allBooksArray.getVal(i));
                        break;
                    case "Titulo":
                        String title = allBooksArray.getVal(i).getTitle();
                        if (tempSearch.toLowerCase().equals(title.toLowerCase()))
                            booksByTitleArray.pushBack(allBooksArray.getVal(i));
                        break;
                    case "Genero":
                        String genre = allBooksArray.getVal(i).getGenre();
                        if (tempSearch.equals(genre))
                            booksByGenreArray.pushBack(allBooksArray.getVal(i));
                        break;
                    case "Codigo":
                        String code = allBooksArray.getVal(i).getCode();
                        if (tempSearch.equals(code))
                            booksByCodeArray.pushBack(allBooksArray.getVal(i));
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

    }

    public void listSearchBy (Search search){
        datos.setByAuthorList(new SinglyLinkedList<Book>());
        datos.setByTitleList(new SinglyLinkedList<Book>());
        datos.setByGenreList(new SinglyLinkedList<Book>());
        datos.setByCodeList(new SinglyLinkedList<Book>());

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
                        datos.setByAuthorList(booksByAuthorList);
                    case "Titulo":
                        datos.setByTitleList(booksByTitleList);
                    case "Genero":
                        datos.setByGenreList(booksByGenreList);
                    case "Code":
                        datos.setByCodeList(booksByCodeList);
                    default:

                }
            }

        }
    }



}
