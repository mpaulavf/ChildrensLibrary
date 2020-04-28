package com.example.childrenslibrayapp.structures;

public class Node<T> {

    public T data;
    public Node<T> next;

    public Node(T item) {
        this.data = item;
        this.next = null;
    }

}
