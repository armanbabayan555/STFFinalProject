package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public abstract class DriverUtils {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(String browserName) {
        try {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setBrowserName(browserName);
            driver = new RemoteWebDriver(new URL("http://localhost:4444/"), desiredCapabilities);
            driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void quitDriver() {
        getDriver().quit();
    }
}
