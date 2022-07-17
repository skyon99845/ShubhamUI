Feature: RedBus-Printing the Travels Detail and Fare where fare is between(2000,3000)

  Scenario: Selection of From (Origin)
    Given user is on RedBus landing page
    When the user enters "Banglore" into the From text box
    Then the From text box displays "Banglore"