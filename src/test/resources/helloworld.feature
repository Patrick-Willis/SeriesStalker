Feature: Hello World

Scenario: Launching the application should respond with a "Hello World!"
Given a User
When the User logs into the application
Then the User should receive a "Hello World!"