Feature: deleteFromCart

  User is able to remove products from the cart


  Scenario: Product removed from cart successfully

    Given User adds product to cart "Samsung galaxy s6"
    When User navigates to cart screen
    And User click on delete product "Samsung galaxy s6"
    Then User shall not see product "Samsung galaxy s6" at cart