package pageobjects.base;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import setup.WaitUtils;

import java.util.List;

import static setup.DriverUtils.getDriver;

public abstract class BaseScreen {

    protected static WebDriver driver;
    protected Actions actions;

    public BaseScreen() {
        driver = getDriver();
        actions = new Actions(driver);
    }

    public void click(By locator) {
        WebElement element = WaitUtils.getInstance().waitForElementToBeClickable(locator);
        element.click();
    }

    public void click(By locator, int index) {
        List<WebElement> elements = WaitUtils.getInstance().waitForElementsToBeVisible(locator);
        elements.get(index).click();
    }

    public void clickBackButton() {
        driver.navigate().back();
    }

    // I know that this also needs to be implemented with an explicit wait, which driver.findElement does not handle.
    // However, running this with the visibilityOfElementLocated method from ExpectedConditions doesn't work, and nothing seems to fix it.

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator).isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isTextPresent(String text) {
        return driver.getPageSource().contains(text);
    }

    public String getText(By locator) {
        try {
            return WaitUtils.getInstance().waitForElementToBeVisible(locator).getText();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    // I know that this also needs to be implemented with an explicit wait, which driver.findElements does not handle.
    // However, running this with the visibilityOfAllElementsLocatedBy method from ExpectedConditions doesn't work, and nothing seems to fix it.
    public String getTextByIndex(By locator, int index) {
        return driver.findElements(locator).get(index).getText();
    }
}
