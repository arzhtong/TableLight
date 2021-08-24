Feature: Table Light

The table light is interacted through a switch that controls
  Background:
    Given the table light is plugged in


  Rule: Table Light turns off after 30 seconds of being powered on along with the switch flicking back to off position.

  Scenario: User turns on table light
    Given the user flicks the switch to the on position
    When 30 seconds have passed
    Then the light will be off
    And the switch flicks back to the off position










