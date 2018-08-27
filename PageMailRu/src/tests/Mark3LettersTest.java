package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import package1.LoginPage;
import package1.Mark3Letters;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class Mark3LettersTest {

  public WebDriver driver;
  public LoginPage loginPage;
  public Mark3Letters mark3Page;

  @BeforeMethod
  public void setUp() {
    System.setProperty("webdriver.chrome.driver",
            "/home/ubuntu/chromedriver_linux64/chromedriver");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    driver.get("http://www.mail.ru/");
    loginPage = new LoginPage(driver);
    loginPage.enterLoginAndPass("lina.baikova",
            "@bk.ru", "aacfTT52z7");
    loginPage.clickEnterButton();
    mark3Page = new Mark3Letters(driver);
  }

  @Test
  public void mark3LettersWtheFlagsTest() {
//    fail("'Cuz it's not ready yet!");
    mark3Page.checkEmails();
    assertTrue(mark3Page.areEmailsMarked());
  }

  @AfterMethod
  public void tearDown() {
    driver.quit();
  }
}