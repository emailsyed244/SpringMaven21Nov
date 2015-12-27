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
  "duration": 11781302414,
  "status": "passed"
});
formatter.scenario({
  "id": "to-test-the-framework;verify-the-framework-is-running-fine",
  "description": "",
  "name": "Verify the framework is running fine",
  "keyword": "Scenario",
  "line": 3,
  "type": "scenario"
});
formatter.step({
  "name": "the user logins",
  "keyword": "Given ",
  "line": 4
});
formatter.step({
  "name": "user gets to the home page",
  "keyword": "When ",
  "line": 5
});
formatter.step({
  "name": "user should see the company logo",
  "keyword": "Then ",
  "line": 6
});
formatter.match({
  "location": "LoginTest.the_user_logins()"
});
formatter.result({
  "duration": 52699314525,
  "status": "passed"
});
formatter.match({
  "location": "LoginTest.user_gets_to_the_home_page()"
});
formatter.result({
  "duration": 13461574265,
  "status": "passed"
});
formatter.match({
  "location": "LoginTest.user_should_see_the_company_logo()"
});
formatter.result({
  "duration": 3808882209,
  "status": "passed"
});
formatter.after({
  "duration": 2877490915,
  "status": "passed"
});
});