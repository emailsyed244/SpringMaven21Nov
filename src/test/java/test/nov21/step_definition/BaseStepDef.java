package test.nov21.step_definition;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import test.nov21.configuration.WebConnect;

import java.util.Map;

@ContextConfiguration("classpath:cucumber.xml")
public class BaseStepDef {

    protected static final Logger LOG = org.slf4j.LoggerFactory.getLogger(BaseStepDef.class);

    @Autowired
    protected WebConnect webConnect;


    protected WebDriver getDriver() {
        return webConnect.getDriver();
    }

}