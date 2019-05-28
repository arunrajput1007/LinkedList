package com.example.singly;

public class SinglyLinkedList {

    private Node head;

    public Node getHead() {
        return head;
    }

    public Node getTail(){
        return getIterator().iterateToLast();
    }

    public int getLength(){
        NodeIterator iterator = getIterator();
        int sizeCount = 0;

        while (iterator.hasNext()){
            iterator.next();
            sizeCount++;
        }
        return sizeCount;
    }

    public Node getNodeAtPosition(Integer position){
        return getIterator().iterateTo(position);
    }

    private NodeIterator getIterator(){
        return NodeIterator.createIterator(this);
    }

    public SinglyLinkedList insertAtHead(Integer data) {
        Node node = new Node(data);
        if(head == null){
            head = node;
        }else{
            node.setNext(head);
            head = node;
        }
        return this;
    }

    public SinglyLinkedList insertAtTail(Integer data) {
        Node node = new Node(data);
        if(getTail()==null){
            head = node;
        }else{
            getTail().setNext(node);
        }
        return this;
    }

    public SinglyLinkedList insertAtPosition(Integer position,Integer data) {
        Node node = new Node(data);
        Node previousNode = getNodeAtPosition(position-1);
        Node nextNode = previousNode.next();
        previousNode.setNext(node);
        node.setNext(nextNode);
        return this;
    }

    /*public SinglyLinkedList updateHead(){}

    public SinglyLinkedList updateHead(){}

    public SinglyLinkedList updateHead(){}*/
}
