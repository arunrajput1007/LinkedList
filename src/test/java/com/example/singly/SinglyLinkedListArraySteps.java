package com.example.singly;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import static com.example.singly.TestUtil.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SinglyLinkedListArraySteps {

    private int[] intArray = null;
    private ArrayList<Integer> intList;
    private SinglyLinkedList singlyList;

    @Given("I have an (.*) with elements (.*)")
    public void givenArray(String collectionType, String contents) {
        assertThat(contents).isNotBlank();
        switch (collectionType) {
            case "Array":
                String[] splitElems = contents.split(",");
                intArray = stringArrToIntArr(splitElems);
                break;
            case "ArrayList":
                intList = Arrays.stream(contents.split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toCollection(ArrayList::new));
                break;
        }
    }

    @When("I pass (.*) in the Singly Linked list Contructor as a Parameter")
    public void callContructor(String collectionType) {
        switch (collectionType) {
            case "Array":
                singlyList = new SinglyLinkedList(intArray);
                break;
            case "ArrayList":
                singlyList = new SinglyLinkedList(intList);
                break;
        }
    }

    @Then("the corresponding (.*) elements must be nodes of a list")
    public void verifyContents(String collectionType) {
        switch (collectionType) {
            case "Array":
                verifyArrayWithSinglyList(intArray, singlyList);
                break;
            case "ArrayList":
                verifyArrayListWithSinglyList(intList, singlyList);
                break;
        }
    }
}
