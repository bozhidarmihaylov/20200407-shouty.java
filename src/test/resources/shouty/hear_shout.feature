Feature: Hear Shout

  Shouts have a range of approximately 1000m

  Scenario Outline: only hear in-range shouts
    Given Lucy is at 0, 0
    And Sean is at <Sean location>
    When Sean shouts
    Then Lucy should hear <what Lucy hears>
    Examples: some simple examples
      | Sean location  | what Lucy hears |
      | 0, 900         | Sean            |
      | 800, 800       | nothing         |

  Scenario: Multiple shouters
    Given people are located at
        | name  | x    | y    |
        | Lucy  |    0 | 0    |
        | Sean  |    0 | 500  |
        | Oscar | 1100 | 0    |
    When Sean shouts
    And Oscar shouts
    Then Lucy should not hear Oscar
    But Lucy should hear Sean

  Scenario: Own shouts should not be heard
    When Sean shouts
    Then Sean should not hear Sean

  Scenario: Multiple shouts from one person
     Given Lucy is at 0, 0
     And Sean is at 0, 500
     When Sean shouts
     And Sean shouts
     Then Lucy should hear 2 shouts from Sean
