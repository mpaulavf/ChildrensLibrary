package com.example.childrenslibrayapp.structures;

import com.example.childrenslibrayapp.mockdata.Datos;
import com.example.childrenslibrayapp.objects.Book;

public class CalificationHeap {

    Datos datos = Datos.getInstance();

    SinglyLinkedList <Book> allBooksList = datos.getAllBooksList();
    DynamicArray <Book> allBooksArray = datos.getAllBooksArray();
    protected int capacity;
    protected int size;
    protected Book[] items;

    public CalificationHeap(){
        this.capacity = 10;
        this.size = 0;
        this.items = new Book[capacity];
    }

    public int getLeftChildIndex(int parentIndex){
        return (2*parentIndex)+1;
    }

    public int getRightChildIndex(int parentIndex){
        return (2*parentIndex)+2;
    }

    public int getParentIndex(int childIndex){
        if((childIndex-1)/2>=0) return (childIndex-1)/2;
        return 0;
    }

    public boolean hasLeftChild(int index){
        return getLeftChildIndex(index)<size;
    }

    public boolean hasRightChild(int index){
        return getRightChildIndex(index)<size;
    }

    public boolean hasParent(int index){
        return getParentIndex(index)>=0;
    }

    public Book leftChild(int index){
        return items[getLeftChildIndex(index)];
    }

    public Book rightChild(int index){
        return items[getRightChildIndex(index)];
    }

    public Book parent(int index){
        return items[getParentIndex(index)];
    }

    public boolean isEmpty(){
        return size==0;
    }

    public Book getMaxAndStay(){
        if(isEmpty()) return null;
        return  items[0];
    }

    public Book getMaxAndRemove(){
        if(isEmpty()) return null;
        Book item = items[0];
        items[0] = items[size - 1];
        size--;
        siftDown();
        return item;
    }

    public void insert(Book item){
        if(size<10) {
            items[size] = item;
            size++;
            siftUp();
        }
    }

    public void removeLastLeaf(){
        items[9]=null;
    }

    public void swap(int index1, int index2){
        Book temp = items[index1];
        items[index1] = items[index2];
        items[index1] = temp;
    }

    public void siftDown(){
        int index = 0;
        while(hasLeftChild(index)){
            int smallerChildIndex = getLeftChildIndex(index);

            int aux0 = items[getRightChildIndex(index)].getCalification();
            int aux1 = items[getLeftChildIndex(index)].getCalification();
            if(hasRightChild(index) && (aux0>aux1)) smallerChildIndex = getRightChildIndex(index);

            int aux2 = items[index].getCalification();
            int aux3 = items[smallerChildIndex].getCalification();
            if(aux2>aux3) break;
            else swap(index, smallerChildIndex);
            index = smallerChildIndex;
        }
    }

    public void siftUp() {
        int index = size - 1;

        int aux0 = items[getParentIndex(index)].getCalification();
        int aux1 = items[index].getCalification();
        while(hasParent(index) && (aux0<aux1)){
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    public void changeDefaultBooks(Book book){
        for(int i=0; i<=size; i++){
            if(items[i]==book) break;
        }
        removeLastLeaf();
        insert(book);
    }

}
