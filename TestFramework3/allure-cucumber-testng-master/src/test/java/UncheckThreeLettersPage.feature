Feature: Uncheck three letters Test
  Scenario Uncheck three marked letters successfully
    Given I am on incoming mails page
    When I remove flags from three letters
    Then I see a positive notification