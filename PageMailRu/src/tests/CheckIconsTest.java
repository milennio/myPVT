package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import package1.CheckIcons;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class CheckIconsTest {

  public WebDriver driver;
  public CheckIcons iconsPage;

  @BeforeMethod
  public void setUp() {
    System.setProperty("webdriver.chrome.driver",
            "/home/ubuntu/chromedriver_linux64/chromedriver");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    driver.get("https://www.mail.ru/");
    iconsPage = new CheckIcons(driver);
  }

  @Test
  public void checkIconsTest(){
    assertTrue(iconsPage.iconsAreDisplayed());
  }

  @AfterMethod
  public void tearDown() {
    driver.quit();
  }
}