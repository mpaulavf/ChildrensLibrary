package com.example.childrenslibrayapp.objects;

import com.example.childrenslibrayapp.structures.SinglyLinkedList;
import com.google.android.material.internal.ScrimInsetsFrameLayout;

import java.util.Scanner;

public class Search {

    private String tempSearch;
    private SinglyLinkedList <String> wordsInSearch;
    private SinglyLinkedList <String> history;

    public Search (String tempSearch) {
        this.tempSearch = tempSearch;
    }

    public Search (String tempSearch, SinglyLinkedList <String> history) {
        this.tempSearch = tempSearch;
        this.history = history;
    }

    public String getTempSearch() { return tempSearch; }
    public void setTempSearch(String tempSearch) {
        addToHistory(tempSearch);
        this.tempSearch = tempSearch;
    }

    public SinglyLinkedList <String> getWords() {
        Scanner sc = new Scanner(tempSearch);
        this.wordsInSearch = new SinglyLinkedList <String>();
        while (sc.hasNext()) {
            String temp = sc.next().trim();
            this.wordsInSearch.insertNodeAtTail(temp);
        }
        sc.close();
        return this.wordsInSearch;
    }
    public void setWords(SinglyLinkedList <String> words) { this.wordsInSearch = wordsInSearch; }

    public SinglyLinkedList <String> getHistory() { return history; }
    public void addToHistory(String tempSearch) {
        history.insertNodeAtTail(tempSearch);
    }

}

