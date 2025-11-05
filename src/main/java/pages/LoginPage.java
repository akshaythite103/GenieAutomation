package pages;

import base.TestBase;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.Environment;
import utils.TestUtils;
import utils.WaitFor;

public class LoginPage extends TestBase {

  public LoginPage() {
    PageFactory.initElements(TestBase.getDriver(), this);
  }

  @FindBy(xpath = "//button[text()='Log In']")
  WebElement loginButton;

  @FindBy(xpath = "//input[@type='email']")
  WebElement emailField;

  @FindBy(xpath = "//input[@type='submit']")
  WebElement nextButton;

  @FindBy(xpath = "//input[@type='password']")
  WebElement passwordField;

  @FindBy(css = "img.logo-image")
  WebElement uplGenieLogo;

  public void clickOnLoginButton() {
    WaitFor.time(1);
    WaitFor.elementToBeClickable(loginButton);
    TestUtils.click(loginButton, "Clicked on 'Log In' button.");
  }

  public void enterUsername(String user) {
    WaitFor.time(1);
    WaitFor.elementToBeClickable(emailField);
    TestUtils.sendKeys(emailField, user, "Entered username successfully.");
  }

  public void clickOnNextButton() {
    WaitFor.time(1);
    WaitFor.elementToBeClickable(nextButton);
    TestUtils.click(nextButton, "Clicked on next button.");
  }

  public void enterPassword(String password) {
    WaitFor.time(1);
    WaitFor.elementToBeClickable(passwordField);
    TestUtils.sendKeys(passwordField, password, "Entered Password successfully.");
  }

  public boolean isLogInButtonPresent() {
    WaitFor.time(1);
    List<WebElement> loginButton =
        TestBase.getDriver().findElements(By.xpath("//button[text()='Log In']"));
    return !loginButton.isEmpty();
  }

  public void verifyLoginSuccessToaster() {
    WaitFor.time(1);
    String expected = "You are successfully logged in";

    //    WebElement toaster =
    //        TestBase.getDriver()
    //            .findElement(By.xpath("//div[text()='You are successfully logged in']"));
    //    String actual = toaster.getText();

    JavascriptExecutor js = (JavascriptExecutor) TestBase.getDriver();
    String actual =
        (String)
            js.executeScript(
                "return document.querySelector('div.Toastify__toast.Toastify__toast-theme--light.Toastify__toast--success').innerText;");

    Assert.assertEquals(actual, expected);
  }

  public boolean isLogoPresent() {
    WaitFor.time(1);
    List<WebElement> logo = TestBase.getDriver().findElements(By.cssSelector("img.logo-image"));
    return !logo.isEmpty();
  }

  public void login() {
    WaitFor.time(1);
    if (isLogInButtonPresent()) clickOnLoginButton();
    if (!isLogoPresent()) {
      enterUsername(Environment.username);
      clickOnNextButton();
      enterPassword(Environment.password);
      clickOnNextButton();
      WaitFor.time(2);
      verifyLoginSuccessToaster();
    }
    WaitFor.elementToBeClickable(uplGenieLogo);
  }
}
