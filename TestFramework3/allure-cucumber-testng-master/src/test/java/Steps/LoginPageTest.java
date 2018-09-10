package Steps;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features = {"src/test/"},tags = {})
public class LoginPageTest extends AbstractTestNGCucumberTests {

}
