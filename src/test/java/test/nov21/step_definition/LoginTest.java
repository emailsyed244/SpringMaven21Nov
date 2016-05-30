package test.nov21.step_definition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import test.nov21.common.CommonMethods;
import test.nov21.configuration.WebConnect;
import test.nov21.pages.LoginPage;
import test.nov21.pages.WLNHeader;

import static org.junit.Assert.assertTrue;

/**
 * Created by UC181137 on 21/11/2015.
 */
public class LoginTest extends BaseStepDef {

    @Autowired
    private LoginPage loginPage;

    @Autowired
    private WLNHeader header;

    @Autowired
    private CommonMethods commonMethods;


    @Given("^the user logins$")
    public void the_user_logins() throws Throwable {

     commonMethods.waitElementByLinkText("Sign in").click();
     loginPage.usernameTextField().sendKeys(userLogin);//sendKeys("topsecret1234");
     loginPage.passwordTextField().sendKeys(userPassword);//.sendKeys("Automation1234");
     loginPage.signOnButton().click();
    }

    @When("^user gets to the home page$")
    public void user_gets_to_the_home_page() throws Throwable {
        System.out.println("user gets to the home page..!");
        header.foldersLink().click();
        commonMethods.waitElementByLinkText("Folders");
        header.getDriver().navigate().back();
    }

    @Then("^user should see the company logo$")
    public void user_should_see_the_company_logo() throws Throwable {
        System.out.println("user should see the company logo..!");
        assertTrue("Logo is not visible..!", header.companyLogo().isDisplayed());
        assertTrue(false);
    }
    @When("^user clicks on \"(.*)\" link$")
    public void user_clicksOnLink(String linkText) throws Throwable {
        commonMethods.waitElementByLinkText(linkText);
        header.getDriver().navigate().back();
    }
    @When("^user should see the \"(.*)\" page$")
    public void userShouldSeePage(String linkText) throws Throwable {
       if(linkText.equalsIgnoreCase("History")){
           assertTrue(true);
       }else{
           assertTrue(false);
       }
    }

}
