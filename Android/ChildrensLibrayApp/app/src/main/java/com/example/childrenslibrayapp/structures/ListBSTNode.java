package com.example.childrenslibrayapp.structures;

import com.example.childrenslibrayapp.objects.Book;

public class ListBSTNode<T>{

    public Book data;
    public int i;
    public int height;
    public ListBSTNode<T> left;
    public ListBSTNode<T> right;
    public ListBSTNode<T> parent;

    public ListBSTNode(Book data, ListBSTNode<T> parent) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = parent;
    }
    public ListBSTNode(Book data) { //genera raíz del arbol
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

}
