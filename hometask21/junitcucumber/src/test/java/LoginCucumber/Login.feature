Feature: Test login page

  Scenario: Test positive login page
    Given I am on main application page
    When I login as correct user
    Then I see logout link

#  Scenario Outline: Test negative login page
#    Given I am on main application page
#    When I login as user with "<name>" and "<domain>" and "<password>" vv
#    Then I see error message
#    Examples:
#      | name    | domain     | password    |
#      | X XX XX | @mail.ru   | 123345768   |
#      | -----   | @inbox.ru  | hfgyt124jfk |
