package Steps;

import Page.CheckThreeLettersPage;
import Page.LoginPage;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;
import resources.WebDriverSingletonPattern;


public class CheckThreeLettersSteps {
  private static final Logger logger = Logger.getLogger(CheckThreeLettersSteps.class);
  private static final String CHROMEDRIVER_EXE = "/home/ubuntu/chromedriver_linux64/chromedriver";
  private static final String MAIN_URL = "http://mail.ru";
  private static final String LOGIN = "lina.baikova";
  private static final String PASSWORD = "aacfTT52z7";
  private static final String DOMAIN = "@bk.ru";
  private WebDriver webDriver;
  private CheckThreeLettersPage checkThreeLettersPage;
  private LoginPage loginPage;

  public CheckThreeLettersSteps()
  {
    logger.info("tests are starting.....");
    String exePath = CHROMEDRIVER_EXE;
    System.setProperty("webdriver.chrome.driver", exePath);
    webDriver = WebDriverSingletonPattern.getInstance();
    loginPage = new LoginPage(webDriver);
    checkThreeLettersPage = new CheckThreeLettersPage(webDriver);
    logger.info("page initialization finished");
  }

  @Given("^I am on main page and sign in as a correct user$")
  public void iAmOnMainPageAndSignInAsACorrectUser() throws Throwable {
    webDriver.get(MAIN_URL);
    logger.info("loading page with the URL " + MAIN_URL);
    loginPage.enterLoginAndPass(LOGIN, DOMAIN, PASSWORD);
    loginPage.clickEnterButton();
  }

  @When("^I mark three letters$")
  public void iMarkThreeLetters() throws Throwable {
    checkThreeLettersPage.checkEmails();
  }

  @Then("^I see positive notification$")
  public void iSeePositiveNotification() throws Throwable {
    logger.info("Письма помечены");
    Assert.assertTrue("checkThreeLettersPage", checkThreeLettersPage.areEmailsMarked());
  }

  @After
  public void afterClass()
  {
    webDriver.quit();
  }
}

