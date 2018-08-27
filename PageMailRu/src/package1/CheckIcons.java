package package1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckIcons {

  public CheckIcons(WebDriver webdriver)
  {
    PageFactory.initElements(webdriver, this);
  }

  @FindBy(xpath = "//*[@id=\"projects\"]/a[1]")
    private WebElement icqIcon;

  @FindBy(xpath = "//*[@id=\"projects\"]/a[2]")
    private WebElement mmIcon;

  @FindBy(xpath = "//*[@id=\"projects\"]/a[3]")
    private WebElement okIcon;

  @FindBy(xpath = "//*[@id=\"projects\"]/a[4]")
    private WebElement agentIcon;

  @FindBy(xpath = "//*[@id=\"projects\"]/a[5]")
    private WebElement horoIcon;

  @FindBy(xpath = "//*[@id=\"projects\"]/a[6]")
    private WebElement tvIcon;

  @FindBy(xpath = "//*[@id=\"projects\"]/a[7]")
    private WebElement goodsIcon;

  public boolean iconsAreDisplayed(){
    return icqIcon.isDisplayed() &&
            mmIcon.isDisplayed() && okIcon.isDisplayed() &&
            agentIcon.isDisplayed() && horoIcon.isDisplayed() &&
            tvIcon.isDisplayed() && goodsIcon.isDisplayed();
  }

}
