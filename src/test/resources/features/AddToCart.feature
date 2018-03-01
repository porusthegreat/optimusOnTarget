Feature: Add to cart and add payment and shipping details

  @endtoend @Sanity
  Scenario: user adds items after clearing the cart and places an order
    Given user chooses to get started
    And user logs in with valid credentials
    And user allows required permissions
    And user navigates and deletes cart items
    And optimus on Cart screen tap on back
    And optimus on Home screen tap on homeItems
    And optimus on HomeDeals screen tap on limitedDeals
    And optimus on HomeDeals screen tap on Bedding
    And user selects items to add to cart
    And user navigates to cart screen to pay bills and verify amount
    And Intent:ShippingAddress
    And Intent:Payment
    Then user chooses to logout







