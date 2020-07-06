package com.example.childrenslibrayapp.structures;

public class HashTable<String, T> {

    public T val;
    public int state; //0 = Vacío, 1 = Eliminado, 2 = Lleno

    public int hashFuncion(int n, int m) {
        return ((n + 1) % m);
    }

    public void put(String key, T item){

    }

    public boolean searchKey(String key){
        return true;
    }

    public void remove(String key){

    }

    public T get(String key){
        T item = null;
        return item;
    }

}
