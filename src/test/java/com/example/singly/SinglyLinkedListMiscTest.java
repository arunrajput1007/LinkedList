package com.example.singly;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SinglyLinkedListMiscTest {

    private SinglyLinkedList linkedList;

    @Before
    public void init(){
        linkedList = new SinglyLinkedList();
    }

    /**
     * Given Non empty list
     * when call to size method
     * then able to return the calculated size
     */
    @Test
    public void calculateSize(){
        linkedList.insertAtHead(5).insertAtTail(9).insertAtTail(8).insertAtHead(7);
        assertThat(linkedList.size()).isEqualTo(4);
    }

    /**
     * Given empty list
     * when call to size method
     * then the result is zero
     */
    @Test
    public void calculateSizeOfEmpty(){
        assertThat(linkedList.size()).isEqualTo(0);
    }

    /**
     * Given non empty list
     * when call to tail method
     * then able to get tail of the list
     */
    @Test
    public void goToTail(){
        linkedList.insertAtHead(2).insertAtHead(3).insertAtHead(5);
        assertThat(linkedList.tail().data()).isEqualTo(2);
    }

    /**
     * Given empty list
     * when call to tail method
     * then the result must be null
     */
    @Test
    public void goToTailOfEmpty(){
        assertThat(linkedList.tail()).isEqualTo(null);
    }

    /**
     * Given non empty list
     * when call to nodeAtPosition
     * then able to get node at specified position
     */
    @Test
    public void getNodeAtPosition(){
        linkedList.insertAtHead(4).insertAtHead(3).insertAtHead(8).insertAtHead(9);
        assertThat(linkedList.nodeAtPosition(1).data()).isEqualTo(9);
        assertThat(linkedList.nodeAtPosition(2).data()).isEqualTo(8);
        assertThat(linkedList.nodeAtPosition(3).data()).isEqualTo(3);
        assertThat(linkedList.nodeAtPosition(4).data()).isEqualTo(4);
    }

    /**
     * Given non empty list
     * able to search first occurrence of node
     */
    @Test
    public void findFirstTest() {
        linkedList.insertAtHead(4).insertAtHead(3).insertAtHead(8).insertAtHead(9);
        Node node = linkedList.findFirst((index, searchNode) -> searchNode.data() == 3).node();
        assertThat(node).isEqualTo(linkedList.nodeAtPosition(3));
    }
}
