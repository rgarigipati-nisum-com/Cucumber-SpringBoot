Feature: Test Recipe Puppy API

Scenario: User initiates a request to get a receipe with onions ansd eggs
    Given the client makes a call to the receipe puppy
	When the user calls the api with onions,eggs
	Then the client receives status code of 200
	And the response has the title Recipe Puppy
	And also has onions,egg as ingredients