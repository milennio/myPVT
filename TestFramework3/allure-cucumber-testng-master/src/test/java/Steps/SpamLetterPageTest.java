package Steps;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = {"/src/java/"}, tags = {})
public class SpamLetterPageTest extends AbstractTestNGCucumberTests {
}
