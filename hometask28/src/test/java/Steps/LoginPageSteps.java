package Steps;

import Page.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.After;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import resources.WebDriverSingletonPattern;

public class LoginPageSteps
{
    private static final Logger logger = Logger.getLogger(LoginPageSteps.class);
    private static final String MAIN_URL = "http://mail.ru";
    private static final String CHROMEDRIVER_EXE = "/home/ubuntu/chromedriver_linux64/chromedriver";
    private static final String LOGIN = "lina.baikova";
    private static final String PASSWORD = "aacfTT52z7";
    private static final String DOMAIN = "@bk.ru";
    private LoginPage loginPage;
    private WebDriver webDriver;

    public LoginPageSteps()
    {
        logger.info("tests are starting.....");
        String exePath = CHROMEDRIVER_EXE;
        System.setProperty("webdriver.chrome.driver", exePath);
        webDriver = WebDriverSingletonPattern.getInstance();
        loginPage = new LoginPage(webDriver);
        logger.info("page initialization finished");
    }

    @Given("^I am on the main application page$")
    public void firstDigit() throws Throwable
    {
        webDriver.get(MAIN_URL);
        logger.info("loading page with the URL " + MAIN_URL);
    }

    @When("^I login as correct user$")
    public void secondDigit() throws Throwable
    {
        loginPage.enterLoginAndPass(LOGIN, DOMAIN, PASSWORD);
        loginPage.clickEnterButton();
    }

    @Then("^I see error message$")
    public void sum() throws Throwable
    {
        logger.error("Logout link validation failed");
        Assert.assertTrue("login page error", loginPage.logoutLinkErrorPresents());
    }

    @Then("^I pass$")
    public void pass() throws Throwable
    {
        logger.info("I pass");
        Assert.assertTrue(true);
    }
    
    @Then("^I fail$")
    public void fail() throws Throwable
    {
        logger.error("I fail");
        Assert.assertTrue(false);
    }

//    @Attachment(value = "Attachment Screenshot", type = "image/png")
//    public byte[] makeScreenshot()
//    {
//        return ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
//    }

    @Then("^I see logout link$")
    public void logoutLinkPresents(){
        Assert.assertTrue("login page", loginPage.logoutLinkPresents());
    }

    @After
    public void afterClass()
    {
//        makeScreenshot();
        webDriver.quit();
    }
}
