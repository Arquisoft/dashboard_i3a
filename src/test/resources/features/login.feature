Feature: Being able to login
Scenario: Login
  Login with some username

    Given a list of users:
      | name                 | password |
      | pablo@example.com    | asdf     |
      | david@example.com    | asdf     |
      | freije@example.com   | asdf     |
    When I login with correct "pablo@example.com" and "asdf"
    Then I receive a welcome message "Welcome:"
    And I can see "Male Stats:"
