Feature: Verification of Feedback Functionality on JavaTpoint.com

  Scenario: User submits feedback and admin replies
    Given the user navigates to JavaTpoint.com
    When the user clicks on Feedback
    Then the Feedback page opens
    And the user submits feedback message
    Then feedback should be received on the admin page
    And admin can reply to the user
