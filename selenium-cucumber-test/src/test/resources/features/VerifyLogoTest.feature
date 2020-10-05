@regression @sanity
Feature: google search testcase

  @verifyLogo
  Scenario Outline: verify logo on JP Morgan homepage
    Given I navigate to google webpage
    Then I see google homepage using "<website>"
    When I search for keyword using "<keyword>"
    And I select search result
    Then I verify JP Mogan logo on home page

    Examples: 
      | website | keyword     |
      | Google  | J.P. Morgan |