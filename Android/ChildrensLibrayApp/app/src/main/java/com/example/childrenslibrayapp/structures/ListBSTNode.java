package com.example.childrenslibrayapp.structures;

public class ListBSTNode{

    public int data;
    public int i;
    public int height;
    public ListBSTNode left;
    public ListBSTNode right;
    public ListBSTNode parent;

    public ListBSTNode(int data, ListBSTNode parent) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = parent;
    }
    public ListBSTNode(int data) { //genera raíz del arbol
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

}
