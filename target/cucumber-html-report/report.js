$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("testFeature.feature");
formatter.feature({
  "id": "as-a-user,-i-want-to-run-company-logo-and-history-tests",
  "tags": [
    {
      "name": "@firstProg1",
      "line": 1
    }
  ],
  "description": "",
  "name": "As a User, I want to run Company Logo and History Tests",
  "keyword": "Feature",
  "line": 2
});
formatter.before({
  "duration": 8889013215,
  "status": "passed"
});
formatter.scenario({
  "id": "as-a-user,-i-want-to-run-company-logo-and-history-tests;verify-the-history-page",
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
  "duration": 34295013485,
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
  "duration": 4685728803,
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
  "duration": 4423573,
  "status": "passed"
});
formatter.write("https://signon.qa.thomsonreuters.com/?productid\u003dPLCUK\u0026viewproductid\u003dPLCUK\u0026lr\u003d0\u0026culture\u003den-GB\u0026returnto\u003dhttps%3a%2f%2fuk.practicallaw.qed.thomsonreuters.com%2fCosi%2fSignOn%3fredirectTo%3d%252fSearch%252fHome.html%253ftransitionType%253dDefault%2526contextData%253d(sc.Default)%2526bhcp%253d1%2526OWSessionId%253d996300a27fa34f1ba1a4a4cd6b48465e%2526skipAnonymous%253dtrue%2526firstPage%253dtrue\u0026tracetoken\u003d0530160432030Xucix7LjdigGehY3YDARgaIhX5SId7eA3Ss-mZuOkBqxWABUs_VRm6N3i0Ii7CgBs7-W6PJ1jAH6peVpg92oqdwg9awZ_fCWeYYw7cq_GNRecxrIZf7vQdBbz_vL4svRlsYe_GpehBuNhAx3rdO9DzcK6gWsC1RcUUB0jvsJ4X7U4QvdGKvyn6efVgwpx71FrHyLVJX1_TD0QxX_uaf4nL8L8-d58igzrtvhkU6kZ-2KhHv32klu44E48y1xP-hMGCUL_CRSKM45s_C5czXsJQsWTCBdirEiAT-PTSmlUCLS8MHdbDbdo31e3wDTbnfe\u0026bhcp\u003d1");
formatter.after({
  "duration": 906321094,
  "status": "passed"
});
});