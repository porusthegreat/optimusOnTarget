Feature: Add shipping address

  @Intent
  Scenario: ShippingAddress
    And optimus on Checkout screen tap on shippingAddress
    And optimus on payments screen tap on addButton
    And optimus on ShippingAddress screen types on firstname value Purushotham
    And optimus on ShippingAddress screen types on lastname value Reddy
    And optimus on ShippingAddress screen types on address value Marathahalli
    And optimus on ShippingAddress screen types on zip value 56003
    And optimus on ShippingAddress screen types on phoneNumber value 9525124595
    And optimus on ShippingAddress screen tap on doneBtn