package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import package1.LoginPage;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class LoginPageTest {

  private WebDriver driver;
  private LoginPage loginPage;


  @BeforeClass
  public void setUp() {
    System.setProperty("webdriver.chrome.driver",
            "/home/ubuntu/chromedriver_linux64/chromedriver");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    driver.get("http://www.mail.ru/");
    loginPage = new LoginPage(driver);
  }

  @Test
  public void loginTest(){
    loginPage.enterLoginAndPass("lina.baikova","@bk.ru", "aacfTT52z7");
    loginPage.clickEnterButton();
    Assert.assertTrue(loginPage.logoutLinkPresents());
  }

  @AfterClass
  public void tearDown() {
    driver.quit();
  }
}
