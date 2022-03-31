@Regression
Feature: Checkout

  Scenario: Checkout from JohnLewis store
    Given user is on JohnLewis home page
    When User allows essential cookies only
    And user click the product type as "Home & Garden"
    And user click the sub-product as "BBQs"
    And user sort the product as "Price low to high"
    And user selects the product as "Weber Smokey Joe Premium Kettle Charcoal BBQ" from "weber-smokey-joe-premium-kettle-charcoal-bbq" page
    And user adds the product in cart as "Add to your basket" from "weber-smokey-joe-premium-kettle-charcoal-bbq" page
    And user verify the product added successfully as "Added to your basket:" from "weber-smokey-joe-premium-kettle-charcoal-bbq" page
    And user opens the basket - "Weber Smokey Joe Premium Kettle Charcoal BBQ" from "basket" page
    And user clicks as "Continue to checkout"
    And user lands on as "Welcome to secure checkout"
    And user selects as "Guest checkout" and "test@test.com"
    And user click as "Continue as guest"
    And user select choose your delivery method as "Delivery" from "delivery-choice" page
    And user enters details on delivery page as
      | title | Mrs |
      | firstname | Bob |
      | lastname | Foo  |
      | phonenumber | 02078281000 |
      | shortaddress | 171 Victoria St, London SW1E 5NN |
      | email   | test@test.com                    |
    And user click the "Use this address"
    And user select the delivery options available as "Next or named day UK delivery"
    And user select the date after 2 days
    And use click as "Continue to payment"
    Then user validate the delivery details on "Review and pay" with
      | addresse      | Mrs Bob Foo         |
      | addressline1  | John Lewis plc      |
      | addressline2  | 171 Victoria Street |
      | city          | London              |
      | postcode      | SW1E 5NN            |
      | phonenumber   | 02078281000         |
      | email         | test@test.com       |
    And user validates the order items as
      | itemname      | Weber Smokey Joe Premium Kettle Charcoal BBQ            |
      | itemcount     | 1                                                       |
      | totalcost     | 101.94                                                  |
