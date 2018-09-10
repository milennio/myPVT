package Steps;

import Page.CheckIconsPage;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import resources.WebDriverSingletonPattern;

public class CheckIconsPageSteps {

  private static final String CHROMEDRIVER_EXE = "/home/ubuntu/chromedriver_linux64/chromedriver";
  private static final String MAIN_URL = "http://mail.ru";
  private WebDriver webDriver;
  private CheckIconsPage checkIconsPage;

  public CheckIconsPageSteps()
  {
    String exePath = CHROMEDRIVER_EXE;
    System.setProperty("webdriver.chrome.driver", exePath);
    webDriver = WebDriverSingletonPattern.getInstance();
    checkIconsPage = new CheckIconsPage(webDriver);
  }

  @Given("^I am on main page$")
  public void i_am_on_main_page() throws Throwable {
    webDriver.get(MAIN_URL);
  }

  @When("^I check up on icons$")
  public void i_check_up_on_icons() throws Throwable {
    checkIconsPage.checkUpOnIcons();

  }

  @Then("^I see the icons$")
  public void i_see_the_icons() throws Throwable {
    checkIconsPage.iconsAreDisplayed();

  }

  @After
  public void afterClass()
  {
    webDriver.quit();
  }
}
