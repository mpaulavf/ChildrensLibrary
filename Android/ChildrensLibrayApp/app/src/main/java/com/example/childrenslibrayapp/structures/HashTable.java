package com.example.childrenslibrayapp.structures;

public class HashTable {

    public int val;
    public int state; //0 = Vacío, 1 = Eliminado, 2 = Lleno

    static int hashFuncion(int n, int m) {
        return ((n + 1) % m);
    }

    static void insert(HashTable[] h, int m, int n) {
        boolean temp = false;
        int aux = hashFuncion(n, m);
        do {
            if (h[aux].state == 0 || h[aux].state == 1) {
                h[aux].val = n;
                h[aux].state = 2;
                temp = true;
            } else {
                aux++;
            }
        } while (aux<m && !temp);
    }

    static int search(HashTable[] h, int m, int n) {
        int j = hashFuncion(n, m);
        while (j < m) {
            if (h[j].state == 0) {
                return -1;
            } else if (h[j].val == n) {
                if (h[j].state == 1) {
                    return -1;
                } else {
                    return j;
                }
            } else {
                j++;
            }
        }
        return -1;
    }

    static int delete(HashTable[] h, int m, int n) {
        int i = search(h, m, n);
        if (i == -1) {
            return -1;
        } else {
            h[i].state = 1;
            return 1;
        }
    }

}
