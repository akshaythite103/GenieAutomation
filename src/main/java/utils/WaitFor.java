package utils;

import base.TestBase;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

/**
 * @author Akshay Thite
 */
public class WaitFor extends TestBase {

  public static FluentWait<WebDriver> wait = null;

  static {
    try {
      wait = new FluentWait<>(TestBase.getDriver());
      wait.withTimeout(Duration.ofSeconds(120));
      wait.pollingEvery(Duration.ofMillis(500));
      wait.withMessage("Element not loaded");
    } catch (Throwable t) {
      System.err.println("Failure during static initialization");
    }
  }

  public static void elementToBePresent(String locatorType, String locatorValue) {
    wait.ignoring(NoSuchElementException.class, ElementClickInterceptedException.class);
  }

  public static void elementToBePresent(WebElement element) {
    wait.ignoring(NoSuchElementException.class, ElementClickInterceptedException.class);
  }

  public static void time(int timeSec) {
    long startTime = System.currentTimeMillis();
    long endTime = startTime + (timeSec * 1000L);
    while (startTime <= endTime) {
      startTime = System.currentTimeMillis();
    }
  }

  public static void elementToBeClickable(WebElement element) {
    wait.until(ExpectedConditions.elementToBeClickable(element));
    wait.ignoring(NoSuchElementException.class, ElementClickInterceptedException.class);
  }

  public static void elementToBeDisable(WebElement element) {
    wait.until(ExpectedConditions.invisibilityOf(element));
  }

  public static void elementsToBeVisible(List<WebElement> element) {
    wait.until(ExpectedConditions.visibilityOfAllElements(element));
  }
}
