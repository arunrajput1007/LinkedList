package com.example.singly;

public class IndexedNode {
    private Node node;
    private int index;

    public IndexedNode(Node node, int index) {
        this.node = node;
        this.index = index;
    }

    public Node node(){
        return node;
    }

    public int index(){
        return index;
    }
}
