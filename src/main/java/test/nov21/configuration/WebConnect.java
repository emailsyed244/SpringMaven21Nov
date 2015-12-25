package test.nov21.configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.rmi.Remote;

/**
 * Created by UC181137 on 21/11/2015.
 */
@Component
public class WebConnect {

    private RemoteWebDriver driver;

    @Value("${driverType}")
    private String driverType;

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
