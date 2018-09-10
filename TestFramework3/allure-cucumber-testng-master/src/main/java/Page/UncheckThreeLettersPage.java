package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UncheckThreeLettersPage {
  public UncheckThreeLettersPage(WebDriver webDriver)
  {
    PageFactory.initElements(webDriver, this);
  }

  @FindBy(xpath = "//*[contains(text(), 'Письма помечены')]")
  private WebElement markedText;

  @FindBy(xpath = "(//*[text() = 'Ещё'])[2]")
  private WebElement dropdownElse;

  @FindBy(xpath = "//*[text() = 'Снять флажок']")
  private WebElement removeFlag;

  @FindBy(xpath = "(//*[@class = 'b-checkbox__box'])[1]")
  private WebElement dropdownCheck;

  public void removeFlags() {
    dropdownCheck.click();
    dropdownElse.click();
    removeFlag.click();
  }

  public boolean areEmailsMarked() {
    return markedText.isDisplayed();
  }
}
