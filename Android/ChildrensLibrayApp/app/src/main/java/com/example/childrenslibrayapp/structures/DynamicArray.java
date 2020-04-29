package com.example.childrenslibrayapp.structures;

public class DynamicArray<T> {
    private int capacity;
    private int size;
    private T[] arr;

    public DynamicArray() {
        capacity = 64;
        size = 0;
        arr = (T[]) new Object [capacity];
    }

    public T getVal(int i) throws Exception{
        if (i<0||i>size){
            throw new Exception("indice invalido");
        }
        return arr[i];
    }

    public void setVal(int i, T val) throws Exception{
        if (i<0||i>size){
            throw new Exception("indice invalido");
        }
        arr[i] = val;
    }

    public void PushBack(T val){
        if (size == capacity){
            T[] newArr = (T[]) new Object[2*capacity];
            for (int i=0; i<size; i++){
                newArr [i] = arr[i];
            }
            arr[capacity] = newArr[2*capacity];
        }

        arr[size] = val;
        size++;
    }

     public void remove (int i) throws Exception {
         if (i<0||i>size){
             throw new Exception("indice invalido");
         }
         for(int j=i; j<size-1;j++){
             arr[j] = arr[j+1];
         }
         size--;
     }

     public int getSize (){
        return size;
     }

}
