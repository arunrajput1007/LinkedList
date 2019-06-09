package com.example.singly;

import static com.example.singly.ListFunctionalUtil.*;

public class SinglyLinkedList {

    private Node head;

    private Node tail;

    public SinglyLinkedList(Node head) {
        this.head = head;
        this.tail = head;
    }

    public SinglyLinkedList() {
    }

    public Node head() {
        return head;
    }

    public Node tail(){
        return tail;
    }

    public Node nodeAtPosition(int position){
        NodeWithIndex nodeWithIndex = findFirst(head,(index,node) -> index == position-1);
        if(nodeWithIndex == null){
            throw new IllegalArgumentException("invalid position: "+position);
        }else{
            return nodeWithIndex.node();
        }
    }

    public int size(){
        NodeWithIndex nodeWithIndex = findFirst(head,(index,node) -> node.next()==null);
        if(nodeWithIndex == null){
            return 0;
        } else
            return nodeWithIndex.index()+1;
    }

    public SinglyLinkedList insertAtHead(Integer data) {
        Node node = new Node(data);
        if(head != null){
            node.updateNext(head);
        } else{
            tail = node;
        }
        head = node;
        return this;
    }

    public SinglyLinkedList insertAtTail(Integer data) {
        Node node = new Node(data);
        if(tail == null){
            head = node;
        }else{
            tail.updateNext(node);
        }
        tail = node;
        return this;
    }

    public SinglyLinkedList insertAtPosition(Integer position,Integer data) {
        Node node = new Node(data);
        Node previousNode = nodeAtPosition(position-1);
        Node nextNode = previousNode.next();
        previousNode.updateNext(node);
        node.updateNext(nextNode);
        return this;
    }
}
