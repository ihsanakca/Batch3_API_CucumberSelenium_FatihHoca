Feature: Sign Up


  Scenario Outline: Exlab user register
    When The user creates a POST request with "<name>" and "<email>" and "<password>" and "<about>" and "<terms>"
    Then The user verifies that the status code is <statusCode>
    And The user verifies that body contains "<content>"
    And The compiler gets the token
    Examples:
      | name        | email            | password   | about      | terms | statusCode | content |
      | Ahmet Gezer | agezer@gmail.com | Ag12345678 | From Bursa | 54    | 200        | token   |


  Scenario Outline: Exlab User can be able to PATCH request and save profile
    When The user creates a PATCH request and send the token "<name>" and "<password>" and "<admin>" and "<about>" and "<terms>" and "<job>" and "<company>" and "<website>" and "<location>" and "<skills>"
    Then The user verifies that the status code is <statusCode>
    And The user creates a GET request to get user own profile with token
    And The user verfiys that name as "<name>" and email as "<email>"
    Examples:
      | name        | password   | admin  | about       | terms | job    | company | website        | location | skills        | statusCode | email            |
      | Ahmet Gezer | Ag12345678 | 0 or 1 | From Burdur | 23    | Devops | Google  | www.google.com | Istanbul | Java, Cypress | 204        | agezer@gmail.com |

