package Steps;

import Page.SendGroupEmailPage;
import Page.LoginPage;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import resources.WebDriverSingletonPattern;

import java.util.concurrent.TimeUnit;

public class SendGroupEmailPageSteps {
  private static final String CHROMEDRIVER_EXE = "/home/ubuntu/chromedriver_linux64/chromedriver";
  private static final String MAIN_URL = "http://mail.ru";
  private static final String LOGIN = "lina.baikova";
  private static final String PASSWORD = "aacfTT52z7";
  private static final String DOMAIN = "@bk.ru";
  private WebDriver webDriver;
  private LoginPage loginPage;
  private SendGroupEmailPage sendGroupEmailPage;

  public SendGroupEmailPageSteps(){
    String exePath = CHROMEDRIVER_EXE;
    System.setProperty("webdriver.chrome.driver", exePath);
    webDriver = WebDriverSingletonPattern.getInstance();
    webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    loginPage = new LoginPage(webDriver);
    sendGroupEmailPage = new SendGroupEmailPage(webDriver);
  }

  @Given("^I am on incoming mails page to send emails$")
  public void iAmOnIncomingMailsPageForSendingAnEmail() throws Throwable {
    webDriver.get(MAIN_URL);
    loginPage.enterLoginAndPass(LOGIN, DOMAIN, PASSWORD);
    loginPage.clickEnterButton();
  }

  @When("^I click on a create mail link$")
  public void iClickOnACreateMailLink() throws Throwable {
    sendGroupEmailPage.clickMakeANewLetterButton();
  }

  @And("^I compose letter$")
  public void iComposeLetter() throws Throwable {
    sendGroupEmailPage.composeLetter("lina.baikova@bk.ru",
            "nothing new", "like really nothing");
  }

  @And("^I click on send button to send copies$")
  public void iClickOnSendButtonToSendCopies() throws Throwable {
    sendGroupEmailPage.clickSendButton();
  }

  @Then("^I see a positive notification that letters are sent$")
  public void iSeeAPositiveNotificationThatLettersAreSent() throws Throwable {
    Assert.assertTrue("The letter has been sent", sendGroupEmailPage.mailFeedback());
  }

  @After
  public void afterClass()
  {
    webDriver.quit();
  }
}
