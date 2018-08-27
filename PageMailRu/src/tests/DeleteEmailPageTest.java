package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import package1.DeleteEmailPage;
import package1.LoginPage;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class DeleteEmailPageTest {

  private WebDriver driver;
  private LoginPage loginPage;
  private DeleteEmailPage deletePage;

  @BeforeMethod
  public void setUp() {
    System.setProperty("webdriver.chrome.driver",
            "/home/ubuntu/chromedriver_linux64/chromedriver");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    //driver.manage().window().maximize();
    driver.get("https://www.mail.ru/");
    deletePage = new DeleteEmailPage(driver);
    loginPage = new LoginPage(driver);
    loginPage.enterLoginAndPass("lina.baikova",
            "@bk.ru", "aacfTT52z7");
    loginPage.clickEnterButton();
  }

  @Test
  public void deleteMessageTest(){
    deletePage.deleteMassage();
    assertTrue(deletePage.deletingResult());
  }

  @AfterMethod
  public void tearDown() {
    driver.quit();
  }
}