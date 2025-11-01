package pages;

import static org.testng.Assert.assertEquals;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.TestUtils;
import utils.WaitFor;

public class UserGuidePage {
  public UserGuidePage() {
    PageFactory.initElements(TestBase.getDriver(), this);
  }

  @FindBy(css = "button.back-btn")
  WebElement backButton;

  @FindBy(xpath = "//span[text()='UPL Genie User Guide']")
  WebElement userGuide;

  @FindBy(xpath = "//span[text()='FAQs']")
  WebElement faqs;

  @FindBy(css = "button.submit-policy-btn")
  WebElement closeButton;

  public void verifyUserGuidePage() {
    WaitFor.time(1);
    TestUtils.isDisplayed(backButton, "Back button display successfully.");
    TestUtils.isDisplayed(userGuide, "User Guide button display successfully.");
    TestUtils.isDisplayed(faqs, "FAQs button display successfully.");
  }

  public void clickOnBackButton() {
    WaitFor.time(1);
    WaitFor.elementToBeClickable(backButton);
    TestUtils.click(backButton, "Clicked on back button.");
    WaitFor.time(1);
    String currentUrl = TestBase.getDriver().getCurrentUrl();
    assert currentUrl != null;
    TestUtils.currentUrlAssertion(currentUrl, "chat");
  }

  public void clickOnUserGuideButton() {
    WaitFor.time(1);
    WaitFor.elementToBeClickable(userGuide);
    TestUtils.click(userGuide, "Clicked on User Guide button.");
    WaitFor.time(1);
    verifyUserGuidePopup();
  }

  public void verifyUserGuidePopup() {
    WaitFor.time(1);
    TestUtils.isDisplayed(
        closeButton, "Close button is displayed on the 'UPL Genie User Guide' popup.");
    String popupTitle = "UPL Genie User Guide";
    WebElement title = TestBase.getDriver().findElement(By.cssSelector("div.heading-title"));
    String actualPopupTitle = title.getText();
    assertEquals(actualPopupTitle, popupTitle);
    clickOnCloseButton();
  }

  public void clickOnCloseButton() {
    WaitFor.time(1);
    WaitFor.elementToBeClickable(closeButton);
    TestUtils.click(closeButton, "Clicked on the 'Close' Button.");
  }

  public void clickOnFaqsButton() {
    WaitFor.time(1);
    WaitFor.elementToBeClickable(faqs);
    TestUtils.click(faqs, "Clicked on FAQs button.");
    WaitFor.time(1);
    verifyFaqsPopup();
  }

  public void verifyFaqsPopup() {
    WaitFor.time(1);
    TestUtils.isDisplayed(closeButton, "Close button is displayed on the 'FAQs' popup.");
    String popupTitle = "FAQs";
    WebElement title = TestBase.getDriver().findElement(By.cssSelector("div.heading-title"));
    String actualPopupTitle = title.getText();
    assertEquals(actualPopupTitle, popupTitle);
    clickOnCloseButton();
  }
}
