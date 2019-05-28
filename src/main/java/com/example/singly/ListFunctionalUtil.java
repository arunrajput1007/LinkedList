package com.example.singly;

class ListFunctionalUtil {

    public static Node nodeAtPositionRecur(int count, int pos, Node head){
        return head!=null && count!=pos ?
                nodeAtPositionRecur(count+1, pos, head.next()): head;
    }

    public static int sizeRecur(Node head){
        return head!=null ? 1 + sizeRecur(head.next()): 0;
    }

    public static Node tailRecur(Node head){
        return head!= null && head.next()!= null ? tailRecur(head.next()): head;
    }
}
