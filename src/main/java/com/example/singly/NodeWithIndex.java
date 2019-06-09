package com.example.singly;

public class NodeWithIndex {
    private Node node;
    private int index;

    public NodeWithIndex(Node node, int index) {
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
