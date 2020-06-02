package com.example.childrenslibrayapp.structures;

public class ListBSTNode<T>{

    public T data;
    public ListBSTNode<T> left;
    public ListBSTNode<T> right;

    public ListBSTNode(T item) { //genera el arbol vacío
        this.data = null;
        this.left = null;
        this.right =null;
    }

}
