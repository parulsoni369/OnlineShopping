@test1
@test_parallel
Feature: Add To Cart and PLace Order

 Scenario Outline: To add two items to cart and place order
    Given Login as Customer to Shopping url with "<username>" and "<password>"
    When I click on the Women tab
    And Scroll down and select T-Shirt and Add To Cart
    And Scroll down and select Dress and Add To Cart
    Then Proceed to Checkout and place Order
    Then Verify text for Order Confirmation is "Your order on My Store is complete."

    Examples:
    |username|password|
    |parulsoni369@gmail.com|ABCD1234|