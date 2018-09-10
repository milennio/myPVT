Feature: Test on sending a group mail

  Scenario: Send a group mail successfully
    Given I am on incoming mails page to send emails
    When I click on a create mail link
    And I compose letter
    And I click on send button to send copies
    Then I see a positive notification that letters are sent