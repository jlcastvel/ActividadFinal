Feature: placeAndPurchase

  User is able to place order and confirm purchase


  Scenario: Place order and confirm purchase successfully

    Given User adds some products to cart "Samsung galaxy s7" "Samsung galaxy s6" "Sony vaio i7"
    When User navigates to cart screen
    And User clicks on place order
    And User fulfill order form from place order screen
    And User clicks on purchase
    Then User should see "Thank you for your purchase!"  message