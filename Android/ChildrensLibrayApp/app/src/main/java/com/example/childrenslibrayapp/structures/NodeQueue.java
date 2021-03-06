package com.example.childrenslibrayapp.structures;

public class NodeQueue<T> {

    private int size;
    private Node<T> front, last;

    NodeQueue(int size) {
        front=null;
        last=null;
    }

    public boolean isEmpty() {
        if (front == null && last == null) return true;
        else return false;
    }

    public boolean isFull() {
        if (size == 4) return true;
        else return false;
    }

    public void push(T info) {
        Node<T> nodex = new Node<T>(null);
        nodex.data = info;
        nodex.next = null;
        size++;
        if (isEmpty()) {
            front = nodex;
            last = nodex;
        } else {
            last.next = nodex;
            last = nodex;
        }
    }

    public T pop() {
        size--;
        if (!isEmpty()){
            T n = front.data;
            if (front == last){
                front = null;
                last = null;
            } else {
                front = front.next;
            }
            return n;
        } else return null;
    }


}
