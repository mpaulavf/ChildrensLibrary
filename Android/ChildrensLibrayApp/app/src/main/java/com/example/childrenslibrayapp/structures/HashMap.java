package com.example.childrenslibrayapp.structures;
import java.util.*;
import java.lang.String;
import com.example.childrenslibrayapp.objects.Client;

public class HashMap<String, Client> {

    public int state;
    public String key;
    public Client client;
    public int size = 13;
    public String[] all;

    public HashMap(){
        this.state = state;
        this.key = key;
        this.client = client;
        this.size = size;
        this.all = all;
    }

    public int hashCode(String key, Client client) {
        int n = key.toString().length();
        int m = Integer.parseInt(client.getClass().getName());
        return ((n + 1) % m);
    }

    public void put(String key, Client client){
        HashMap[] h = new HashMap[size];
        boolean temp = false;
        int aux = hashCode(key, client);
        do {
            if (h[aux].state == 0 || h[aux].state == 1) {
                h[aux].client = client;
                h[aux].state = 2;
                temp = true;
            } else {
                aux++;
            }
        } while (aux<size && !temp);
    }

    public boolean searchKey(String key){
        HashMap[] h = new HashMap[size];
        int j = hashCode(key, get(key));
        while (j < size) {
            if (h[j].state == 0) {
                return false;
            } else if (h[j].client == get(key)) {
                if (h[j].state == 1) {
                    return false;
                } else {
                    return true;
                }
            } else {
                j++;
            }
        }
        return false;
    }

    public void remove(String key){
        HashMap[] h = new HashMap[size];
        boolean temp = searchKey(key);
        if (temp == false) return;
        else {
            int i = hashCode(key, get(key));
            h[i].state = 1;
            return;
        }
    }

    // Retorna el cliente de la clave
    public Client get(String key){
        return client;
    }

}

