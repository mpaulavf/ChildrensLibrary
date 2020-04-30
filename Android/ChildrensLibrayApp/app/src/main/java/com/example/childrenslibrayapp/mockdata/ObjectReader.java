package com.example.childrenslibrayapp.mockdata;

//creditos a un compa de los andes por las listas para generar los libros.


import android.content.Context;
import android.util.Log;

import com.example.childrenslibrayapp.R;
import com.example.childrenslibrayapp.objects.*;
import com.example.childrenslibrayapp.structures.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.List;

import java.lang.*;


public class ObjectReader {
    private Context context;

    public ObjectReader(Context context){
        this.context = context;
    }


    public void readBooks(DynamicArray<Book> libros) {
        //Basado en info dada en https://www.youtube.com/watch?v=i-TqNzUryn8
        InputStream is = context.getResources().openRawResource(R.raw.libros_x10000);

        BufferedReader br = new BufferedReader(new InputStreamReader((is)));

        String line = "";
        try {
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                Book book = new Book();
                book.setTitle(tokens[0]);
                book.setAuthorName(tokens[1]);
                book.setCode(tokens[2]);
                book.setGenre(tokens[3]);

                libros.pushBack(book);

                Log.d("ObjectGenerator", "Libro creado: " + book);
            }
        }catch (IOException e){
            Log.wtf("ObjectGenerator", "Error reading data file " + line, e);
            e.printStackTrace();
        }
    }

    public void readBooks(SinglyLinkedList<Book> libros) {
        //Basado en info dada en https://www.youtube.com/watch?v=i-TqNzUryn8
        InputStream is = context.getResources().openRawResource(R.raw.libros_x10000);

        BufferedReader br = new BufferedReader(new InputStreamReader((is)));

        String line = "";
        try {
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                Book book = new Book();
                book.setTitle(tokens[0]);
                book.setAuthorName(tokens[1]);
                book.setCode(tokens[2]);
                book.setGenre(tokens[3]);

                libros.insertNodeAtTail(book);

                Log.d("ObjectGenerator", "Libro creado: " + book);
            }
        }catch (IOException e){
            Log.wtf("ObjectGenerator", "Error reading data file " + line, e);
            e.printStackTrace();
        }
    }

    public void readUsers(DynamicArray<User> users){

        //Basado en info dada en https://www.youtube.com/watch?v=i-TqNzUryn8
        InputStream is = context.getResources().openRawResource(R.raw.usuarios_x10000);

        BufferedReader br = new BufferedReader(new InputStreamReader((is)));

        String line = "";
        try {
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                User user = new User();
                user.setName(tokens[0]);
                user.setSurname(tokens[1]);
                user.setNickname(tokens[2]);
                user.setPassword(tokens[3]);

                user.setIsWorker((Boolean.valueOf(tokens[4])));

                users.pushBack(user);

                Log.d("ObjectGenerator", "Usuario creado: " + user);
            }
        }catch (IOException e){
            Log.wtf("ObjectGenerator", "Error reading data file " + line, e);
            e.printStackTrace();
        }

    }
    public void readUsers(SinglyLinkedList<User> users){

        //Basado en info dada en https://www.youtube.com/watch?v=i-TqNzUryn8
        InputStream is = context.getResources().openRawResource(R.raw.usuarios_x10000);

        BufferedReader br = new BufferedReader(new InputStreamReader((is)));

        String line = "";
        try {
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                User user = new User();
                user.setName(tokens[0]);
                user.setSurname(tokens[1]);
                user.setNickname(tokens[2]);
                user.setPassword(tokens[3]);

                user.setIsWorker((Boolean.valueOf(tokens[4])));

                users.insertNodeAtTail(user);

                Log.d("ObjectGenerator", "Usuario creado: " + user);
            }
        }catch (IOException e){
            Log.wtf("ObjectGenerator", "Error reading data file " + line, e);
            e.printStackTrace();
        }

    }



}
