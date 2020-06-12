package com.example.childrenslibrayapp.mockdata;

import android.content.Context;

import com.example.childrenslibrayapp.R;
import com.example.childrenslibrayapp.objects.*;
import com.example.childrenslibrayapp.structures.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;


public class ObjectWriter {
    Context context;
    public ObjectWriter(Context current){
        this.context = current;
    }

    File exportBooks = new File(String.valueOf(context.getResources().openRawResource(R.raw.libros_x10000)));
    File exportUsers = new File(String.valueOf(context.getResources().openRawResource(R.raw.usuarios_x10000)));

    public void exportBooks(DynamicArray <Book> books, File destination){
        Book book = new Book();
        try {
            PrintWriter peewee = new PrintWriter(destination);
            for (int i=0; i<books.getSize();i++){

                book = books.getVal(i);

                peewee.println(book.getTitle() + "," + book.getAuthorName() + "," + book.getCode() + "," + book.getGenre());
            }

            peewee.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exportUsers (DynamicArray <User> users){
        User user = new User();
        try {
            PrintWriter peewee = new PrintWriter(exportUsers);
            for (int i=0; i<users.getSize();i++){

                user = users.getVal(i);

                peewee.println(user.getName() + "," + user.getSurname() + "," + user.getNickname() + "," + user.getPassword() + "," + user.getPassword() + "," + user.getIsWorker());
            }

            peewee.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
