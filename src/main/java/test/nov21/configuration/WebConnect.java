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

    @Value("${cucumberJsonFile}")
    private String cucumberJsonFile;

    @Value("${reportOutputRoot}")
    private String reportOutputRoot;

    @Value("${reportProject}")
    private String reportProject;


    @Value("${driverType}")
    private String driverType;

    @Value("${reportBuilder}")
    private String reportBuilder;

    public String getDriverType() {
        return driverType;
    }

    public  String getCucumberJsonFile() {
        return cucumberJsonFile;
    }

    public String getReportOutputRoot() {
        return reportOutputRoot;
    }

    public String getReportProject() {
        return reportProject;
    }

    public String getReportBuilder() {
        return reportBuilder;
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
        System.out.println("Report builder : "+reportBuilder);
        System.out.println("Report output : "+reportOutputRoot);
        System.out.println("Report Project : "+reportProject);
        System.out.println("Cucumber Json File : "+cucumberJsonFile);
        if(reportBuilder.equalsIgnoreCase("true")){
          CustomReportBuilder.runOnShutDown();
        }

    }
    public void closeSetup(){
        System.out.println(" close() method.........!");
        driver.quit();
//       try {
//
//           Date date = new Date();
//           SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
//           String dateString = new SimpleDateFormat("dd-MMM-yyyy").format(date);
//           String time = new SimpleDateFormat("HH.mm.ss").format(date);
//
//           //  String reportOutputDirectory = reportOutputRoot + "\\" + dateString + "\\" + time;
//
//         //  String customText = project + "<h3><BR/> Environment: <font color=\"red\">" + env + "</font>     Browser : <font color=\"blue\">" + browser + "</font>" + "     Run At: <font color=\"blue\">" + dateFormat.format(date) + "</font></h3>";
//
//           File reportOutputDirectory = new File("target");//+ "\\" + dateString + "\\" + time);
//           List<String> jsonFiles = new ArrayList<>();
//           jsonFiles.add("cucumber.json");
//           //  jsonFiles.add("cucumber-report-2.json");
//
//           String jenkinsBasePath = "";
//           String buildNumber = "1";
//           String projectName = "Syed_PPIUK";
//           boolean skippedFails = true;
//           boolean pendingFails = false;
//           boolean undefinedFails = true;
//           boolean missingFails = true;
//           boolean runWithJenkins = false;
//           boolean parallelTesting = false;
//
//           Configuration configuration = new Configuration(reportOutputDirectory, projectName);
//// optionally only if you need
//           configuration.setStatusFlags(skippedFails, pendingFails, undefinedFails, missingFails);
//           configuration.setParallelTesting(parallelTesting);
//           configuration.setJenkinsBasePath(jenkinsBasePath);
//           configuration.setRunWithJenkins(runWithJenkins);
//           configuration.setBuildNumber(buildNumber);
//   try{
//           ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
//           reportBuilder.generateReports();
//       } catch (Exception e) {
//           System.out.println("Unable to create Custom Report \n" + e.getMessage());
//       }
//
//           CucumberResultsOverview results = new CucumberResultsOverview();
//          results.setOutputDirectory(".//target");
//          results.setOutputName(".//target1//cucumber-results");
//           results.setSourceFile(".//target//cucumber.json");
//           results.executeFeaturesOverviewReport();
//      //     results.setScreenShotLocation("../src/test/resources/");
//      }catch(Exception e){
//           System.out.println(e.getMessage());
//       }
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
