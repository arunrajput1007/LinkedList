package com.example.singly;

public class Client {

    public static void main(String [] args){
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList(null);
        singlyLinkedList.insertNodeAtTail(new Node(5));
        singlyLinkedList.print();
        singlyLinkedList.insertNodeAtTail(new Node(6));
        singlyLinkedList.print();
        singlyLinkedList.insertNodeAtHead(new Node(7));
        singlyLinkedList.print();
        singlyLinkedList.insertNodeAtPosition(1,new Node(3));
        singlyLinkedList.print();
    }
}
