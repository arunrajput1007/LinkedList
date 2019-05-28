package com.example.singly;

import static com.example.singly.ListFunctionalUtil.*;

public class SinglyLinkedList {

    private Node head;

    public Node head() {
        return head;
    }

    public Node tail(){
        return tailRecur(head);
    }

    public int size(){
        return sizeRecur(head);
    }

    public Node nodeAtPosition(Integer position){
        return nodeAtPositionRecur(1,position,head());
    }

    public SinglyLinkedList insert(Integer data) {
        Node node = new Node(data);
        if(head == null){
            head = node;
        }else{
            node.changeNext(head);
            head = node;
        }
        return this;
    }

    public SinglyLinkedList insertAtTail(Integer data) {
        Node node = new Node(data);
        if(tail()==null){
            head = node;
        }else{
            tail().changeNext(node);
        }
        return this;
    }

    public SinglyLinkedList insertAtPosition(Integer position,Integer data) {
        Node node = new Node(data);
        Node previousNode = nodeAtPosition(position-1);
        Node nextNode = previousNode.next();
        previousNode.changeNext(node);
        node.changeNext(nextNode);
        return this;
    }
}
