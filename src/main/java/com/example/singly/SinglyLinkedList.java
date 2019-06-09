package com.example.singly;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

@Data
@NoArgsConstructor
public class SinglyLinkedList {

    private Node head;
    private Node tail;

    public SinglyLinkedList(Node head) {
        this.head = head;
        this.tail = head;
    }

    public SinglyLinkedList(List<Integer> integerList) {
        integerList.forEach(this::insertAtTail);
    }

    public SinglyLinkedList(int[] integerArray) {
        Arrays.stream(integerArray).forEach(this::insertAtTail);
    }

    public Node head() {
        return head;
    }

    public Node tail(){
        return tail;
    }

    public Node nodeAtPosition(int position){
        IndexedNode indexedNode = findFirst((index, node) -> index == position - 1);
        if (indexedNode == null) {
            throw new IllegalArgumentException("invalid position: "+position);
        }else{
            return indexedNode.node();
        }
    }

    public IndexedNode findFirst(BiPredicate<Integer, Node> biPred) {
        Node node = head;
        for (int index = 0; node != null; node = node.next(), index++) {
            if (biPred.test(index, node)) {
                return new IndexedNode(node, index);
            }
        }
        return null;
    }

    public int size(){
        IndexedNode indexedNode = findFirst((index, node) -> node.next() == null);
        if (indexedNode == null) {
            return 0;
        } else
            return indexedNode.index() + 1;
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
