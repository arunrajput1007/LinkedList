package com.example.singly;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.example.singly.TestUtil.stringArrToIntArr;
import static org.assertj.core.api.Assertions.assertThat;

public class SinglyLinkedListInsertionSteps {

    private final String HEAD = "HEAD";
    private final String TAIL = "TAIL";
    private SinglyLinkedList singlyList;
    private Node actualNode;
    private int[] intArr;

    @Given("I have a Singly Linked List with elements (.*)")
    public void initList(String contents) {
        if (!contents.equals("-")) {
            intArr = stringArrToIntArr(contents.split(","));
            singlyList = new SinglyLinkedList(intArr);
        } else {
            singlyList = new SinglyLinkedList();
        }
    }

    @When("I insert a node with data (.*) at (.*) position into it")
    public void insertNode(int data, String position) {
        switch (position) {
            case HEAD:
                singlyList.insertAtHead(data);
                break;
            case TAIL:
                singlyList.insertAtTail(data);
                break;
            default:
                singlyList.insertAtPosition(Integer.parseInt(position), data);
                break;
        }
    }

    @Then("I am able to retrieve the inserted node at position (.*)$")
    public void getNode(String position) {
        switch (position) {
            case HEAD:
                actualNode = singlyList.head();
                break;
            case TAIL:
                actualNode = singlyList.tail();
                break;
            default:
                actualNode = singlyList.nodeAtPosition(Integer.parseInt(position));
                break;
        }
    }

    @And("I can verify the retrieved node is (.*)")
    public void assertAsPerExpectation(String expectation) {
        switch (expectation) {
            case "HEAD && TAIL":
                assertThat(singlyList.head())
                        .isEqualTo(singlyList.tail())
                        .isEqualTo(actualNode);
                break;
            case "HEAD && !TAIL":
                assertThat(singlyList.head())
                        .isEqualTo(actualNode);
                break;
            case "!HEAD && TAIL":
                assertThat(singlyList.tail())
                        .isEqualTo(actualNode);
                break;
        }
    }

    @And("the contents of the list is (.*)")
    public void verifyContents(String expectedContents) {
        intArr = stringArrToIntArr(expectedContents.split(","));
        assertThat(singlyList).isEqualTo(new SinglyLinkedList(intArr));
    }

    @And("size of the list is (.*)")
    public void verifySize(Integer size) {
        assertThat(singlyList.size()).isEqualTo(size);
    }
}
