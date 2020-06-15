package com.example.childrenslibrayapp.structures;

public class ListBST<T> { //implementado para enteros

    public ListBSTNode<T> root;

    public ListBST() {
        root = null;
    }

    //Métodos: find || next || add || remove || search

    public ListBSTNode<T> find (String data, ListBSTNode<T> root){
        if(root.data == data){
            return root;
        }else if (data.compareTo(root.data) < 0){
            if (root.left != null){
                return find(data, root.left);
            }
            return root;
        }else if (data.compareTo(root.data) > 0){
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
        if (n.data.compareTo(n.parent.data) < 0){
            return n.parent;
        }else{
            return RightAncestor (n.parent);
        }
    }

    public void insert(String k, ListBSTNode<T> root) {
        ListBSTNode p = find(k, root);
        p.data = k;
    }

    public void delete (ListBSTNode<T> n){
        ListBSTNode temp = null;
        if (n.right == null){
            temp = n.left;
            n = temp;
            //quitar n, promover n.left;
        }else{
            ListBSTNode x = next(n);

            //reemplazar N con X, promover X.right;
        }
    }

    public static ListBSTNode insertBalance(ListBSTNode root,String data){

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

    public static int rootHeight(ListBSTNode root){
        if(root==null) return -1;
        else return root.height;
    }

    public static int adjustRootHeight(ListBSTNode root){
        if(root==null) return -1;
        else return 1 + Math.max(rootHeight(root.left), rootHeight(root.right));
    }

    public static ListBSTNode rightRotation(ListBSTNode root){

        ListBSTNode temp = root.left;
        root.left = temp.right;
        temp.right = root;
        root.height = adjustRootHeight(root);
        temp.height = adjustRootHeight(temp);

        return temp;

    }

    public static ListBSTNode leftRotation(ListBSTNode root){

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

}
