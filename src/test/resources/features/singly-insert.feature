Feature: Insert node in Singly Linked list

  Scenario Outline: Able to insert node at different positions into a Singly Linked List
    Given I have a Singly Linked List with elements <input-contents>
    When I insert a node with data <data> at <position> position into it
    Then I am able to retrieve the inserted node at position <position>
    And I can verify the retrieved node is <expectation>
    And the contents of the list is <output-contents>
    And size of the list is <length>

    Examples:
      | input-contents | data | position | output-contents | expectation   | length |
      | -              | 5    | HEAD     | 5               | HEAD && TAIL  | 1      |
      | -              | 3    | TAIL     | 3               | HEAD && TAIL  | 1      |
      | 3,4,5          | 2    | HEAD     | 2,3,4,5         | HEAD && !TAIL | 4      |
      | 3,4,5          | 3    | TAIL     | 3,4,5,3         | !HEAD && TAIL | 4      |
      | 7,9,4,3,8      | 2    | 2        | 7,2,9,4,3,8     | -             | 6      |
      | 3,4,5          | 9    | 3        | 3,4,9,5         | -             | 4      |

  Scenario Outline: Able to instantiate Singly Linked List from Collection of elements
    Given I have an <Collection Type> with elements <input>
    When I pass <Collection Type> in the Singly Linked list Contructor as a Parameter
    Then the corresponding <Collection Type> elements must be nodes of a list

    Examples:
      | Collection Type | input |
      | Array           | 2,9,7 |
      | ArrayList       | 8,5   |

  try with junit