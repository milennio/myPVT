Feature: Test on deleting a mail

  Scenario: Create a new mail successfully
    Given I am on incoming mails page to delete an email
    When I check a mail
    And I click on delete button
    Then I see a positive notification that the letter is deleted