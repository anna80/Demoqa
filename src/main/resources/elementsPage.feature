Feature: Elements Page
  As a user
  I want to verify functionality Elements page

  Scenario Outline: Verify that user created on Elements menu page
    Given Open '<url>' page
    And Go to Elements menu
    And 'https://demoqa.com/elements' page is opened
    And Select Web table button
    When Select Add button
    And Visibility Registration Form
    And Select '<firstName>' in field Name
    And Select '<lastName>' in field also Name
    And Select '<email>' in field Email
    And Select '<age>' in field Age
    And Select '<salary>' in field Salary
    And Select '<department>' in field Department
    And Click button Submit
    Then Verify if user is created
    And Delete created user
    Examples:
      | url                 | firstName | lastName  | email                | age | salary | department |
      | https://demoqa.com/ | Anna      | Holubenko | anuli4ka80@gmail.com | 42  | 30000  | EPAM       |


  Scenario: Verify that user searchable
    Given Open 'https://demoqa.com/' page
    And Go to Elements menu
    And 'https://demoqa.com/elements' page is opened
    And Select Web table button
    When Do search by 'alden@example.com' of user
    Then Verify if 'alden@example.com' of user searchable


