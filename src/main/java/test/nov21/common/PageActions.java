package test.nov21.common;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.nov21.configuration.WebConnect;

@Component
public class PageActions {

	@Autowired
	private WebConnect webDriverDiscovery;

	public void dragAndDrop(WebElement dragElement, WebElement dropElement) {
		new Actions(webDriverDiscovery.getDriver()).dragAndDrop(dragElement, dropElement).build().perform();
	}

	public void rightClick(WebElement element) {
		new Actions(webDriverDiscovery.getDriver()).contextClick(element).build().perform();
	}

	public void keyPress(Keys key) {
		new Actions(webDriverDiscovery.getDriver()).sendKeys(key).build().perform();
	}

	public void doubleClick(WebElement element) {
		new Actions(webDriverDiscovery.getDriver()).doubleClick(element).build().perform();
	}

	public void mouseOver(WebElement element) {
		new Actions(webDriverDiscovery.getDriver()).moveToElement(element).build().perform();
	}
}
