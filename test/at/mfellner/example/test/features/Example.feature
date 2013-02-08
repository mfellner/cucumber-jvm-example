Feature: The example program should print "Hello, world." and then exit.

  As a mighty computer programmer
  I just want to run my example program
  So I can read its output on the command line

  Scenario: Run the example program
    When I run the program
    Then I see Hello, world. in the out stream.
