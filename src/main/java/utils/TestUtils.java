package utils;

import base.TestBase;
import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

/**
 * @author Akshay Thite
 */
public class TestUtils {
  public static void click(WebElement element, String msg) {
    WaitFor.elementToBeClickable(element);
    element.click();
    LogUtils.info(msg);
  }

  public static void clickUsingJavaScriptExecutor(WebElement element, String msg) {
    WaitFor.elementToBeClickable(element);
    JavascriptExecutor js = (JavascriptExecutor) TestBase.getDriver();
    js.executeScript("arguments[0].click();", element);
    LogUtils.info(msg);
  }

  public static void mouseHoverUsingActionsClass(WebElement element, String msg) {
    WaitFor.elementToBeClickable(element);
    Actions action = new Actions(TestBase.getDriver());
    action.moveToElement(element).perform();
    LogUtils.info(msg);
  }

  public static void clickUsingActionsClass(WebElement element, String msg) {
    WaitFor.elementToBeClickable(element);
    Actions action = new Actions(TestBase.getDriver());
    action.click(element).perform();
    LogUtils.info(msg);
  }

  public static void sendKeys(WebElement element, String keys, String msg) {
    WaitFor.elementToBeClickable(element);
    element.sendKeys(keys);
    LogUtils.info(msg);
  }

  public static String getTimeStamp() {
    return new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")
        .format(new Timestamp(System.currentTimeMillis()));
  }

  public static String currentDate() {
    return new SimpleDateFormat("MM/dd/yyyy").format(new Timestamp(System.currentTimeMillis()));
  }

  public static void getScreenShot() {
    try {
      TakesScreenshot scrShot = ((TakesScreenshot) TestBase.getDriver());
      File f = scrShot.getScreenshotAs(OutputType.FILE);
      Allure.addAttachment("Screenshot " + getTimeStamp(), FileUtils.openInputStream(f));
    } catch (IOException e1) {
      e1.printStackTrace();
    }
  }

  @Attachment(value = "Page Screenshot", type = "image/png")
  public static void getFullPageScreenShot(String methodName) throws IOException {
    byte[] t = Shutterbug.shootPage(TestBase.getDriver(), Capture.FULL, true).getBytes();
    Allure.addAttachment(
        "FULL SCREENSHOT " + methodName + getTimeStamp(), new ByteArrayInputStream(t));
  }

  public static void getScreenshotUsingAshot(String methodName) {
    String baseDir = System.getProperty("user.dir");
    AShot ashot = new AShot();
    ashot.shootingStrategy(ShootingStrategies.viewportPasting(1000));
    BufferedImage image = ashot.takeScreenshot(TestBase.getDriver()).getImage();
    try {
      ImageIO.write(
          image,
          "PNG",
          new File(baseDir + "/screenshots/" + methodName + "_" + getTimeStamp() + ".png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void currentUrlAssertion(String actualUrl) {
    WaitFor.time(2);
    String currentUrl = TestBase.getDriver().getCurrentUrl();
    Assert.assertEquals(actualUrl, currentUrl);
  }

  public static void currentUrlAssertion(String localUrl, String endPoint) {
    WaitFor.time(2);
    if (localUrl.contains(Environment.devUrl))
      TestUtils.currentUrlAssertion(Environment.devUrl + endPoint);
    else if (localUrl.contains(Environment.prodUrl))
      TestUtils.currentUrlAssertion(Environment.prodUrl + endPoint);
  }

  public static void scroll(WebElement element) {
    JavascriptExecutor js = (JavascriptExecutor) TestBase.getDriver();
    //        js.executeScript("javascript:window.scrollBy(0,200)");
    js.executeScript("arguments[0].scrollIntoView(true);", element);
    //        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
  }

  public static void isEnabled(WebElement element, String msg) {
    WaitFor.elementToBePresent(element);
    boolean isPresent = element.isDisplayed();
    if (!isPresent) {
      LogUtils.info("Element is not enabled in given time.");
    } else {
      LogUtils.info(msg);
    }
  }

  public static void isDisplayed(WebElement element, String msg) {
    WaitFor.elementToBeClickable(element);
    element.isDisplayed();
    LogUtils.info(msg);
  }

  public static void hitButton(int keycode) {
    Robot robo = null;
    try {
      robo = new Robot();
    } catch (AWTException e) {
      e.printStackTrace();
    }
    assert robo != null;
    robo.keyPress(keycode);
    robo.keyRelease(keycode);
  }

  public static void hitButtonUsingActionClass(Keys key) {
    Actions action = new Actions(TestBase.getDriver());
    action.keyDown(key).keyUp(key).perform();
  }

  public static void handleAlertAccept() {
    try {
      Alert alert = TestBase.getDriver().switchTo().alert();
      alert.accept();
    } catch (NoAlertPresentException ex) {
      ex.printStackTrace();
    }
  }

  public static String futureDate(int days) {
    LocalDateTime currentDateTime = LocalDateTime.now().plusDays(days);
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d");
    return dateTimeFormatter.format(currentDateTime);
  }

  public static String getCurrentYear() {
    LocalDateTime currentDateTime = LocalDateTime.now();
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy");
    return dateTimeFormatter.format(currentDateTime);
  }

  public static boolean isDisabled(WebElement element) {
    WaitFor.time(2);
    return !element.isDisplayed();
  }

  public static String getCurrentDate() {
    LocalDateTime currentDate = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM, yyyy");
    return formatter.format(currentDate);
  }

  public static String getFutureDate(int days) {
    LocalDateTime currentDateTime = LocalDateTime.now().plusDays(days);
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");
    return dateTimeFormatter.format(currentDateTime);
  }

  @Attachment(value = "Screenshot on Failure", type = "image/png")
  public byte[] saveScreenshot() {
    if (TestBase.getDriver() != null) {
      return ((TakesScreenshot) TestBase.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
    return new byte[0];
  }

  @Attachment(value = "screenshot", type = "image/png", fileExtension = ".png")
  public static byte[] attachScreenshot(String methodName) throws IOException {
    String baseDir = System.getProperty("user.dir");
    //    LogUtils.info("Base directory of Project: " + baseDir);
    return Files.readAllBytes(Paths.get(baseDir + "/screenshots/" + methodName + ".png"));
  }

  public void captureScreenshot(String methodName) {
    String baseDir = System.getProperty("user.dir");
    //    LogUtils.info("Base directory of Project: " + baseDir);
    try (InputStream is =
        Files.newInputStream(Paths.get(baseDir + "/screenshots/" + methodName + ".png"))) {
      Allure.attachment("image.png", is);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static void switchToNewTab(String originalWindow) {
    WebDriverWait wait = new WebDriverWait(TestBase.getDriver(), Duration.ofSeconds(90));
    wait.until(ExpectedConditions.numberOfWindowsToBe(2));
    Set<String> windowHandles = TestBase.getDriver().getWindowHandles();
    for (String handle : windowHandles) {
      if (!handle.equals(originalWindow)) {
        TestBase.getDriver().switchTo().window(handle);
        break;
      }
    }
  }

  public static void uploadFile(WebElement element, String filePath) {
    element.sendKeys(filePath);
    LogUtils.info("File uploaded...");
  }

  public static String getFileName(String filePath) {
    if (filePath == null || filePath.isEmpty()) {
      throw new IllegalArgumentException("File path cannot be null or empty");
    }
    int lastIndex = filePath.lastIndexOf('/');
    if (lastIndex == -1) {
      return filePath;
    }
    return filePath.substring(lastIndex + 1);
  }
}
