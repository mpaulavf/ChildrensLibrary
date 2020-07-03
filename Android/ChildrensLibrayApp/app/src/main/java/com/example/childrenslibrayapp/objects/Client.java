package com.example.childrenslibrayapp.objects;

import com.example.childrenslibrayapp.structures.DynamicArray;
import com.example.childrenslibrayapp.structures.SinglyLinkedList;

import java.util.Calendar;
import java.util.Date;

public class Client extends User{

    private Calendar date;
    private SinglyLinkedList <String> search;
    private boolean mark = false;
    private DynamicArray<Book> borrowBooks = new DynamicArray<Book>();

    public Client(String name, String surname, String nickname, String password, Boolean isWorker, Calendar date, SinglyLinkedList <String> search) {
        super(name, surname, nickname, password, isWorker);
        this.date = date;
        this.search = search;
    }

    public Calendar getDate() {
        return date;
    }
    public void setDate(Calendar date) {
        this.date = date;
    }

    public SinglyLinkedList <String> getSearch() {
        return search;
    }
    public void setSearch(SinglyLinkedList <String> search) {
        this.search = search;
    }

    public DynamicArray <Book> getBorrowBooks() {
        return borrowBooks;
    }
    public void setSearch(DynamicArray <Book> borrowBooks) {
        this.borrowBooks = borrowBooks;
    }

    public boolean getMark() {
        return mark;
    }
    public void setMark(boolean mark) {
        this.mark = mark;
    }

    public void giveItMark(boolean mark, DynamicArray borrowBooks) throws Exception {
        Book temp;
        BorrowState aux;
        Date today = new Date();
        for(int i=0;i<borrowBooks.getSize()+1;i++){
            temp = (Book) borrowBooks.getVal(i);
            aux = temp.getBorrowState();
            if(aux.endDate.compareTo(today) > 0) mark=true;
        }
    }

    public void addBorrowBook(Book book, DynamicArray borrowBooks) throws Exception {
        Book temp;
        boolean itsIn = false;
        for(int i=0;i<borrowBooks.getSize();i++){
            temp = (Book) borrowBooks.getVal(i);
            if(temp.getCode().equals(book.getCode())) itsIn = true;
        }
        if(!itsIn) borrowBooks.pushBack(book);
    }

}
