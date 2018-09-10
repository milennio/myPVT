package resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSingletonPattern {
  private static WebDriver ourInstance;

  public static WebDriver getInstance() {
    if (ourInstance == null){
      ourInstance = new ChromeDriver();
    }
    return ourInstance;
  }

  private WebDriverSingletonPattern() {
  }
}
