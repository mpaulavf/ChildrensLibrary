package com.example.childrenslibrayapp.mockdata;

import com.example.childrenslibrayapp.objects.*;
import com.example.childrenslibrayapp.structures.DynamicArray;
import com.example.childrenslibrayapp.structures.SinglyLinkedList;

public class Datos {

    private static Datos instance = null;

    protected Datos (){
        //exists only to defeat instantiation.
    }
    //datos es una singleton class que podemos utilizar para acceder a cualquier lsita o arreglo o futura estructura a nivel de aplicación

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

    SinglyLinkedList <User> allUsersList;
    DynamicArray<User> allUsersArray;

    public static Datos getInstance() {
        if(instance == null) {
            instance = new Datos ();
        }
        return instance;
    }
    /*
    public Datos(SinglyLinkedList<Book> allBooksList, DynamicArray<Book> allBooksArray, SinglyLinkedList<User> allUsersList, DynamicArray<User> allUsersArray) {
        this.allBooksList = allBooksList;
        this.allBooksArray = allBooksArray;
        this.allUsersList = allUsersList;
        this.allUsersArray = allUsersArray;
    }

    public Datos(DynamicArray<Book> allBooksArray, DynamicArray<User> allUsersArray) {
        this.allBooksArray = allBooksArray;
        this.allUsersArray = allUsersArray;
    }

    public Datos(SinglyLinkedList<Book> allBooksList, SinglyLinkedList<User> allUsersList) {
        this.allBooksList = allBooksList;
        this.allUsersList = allUsersList;
    }
    */

    public SinglyLinkedList<Book> getAllBooksList() {
        return allBooksList;
    }

    public DynamicArray<Book> getAllBooksArray() {
        return allBooksArray;
    }

    public SinglyLinkedList<User> getAllUsersList() {
        return allUsersList;
    }

    public DynamicArray<User> getAllUsersArray() {
        return allUsersArray;
    }

    public void setAllBooksList(SinglyLinkedList<Book> allBooksList) {
        this.allBooksList = allBooksList;
    }

    public void setAllBooksArray(DynamicArray<Book> allBooksArray) {
        this.allBooksArray = allBooksArray;
    }

    public void setAllUsersList(SinglyLinkedList<User> allUsersList) {
        this.allUsersList = allUsersList;
    }

    public void setAllUsersArray(DynamicArray<User> allUsersArray) {
        this.allUsersArray = allUsersArray;
    }

    public void setByAuthorList(SinglyLinkedList<Book> byAuthorList) {
        this.byAuthorList = byAuthorList;
    }

    public void setByTitleList(SinglyLinkedList<Book> byTitleList) {
        this.byTitleList = byTitleList;
    }

    public void setByGenreList(SinglyLinkedList<Book> byGenreList) {
        this.byGenreList = byGenreList;
    }

    public void setByCodeList(SinglyLinkedList<Book> byCodeList) {
        this.byCodeList = byCodeList;
    }

    public void setByAuthorArray(DynamicArray<Book> byAuthorArray) {
        this.byAuthorArray = byAuthorArray;
    }

    public void setByTitleArray(DynamicArray<Book> byTitleArray) {
        this.byTitleArray = byTitleArray;
    }

    public void setByGenreArray(DynamicArray<Book> byGenreArray) {
        this.byGenreArray = byGenreArray;
    }

    public void setByCodeArray(DynamicArray<Book> byCodeArray) {
        this.byCodeArray = byCodeArray;
    }
}