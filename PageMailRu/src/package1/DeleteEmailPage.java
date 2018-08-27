package package1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteEmailPage {

  public DeleteEmailPage(WebDriver webdriver)
  {
    PageFactory.initElements(webdriver, this);
  }

  public WebDriver driver;

//  @FindBy(xpath = "(//*[@class = 'js-href b-datalist__item__link'])[1]")
//  private WebElement emailLink;
//
//  @FindBy(xpath = "(//*[text() = 'Удалить'])[2]")
//    private WebElement delButton;

  @FindBy(xpath = "(//div[@class='b-checkbox__box'])[3]")
    private WebElement buttonCheckBox;

  @FindBy(xpath = "(//span[text()='Удалить'])[1]")
    private WebElement buttonDelete;

  @FindBy(xpath = "//*[contains(text(), 'удалены')]")
    private WebElement messageEmailDeleted;

  public void deleteMassage(){
    buttonCheckBox.click();
    buttonDelete.click();
  }

  public boolean deletingResult(){
    return messageEmailDeleted.isDisplayed();
  }
}
