package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CleanUpTheTrashBinPage {

  public CleanUpTheTrashBinPage(WebDriver webdriver)
  {
    PageFactory.initElements(webdriver, this);
  }

  @FindBy(xpath = "//*[text() = 'Корзина']")
  private WebElement basketLink;

  @FindBy(xpath = "//button[@data-name = 'clearFolder']")
  private WebElement clearFolderButton;

  @FindBy(xpath = "//span[text() = 'В Корзине пусто.']")
  private WebElement confirmText;

  @FindBy(xpath = "//*[@class = 'btn btn_stylish confirm-ok']")
  private WebElement acceptDelButton;

  public void clickOnTheBasketLink(){
    basketLink.click();
  }

  public void cleanUpTheTrashBin(){
    clearFolderButton.click();
    acceptDelButton.click();
  }

  public boolean isTrashRemoved(){
    return confirmText.isDisplayed();
  }

}