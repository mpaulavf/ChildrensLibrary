package com.example.childrenslibrayapp.structures;

public class ArrayBST  {
    public DynamicArray bst;
    //root i = 1
    //leftChild 2i / rightChild 2i+1 / parent = i/2

    public ArrayBST() {
        bst = new <Integer> DynamicArray();
    }

    //Metodos añadir, eliminar, buscar
/*
    public int find (int query, ArrayBST arBst){
        if(arBst.root == data){
            return root;
        }else if (data < root.data){
            if (root.left != null){
                return find(data, root.left);
            }
            return root;
        }else if (data > root.data){
            if (root.left != null){
                return find(data, root.right);
            }
            return root;
        }
        return root;
    }
*/



}
