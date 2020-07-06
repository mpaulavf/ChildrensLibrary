package com.example.childrenslibrayapp.objects;

import com.example.childrenslibrayapp.structures.DynamicArray;
import com.example.childrenslibrayapp.structures.HashTable;

import java.util.Date;

public class Worker extends User{

    public Worker(String name, String surname, String nickname, String password, Boolean isWorker) {
        super(name, surname, nickname, password, isWorker);
    }

    HashTable<String, Client> borrowBooks = new HashTable<String, Client>();
    HashTable<String, Client> markClients = new HashTable<String, Client>();

    private DynamicArray<Client> allClients = new DynamicArray<Client>();
    private DynamicArray<Book> allBooks = new DynamicArray<Book>();

    private void addNewBook(Book book){
        allBooks.pushBack(book);
    }

    private void removeBook(Book book) throws Exception {
        int temp = Integer.parseInt(book.getCode());
        allBooks.remove(temp);
    }

    // retorna falso si el libro no está disponible
    private boolean stateBook(Book book){
        String temp = book.getCode();
        if(borrowBooks.searchKey(temp) == true) return false;
        else return true;
    }

    // Retorna true si se puedo realizar el préstamo
    // De lo contrario, false y agrega al cliente a la lista de espera
    private boolean giveBook(Client client, Book book){
        String temp = book.getCode();
        String aux = book.getBorrowState().nextInLine().getNickname();
        if(stateBook(book) && client.getNickname()==aux) {
            borrowBooks.put(book.getCode(), client);
            return true;
        }
        else {
            book.getBorrowState().addToQueue(client);
            return false;
        }
    }

    private void returnBook(Book book) throws Exception {
        if(stateBook(book)) return;
        String temp = book.getCode();
        borrowBooks.remove(temp);
    }

    private void addMark(Book book){
        String aux = book.getCode();
        Date today = new Date();
        BorrowState temp = book.getBorrowState();
        if(!stateBook(book) && temp.endDate.compareTo(today)<0){
            Client client = borrowBooks.get(aux);
            markClients.put(client.getNickname(), client);
        }
    }

    // Se le quitará la marca de moroso al cliente cuando no tenga libros en su lista de prestados
    // El cliente se debe comunicar para ello
    private void removeMark(Client client) throws Exception {
        String temp = client.getNickname();
        if(markClients.searchKey(temp)) markClients.remove(temp);
    }

}
