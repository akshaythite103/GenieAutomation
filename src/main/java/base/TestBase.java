package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.Environment;
import utils.LogUtils;
import utils.WaitFor;

public class TestBase {

  private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
  public static Properties prop;

  public TestBase() {
    try {
      prop = new Properties();
      FileInputStream ip =
          new FileInputStream(
              System.getProperty("user.dir") + "/src/main/java/config/config.properties");
      prop.load(ip);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void initialization() {
    String browserName = Environment.browser;
    String osName = System.getProperty("os.name").toLowerCase();
    LogUtils.info("Browser name: " + browserName);

    if (browserName.equals("chrome")) {
      ChromeOptions options = new ChromeOptions();
      options.addArguments("start-maximized");
      options.addArguments("--disable-infobars");
      options.addArguments("--disable-extensions");
      options.addArguments("--disable-gpu");
      options.addArguments("--disable-dev-shm-usage");
      options.addArguments("--no-sandbox");
      options.addArguments("--remote-allow-origins=*");

      if (osName.contains("linux")) {
        options.addArguments("--headless");
        options.addArguments("user-agent=Mozilla/5.0 ... Chrome/103.0.0.0 Safari/537.36");
      }

      WebDriverManager.chromedriver().setup();
      WebDriver localDriver = new ChromeDriver(options);
      driver.set(localDriver);
      localDriver.manage().deleteAllCookies();
      localDriver.get(Environment.prodUrl);
      //      localDriver.get(System.getProperty("url"));
      // Only for Jenkins Uncomment the above line and add the respective script in the jenkins
      WaitFor.time(5);
    }
  }

  public static WebDriver getDriver() {
    return driver.get();
  }

  public static void quitDriver() {
    WebDriver localDriver = getDriver();
    if (localDriver != null) {
      localDriver.quit();
      driver.remove();
    }
  }
}
