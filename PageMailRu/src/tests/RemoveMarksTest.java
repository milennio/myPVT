package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import package1.LoginPage;
import package1.Mark3Letters;
import package1.RemoveMarks;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class RemoveMarksTest {

  private WebDriver driver;
  private LoginPage loginPage;
  private RemoveMarks removeMarksPage;

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
    removeMarksPage = new RemoveMarks(driver);
  }

  @Test
  public void removingMarksTest() {
    removeMarksPage.removeFlags();
    assertTrue(removeMarksPage.areEmailsMarked());
  }

  @AfterMethod
  public void tearDown() {
  }
}