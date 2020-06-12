package com.example.childrenslibrayapp.mockdata;

import com.example.childrenslibrayapp.objects.Book;
import com.example.childrenslibrayapp.structures.DynamicArray;
import com.example.childrenslibrayapp.structures.SinglyLinkedList;

public class Busquedas {
    SinglyLinkedList <Book> allBooksList;
    SinglyLinkedList <Book> byAuthorList;
    SinglyLinkedList <Book> byTitleList;
    SinglyLinkedList <Book> byGenreList;
    SinglyLinkedList <Book> byCodeList;

    DynamicArray <Book> allBooksArray;
    DynamicArray <Book> byAuthorArray;
    DynamicArray <Book> byTitleArray;
    DynamicArray <Book> byGenreArray;
    DynamicArray <Book> byCodeArray;

    public Busquedas(SinglyLinkedList<Book> allBooksList, DynamicArray<Book> allBooksArray) {
        this.allBooksList = allBooksList;
        this.allBooksArray = allBooksArray;
    }

    public Busquedas(DynamicArray<Book> allBooksArray) {
        this.allBooksArray = allBooksArray;
    }

    public Busquedas(SinglyLinkedList<Book> allBooksList) {
        this.allBooksList = allBooksList;
    }
}
