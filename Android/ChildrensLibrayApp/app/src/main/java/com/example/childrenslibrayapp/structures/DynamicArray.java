package com.example.childrenslibrayapp.structures;

import android.util.Log;

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

    public void pushBack(T val){
        if (size == capacity-1){
            capacity = 2* capacity;
            T[] newArr = (T[]) new Object[capacity];

            for (int i=0; i<size; i++){
                newArr [i] = arr[i];
            }
            arr = newArr;
        }

        Log.d("ObjectGenerator", arr.length + "," + size);

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

     public void clear() { // Basado en https://stackoverflow.com/questions/7032070/what-is-the-difference-between-arraylist-clear-and-arraylist-removeall

         for (int i = 0; i < arr.length; i++)
             arr[i] = null;
         size = 0;
     }


}
