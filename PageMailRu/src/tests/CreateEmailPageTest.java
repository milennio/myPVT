package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import package1.CreateEmailPage;
import package1.LoginPage;


import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class CreateEmailPageTest {

  private WebDriver driver;
  private CreateEmailPage emailPage;
  private LoginPage loginPage;

  @BeforeClass
  public void setUp() {
    System.setProperty("webdriver.chrome.driver",
            "/home/ubuntu/chromedriver_linux64/chromedriver");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    driver.get("https://www.mail.ru/");
    emailPage = new CreateEmailPage(driver);
    loginPage = new LoginPage(driver);
    loginPage.enterLoginAndPass("lina.baikova",
            "@bk.ru", "aacfTT52z7");
    loginPage.clickEnterButton();
    emailPage.clickMakeANewLetterButton();
  }

  @Test
  public void SendEmailTest(){
    emailPage.writeLetter("lina.baikova@bk.ru", "letter_1_test_1",
            driver, "some stupid stuff over and over again");
    emailPage.clickSendButton();
    assertTrue(emailPage.mailFeedback(),
            "The letter has been sent. Your test has passed.");
  }

  @AfterClass
  public void tearDown() {
    driver.quit();
  }


}