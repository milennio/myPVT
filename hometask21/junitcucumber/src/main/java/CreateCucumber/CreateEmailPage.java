package CreateCucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateEmailPage {

  private WebDriver driver;

  @FindBy(id = "mailbox:login")
  private WebElement loginField;

  @FindBy(id = "mailbox:domain")
  private WebElement domainField;

  @FindBy(id = "mailbox:password")
  private WebElement passwordField;

  @FindBy(xpath = "//*[@id='mailbox:submit']/input")
  private WebElement buttonEnter;

  @FindBy(xpath = "//*[@id='PH_logoutLink']")
  private WebElement logoutLink;

  @FindBy(xpath = "(//i[@class = 'ico ico_toolbar ico_toolbar_compose'])[1]")
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

  public CreateEmailPage(WebDriver webdriver)
  {
    PageFactory.initElements(webdriver, this);
  }

  public void enterLoginAndPass(String login,String domain, String password)
  {
    loginField.clear();
    loginField.sendKeys(login);
    (new Select(domainField)).selectByVisibleText(domain);
    passwordField.clear();
    passwordField.sendKeys(password);
  }

  public void clickEnterButton()
  {
    buttonEnter.click();
  }

  public boolean logoutLinkPresents()
  {
    return (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(logoutLink)).isDisplayed();
  }

  public void clickMakeANewLetterButton() {
    buttonNewLetter.click();
  }

  public void writeLetter(String email, String theme, String text) {
    toWhomField.clear();
    toWhomField.sendKeys(email);
    themeField.clear();
    themeField.sendKeys(theme);
    (new WebDriverWait(driver, 10))
            .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));
//    driver.switchTo().frame(iframe);
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
