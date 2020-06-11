package com.example.childrenslibrayapp.structures;


public class ListBST { //implementado para enteros
    public ListBSTNode root;

    public ListBST () {
        root = null;
    }

    //Métodos: find || next || add || remove || search

    public ListBSTNode find (int data, ListBSTNode root){
        if(root.data == data){
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

    public ListBSTNode next (ListBSTNode n){
        if (n.right != null){
            return LeftDescendant(n.right);
        }else{
            return RightAncestor(n);
        }
    }

    private ListBSTNode LeftDescendant (ListBSTNode n){
        if (n.left != null){
            return n;
        }else{
            return LeftDescendant (n.left);
        }
    }

    private ListBSTNode RightAncestor (ListBSTNode n){
        if (n.data < n.parent.data){
            return n.parent;
        }else{
            return RightAncestor (n.parent);
        }
    }

    public void insert(int k, ListBSTNode root) {
        ListBSTNode p = find(k, root);
        p.data = k;
    }

    public void delete (ListBSTNode n){
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
/*
    private void rotateRight (ListBSTNode x){
        ListBSTNode p = x.parent;
        ListBSTNode y = x.left;
        ListBSTNode b = y.right;
        y.parent = p;
        p.correctChild() = y;
        x.parent = y;
        y.right = x;
        b.parent = x;
        x.left = b;
    }

    private void rebalance (ListBSTNode n){
        ListBSTNode p = n.parent;
        if (n.left.height > n.right.height+1){
            rebalanceRight(n);
        }
        if (n.right.height > n.left.height+1){
            rebalanceLeft(n);
        }

        adjustHeight(n);
        if (p!=null){
            rebalance(p);
        }
    }
*/
    private void adjustHeight(ListBSTNode n) {
        n.height = 1 + Math.max(n.left.height, n.right.height);
    }

}
