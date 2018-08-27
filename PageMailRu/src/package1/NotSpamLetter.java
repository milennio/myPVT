package package1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotSpamLetter {

  public NotSpamLetter(WebDriver webdriver)
  {
    PageFactory.initElements(webdriver, this);
  }

  @FindBy(xpath = "(//*[@class = 'b-nav__item__text'])[4]")
  private WebElement spamLink;

  @FindBy(xpath = "(//*[@class = 'b-checkbox__box'])[11]")
  private WebElement checkboxButton;

  @FindBy(xpath = "//*[@data-name = 'noSpam']")
  private WebElement noSpamButton;

  @FindBy(xpath = "//*[contains(text(), 'в папку «Входящие»')]")
  private WebElement noSpamText;

  public void noSpamLetter(){
    spamLink.click();
    checkboxButton.click();
    noSpamButton.click();
  }

  public boolean noSpamNotifyMessage(){
    return noSpamText.isDisplayed();
  }
  
}
