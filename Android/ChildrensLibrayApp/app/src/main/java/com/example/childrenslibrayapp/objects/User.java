package com.example.childrenslibrayapp.objects;

import com.example.childrenslibrayapp.mockdata.ObjectGenerator;
import com.example.childrenslibrayapp.structures.Node;
import com.example.childrenslibrayapp.structures.SinglyLinkedList;

public class User {

    private String name;
    private String surname;
    private String nickname;
    private String password;
    private Boolean isWorker;

    public User(String name, String surname, String nickname, String password, Boolean isWorker) {
        this.name = name;
        this.surname = surname;
        this.nickname = nickname;
        this.password = password;
        this.isWorker = isWorker;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Boolean getIsWorker() { return isWorker; }
    public void setIsWorker(Boolean isWorker) { this.isWorker = isWorker; }

    public void filtrarUsuarios(SinglyLinkedList <User> users) {
        Node temp = users.head;
        if (temp == null) return;
        Node aux = users.head;
        SinglyLinkedList <Client> client = new SinglyLinkedList <Client>();
        SinglyLinkedList <Worker> worker = new SinglyLinkedList <Worker>();
        while(true){
            if (temp.next != null) {
                User userTemp = (User) temp.data;
                if (userTemp.getIsWorker()==true) {
                    Worker workerTemp = (Worker) userTemp;
                    worker.insertNodeAtTail(aux, workerTemp);
                }
                else {
                    Client clientTemp = (Client) userTemp;
                    client.insertNodeAtTail(aux, clientTemp);
                }
                temp = temp.next;
            }
            else break;
        }
    }

}
