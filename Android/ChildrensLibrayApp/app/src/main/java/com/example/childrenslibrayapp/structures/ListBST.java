package com.example.childrenslibrayapp.structures;

import com.example.childrenslibrayapp.objects.Book;

public class ListBST<T> { //implementado para enteros

    public ListBSTNode<T> root;

    public ListBST() {
        root = null;
    }

    //Métodos: find || next || add || remove || search

    public ListBSTNode<T> find (Book data, ListBSTNode<T> root){
        if(root.data == data){
            return root;
        }else if (data.getCode().compareTo(root.data.getCode()) < 0){
            if (root.left != null){
                return find(data, root.left);
            }
            return root;
        }else if (data.getCode().compareTo(root.data.getCode()) > 0){
            if (root.left != null){
                return find(data, root.right);
            }
            return root;
        }
        return root;
    }

    public ListBSTNode<T> next (ListBSTNode<T> n){
        if (n.right != null){
            return LeftDescendant(n.right);
        }else{
            return RightAncestor(n);
        }
    }

    private ListBSTNode<T> LeftDescendant (ListBSTNode<T> n){
        if (n.left != null){
            return n;
        }else{
            return LeftDescendant (n.left);
        }
    }

    private ListBSTNode<T> RightAncestor (ListBSTNode<T> n){
        if (n.data.getCode().compareTo(n.parent.data.getCode()) < 0){
            return n.parent;
        }else{
            return RightAncestor (n.parent);
        }
    }

    public void insert(Book k, ListBSTNode<T> root) {
        ListBSTNode p = find(k, root);
        p.data = k;
    }

    public void removeRootAndBalance(ListBSTNode root, Book book){

        ListBSTNode temp = null;
        ListBSTNode aux = find(book, root);

        if(aux != null) {
            if ((aux.left == null) && (aux.right == null)) aux = null;
            else if (aux.left != null && aux.right != null) {
                if(aux.data.getCode().equals(this.root.data.getCode())){
                    temp = aux.left;
                    aux = aux.right;
                    while(aux.left != null){
                        aux = aux.left;
                    }
                    aux.left = temp;
                } else {
                    if(aux.data.getCode().equals(this.root.data.getCode())){
                        if(aux.left != null){
                            aux = aux.left;
                        } else{
                            aux = aux.right;
                        }
                    }
                }
                return;
            }
            return;
        }
    }

    public ListBSTNode insertBalance(ListBSTNode root,Book data){

        if(root==null){
            root = new ListBSTNode(data);
            root.height = adjustRootHeight(root);
            return root;
        } else if((data.compareTo(root.data) > 0) && data.equals(root.data)) root.left = insertBalance(root.left, data);
        else if(data.compareTo(root.data) > 0) root.right = insertBalance(root.right, data);

        int balanceFactor = rootHeight(root.left) - rootHeight(root.right);

        if(balanceFactor>1){
            if(rootHeight(root.left.left) < rootHeight(root.left.right)) root.left = leftRotation(root.left);
            root = rightRotation(root);
        } else if(balanceFactor<-1){
            if(rootHeight(root.right.right) < rootHeight(root.right.left)) root.right = rightRotation(root.right);
            root = leftRotation(root);
        } else root.height = adjustRootHeight(root);

        return root;

    }

    public int rootHeight(ListBSTNode root){
        if(root==null) return -1;
        else return root.height;
    }

    public int adjustRootHeight(ListBSTNode root){
        if(root==null) return -1;
        else return 1 + Math.max(rootHeight(root.left), rootHeight(root.right));
    }

    public ListBSTNode rightRotation(ListBSTNode root){

        ListBSTNode temp = root.left;
        root.left = temp.right;
        temp.right = root;
        root.height = adjustRootHeight(root);
        temp.height = adjustRootHeight(temp);

        return temp;

    }

    public ListBSTNode leftRotation(ListBSTNode root){

        ListBSTNode temp = root.right;
        root.right = temp.left;
        temp.left = root;
        root.height = adjustRootHeight(root);
        temp.height = adjustRootHeight(temp);

        return temp;

    }

    private void adjustHeight(ListBSTNode n) {
        n.height = 1 + Math.max(n.left.height, n.right.height);
    }

    public boolean isEmpty(){
       return root == null;
    }

}
