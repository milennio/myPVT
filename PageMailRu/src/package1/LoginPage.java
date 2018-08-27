package package1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {

  @FindBy(id = "mailbox:login")
  private WebElement loginField;

  @FindBy(id = "mailbox:password")
  private WebElement passField;

  @FindBy(id = "mailbox:domain")
  private WebElement domainField;

  @FindBy(xpath = "//*[@id='mailbox:submit']/input")
  private WebElement buttonEnter;

  @FindBy(xpath = "//*[@id='PH_logoutLink']")
  private WebElement logoutLink;

  public LoginPage(WebDriver webdriver)
  {
    PageFactory.initElements(webdriver, this);
  }

  public void enterLoginAndPass(String login, String domain, String password)
  {
    loginField.clear();
    loginField.sendKeys(login);
    (new Select(domainField)).selectByVisibleText(domain);
    passField.clear();
    passField.sendKeys(password);
  }

  public void clickEnterButton()
  {
    buttonEnter.click();
  }

  public boolean logoutLinkPresents()
  {
    return logoutLink.isDisplayed();
  }

}
