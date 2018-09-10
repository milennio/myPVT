package Steps;

import Page.CleanUpTheTrashBinPage;
import Page.LoginPage;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;

public class CleanUpTheTrashBinPageSteps {
  private static final Logger logger = Logger.getLogger(CleanUpTheTrashBinPageSteps.class);
  private static final String CHROMEDRIVER_EXE = "/home/ubuntu/chromedriver_linux64/chromedriver";
  private static final String MAIN_URL = "http://mail.ru";
  private static final String LOGIN = "lina.baikova";
  private static final String PASSWORD = "aacfTT52z7";
  private static final String DOMAIN = "@bk.ru";
  private WebDriver webDriver;
  private CleanUpTheTrashBinPage cleanUpTheTrashBinPage;
  private LoginPage loginPage;

  public CleanUpTheTrashBinPageSteps()
  {
    logger.info("tests are starting.....");
    String exePath = CHROMEDRIVER_EXE;
    System.setProperty("webdriver.chrome.driver", exePath);
    webDriver = new ChromeDriver();
    loginPage = new LoginPage(webDriver);
    cleanUpTheTrashBinPage = new CleanUpTheTrashBinPage(webDriver);
    logger.info("page initialization finished");
  }

  @Given("^I am on user's page$")
  public void iAmOnUserSPage() throws Throwable {
    webDriver.get(MAIN_URL);
    logger.info("loading page with the URL " + MAIN_URL);
    loginPage.enterLoginAndPass(LOGIN, DOMAIN, PASSWORD);
    loginPage.clickEnterButton();
  }


  @When("^I click on trash bin link$")
  public void iClickOnTrashBinLink() throws Throwable {
    cleanUpTheTrashBinPage.clickOnTheBasketLink();
  }


  @And("^I delete all messages$")
  public void iDeleteAllMessages() throws Throwable {
    cleanUpTheTrashBinPage.cleanUpTheTrashBin();
  }


  @Then("^I see positive delete notification$")
  public void iSeePositiveDeleteNotification() throws Throwable {
    logger.info("Письма удалены");
    Assert.assertTrue("CleanUpTheTrashBinPage", cleanUpTheTrashBinPage.isTrashRemoved());
  }

  @After
  public void afterClass()
  {
    webDriver.quit();
  }
}