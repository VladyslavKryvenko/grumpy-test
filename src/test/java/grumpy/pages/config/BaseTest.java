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

  @Parameters({"browserName", "browserVersion"})
  @BeforeMethod
  public void setup(String browserName, String browserVersion) {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setBrowserName(browserName);
    capabilities.setVersion(browserVersion);
    capabilities.setCapability("enableVNC", true);

    RemoteWebDriver driver = null;
    try {
      driver = new RemoteWebDriver(URI.create("http://localhost:4444/wd/hub").toURL(), capabilities);
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
    WebDriverRunner.setWebDriver(driver);

    Configuration.baseUrl = " http://172.17.0.2:8080";
  }
}

