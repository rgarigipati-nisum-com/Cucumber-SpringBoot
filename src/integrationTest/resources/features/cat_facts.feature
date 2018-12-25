Feature: Test Cat Facts API

  Scenario: User initiates a request to get facts about cats
    Given the client makes a call to the hero ku
    When the user calls the api for facts
    Then the client receives status of 200
    And the response has the text
      | text                                                |
      | The technical term for a cat’s hairball is a bezoar |
      | Cats can't taste sweetness                          |
