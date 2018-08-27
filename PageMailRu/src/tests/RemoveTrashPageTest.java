package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import package1.DeleteEmailPage;
import package1.LoginPage;
import package1.RemoveTrashPage;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class RemoveTrashPageTest {

  private WebDriver driver;
  private LoginPage loginPage;
  private RemoveTrashPage trashPage;

  @BeforeMethod
  public void setUp() {
    System.setProperty("webdriver.chrome.driver",
            "/home/ubuntu/chromedriver_linux64/chromedriver");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    //driver.manage().window().maximize();
    driver.get("https://www.mail.ru/");
    trashPage = new RemoveTrashPage(driver);
    loginPage = new LoginPage(driver);
    loginPage.enterLoginAndPass("lina.baikova",
            "@bk.ru", "aacfTT52z7");
    loginPage.clickEnterButton();
  }

  @Test
  public void removeTrashTest(){
    trashPage.removeTrash();
    assertTrue(trashPage.isTrashRemoved());
  }

  @AfterMethod
  public void tearDown() {
    driver.quit();
  }
}