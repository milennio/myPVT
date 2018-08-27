package package1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpamLetter {

  public SpamLetter(WebDriver webdriver)
  {
    PageFactory.initElements(webdriver, this);
  }

  @FindBy(xpath = "(//div[@class='b-checkbox__box'])[3]")
  private WebElement checkboxButton;

  @FindBy(xpath = "(//span[text()='Спам'])[1]")
  private WebElement spamButton;

//  @FindBy(xpath = "//*[@class = 'b-layer__container']")
//  private WebElement confirmAlert;

  @FindBy(xpath = "//*[@data-id = 'approve']")
  private WebElement acceptSpamButton;

  @FindBy(xpath = "//*[contains(text(), 'перемещены в папку «Спам»')]")
  private WebElement messageSpamed;

  private WebDriver driver;

  public void setSpamLetter() {
    checkboxButton.click();
    spamButton.click();
    acceptSpamButton.click();
//    if (driver.findElement(By.xpath("//*[@data-id = 'approve']")).isDisplayed())
//        driver.findElement(By.xpath("//*[@data-id = 'approve']")).click();
  }

  public boolean confirmSpamLetter() {
    return messageSpamed.isDisplayed();
  }
}
