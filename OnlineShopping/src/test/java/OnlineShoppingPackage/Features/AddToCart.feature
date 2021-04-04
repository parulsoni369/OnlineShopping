@test1
Feature: Application Login

  Scenario: Creation of case using correct excel data
    Given Login as TL
    When I upload data into quantum
    Then case should be created
