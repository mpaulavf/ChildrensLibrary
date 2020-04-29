package com.example.childrenslibrayapp.mockdata;

import com.example.childrenslibrayapp.objects.Book;
import com.example.childrenslibrayapp.structures.SinglyLinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CSVReader {
    InputStream inputStream;

    public CSVReader(InputStream is){
        this.inputStream = is;
    }

    public SinglyLinkedList<String[]> read(){
        SinglyLinkedList<String[]> resultados = new SinglyLinkedList<String[]>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        try {
            String csvLine;
            while ((csvLine = reader.readLine()) != null) {
                String[] fila = csvLine.split(",");
                resultados.insertNodeAtTail(resultados.head,fila);


            }
        }catch (IOException e) {
            throw new RuntimeException("Error al leer el CSV: " + e);
        } finally {
            try {
                inputStream.close();
            }catch (IOException ex){
                throw new RuntimeException("Error al cerrar el input stream: " + ex);
            }
        }
       return  resultados;
    }
}
