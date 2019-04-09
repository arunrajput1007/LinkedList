package com.example.singly;

import java.util.function.IntFunction;
import java.util.function.Supplier;

public class SinglyLinkedList {

    private Node head;

    public SinglyLinkedList(Node head) {
        this.head = head;
    }

    public void insertNodeAtTail(Node node){
        if(isHeadNotEmpty()){
            Node last = tail.get();
            addNodeAfter(last,node);
        } else{
            promoteNodeAsHead(node);
        }
    }

    public void insertNodeAtHead(Node node){
        promoteNodeAsHead(node);
    }

    public void insertNodeAtPosition(int pos, Node node){
        Node secondLastPosNode = goToPosition.apply(pos-1);
        addNodeAfter(secondLastPosNode,node);
    }

    //update head
    //update tail
    //update at position
    //delete single node at position
    //delete tail
    //delete head
    //delete everything after position

    //get node at position
    //get everything after position

    //find middle node
    //find length of linked list

    private boolean isHeadNotEmpty(){
        return head != null;
    }

    private void addNodeAfter(Node afterNode, Node newNode){
        Node temp = afterNode.next;
        afterNode.next = newNode;
        newNode.next = temp;
    }

    private void promoteNodeAsHead(Node node){
        if(isHeadNotEmpty()) {
            node.next = head;
        }
        head = node;
    }

    public void print(){
        System.out.println(head);
    }

    private Supplier<Node> tail = () -> {
        Node node = head;
        while(node.next!=null){
            node = node.next;
        }
        return node;
    };

    //TODO need to refactor
    private IntFunction<Node> goToPosition = pos -> {
        int currentPos = 0;
        Node node = head;
        while(node.next!=null && currentPos!=pos){
            node = node.next;
        }
        return node;
    };

}
