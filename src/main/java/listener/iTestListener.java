package listener;

import base.TestBase;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;
import utils.LogUtils;
import utils.TestUtils;

public class iTestListener implements ITestListener, IConfigurationListener {

  private int totalTests = 0;
  private int passedTests = 0;
  private int failedTests = 0;
  private int skippedTests = 0;

  @Override
  public void onStart(ITestContext context) {
    totalTests = context.getAllTestMethods().length;
    System.out.println("Testing Started... Total Test Cases: " + totalTests);
  }

  @Override
  public void onFinish(ITestContext context) {
    System.out.println("Testing Completed.");

    double passPercentage = (passedTests * 100.0) / totalTests;
    double failPercentage = (failedTests * 100.0) / totalTests;
    double skipPercentage = (skippedTests * 100.0) / totalTests;

    System.out.println("Pass Percentage: " + passPercentage + "%");
    System.out.println("Fail Percentage: " + failPercentage + "%");
    System.out.println("Skip Percentage: " + skipPercentage + "%");
  }

  @Override
  public void onTestSuccess(ITestResult result) {
    System.out.println("✅ The name of PASSED testcase is: " + result.getName());
    passedTests++;
  }

  @Override
  public void onTestFailure(ITestResult result) {
    System.out.println("❌ The name of FAILED testcase is: " + result.getName());
    TestUtils.getScreenshotUsingAshot(result.getMethod().getMethodName());

    WebDriver driver = TestBase.getDriver();
    attachScreenshot(driver);

    failedTests++;
  }

  @Attachment(value = "Failure Screenshot", type = "image/png")
  private byte[] attachScreenshot(WebDriver driver) {
    LogUtils.info("Failure Timestamp: " + TestUtils.getTimeStamp());
    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
  }

  @Override
  public void onTestSkipped(ITestResult result) {
    System.out.println("⚠️ The name of SKIPPED testcase is: " + result.getName());
    //    TestUtils.getScreenshotUsingAshot(result.getMethod().getMethodName());

    WebDriver driver = TestBase.getDriver();
    attachScreenshot(driver);

    skippedTests++;
  }

  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    System.out.println("Partially succeeded: " + result.getName());
  }

  @Override
  public void onTestStart(ITestResult result) {
    System.out.println("➡️ STARTED: " + result.getName());
  }

  @Override
  public void onConfigurationFailure(ITestResult result) {
    try {
      WebDriver driver = TestBase.getDriver();
      TestUtils.getScreenshotUsingAshot(result.getMethod().getMethodName() + "_BeforeMethodFailed");
      attachScreenshot(driver);
      System.out.println(
          "📸 Screenshot captured for @BeforeMethod failure: "
              + result.getMethod().getMethodName());
    } catch (Exception e) {
      System.out.println(
          "⚠️ Failed to capture screenshot for @BeforeMethod failure: " + e.getMessage());
    }
  }
}
