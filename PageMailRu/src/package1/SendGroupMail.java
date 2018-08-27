package package1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SendGroupMail {

  public SendGroupMail (WebDriver webDriver){
    PageFactory.initElements(webDriver, this);
  }

  @FindBy(xpath = "//*[@class = 'b-toolbar__btn__text b-toolbar__btn__text_pad']")
    private WebElement createLetterButton;

  @FindBy(xpath = "//*[@class = 'b-toolbar__btn__text']")
    private WebElement sendLetterButton;

  @FindBy(xpath = "(//textarea[@class = 'js-input compose__labels__input'])[1]")
    private WebElement toWhomField;

  @FindBy(xpath = "//input[@class = 'b-input']")
    private WebElement themeField;

  @FindBy(xpath = "//*[@tabindex = '201']")
    private WebElement copyField;

  @FindBy(xpath = ".//iframe[contains(@id, 'composeEditor_ifr')]")
    public WebElement iframe;

  @FindBy(xpath = "//*[@class='message-sent__title']")
    private WebElement feedback;

//  @FindBy(xpath = "(//*[text() = 'Копия'])[1]")
//    private WebElement madeCopiesLink1;

  @FindBy(xpath = "(//*[text() = 'Копия'])[2]")
    private WebElement madeCopiesLink2;

  @FindBy(xpath = "//*[@id='jsHtml']/body/div[10]/div[1]/div/div[1]/div/div[1]/div[2]/div/div/div[1]/div/div[1]")
    private WebElement checkBoxForAll;

  @FindBy(xpath = "//*[@data-id = 'popup_ok']")
    private WebElement addButton;

  @FindBy(xpath = "//*[@data-title = 'lina.baikova']")
    private WebElement email1;

  @FindBy(xpath = "//*[@data-title = 'milennio.cher']")
    private WebElement email2;

  public void clickMakeANewLetterButton() {
    createLetterButton.click();
  }

  public void composeLetter(String email, String theme, WebDriver driver, String text) {
    toWhomField.clear();
    toWhomField.sendKeys(email);




    //madeCopiesLink1.click();
    madeCopiesLink2.click();



    //checkBoxForAll.click();
    email1.click();
    email2.click();



    addButton.click();
    themeField.clear();
    themeField.sendKeys(theme);
    driver.switchTo().frame(iframe);
    WebElement tempElement = driver.findElement(By.xpath("//*[@id='tinymce']"));
    tempElement.sendKeys(text);
    driver.switchTo().defaultContent();
  }

  public void clickSendButton(){
    sendLetterButton.click();
  }

  public boolean mailFeedback() {
    return feedback.isDisplayed();
  }
}
