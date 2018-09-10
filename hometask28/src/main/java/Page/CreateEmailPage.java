package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateEmailPage {
  @FindBy(xpath = "//*[@class = 'b-toolbar__btn__text b-toolbar__btn__text_pad']")
  private WebElement buttonNewLetter;

  @FindBy(xpath = "//*[@class = 'b-toolbar__btn__text']")
  private WebElement buttonSendLetter;

  @FindBy(xpath = "(//textarea[@class = 'js-input compose__labels__input'])[1]")
  private WebElement toWhomField;

  @FindBy(xpath = "//input[@class = 'b-input']")
  private WebElement themeField;

  @FindBy(xpath = ".//iframe[contains(@id, 'composeEditor_ifr')]")
  public WebElement iframe;

  @FindBy(xpath = "//*[@class='message-sent__title']")
  //@FindBy(xpath = "//*[text()=' отправлено. ']")
  private WebElement feedback;

  private WebDriver driver;

  public CreateEmailPage(WebDriver webdriver)
  {
    PageFactory.initElements(webdriver, this);
  }

  public void clickMakeANewLetterButton() {
    buttonNewLetter.click();
  }

  public void writeLetter(String email, String theme, String text) {
    toWhomField.clear();
    toWhomField.sendKeys(email);
    themeField.clear();
    themeField.sendKeys(theme);
    driver.switchTo().frame(iframe);
    WebElement tempElement = driver.findElement(By.xpath("//*[@id='tinymce']"));
    tempElement.sendKeys(text);
    driver.switchTo().defaultContent();
  }

  public void clickSendButton(){
    buttonSendLetter.click();
  }

  public boolean mailFeedback() {
    return feedback.isDisplayed();
  }
}