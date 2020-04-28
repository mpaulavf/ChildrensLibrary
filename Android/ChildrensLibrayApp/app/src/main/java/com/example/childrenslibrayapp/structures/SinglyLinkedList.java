package com.example.childrenslibrayapp.structures;

public class SinglyLinkedList<T> {

    public Node<T> head;
    public Node<T> tail;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }


    public Node<T> insertNodeAtHead(Node<T> list, T data) {
        Node<T> first = new Node<T>(data);
        if(list == null) return first;
        Node<T> temp = list;
        list = first;
        list.next = temp;
        return list;
    }


    public Node<T> insertNodeAtPosition(Node<T> head, T data, int position) {
        Node<T> node0 = new Node<T>(data);
        node0.next = null;
        if(head == null || position == 0){
            node0.next = head;
            head = node0;
            return head;
        }else{
            Node<T> node1 = head;
            for(int i=0;i < position-1;i++){
                node1 = node1.next;
            }
            node0.next = node1.next;
            node1.next = node0;
            return head;
        }
    }

    public Node<T> insertNodeAtTail(Node<T> head, T data) {
        Node<T> temp = new Node<T>(data);
        temp.next = null;
        if (head == null){
            head = temp;
        }else{
            Node<T> node = head;
            while (node.next != null){
                node = node.next;
            }
            node.next = temp;
        }
        return head;
    }

    public Node<T> deleteNode(Node<T> head, int position) {
        if(position == 0) head=head.next;
        else{
            Node<T> temp = head;
            for(int i=0;i < position-1;i++){
                temp=temp.next;
            }
            temp.next=temp.next.next;
        }
        return head;
    }

    public Node<T> removeDuplicates(Node<T> head) {
        if(head == null && head.next == null) return null;
        Node<T> node = head;
        while(head.next != null){
            if (head.data == head.next.data) head.next = head.next.next;
            else head = head.next;
        }
        return node;
    }

    public void printLinkedList(Node<T> head) {
        if (head == null) return;
        while(true){
            System.out.println(head.data);
            if (head.next != null) head = head.next;
            else break;
        }
    }

    public void reversePrint(Node<T> head) {
        if(head == null) return;
        reversePrint(head.next);
        System.out.println(head.data);
    }

}