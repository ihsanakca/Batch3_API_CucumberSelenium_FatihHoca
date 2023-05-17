Feature: Sign Up

  @wip
  Scenario Outline:
    When The user creates a POST request with "<name>" and "<email>" and "<password>" and "<about>" and "<terms>"
    Then The user verifys that the status code is <statusCode>
    And The user verfiys that body contains "<content>"
    And The compiler gets the token
    Examples:
      | name | email | password | about | terms | statusCode | content |
      | name | email | password | about | terms | 200        | content |

