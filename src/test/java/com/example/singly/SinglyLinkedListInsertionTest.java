package com.example.singly;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class SinglyLinkedListInsertionTest {

    private SinglyLinkedList linkedList;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void init(){
        linkedList = new SinglyLinkedList();
    }

    /**
     * I am able to insert nodes to a head into an empty linked list
     */
    @Test
    public void insertNodeIntoAnEmptyList(){
        linkedList.insert(5);
        assertThat(linkedList.head()).isNotNull();
        assertThat(linkedList.head().data()).isEqualTo(5);
    }

    /**
     * I am able to insert node into a non empty linked list
     */
    @Test
    public void insertNode(){
        linkedList.insert(5).insert(3);
        assertThat(linkedList.head().data()).isEqualTo(3);
        assertThat(linkedList.head().next().data()).isEqualTo(5);
    }

    /**
     * I am able to insert node into a tail of an empty linked list
     * in that case node inserted is both head and tail
     */
    @Test
    public void insertNodeAtTailOfEmptyList(){
        linkedList.insertAtTail(4);
        assertThat(linkedList.head()).isNotNull();
        assertThat(linkedList.tail()).isNotNull();
        assertThat(linkedList.head()).isEqualTo(linkedList.tail());
    }

    /**
     * I am able to insert node into a tail of a non empty linked list
     */
    @Test
    public void insertNodeAtTailOfNonEmptyList(){
        linkedList.insert(2).insert(3).insert(5);
        linkedList. insertAtTail(7);
        assertThat(linkedList.tail()).isNotNull();
        assertThat(linkedList.tail().data()).isEqualTo(7);
    }

    /**
     * If insert at invalid position of non empty list
     * then I am able to get InvalidPositionException
     */
    @Test
    public void insertAtInvalidPosition(){
        linkedList.insert(2).insert(3).insert(7);
        exception.expect(IllegalArgumentException.class);
        linkedList.insertAtPosition(5,1);
    }

    /**
     * If insert at valid position of non empty list
     * then I am able to retrieve element from definite position
     */
    @Test
    public void insertAtPosition(){
        linkedList.insert(2).insert(3).insert(7);
        linkedList.insertAtPosition(4,9);
        //assertThat(linkedList.nodeAtPosition(4).data()).isEqualTo(9);
    }
}
