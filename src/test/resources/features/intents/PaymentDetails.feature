Feature: Add Payment details

  @Intent
  Scenario: Payment
    And optimus on Checkout screen tap on paymentDetails
    And optimus on payments screen tap on creditCard
    And optimus on payments screen tap on addButton
    And optimus on payments screen types on cardNum value 4012888888881881
    And optimus on payments screen types on payment_card_expiry value 1222
    And optimus on payments screen types on security_code value 222
    And optimus on ShippingAddress screen types on firstname value Purushotham
    And optimus on ShippingAddress screen types on lastname value Reddy
    And optimus on payments screen types on address value Marathahalli
    And optimus on ShippingAddress screen types on zip value 56003
    And optimus on ShippingAddress screen types on phoneNumber value 9525124595
    And optimus on payments screen tap on doneBtn
    And optimus on payments screen verifies cardDetails is visible
    And user navigates back
    And optimus on Cart screen verifies checkoutBtn is visible
    And optimus on Cart screen tap on back

