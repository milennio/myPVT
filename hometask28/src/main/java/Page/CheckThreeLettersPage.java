package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckThreeLettersPage {

  public CheckThreeLettersPage(WebDriver webDriver)
  {
    PageFactory.initElements(webDriver, this);
  }

  @FindBy(xpath = "//*[contains(text(), 'Письма помечены')]")
  private WebElement markedText;

  @FindBy(xpath = "(//*[text() = 'Ещё'])[2]")
  private WebElement dropdown;

  @FindBy(xpath = "//*[text() = 'Пометить флажком']")
  private WebElement flag;

  @FindBy(xpath = "(//*[@class='b-checkbox__box'])[3]")
  private WebElement email1;

  @FindBy(xpath = "(//*[@class='b-checkbox__box'])[5]")
  private WebElement email2;

  @FindBy(xpath = "(//*[@class='b-checkbox__box'])[7]")
  private WebElement email3;

  public void checkEmails() {
    email1.click();
    email2.click();
    email3.click();
    dropdown.click();
    flag.click();
  }

  public boolean areEmailsMarked() {
    return markedText.isDisplayed();
  }
}