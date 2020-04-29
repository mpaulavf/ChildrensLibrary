package com.example.childrenslibrayapp.objects;

import com.example.childrenslibrayapp.structures.SinglyLinkedList;

import java.util.Calendar;

public class Client extends User{

    private Calendar date;
    private SinglyLinkedList <String> search;

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

}
