Feature: Opencart Login Function

Scenario: Valid Login
Given User is on Home page
And User navigates to login Page
When User enters "test1234@123.com" and "test"
Then should display  My Account page

Scenario: Search Item
Given should display  My Account page
When User search an Item 
  | phone |
Then Should display search result page

Scenario: Valid Login
Given should display  search result page
When User Add Item to cart
Then Item must be available in cart