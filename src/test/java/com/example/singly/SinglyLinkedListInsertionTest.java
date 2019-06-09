package com.example.singly;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @todo Migrate all these test in cucumber and check whethet it looks pretty or not
 */
public class SinglyLinkedListInsertionTest {

    private SinglyLinkedList linkedList;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void init(){
        linkedList = new SinglyLinkedList();
    }

    /**
     * I am able to insertAtHead nodes to a head into an empty linked list
     */
    @Test
    public void insertNodeIntoAnEmptyList(){
        linkedList.insertAtHead(5);
        assertThat(linkedList.head()).isNotNull();
        assertThat(linkedList.head().data()).isEqualTo(5);
    }

    /**
     * I am able to insertAtHead node into a non empty linked list
     */
    @Test
    public void insertNode(){
        linkedList.insertAtHead(5).insertAtHead(3);
        assertThat(linkedList.head().data()).isEqualTo(3);
        assertThat(linkedList.head().next().data()).isEqualTo(5);
    }

    /**
     * I am able to insertAtHead node into a tail of an empty linked list
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
     * I am able to insertAtHead node into a tail of a non empty linked list
     */
    @Test
    public void insertNodeAtTailOfNonEmptyList(){
        linkedList.insertAtHead(2).insertAtHead(3).insertAtHead(5);
        linkedList. insertAtTail(7);
        assertThat(linkedList.tail()).isNotNull();
        assertThat(linkedList.tail().data()).isEqualTo(7);
    }

    /**
     * If insertAtHead at invalid position of non empty list
     * then I am able to get InvalidPositionException
     */
    @Test
    public void insertAtInvalidPosition(){
        linkedList.insertAtHead(2).insertAtHead(3).insertAtHead(7);
        exception.expect(IllegalArgumentException.class);
        linkedList.insertAtPosition(5,1);
    }

    /**
     * If insertAtHead at valid position of non empty list
     * then I am able to retrieve element from definite position
     */
    @Test
    public void insertAtPosition(){
        linkedList.insertAtHead(2).insertAtHead(3).insertAtHead(7);
        linkedList.insertAtPosition(4,9);
        assertThat(linkedList.nodeAtPosition(4).data()).isEqualTo(9);
    }
}
