package Steps;

import Page.CheckThreeLettersPage;
import Page.LoginPage;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import resources.WebDriverSingletonPattern;


public class CheckThreeLettersSteps {

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

    String exePath = CHROMEDRIVER_EXE;
    System.setProperty("webdriver.chrome.driver", exePath);
    webDriver = WebDriverSingletonPattern.getInstance();
    loginPage = new LoginPage(webDriver);
    checkThreeLettersPage = new CheckThreeLettersPage(webDriver);

  }

  @Given("^I am on main page and sign in as a correct user$")
  public void iAmOnMainPageAndSignInAsACorrectUser() throws Throwable {
    webDriver.get(MAIN_URL);
    loginPage.enterLoginAndPass(LOGIN, DOMAIN, PASSWORD);
    loginPage.clickEnterButton();
  }

  @When("^I mark three letters$")
  public void iMarkThreeLetters() throws Throwable {
    checkThreeLettersPage.checkEmails();
  }

  @Then("^I see positive notification$")
  public void iSeePositiveNotification() throws Throwable {
    Assert.assertTrue("checkThreeLettersPage", checkThreeLettersPage.areEmailsMarked());
  }

  @After
  public void afterClass()
  {
    webDriver.quit();
  }
}

