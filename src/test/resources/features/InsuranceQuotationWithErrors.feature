Feature: Insurance Quotation with errors

  Scenario: Generate error by adding past date range
    Given I am on the home page
    And I accept all cookies if available
    When I navigate to the calculator page
    And I select the travel type "SEGURO DE VIAJE"
    And I select the travel type "único viaje"
    And I choose the destination "España"
    And I select dates range "01/12/2023" "31/10/2023"
    And I click on Ver Presupuesto
    Then I view the error modal

  Scenario: Generate error by adding return date wrong
    Given I am on the home page
    And I accept all cookies if available
    When I navigate to the calculator page
    And I select the travel type "SEGURO DE VIAJE"
    And I select the travel type "único viaje"
    And I choose the destination "España"
    And I select dates range "01/12/2024" "01/01/2023"
    And I click on Ver Presupuesto
    Then I view the error modal
