Feature: Hello World

Scenario: Launching the application should respond with a "Hello Patrick!"
Given a user "Patrick"
When the user logs into the application
Then the user should receive a "Hello Patrick!"