package com.example.childrenslibrayapp.objects;

import com.example.childrenslibrayapp.structures.SinglyLinkedList;
import com.google.android.material.internal.ScrimInsetsFrameLayout;

import java.util.Scanner;

public class Search {

    public String category;
    private String tempSearch;
    private SinglyLinkedList <String> history;

    public Search (String tempSearch, String category) {
        this.tempSearch = tempSearch;
        this.category = category;
    }

    public String getTempSearch() { return tempSearch; }
    public void setTempSearch(String tempSearch) {
        //addToHistory(tempSearch); //esto es lo que genera el null pointer!!! Toca arreglarlo
        this.tempSearch = tempSearch;
    }

    public SinglyLinkedList <String> showHistory() { return history; }
    public void addToHistory(String tempSearch) {
        history.insertNodeAtTail(tempSearch);
    }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

}

