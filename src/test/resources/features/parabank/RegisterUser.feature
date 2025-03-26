
@ParaBankRegistration
Feature: Para Bank User Registration

  Background: Open Para Bank Website
    Given User Opens Para Bank Login Page

  Scenario: Verify user is successfully registered with correct data
    When User Registers an Account with the following data
      | First Name | Vivek                    |
      | Last Name  | Biswas                   |
      | Address    | Dummy Home, Dummy Street |
      | City       | Dummy City               |
      | State      | Dummy State              |
      | Zip Code   | 100001                   |
      | Phone      | 9123456789               |
      | SSN        | 12321                    |
      | Username   | VivekBiswas              |
      | Password   | VivekB5                  |
    Then User Sees the Message "Your account was created successfully. You are now logged in."


  Scenario: Verify user is not registered with missing data
    When User Registers an Account with the following data
      | First Name | Vivek                    |
      | Address    | Dummy Home, Dummy Street |
      | State      | Dummy State              |
      | SSN        | 12321                    |
      | Username   | VivekBiswas              |
      | Password   | VivekB5                  |
    Then User Sees the Error Message "Last name is required."
    And User Sees the Error Message "City is required."
    And User Sees the Error Message "City is required."