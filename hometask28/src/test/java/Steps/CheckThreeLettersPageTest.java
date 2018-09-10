package Steps;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features = {"src/test/"},tags = {})
public class CheckThreeLettersPageTest extends AbstractTestNGCucumberTests {

}
