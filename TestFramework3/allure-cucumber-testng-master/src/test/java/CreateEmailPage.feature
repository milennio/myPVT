Feature: Test on creating new mail

  Scenario: Create a new mail successfuly
    Given I am on incoming mails page to send an email
    When I click on create link
    And I fill all fields
    And I click on send button to send an email
    Then I see a positive notification