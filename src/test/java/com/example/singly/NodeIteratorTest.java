package com.example.singly;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NodeIteratorTest {

    /**
     * Given non empty list
     * then hasnext must be true for each element
     * and next must be not null
     * for last element
     * hasnext must be false
     * next must be null
     */
    @Test
    public void nonEmptyList(){
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.insertAtHead(5).insertAtHead(4).insertAtHead(7);
        NodeIterator nodeIterator = NodeIterator.createIterator(linkedList);
        assertThat(nodeIterator.hasNext()).isTrue();
        assertThat(nodeIterator.next()).isEqualTo(new Node(7));
        assertThat(nodeIterator.hasNext()).isTrue();
        assertThat(nodeIterator.next()).isEqualTo(new Node(4));
        assertThat(nodeIterator.hasNext()).isTrue();
        assertThat(nodeIterator.next()).isEqualTo(new Node(5));

        assertThat(nodeIterator.hasNext()).isFalse();
        assertThat(nodeIterator.next()).isEqualTo(null);
    }

    /**
     * When next element called on empty list
     * then call to hasnext must be false
     * and call to next is equal to null
     */
    @Test
    public void whenNextElementOfEmptyListThenFalse(){
        SinglyLinkedList linkedList = new SinglyLinkedList();
        NodeIterator nodeIterator = NodeIterator.createIterator(linkedList);
        assertThat(nodeIterator.hasNext()).isFalse();
        assertThat(nodeIterator.next()).isNull();
    }
}
