package utils;

import base.TestBase;
import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * @author Akshay Thite
 */
public class iTestListener extends TestBase implements ITestListener {

  @Override
  public void onStart(ITestContext Results) {
    System.out.println("Test Started");
  }

  @Override
  public void onFinish(ITestContext Results) {
    System.out.println("Test Started");
  }

  public void onTestFailure(ITestResult Result) {
    System.out.println("The name of the testcase failed is :" + Result.getName());
    try {
      TestUtils.getFullPageScreenShot(Result.getMethod().getMethodName());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void onTestSkipped(ITestResult Result) {
    System.out.println("The name of the testcase Skipped is :" + Result.getName());
  }

  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    System.out.println("Success PErceNTage");
  }

  // When Test case get Started, this method is called.
  @Override
  public void onTestStart(ITestResult Result) {
    System.out.println(Result.getName() + " test case started");
  }

  // When Test case get passed, this method is called.
  @Override
  public void onTestSuccess(ITestResult Result) {
    System.out.println("The name of the testcase passed is :" + Result.getName());
  }
}
