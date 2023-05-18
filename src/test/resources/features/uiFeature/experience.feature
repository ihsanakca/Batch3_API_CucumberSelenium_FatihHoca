Feature: Compare UI and API experiences

  @wip
  Scenario Outline: UI and API experiences
    When The user creates a POST request for add a new experience with "<job>" and "<company>" and "<location>" and "<fromdate>" and "<todate>" and "<current>" and "<description>"
    Then The user verifies that the status code is <statusCode>
    And The user is on the Dashboard page
    Then The user verifies that UI experience and API experience must be match job is "<job>"
    Examples:
      | job         | company | location | fromdate   | todate     | current | description | statusCode |
      | QA Engineer | samsung | Seul     | 2012-12-12 | 2016-02-06 | false   | Hard job    | 200        |