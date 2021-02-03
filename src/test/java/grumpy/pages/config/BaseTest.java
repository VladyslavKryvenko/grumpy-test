package grumpy.pages.config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.LinkedList;
import java.util.Properties;

public class BaseTest {
  //  private final String browserName;
//  private final String browserVersion;
//  private final String gridUrl;
//  private final String platform;
//
//
//  public BaseTest(String browserName, String browserVersion, String gridUrl, String platform) {
//    this.browserName = browserName;
//    this.browserVersion = browserVersion;
//    this.gridUrl = gridUrl;
//    this.platform = platform;
//  }
  @Parameters({"browserName","browserVersion"})
  @BeforeMethod
  public void setup(String browserName,String browserVersion) {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setBrowserName(browserName);
    capabilities.setVersion(browserVersion);
//    capabilities.setCapability("platform", platform);

    capabilities.setCapability("enableVNC", true);


    RemoteWebDriver driver = null;
    try {
      driver = new RemoteWebDriver(URI.create("http://localhost:4444/wd/hub").toURL(), capabilities);
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
    WebDriverRunner.setWebDriver(driver);
    Configuration.holdBrowserOpen = true;
    Configuration.baseUrl = " http://172.17.0.2:8080";
  }
}

//  public static LinkedList<String[]> getEnvironments() {
//    LinkedList<String[]> env = new LinkedList<String[]>();
//    env.add(new String[]{"chrome", "65.0"});
//    env.add(new String[]{"firefox", "58.0"});
//    env.add(new String[]{"opera", "51.0"});
//return env;
//  }