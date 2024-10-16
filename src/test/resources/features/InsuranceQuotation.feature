Feature: Insurance quotation

  Scenario: Automate insurance quotation
    Given I am on the home page
    And I accept all cookies if available
    When I navigate to the calculator page
    And I select the travel type "SEGURO DE VIAJE"
    And I select the travel type "único viaje"
    And I choose the destination "España"
    And I select the current date and 2 weeks later
    And I click on Ver Presupuesto
    Then I should see the loading spinner
    When the spinner disappears
    Then I select the first insurance option
    And I fill out the form with the following traveler details:
      | Treatment  | MR          |
      | Name       | John         |
      | Last Name     | Doe          |
      | Date of Birth     | 01011990          |
      | DNI/NIE      | 99999999R    |
      | Address    | Example St.  |
      | City       | Madrid       |
      | Post Code  | 28001        |
      | Phone     | +34 600000000|
      | Email        | john.doe@mail.com |
    And I confirm that the policyholder is the traveler
    And I continue to checkout page
    Then I should see the loading spinner
    When the spinner disappears
    Then I should be on the "Pago" page