Feature: Forms Page
  As a user
  I want to verify functionality Forms page

  Scenario Outline: Verify Practice Form menu
    Given Open 'https://demoqa.com/' page
    And Verify the visible Form menu
    When Go to Form menu
    And 'https://demoqa.com/forms' page is opened
    When Select Practice Form menu
    And Select '<firstName>' in field Name
    And Select '<lastName>' in field also Name
    And Select '<email>' in field Email
    And Select Female in field Gender
    And Select '<mobileNumber>' in field Mobile
    And Select Date in field Date of birth
    And Select Music in field Hobbies
    And Add '<currentAddress>' in field
    And Click button Submit
    Then Verify if all data is correct in confirmation window
    Examples:
      | firstName | lastName  | email                | mobileNumber | currentAddress|
      | Anna      | Holubenko | anuli4ka80@gmail.com | 0939897615   | Ukraine       |
