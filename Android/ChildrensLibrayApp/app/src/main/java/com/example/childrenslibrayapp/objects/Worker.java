package com.example.childrenslibrayapp.objects;

import com.example.childrenslibrayapp.structures.DynamicArray;

public class Worker extends User{

    public Worker(String name, String surname, String nickname, String password, Boolean isWorker) {
        super(name, surname, nickname, password, isWorker);
    }

    private DynamicArray<Client> allClients = new DynamicArray<Client>();
    private DynamicArray<Book> allBooks = new DynamicArray<Book>();

    private void addNewBook(Book book){
        allBooks.pushBack(book);
    }

    private void removeBook(Book book){

    }

    private void modifyBook(){

    }

    private void giveBook(Client client, Book book){
        BorrowState state = book.getBorrowState();
        if(!state.borrow){
            if(state.nextInLine().getNickname().equals(client.getNickname())){
                state.borrow = true;
                state.startBorrow(true);
            }
        }
    }

    private void returnBook(int code, Book book) throws Exception {
        Client temp = (Client) allClients.getVal(code);
        DynamicArray aux = temp.getBorrowBooks();
        Book ex;
        for(int i=0;i<aux.getSize();i++){
            ex = (Book) aux.getVal(i);
            if(ex.getCode().equals(book.getCode())){
                book.getBorrowState().borrow = false;
            }
        }
    }

    // Se le quitará la marca de moroso al cliente cuando no tenga libros en su lista de prestados
    // El cliente se debe comunicar para ello
    private void removeMark(int code) throws Exception {
        Client temp = (Client) allClients.getVal(code);
        DynamicArray aux = temp.getBorrowBooks();
        if(aux.isEmpty()) temp.setMark(false);
    }

}
