package test.nov21.configuration;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import test.nov21.common.CommonMethods;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public abstract class AbstractPage {

    private static final int DRIVER_WAIT_TIME = 60;
    protected static final Logger LOG = LoggerFactory.getLogger(AbstractPage.class);
    public static final String ABOUT_BLANK = "about:blank";

    @Autowired
    private WebConnect driver;

    @Autowired
    CommonMethods commonMethods;

    @Value("${username}")
    public String defaultUserName;

    @Value("${password}")
    public String defaultPassWord;

  //  @Value("${plcUserName}")
    public String plcUserName;

 //   @Value("${plcPassword}")
    public String plcPassword;

 //   @Value("${clientID}")
    public String clientID;

 //   @Value("${annUserName}")
    public String annUserName;

 //   @Value("${annUserFirstName}")
    public String annUserFirstName;

 //   @Value("${annUserLastName}")
    public String annUserLastName;

 //   @Value("${annAnotherUserName}")
    public String annAnotherUserName;

  //  @Value("${annAnotherFirstName}")
    public String annAnotherFirstName;

  //  @Value("${annAnotherLastName}")
    public String annAnotherLastName;

    public WebDriver getDriver() {
        return driver.getDriver();
    }

    public WebElement findElement(By by) {
        return getDriver().findElement(by);
    }

    public List<WebElement> findElements(By by) {
        return getDriver().findElements(by);
    }

    public WebElement findChildElement(WebElement element, final By by) {
        Wait<WebElement> wait = new FluentWait<WebElement>(element)
                .withTimeout(DRIVER_WAIT_TIME, TimeUnit.SECONDS)
                .ignoring(ElementNotVisibleException.class)
                .ignoring(NoSuchElementException.class);

        return wait.until(new Function<WebElement, WebElement>() {
            @Override
            public WebElement apply(WebElement webElement) {
                return webElement.findElement(by);
            }
        });
    }

    public void navigate(String url) {
        getDriver().get(url);
    }

    public List<WebElement> waitForElementsVisible(final By by) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), DRIVER_WAIT_TIME);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
        return getDriver().findElements(by);
    }

    public List<WebElement> waitForElementsClickable(final By by) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), DRIVER_WAIT_TIME);
        wait.until(ExpectedConditions.elementToBeClickable(by));
        return getDriver().findElements(by);
    }

    public void refreshPage() {
        String currentURL = getDriver().getCurrentUrl();
        getDriver().navigate().to(currentURL);
        getDriver().navigate().refresh();
    }

    public WebElement waitForExpectedElement(final By by) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), DRIVER_WAIT_TIME);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return getDriver().findElement(by);
    }

    public void waitForElementInvisible(final By by) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), DRIVER_WAIT_TIME);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public List<WebElement> waitForExpectedElements(final By by) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), DRIVER_WAIT_TIME);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return getDriver().findElements(by);
    }

    public WebElement waitForExpectedElement(final By by, int timeout) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), timeout);
        wait.until(visibilityOfElementLocated(by));
        return getDriver().findElement(by);
    }

    public List<WebElement> waitForExpectedElements(final By by, int timeout) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), timeout);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return getDriver().findElements(by);
    }

    public List<WebElement> waitForElementsVisible(final By by, int timeout) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), timeout);
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public WebElement waitForElementPresent(final By by) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), DRIVER_WAIT_TIME);
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement waitForElementVisible(final By by) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), DRIVER_WAIT_TIME);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return getDriver().findElement(by);
    }

    public WebElement waitForElementVisible(final WebElement element, int timeOut) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), timeOut);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public void waitForTextPresent(final By by, String txt, int timeOut) {
        LOG.info("waiting for the text " + txt + " to be present... ");
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), timeOut);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(by, txt));
    }

    public WebElement waitForElementToBeClickableAndReturnElement(final By by) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), DRIVER_WAIT_TIME, 100);
        wait.until(ExpectedConditions.elementToBeClickable(by));
        return getDriver().findElement(by);
    }

    public List<WebElement> waitForElementsToBeClickableAndReturnElement(final By by) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), DRIVER_WAIT_TIME, 100);
        wait.until(ExpectedConditions.elementToBeClickable(by));
        return getDriver().findElements(by);
    }

    public WebElement waitForElementToBeClickable(final WebElement element) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), DRIVER_WAIT_TIME, 100);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    public WebElement waitForElementToBeClickable(final WebElement element, int timeout) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), timeout, 100);
        wait.until(ExpectedConditions.elementToBeSelected(element));
        return element;
    }

    public void waitForElementToBeClickable(final By by) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), DRIVER_WAIT_TIME, 100);
        wait.until(ExpectedConditions.elementToBeClickable(waitAndFindElement(by)));
    }

    public void waitForElementToDissappear(final By byLocator) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), DRIVER_WAIT_TIME, 100);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(byLocator));
    }

    public void waitForPageTitle(String title) {
        pageTitleWait(title, DRIVER_WAIT_TIME);
    }

    public void pageTitleWait(String title, int timeOut) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), timeOut);
        wait.until(ExpectedConditions.titleIs(title));
    }

    public Boolean isElementPresent(By by) {
        try {
            waitForElementPresent(by);
            return true;
        } catch (TimeoutException e) {
            LOG.error("Element NOT Present", e);
            return false;
        }
    }

    public Boolean isTextPresent(By by, String txt) {
        try {
            waitForTextPresent(by, txt, DRIVER_WAIT_TIME);
            return true;
        } catch (TimeoutException e) {
            LOG.error("Text NOT Present", e);
            return false;
        }
    }

    public boolean isElementDisplayed(WebElement webElement) {
        try {
            return webElement.isDisplayed();
        } catch (NoSuchElementException e) {
            LOG.error("Element NOT Displayed", e);
            return false;
        }
    }

    public String getPageTitle() {
        return getDriver().getTitle();
    }


    protected ExpectedCondition<WebElement> visibilityOfElementLocated(final By by) {
        return new ExpectedCondition<WebElement>() {

            @Override
            public WebElement apply(WebDriver driver) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    LOG.error(e.getMessage());
                }
                WebElement element = getDriver().findElement(by);
                return element.isDisplayed() ? element : null;
            }
        };
    }

    public String getAlertDialogMsg() {
        Alert alert = getDriver().switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }

    public void acceptDialogIfAppears() {
        try {
            Alert alert = null;
            alert = getDriver().switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException e) {
            LOG.error("No Alert present", e);
        }
    }

    public void dismissDialogIfAppears() {
        Alert alert = getDriver().switchTo().alert();
        alert.dismiss();
    }

    /**
     * TODO - Made this CANCEL for Firefox
     */
    public WebElement cancel() {
        return getDriver().findElement(By.linkText("CANCEL"));
    }

    public boolean isOnPage(String pageTitle) {
        return pageTitle.equalsIgnoreCase(getDriver().getTitle());
    }

    public void deleteAllCookies() {
        getDriver().manage().deleteAllCookies();
    }

    public void selectDropDown(WebElement element, String option) {
        Select s = new Select(element);
        s.selectByValue(option);
    }

    public void selectDropDownByVisibleText(WebElement element, String option) {
        Select s = new Select(element);
        s.selectByVisibleText(option);
    }

    public WebElement getElementByLinkText(String linkText) {
        return getDriver().findElement(By.linkText(linkText));
    }

    public WebElement waitAndFindElement(By by) {
        return waitForElementVisible(by);
    }

    public List<WebElement> waitAndFindElements(By by) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), DRIVER_WAIT_TIME);
        wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(by)));
        return getDriver().findElements(by);
    }

    public void goTo(String url) {
        getDriver().get(url);
    }

    public String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }

    public void maximizeWindow() {
        getDriver().manage().window().maximize();
    }

    public WebElement findElementByText(List<WebElement> eList, String text) {
        WebElement webElement = null;
        for (WebElement e : eList) {
            if (e.getText().equalsIgnoreCase(text)) {
                webElement = e;
                break;
            }
        }
        return webElement;
    }

    public WebElement waitFluentForElement(final By by) {
        WebElement element = null;
        Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(2, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return getDriver().findElement(by);
            }
        });
        return element;
    }

    public void switchToIframe(WebElement element) {
        getDriver().switchTo().frame(element);
    }

    public void switchToWindow(String index) {
        getDriver().switchTo().window(index);
    }

    public void switchOutFromIframe() {
        getDriver().switchTo().defaultContent();
    }

    public Boolean isTextPresent(By by, String txt, int timeInSeconds) {
        try {
            waitForTextPresent(by, txt, timeInSeconds);
            return true;
        } catch (TimeoutException e) {
            LOG.error("Text NOT Present", e);
            return false;
        }
    }

    public void waitForPageToLoadAndJQueryProcessingWithCustomTimeOut(int waitTimeOutInSeconds) {
        waitForPageToLoadAndJQueryProcessing(waitTimeOutInSeconds);
    }

    public void waitForPageToLoadAndJQueryProcessing() {
        waitForPageToLoadAndJQueryProcessing(DRIVER_WAIT_TIME);
    }

    private void waitForPageToLoadAndJQueryProcessing(int waitTimeOutInSeconds) {
        new WebDriverWait(getDriver(), waitTimeOutInSeconds) {
        }.until(new ExpectedCondition<Boolean>() {

            @Override
            public Boolean apply(WebDriver driverObject) {
                return (Boolean) ((JavascriptExecutor) driverObject).executeScript("return jQuery.active == 0");
            }
        });
    }

    public void waitForPageToLoad() {
        ExpectedCondition<Boolean> expectedCondition = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), DRIVER_WAIT_TIME);
        wait.until(expectedCondition);
    }

    public void scrollDown(int count) {
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("scroll(0, " + 250 * count + ")");
    }

    /**
     * This method does the try and find the element for the 3 times repeating statements if element is not getting found at a time.
     * And based on the given locator element will be found and return as webelement.
     *
     * @param by
     * @return WebElement
     */
    protected WebElement retryingFindElement(By by) {
        int attempts = 0;
        while (attempts < 2) {
            try {
                return waitForExpectedElement(by, 2);
            } catch (Exception te) {
                LOG.warn("Exceeding time to find element in retryingFindElement(): " + by, te.getMessage());
            }
            attempts++;
        }
     //   throw new Exception;
     return null;
    }

    /**
     * This method does the try and find the element for the 3 times repeating statements if element is not getting found at a time.
     * And based on the given locator element will be found and return as webelement.
     *
     * @param by
     * @return WebElement
     */
    protected List<WebElement> retryingFindElements(By by) {
        int attempts = 0;
        while (attempts < 3) {
            try {
                return waitForElementsVisible(by, 10);
            } catch (Exception te) {
                LOG.warn("Exceeding time to find elements in retryingFindElements(): " + by, te.getMessage());
            }
            attempts++;
        }
     //   throw new PageOperationException("Unable to find the elements:" + by);
        return null;
    }

    /**
     * This method returns String value from input and textarea webelement
     *
     * @param webElement
     * @return String
     */
    public String getTextFromInputOrTextarea(WebElement webElement) {
        return webElement.getAttribute("value");
    }

    /**
     * This method returns the current window handler as string.
     *
     * @return String
     */
    public String getCurrentWindowHandle() {
        return getDriver().getWindowHandle();
    }

    /**
     * This method checks if current url matches with regex.
     *
     * @param regex
     * @return boolean
     */
    public boolean isURLmatches(String regex) {
        return getCurrentUrl().matches(regex);
    }

    public boolean isCheckBoxSelectable(WebElement checkBox) {
        boolean initialState = checkBox.isSelected();
        checkBox.click();
        boolean finalState = checkBox.isSelected();
        if (initialState != finalState) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * This method scrolls using javascript element into view and clicks on element.
     * Sometimes webdriver in chrome is unable to click on element https://code.google.com/p/selenium/issues/detail?id=2766
     */
    public void scrollIntoViewAndClick(WebElement element) {
		Capabilities cp = driver.getDriver().getCapabilities();
		if (cp.getBrowserName().equals("chrome")) {
			try {
				((JavascriptExecutor) getDriver()).executeScript(
						"arguments[0].scrollIntoView(false)", element);
			} catch (Exception e) {
				LOG.info("context", e);
			} finally {
				element.click();

			}
		} else
			element.click();
	}

    public Object executeScript(String script){
        return ((JavascriptExecutor) driver.getDriver()).executeScript(script);
    }

    public Object executeScript(String script,WebElement arg){
        return ((JavascriptExecutor) driver.getDriver()).executeScript(script,arg);
    }

    public Object executeScript(String script,WebElement arg,String anotherScript){
        return ((JavascriptExecutor) driver.getDriver()).executeScript(script,arg, anotherScript);
    }

    protected void doubleClickOnTextElement(WebElement element){
        Actions select = new Actions(driver.getDriver());
        select.doubleClick(element).perform();
    }

    /**
     * Wait until element is exists in DOM
     * IMPORTANT: element visibility is not check in this method
     * @param by Element locator {@link By}
     * @return Found element
     */
    public WebElement waitForElementExists(final By by) {
        ExpectedCondition<WebElement> existsCondition = new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return (!driver.findElements(by).isEmpty()) ? driver.findElements(by).get(0) : null;
            }
        };
        return waitFor(existsCondition, getDriver());
    }

    /**
     * For waiting without WebDriver: Wait for function will be true or return some except false.
     *
     * @param condition        Function for waiting {@link Function}
     * @param waitWith         Object who will helping to wait (which will be passed to {@link Function#apply(Object)})
     * @param timeOutInSeconds Time-out in seconds
     * @param <F>              Type of waitWith param
     * @param <T>              Type of object which is waiting
     * @return Object which waiting for or null - is exceptions occured
     */
    public static <F, T> T waitFor(Function<F, T> condition, F waitWith, long timeOutInSeconds) {
        Wait<F> wait = new FluentWait<>(waitWith)
                .withTimeout(timeOutInSeconds, TimeUnit.SECONDS)
                .pollingEvery(300, TimeUnit.MILLISECONDS);
        try {
            return wait.until(condition);
        } catch (Exception | AssertionError e) {
            LOG.warn("Waiting was not successfull", e);
        }
        return null;
    }

    /**
     * For waiting without WebDriver: Wait for function will be true or return some except false.
     * Default timeout {@link #DRIVER_WAIT_TIME} is using.
     *
     * @param condition Function for waiting {@link Function}
     * @param waitWith  Object who will helping to wait (which will be passed to {@link Function#apply(Object)})
     * @param <F>       Type of waitWith param
     * @param <T>       Type of object which is waiting
     * @return Object which waiting for or null - is exceptions occurred
     */
    public static <F, T> T waitFor(Function<F, T> condition, F waitWith) {
        return waitFor(condition, waitWith, DRIVER_WAIT_TIME);
    }

    /**
     * Wait until element is not exists in DOM
     * IMPORTANT: element visibility is not check in this method
     * @param by Element locator {@link By}
     * @return True - is element absent, otherwise - false.
     */
    public Boolean waitForElementAbsent(final By by) {
        ExpectedCondition<Boolean> absenceCondition = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return driver.findElements(by).isEmpty();
                } catch (NullPointerException npe) {
                    return true;
                }
            }
        };
        return waitFor(absenceCondition, getDriver());
    }

    public boolean isExists(By by) {
        return getDriver().findElements(by) != null && !getDriver().findElements(by).isEmpty();
    }

    /**
     * Wait until element will be visible for user (not only present in DOM) and present on the screen.
     * Method should call when some link was pressed which redirects user from one section to another entire one
     * document, one scrollable view.
     * @param by Element locator {@link By}
     * @return True - if element present on the screen for user now, otherwise - fasle.
     */
    public Boolean waitForViewScrollingToElement(final By by) {
        ExpectedCondition<Boolean> scrollingCondition = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return isViewScrolledToElement(driver.findElement(by));
            }
        };
        return waitFor(scrollingCondition, getDriver()) != null;
    }

    /**
     * Check if current view scrolled to necessary element.
     * Original script: https://github.com/customd/jquery-visible/blob/master/jquery.visible.js (under MIT license)
     * IMPORTANT: JQuery is required.
     * @param element WebElement which view should be scrolled to
     * @return True - if view scrolled to element and it visible, otherwise - false.
     */
    public boolean isViewScrolledToElement(WebElement element) {
        String jqueryVisiblePlugin = "!function(a){var b=a(window);a.fn.visible=function(a,c,d){if(!(this.length<1))" +
                "{var e=this.length>1?this.eq(0):this,f=e.get(0),g=b.width(),h=b.height(),d=d?d:\"both\",i=c===!0?" +
                "f.offsetWidth*f.offsetHeight:!0;if(\"function\"==typeof f.getBoundingClientRect){" +
                "var j=f.getBoundingClientRect(),k=j.top>=0&&j.top<h,l=j.bottom>0&&j.bottom<=h,m=j.left>=0&&j.left<g," +
                "n=j.right>0&&j.right<=g,o=a?k||l:k&&l,p=a?m||n:m&&n;if(\"both\"===d)return i&&o&&p;if(\"vertical\"===d)" +
                "return i&&o;if(\"horizontal\"===d)return i&&p}else{var q=b.scrollTop(),r=q+h,s=b.scrollLeft()," +
                "t=s+g,u=e.offset(),v=u.top,w=v+e.height(),x=u.left,y=x+e.width(),z=a===!0?w:v,A=a===!0?v:w,B=a===!0?y:x," +
                "C=a===!0?x:y;if(\"both\"===d)return!!i&&r>=A&&z>=q&&t>=C&&B>=s;if(\"vertical\"===d)return!!i&&r>=A&&z>=q;" +
                "if(\"horizontal\"===d)return!!i&&t>=C&&B>=s}}}}(jQuery);";
        String pluginAvailabilityCheck = "try { $('body').visible('both'); return true; } catch (err) { return false; }";
        JavascriptExecutor jsEx = ((JavascriptExecutor) getDriver());
        if (!((Boolean)jsEx.executeScript(pluginAvailabilityCheck))) {
            jsEx.executeScript(jqueryVisiblePlugin);
        }
        return (Boolean) jsEx.executeScript("return $(arguments[0]).visible('both');", element);
    }

	public WebElement getPageHeaderLabel() {
		return waitForExpectedElement(By.id("co_browsePageLabel"));
	}
}
