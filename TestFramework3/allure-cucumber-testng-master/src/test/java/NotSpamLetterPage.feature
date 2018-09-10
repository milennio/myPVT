Feature: Test removing mail into spam

  Scenario: Mark mail as not a spam
    Given I am on incoming mails page to remove mails from spam
    When I remove mail into spam
    Then I see a positive notification that messages are not spam