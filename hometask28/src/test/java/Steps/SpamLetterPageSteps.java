package Steps;

import Page.SpamLetterPage;
import Page.LoginPage;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import resources.WebDriverSingletonPattern;

public class SpamLetterPageSteps {
  private static final String CHROMEDRIVER_EXE = "/home/ubuntu/chromedriver_linux64/chromedriver";
  private static final String MAIN_URL = "http://mail.ru";
  private static final String LOGIN = "lina.baikova";
  private static final String PASSWORD = "aacfTT52z7";
  private static final String DOMAIN = "@bk.ru";
  private WebDriver webDriver;
  private LoginPage loginPage;
  private SpamLetterPage spamLetterPage;

  public SpamLetterPageSteps(){
    String exePath = CHROMEDRIVER_EXE;
    System.setProperty("webdriver.chrome.driver", exePath);
    webDriver = WebDriverSingletonPattern.getInstance();
    loginPage = new LoginPage(webDriver);
    spamLetterPage = new SpamLetterPage(webDriver);
  }

  @Given("^I am on incoming mails page to remove spam$")
  public void iAmOnIncomingMailsPage() throws Throwable {
    webDriver.get(MAIN_URL);
    loginPage.enterLoginAndPass(LOGIN, DOMAIN, PASSWORD);
    loginPage.clickEnterButton();
  }

  @When("^I remove mail into spam$")
  public void iRemoveMailIntoSpam() throws Throwable {
    spamLetterPage.setSpamLetter();
  }

  @Then("^I see a positive notification that a letter is removed$")
  public void iSeeAPositiveNotificationThatALetterIsRemoved(){
    Assert.assertTrue("Remove to spam", spamLetterPage.confirmSpamLetter());
  }

  @After
  public void afterClass()
  {
    webDriver.quit();
  }
}
