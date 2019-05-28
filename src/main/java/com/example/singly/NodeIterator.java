package com.example.singly;

import java.util.Iterator;

public class NodeIterator implements Iterator<Node> {
    private SinglyLinkedList linkedList;
    private Node node;
    private boolean startedIteration;

    public NodeIterator(SinglyLinkedList linkedList) {
        this.linkedList = linkedList;
        this.node=null;
    }

    public static NodeIterator createIterator(SinglyLinkedList list){
        return new NodeIterator(list);
    }

    @Override
    public boolean hasNext() {
        if(startedIteration){
            return node.next()!=null;
        } else{
            return linkedList.getHead()!=null;
        }
    }

    @Override
    public Node next() {
        if(!startedIteration){
            startedIteration = true;
            node = linkedList.getHead();
        }else{
            node = node.next();
        }
        return node;
    }

    public Node current(){
        return this.node;
    }

    public Node iterateTo(int position){
        int count = 0;
        for( ; hasNext() && position!=count; count++){
            next();
        }
        if(count!=position){
            throw new IllegalArgumentException("Position not reachable: "+position);
        }
        return current();
    }

    public Node iterateToLast(){
        while(hasNext()){
            next();
        }
        return current();
    }
}
