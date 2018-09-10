package CreateCucumber;

import CreateCucumber.CreateEmailPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import java.util.concurrent.TimeUnit;

public class CreateEmailSteps {

  private static final String MAIN_URL = "http://mail.ru";
  private static final String CHROMEDRIVER_EXE = "/home/ubuntu/chromedriver_linux64/chromedriver";
  private static final String LOGIN = "lina.baikova";
  private static final String PASSWORD = "aacfTT52z7";
  private static final String DOMAIN = "@bk.ru";
  private static final String EMAILADDRESS = "lina.baikova@bk.ru";
  private static final String THEME = "To my beloved me...";
  private static final String TEXT = "...just put your stuff together and slay this course!";
  private CreateEmailPage createPage;
  private WebDriver webDriver;

  public CreateEmailSteps() {
    String exePath = CHROMEDRIVER_EXE;
    System.setProperty("webdriver.chrome.driver", exePath);
    webDriver = new ChromeDriver();
    webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    createPage = new CreateEmailPage(webDriver);
  }

  @Given("^I am on main application page signing in as a correct user$")
  public void signIn()
  {
    webDriver.get(MAIN_URL);
    createPage.enterLoginAndPass(LOGIN, DOMAIN, PASSWORD);
    createPage.clickEnterButton();
  }

  @When("^I click on 'Create Email' button$")
  public void createEmail() {
    createPage.clickMakeANewLetterButton();
  }

  @And("^Fill fields with info$")
  public void writeEmail() {
    createPage.writeLetter(EMAILADDRESS, THEME, TEXT);
  }

  @And("^Click 'Send' button$")
  public void sendEmail () {
    createPage.clickSendButton();
  }

  @Then("^I receive a positive feedback$")
  public void getAFeedback() {
    Assert.assertTrue(createPage.mailFeedback());
  }

  @After
  public void afterClass()
  {
    webDriver.quit();
  }
}
