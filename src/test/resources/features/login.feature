Feature: Being able to login
Scenario: Login
  Login with some username

    Given a list of users:
      | pablo@example.com    | asdf   |
      | david@example.com    | asdf   |
      | freije@example.com   | asdf   |
    When I login with correct name and password
    Then I can enter the dashboard
