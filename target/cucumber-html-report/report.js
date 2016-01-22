$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("test.nov21/testFeature.feature");
formatter.feature({
  "id": "to-test-the-framework",
  "tags": [
    {
      "name": "@firstProg",
      "line": 1
    }
  ],
  "description": "",
  "name": "To test the framework",
  "keyword": "Feature",
  "line": 2
});
formatter.before({
  "duration": 17170625372,
  "status": "passed"
});
formatter.scenario({
  "id": "to-test-the-framework;verify-the-company-logo",
  "description": "",
  "name": "Verify the Company logo",
  "keyword": "Scenario",
  "line": 4,
  "type": "scenario"
});
formatter.step({
  "name": "the user logins",
  "keyword": "Given ",
  "line": 5
});
formatter.step({
  "name": "user gets to the home page",
  "keyword": "When ",
  "line": 6
});
formatter.step({
  "name": "user should see the company logo",
  "keyword": "Then ",
  "line": 7
});
formatter.match({
  "location": "LoginTest.the_user_logins()"
});
formatter.result({
  "duration": 38172765736,
  "status": "passed"
});
formatter.match({
  "location": "LoginTest.user_gets_to_the_home_page()"
});
formatter.result({
  "duration": 15369024109,
  "status": "passed"
});
formatter.match({
  "location": "LoginTest.user_should_see_the_company_logo()"
});
formatter.result({
  "duration": 5181204704,
  "status": "failed",
  "error_message": "java.lang.AssertionError\r\n\tat org.junit.Assert.fail(Assert.java:86)\r\n\tat org.junit.Assert.assertTrue(Assert.java:41)\r\n\tat org.junit.Assert.assertTrue(Assert.java:52)\r\n\tat test.nov21.step_definition.LoginTest.user_should_see_the_company_logo(LoginTest.java:49)\r\n\tat ✽.Then user should see the company logo(test.nov21/testFeature.feature:7)\r\n"
});
formatter.write("https://a.uk.practicallaw.qed.thomsonreuters.com/Search/Home.html?transitionType\u003dDefault\u0026contextData\u003d(sc.Default)\u0026bhcp\u003d1\u0026OWSessionId\u003d06689024a135455393b72571a366c148\u0026skipAnonymous\u003dtrue\u0026firstPage\u003dtrue");
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "duration": 635726416,
  "status": "passed"
});
formatter.before({
  "duration": 506753388,
  "status": "passed"
});
formatter.scenario({
  "id": "to-test-the-framework;verify-the-history-page",
  "description": "",
  "name": "Verify the History Page",
  "keyword": "Scenario",
  "line": 10,
  "type": "scenario"
});
formatter.step({
  "name": "the user logins",
  "keyword": "Given ",
  "line": 11
});
formatter.step({
  "name": "user clicks on \"History\" link",
  "keyword": "When ",
  "line": 12
});
formatter.step({
  "name": "user should see the \"History\" page",
  "keyword": "Then ",
  "line": 13
});
formatter.match({
  "location": "LoginTest.the_user_logins()"
});
formatter.result({
  "duration": 29124298761,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "History",
      "offset": 16
    }
  ],
  "location": "LoginTest.user_clicksOnLink(String)"
});
formatter.result({
  "duration": 5320986630,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "History",
      "offset": 21
    }
  ],
  "location": "LoginTest.userShouldSeePage(String)"
});
formatter.result({
  "duration": 177409,
  "status": "passed"
});
formatter.after({
  "duration": 112214,
  "status": "passed"
});
formatter.before({
  "duration": 927425977,
  "status": "passed"
});
formatter.scenario({
  "id": "to-test-the-framework;verify-the-favourite-page",
  "description": "",
  "name": "Verify the Favourite Page",
  "keyword": "Scenario",
  "line": 15,
  "type": "scenario"
});
formatter.step({
  "name": "the user logins",
  "keyword": "Given ",
  "line": 16
});
formatter.step({
  "name": "user clicks on \"Favourites\" link",
  "keyword": "When ",
  "line": 17
});
formatter.step({
  "name": "user should see the \"Favourite\" page",
  "keyword": "Then ",
  "line": 18
});
formatter.match({
  "location": "LoginTest.the_user_logins()"
});
formatter.result({
  "duration": 27009343003,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Favourites",
      "offset": 16
    }
  ],
  "location": "LoginTest.user_clicksOnLink(String)"
});
formatter.result({
  "duration": 4700256196,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Favourite",
      "offset": 21
    }
  ],
  "location": "LoginTest.userShouldSeePage(String)"
});
formatter.result({
  "duration": 524719,
  "status": "failed",
  "error_message": "java.lang.AssertionError\r\n\tat org.junit.Assert.fail(Assert.java:86)\r\n\tat org.junit.Assert.assertTrue(Assert.java:41)\r\n\tat org.junit.Assert.assertTrue(Assert.java:52)\r\n\tat test.nov21.step_definition.LoginTest.userShouldSeePage(LoginTest.java:61)\r\n\tat ✽.Then user should see the \"Favourite\" page(test.nov21/testFeature.feature:18)\r\n"
});
formatter.write("https://a.uk.practicallaw.qed.thomsonreuters.com/Search/Home.html?transitionType\u003dDefault\u0026contextData\u003d(sc.Default)\u0026bhcp\u003d1\u0026OWSessionId\u003da02e1a9c4dd84211b809f33f9083e84f\u0026skipAnonymous\u003dtrue\u0026firstPage\u003dtrue");
formatter.embedding("image/png", "embedded1.png");
formatter.after({
  "duration": 1444410596,
  "status": "passed"
});
});