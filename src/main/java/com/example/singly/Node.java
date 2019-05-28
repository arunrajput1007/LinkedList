package com.example.singly;

import lombok.ToString;

import java.util.Objects;

@ToString
public class Node {

    private int data;
    private Node next;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public Node next() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Node)){
            return false;
        }
        return this.getData() == ((Node) obj).getData();
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
