package package1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RemoveMarks {

  public RemoveMarks (WebDriver webDriver)
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

  @FindBy(xpath = "//*[text() = 'Помеченные флажком']")
    private WebElement flagMarked;

  public void removeFlags() {
    dropdownCheck.click();
    //flagMarked.click();
    dropdownElse.click();
    removeFlag.click();
  }

  public boolean areEmailsMarked() {
    return markedText.isDisplayed();
  }

}
