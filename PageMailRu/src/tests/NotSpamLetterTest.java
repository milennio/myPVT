package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import package1.LoginPage;
import package1.NotSpamLetter;
import package1.SpamLetter;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class NotSpamLetterTest {

  public WebDriver driver;
  public LoginPage loginPage;
  public NotSpamLetter noSpamPage;

  @BeforeMethod
  public void setUp() {
    System.setProperty("webdriver.chrome.driver",
            "/home/ubuntu/chromedriver_linux64/chromedriver");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    // driver.manage().window().maximize();
    driver.get("https://www.mail.ru/");
    loginPage = new LoginPage(driver);
    loginPage.enterLoginAndPass("lina.baikova",
            "@bk.ru", "aacfTT52z7");
    loginPage.clickEnterButton();
    noSpamPage = new NotSpamLetter(driver);
  }

  @Test
  public void removeFromSpamTest(){
    noSpamPage.noSpamLetter();
    assertTrue(noSpamPage.noSpamNotifyMessage());
  }

  @AfterMethod
  public void tearDown() {
    driver.quit();
  }
}