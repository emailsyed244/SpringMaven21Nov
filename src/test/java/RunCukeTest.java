import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty","html:target/html_cucumber_reoports","json:target/cucumber.json"},
        tags = {"@firstProg"}
      //  glue = {"cucumber.api.spring"}
)
public class RunCukeTest {
}
