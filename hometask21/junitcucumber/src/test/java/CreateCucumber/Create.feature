Feature: Test create an email page

  Scenario: Create and send successfully an email
    Given I am on main application page signing in as a correct user
    When I click on 'Create Email' button
    And Fill fields with info
    And Click 'Send' button
    Then I receive a positive feedback

