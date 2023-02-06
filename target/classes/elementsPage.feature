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
#    Then Verify that user is deleted
    Examples:
      | url                 | firstName | lastName  | email                | age | salary | department |
      | https://demoqa.com/ | Anna      | Holubenko | anuli4ka80@gmail.com | 42  | 30000  | EPAM       |


  Scenario Outline: Verify that user searchable
    Given Open '<url>' page
    And Go to Elements menu
    And 'https://demoqa.com/elements' page is opened
    And Select Web table button
    When Do search by any user '<name>'
    Then Verify if user '<name>' searchable
    Examples:
      | url                 | name  |
      | https://demoqa.com/ | Alden |

