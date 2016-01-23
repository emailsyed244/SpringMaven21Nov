package test.nov21.hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import test.nov21.configuration.WebConnect;
import test.nov21.step_definition.BaseStepDef;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * Created by UC181137 on 21/11/2015.
 */


public class Hooks extends BaseStepDef {

    @Value("${baseTest}")
    private String baseTest;

    static boolean isNewSession=false;

    @Before
    public void setup(){
      if(!isNewSession) {
          getDriver().navigate().to("https://a.uk.practicallaw." + baseTest + ".thomsonreuters.com");
          isNewSession = true;
      }else{
          getDriver().manage().deleteAllCookies();
          getDriver().navigate().to("https://a.uk.practicallaw." + baseTest + ".thomsonreuters.com");
      }
    }

    @After
    public void afterTest(Scenario scenario){
        LOG.info("Taking screenshot if test failed");
        if (!WebConnect.driverType.equalsIgnoreCase("browserStack")) {
            try {

                if (scenario.isFailed()) {
                  //  LOG.info("Current Session ID '" + restServiceFFHImpl.getCurrentSession() + "'");
                    System.out.println("ID : " + scenario.getId());
                    System.out.println("Name : " + scenario.getName());
                    System.out.println("Status : " + scenario.getStatus());
                    String scenarioID=scenario.getId();
                    scenarioID=scenarioID.replaceAll(";","_");
                    scenario.write(getDriver().getCurrentUrl());

                    byte[] screenShot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
                    scenario.embed(screenShot, "image/png");
                    File scrFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
                    FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\target1\\"+scenarioID+".png"));
                 }
            } catch (WebDriverException | IOException e) {
                LOG.error(e.getMessage());
            }
        }

    }


}
