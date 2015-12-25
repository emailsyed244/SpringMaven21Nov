package test.nov21.hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import test.nov21.configuration.WebConnect;
import test.nov21.step_definition.BaseStepDef;

/**
 * Created by UC181137 on 21/11/2015.
 */


public class Hooks extends BaseStepDef {

    @Value("${baseTest}")
    private String baseTest;

    @Before
    public void setup(){
       getDriver().navigate().to("https://a.uk.practicallaw."+baseTest+".thomsonreuters.com");
    }

    @After
    public void destroy(){
        webConnect.getDriver().quit();
    }
}
