Feature: Test on spam
  Scenario: Remove a letter to Spam folder
    Given I am on incoming mails page to remove spam
    When I remove mail into spam
    Then I see a positive notification that a letter is removed