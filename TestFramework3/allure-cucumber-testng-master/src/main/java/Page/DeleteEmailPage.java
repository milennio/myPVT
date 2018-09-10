package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteEmailPage {
  public DeleteEmailPage(WebDriver webdriver)
  {
    PageFactory.initElements(webdriver, this);
  }

  @FindBy(xpath = "(//div[@class='b-checkbox__box'])[3]")
  private WebElement buttonCheckBox;

  @FindBy(xpath = "(//span[text()='Удалить'])[1]")
  private WebElement buttonDelete;

  @FindBy(xpath = "//*[contains(text(), 'удалены')]")
  private WebElement messageEmailDeleted;

  public void checkMessage(){
    buttonCheckBox.click();
  }

  public void delMessage(){
    buttonDelete.click();
  }

  public boolean messageEmailDel(){
    return messageEmailDeleted.isDisplayed();
  }
}
