package setup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitUtils {

    //todo
    public static final Duration MAX_DURATION = Duration.ofSeconds(20);
    public static final Duration LONG_DURATION = Duration.ofSeconds(10);
    public static final Duration AVERAGE_DURATION = Duration.ofSeconds(10);
    public static final Duration SHORT_DURATION = Duration.ofSeconds(5);

    public static WaitUtils getInstance() {
        return new WaitUtils();
    }

    public WebElement waitForElementToBeClickable(By by) {
        try {
            return new WebDriverWait(DriverUtils.getDriver(), AVERAGE_DURATION).until(ExpectedConditions.elementToBeClickable(by));
        } catch (WebDriverException ignored) {
            throw new Error("The Element with the name '" + by + "' could not be found");
        }
    }

    public List<WebElement> waitForElementsToBeVisible(By by) {
        try {
            return new WebDriverWait(DriverUtils.getDriver(), AVERAGE_DURATION).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
        } catch (WebDriverException ignored) {
            throw new Error("The Elements with the name '" + by + "' could not be found");
        }
    }

    public WebElement waitForElementToBeVisible(By by) {
        try {
            return new WebDriverWait(DriverUtils.getDriver(), SHORT_DURATION).until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (WebDriverException ignored) {
            throw new Error("The Elements with the name '" + by + "' could not be found");
        }
    }


}
