package Steps;

import Page.NotSpamLetterPage;
import Page.LoginPage;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import resources.WebDriverSingletonPattern;

public class NotSpamLetterPageSteps {
  private static final String CHROMEDRIVER_EXE = "/home/ubuntu/chromedriver_linux64/chromedriver";
  private static final String MAIN_URL = "http://mail.ru";
  private static final String LOGIN = "lina.baikova";
  private static final String PASSWORD = "aacfTT52z7";
  private static final String DOMAIN = "@bk.ru";
  private WebDriver webDriver;
  private NotSpamLetterPage notSpamLetterPage;
  private LoginPage loginPage;

  public NotSpamLetterPageSteps(){
    String exePath = CHROMEDRIVER_EXE;
    System.setProperty("webdriver.chrome.driver", exePath);
    webDriver = WebDriverSingletonPattern.getInstance();
    loginPage = new LoginPage(webDriver);
    notSpamLetterPage = new NotSpamLetterPage(webDriver);
  }

  @Given("^I am on incoming mails page to remove mails from spam$")
  public void iAmOnIncomingMailsPageToRemoveMailsFromSpam() throws Throwable {
    webDriver.get(MAIN_URL);
    loginPage.enterLoginAndPass(LOGIN, DOMAIN, PASSWORD);
    loginPage.clickEnterButton();
  }

  @When("^I remove mail from spam$")
  public void iRemoveMailIntoSpam() throws Throwable {
    notSpamLetterPage.noSpamLetter();
  }
  @Then("^I see a positive notification that messages are not spam$")
  public void iSeeAPositiveNotificationNotSpam() throws Throwable {
    Assert.assertTrue("The letter is not a spam", notSpamLetterPage.noSpamNotifyMessage());
  }

  @After
  public void afterClass()
  {
    webDriver.quit();
  }
}
