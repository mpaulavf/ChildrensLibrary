package com.example.childrenslibrayapp.structures;

public class ListBSTNode<T>{

    public String data;
    public int i;
    public int height;
    public ListBSTNode<T> left;
    public ListBSTNode<T> right;
    public ListBSTNode<T> parent;

    public ListBSTNode(String data, ListBSTNode<T> parent) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = parent;
    }
    public ListBSTNode(String data) { //genera raíz del arbol
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

}
