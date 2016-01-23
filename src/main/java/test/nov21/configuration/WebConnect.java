package test.nov21.configuration;

//import com.github.mkolisnyk.cucumber.reporting.CucumberResultsOverview;
//import net.masterthought.cucumber.Configuration;
//import net.masterthought.cucumber.ReportBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.rmi.Remote;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by UC181137 on 21/11/2015.
 */
@Component
public class WebConnect {

   // private static Logger LOG= LoggerFactory.getLogger(WebConnect.class);
    private RemoteWebDriver driver;
    public static String driverType;

    @Value("${reportBuilder}")
    private String reportBuilder;

    @Value("${driverType}")
    public void setDriverType(String driverType1) {
        driverType=driverType1;
    }

    public  RemoteWebDriver getDriver() {
       if(driver==null){
              if(driverType.equalsIgnoreCase("Firefox")){
                  driver= new FirefoxDriver();
              }else if(driverType.equalsIgnoreCase("chrome")){
                  driver= new ChromeDriver();
              }
          }
        return driver;
    }
    public void initSetup(){
        System.out.println(" init() method.........!");
        if(reportBuilder.equalsIgnoreCase("true")){
          CustomReportBuilder.runOnShutDown();
        }

    }
    public void closeSetup(){
        System.out.println(" close() method.........!");
        driver.quit();
    }

//
//    @SuppressWarnings("unchecked")
//    @PostConstruct
//    public void init(){
//
//      getDriver();
//
//  }
//    public  void setDriver(FirefoxDriver remoteWebDriver) {
//        driver = remoteWebDriver;
//    }
}
