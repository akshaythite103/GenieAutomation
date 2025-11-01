package utils;

/**
 * @author Akshay Thite
 */
public class Environment {
  private static final String filePath = "/src/main/java/config/config.properties";
  public static String browser;
  public static String localUrl;
  public static String devUrl;
  public static String prodUrl;
  public static String username;
  public static String password;

  static {
    PropertiesUtil prop = new PropertiesUtil();
    String baseDir = System.getProperty("user.dir");
    browser = prop.getValue(baseDir + filePath, "browser");
    localUrl = prop.getValue(baseDir + filePath, "localUrl");
    devUrl = prop.getValue(baseDir + filePath, "devUrl");
    prodUrl = prop.getValue(baseDir + filePath, "prodUrl");
    username = prop.getValue(baseDir + filePath, "username");
    password = prop.getValue(baseDir + filePath, "password");
  }
}
