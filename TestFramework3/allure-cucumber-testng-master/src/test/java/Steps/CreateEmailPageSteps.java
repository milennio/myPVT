package Steps;

import Page.CreateEmailPage;
import Page.LoginPage;
import cucumber.api.java.After;
import org.junit.Assert;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import resources.WebDriverSingletonPattern;

public class CreateEmailPageSteps {
  private static final Logger logger = Logger.getLogger(CreateEmailPageSteps.class);
  private static final String CHROMEDRIVER_EXE = "/home/ubuntu/chromedriver_linux64/chromedriver";
  private static final String MAIN_URL = "http://mail.ru";
  private static final String LOGIN = "lina.baikova";
  private static final String PASSWORD = "aacfTT52z7";
  private static final String DOMAIN = "@bk.ru";
  private WebDriver webDriver;
  private CreateEmailPage createEmailPage;
  private LoginPage loginPage;

  public CreateEmailPageSteps()
  {
    logger.info("tests are starting.....");
    String exePath = CHROMEDRIVER_EXE;
    System.setProperty("webdriver.chrome.driver", exePath);
    webDriver = WebDriverSingletonPattern.getInstance();
    loginPage = new LoginPage(webDriver);
    createEmailPage = new CreateEmailPage(webDriver);
    logger.info("page initialization finished");
  }

  @Given("^I am on incoming mails page to send an email$")
    public void iAmOnIncomingMailsPageToSendAnEmail() throws Throwable {
    webDriver.get(MAIN_URL);
    logger.info("loading page with the URL " + MAIN_URL);
    loginPage.enterLoginAndPass(LOGIN, DOMAIN, PASSWORD);
    loginPage.clickEnterButton();
  }

  @When("^I click on create link$")
  public void iClickOnCreateLink() throws Throwable {
    createEmailPage.clickMakeANewLetterButton();
  }

  @And("^I fill all fields$")
  public void iFillAllFields() throws Throwable {
    createEmailPage.writeLetter("lina.baikova@bk.ru", "letter_1_test_1",
            "some stupid stuff over and over again");

  }

  @And("^I click on send button to send an email$")
  public void iClickOnSendButtonToSendAnEmail() throws Throwable {
    createEmailPage.clickSendButton();
  }

  @Then("^I see a positive notification that the letter is sent$")
  public void iSeeAPositiveNotificationThatTheLetterIsSent() throws Throwable {
    Assert.assertTrue("The letter has been sent. Your test has passed.", createEmailPage.mailFeedback());
  }

  @After
  public void afterClass()
  {
    webDriver.quit();
  }
}
