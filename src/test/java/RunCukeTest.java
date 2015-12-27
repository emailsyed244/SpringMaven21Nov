import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","html:target/html_cucumber_reoports","json:target/cucumber.json"},
        features = {"src\\test\\resources\\test.nov21\\testFeature.feature"}
       // tags = {"@firstProg"}
      //  glue = {"cucumber.api.spring"}
)
public class RunCukeTest {
}
