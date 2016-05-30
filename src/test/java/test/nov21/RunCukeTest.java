package test.nov21;//import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
//import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
//import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
//@RunWith(ExtendedCucumber.class)
//@ExtendedCucumberOptions(
//        jsonReport = "target/cucumber.json",
//        jsonUsageReport = "target/cucumber.json",
//        outputFolder = "target1/",
//        detailedReport = true,
//        detailedAggregatedReport = true,
//        overviewReport = true,
//        usageReport = true,
//        coverageReport = false,
//        retryCount = 0,
//        screenShotLocation = "screenshot/",
//      //  screenShotSize = "300px",
//        toPDF = true
//)
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-html-report","junit:target/cucumber-junit.xml",
                "json:target/cucumber.json","pretty:target/cucumber-pretty.txt"},
               // ,"usage:target/cucumber-usage.json"},
        features = {"src\\test\\resources\\test.nov21\\"},
        tags = {"@firstProg1","~@wip"}

)
public class RunCukeTest {
//    @BeforeClass
//    public static void setup(){
//        System.out.println("Before Class....!");
//    }
//    @AfterClass
//    public static void tearDown(){
//        System.out.println("After Class....!");
//    }
}
