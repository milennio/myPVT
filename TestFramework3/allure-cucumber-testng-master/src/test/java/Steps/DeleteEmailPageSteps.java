package Steps;

import Page.DeleteEmailPage;
import Page.LoginPage;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import resources.WebDriverSingletonPattern;

public class DeleteEmailPageSteps {
  private static final Logger logger = Logger.getLogger(DeleteEmailPageSteps.class);
  private static final String CHROMEDRIVER_EXE = "/home/ubuntu/chromedriver_linux64/chromedriver";
  private static final String MAIN_URL = "http://mail.ru";
  private static final String LOGIN = "lina.baikova";
  private static final String PASSWORD = "aacfTT52z7";
  private static final String DOMAIN = "@bk.ru";
  private WebDriver webDriver;
  private LoginPage loginPage;
  private DeleteEmailPage deleteEmailPage;

  public DeleteEmailPageSteps()
  {
    logger.info("tests are starting.....");
    String exePath = CHROMEDRIVER_EXE;
    System.setProperty("webdriver.chrome.driver", exePath);
    webDriver = WebDriverSingletonPattern.getInstance();
    loginPage = new LoginPage(webDriver);
    deleteEmailPage = new DeleteEmailPage(webDriver);
    logger.info("page initialization finished");
  }

  @Given("^I am on incoming mails page to delete an email$")
  public void iAmOnIncomingMailsPageToDeleteAnEmail() throws Throwable {
    webDriver.get(MAIN_URL);
    logger.info("loading page with the URL " + MAIN_URL);
    loginPage.enterLoginAndPass(LOGIN, DOMAIN, PASSWORD);
    loginPage.clickEnterButton();
  }

  @When("^I check a mail$")
  public void iCheckAMail(){
    deleteEmailPage.delMessage();
  }

  @And("^I click on delete button$")
  public void iClickOnDeleteButton() throws Throwable {
    deleteEmailPage.delMessage();
    throw new PendingException();
  }

  @Then("^I see a positive notification that the letter is deleted$")
  public void iSeeAPositiveNotificationThatTheLetterIsDeleted() throws Throwable {
    Assert.assertTrue("The letter has been deleted. Your test has passed.",
            deleteEmailPage.messageEmailDel());
    throw new PendingException();
  }

  @After
  public void afterClass()
  {
    webDriver.quit();
  }
}
