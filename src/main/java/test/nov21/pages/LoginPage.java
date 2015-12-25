package test.nov21.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.nov21.configuration.AbstractPage;

/**
 * Created by UC181137 on 21/11/2015.
 */
@Component
public class LoginPage extends AbstractPage{

    @Autowired
    AbstractPage abstractPage;

    public boolean isUsernameValidationErrorDisplayed(String usernameValidationError) {
        return isTextPresent(By.xpath("//span[@id='Username_validationMessage']/span"), usernameValidationError);
    }

    public boolean isOnePassValidationErrorDisplayed(String usernameValidationError) {
        return isTextPresent(By.xpath("//div[@id='errorMessageContainer']/span"), usernameValidationError);
    }

    public WebElement manageOnePassLoginFormTitle() {
        return retryingFindElement(By.xpath("//div[@class='signin']//h2"));
    }

    public WebElement usernameTextField() {
        return retryingFindElement(By.id("Username"));
    }

    public WebElement passwordTextField() {
        return retryingFindElement(By.id("Password"));
    }

    public WebElement signOnButton() {
        return getDriver().findElement(By.id("SignIn"));
    }

    public WebElement signOffLink() {
        return waitForExpectedElement(By.linkText("Sign Off"));
    }

}
