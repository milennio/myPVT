package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import package1.CreateEmailPage;
import package1.LoginPage;
import package1.SendGroupMail;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class SendGroupMailTest {

  private WebDriver driver;
  private SendGroupMail groupPage;
  private LoginPage loginPage;

  @BeforeMethod
  public void setUp() {
    System.setProperty("webdriver.chrome.driver",
            "/home/ubuntu/chromedriver_linux64/chromedriver");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("https://www.mail.ru/");
    groupPage = new SendGroupMail(driver);
    loginPage = new LoginPage(driver);
    loginPage.enterLoginAndPass("lina.baikova",
            "@bk.ru", "aacfTT52z7");
    loginPage.clickEnterButton();
    groupPage.clickMakeANewLetterButton();
  }

  @Test
  public void SendEmailTest(){
    fail("The freaking checkbox does not wanna be checked!!!");
    groupPage.composeLetter("lina.baikova@bk.ru", "letter_1_test_2",
            driver, "some stupid stuff over and over again.\nand again.\nand again.");
    groupPage.clickSendButton();
    assertTrue(groupPage.mailFeedback(),
            "The letter has been sent. Your test has passed.");
  }

  @AfterMethod
  public void tearDown() {
    driver.quit();
  }
}