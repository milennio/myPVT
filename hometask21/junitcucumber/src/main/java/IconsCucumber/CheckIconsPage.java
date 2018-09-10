package IconsCucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckIconsPage {

  public CheckIconsPage(WebDriver webdriver)
  {
    PageFactory.initElements(webdriver, this);
  }

  private String icqPath = "//*[@id='projects']/a[1]";
  private String mmPath = "//*[@id='projects']/a[2]";
  private String okPath = "//*[@id='projects']/a[3]";
  private String agentPath = "//*[@id='projects']/a[4]";
  private String horoPath = "//*[@id='projects']/a[5]";
  private String tvPath = "//*[@id='projects']/a[6]";
  private String goodsPath = "//*[@id='projects']/a[7]";

  @FindBy(xpath = "//*[@id='projects']/a[1]")
  private WebElement icqIcon;

  @FindBy(xpath = "//*[@id='projects']/a[2]")
  private WebElement mmIcon;

  @FindBy(xpath = "//*[@id='projects']/a[3]")
  private WebElement okIcon;

  @FindBy(xpath = "//*[@id='projects']/a[4]")
  private WebElement agentIcon;

  @FindBy(xpath = "//*[@id='projects']/a[5]")
  private WebElement horoIcon;

  @FindBy(xpath = "//*[@id='projects']/a[6]")
  private WebElement tvIcon;

  @FindBy(xpath = "//*[@id='projects']/a[7]")
  private WebElement goodsIcon;

  public void checkUpOnIcons() {
    icqIcon.findElement(By.xpath(icqPath));
    mmIcon.findElement(By.xpath(mmPath));
    okIcon.findElement(By.xpath(okPath));
    agentIcon.findElement(By.xpath(agentPath));
    horoIcon.findElement(By.xpath(horoPath));
    tvIcon.findElement(By.xpath(tvPath));
    goodsIcon.findElement(By.xpath(goodsPath));
  }

  public boolean iconsAreDisplayed(){
    return icqIcon.isDisplayed() &&
            mmIcon.isDisplayed() && okIcon.isDisplayed() &&
            agentIcon.isDisplayed() && horoIcon.isDisplayed() &&
            tvIcon.isDisplayed() && goodsIcon.isDisplayed();
  }

}