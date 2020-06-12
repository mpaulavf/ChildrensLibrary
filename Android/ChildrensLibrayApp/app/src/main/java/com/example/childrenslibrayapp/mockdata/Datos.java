package com.example.childrenslibrayapp.mockdata;

import com.example.childrenslibrayapp.objects.*;
import com.example.childrenslibrayapp.structures.DynamicArray;
import com.example.childrenslibrayapp.structures.SinglyLinkedList;

public class Datos {
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
}
