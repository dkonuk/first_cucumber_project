Feature: As a User I want to Login
  This feature includes Login tests

  Scenario Outline: Failed Login
    Given Open the web site
    When Enter '<username>' and '<password>' and click login button
    Then Getting error as '<errorText>'
    Examples:
      | username        | password     | errorText                                                                 |
      | standard_userr  | secret_sauce | Epic sadface: Username and password do not match any user in this service |
      | locked_out_user | secret_sauce | Epic sadface: Sorry, this user has been locked out.                       |

  Scenario Outline: Successful Login
    Given Open the web site
    When Enter '<username>' and '<password>' and click login button
    Then Login successfully

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |
      | visual_user   | secret_sauce |


  Scenario: Successful Login 2
    Given Open the web site
    When Enter user credentials from table
      | username      | password     |
      | standard_user | secret_sauce |
      | visual_user   | secret_sauce |
    Then Login successfully


  Scenario: Get data from file
    Given Open the web site
    When Get data on file and login and Getting error

    Scenario: Login with social media account
      When User click google account
      Then Social Media Login page open
      When User input credentials