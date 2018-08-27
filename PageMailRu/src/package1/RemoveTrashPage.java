package package1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RemoveTrashPage {

  public RemoveTrashPage(WebDriver webdriver)
  {
    PageFactory.initElements(webdriver, this);
  }

  public WebDriver driver;

  @FindBy(xpath = "//*[text() = 'Корзина']")
    private WebElement basketLink;

  @FindBy(xpath = "//button[@data-name = 'clearFolder']")
    private WebElement clearFolderButton;

  @FindBy(xpath = "//span[text() = 'В Корзине пусто.']")
    private WebElement confirmText;

  @FindBy(xpath = "//*[@class= 'popup js-layer popup_dark popup_']")
    private WebElement confirmAlert;

  @FindBy(xpath = "//*[@class = 'btn btn_stylish confirm-ok']")
    private WebElement acceptDelButton;

  public void removeTrash(){
    basketLink.click();
    clearFolderButton.click();
    acceptDelButton.click();
  }

  public boolean isTrashRemoved(){
    return confirmText.isDisplayed();
  }

}
