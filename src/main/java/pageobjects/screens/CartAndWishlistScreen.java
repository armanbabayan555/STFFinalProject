package pageobjects.screens;

import locators.CartAndWishlistScreenConstants;
import org.openqa.selenium.By;
import pageobjects.base.BaseScreen;

public class CartAndWishlistScreen extends BaseScreen {

    private By reference = By.className(CartAndWishlistScreenConstants.REFERENCE);
    private By removeButtons = By.className(CartAndWishlistScreenConstants.REMOVE_BUTTON);

    public String getReferenceNumberByIndex(int index) {
        return getTextByIndex(reference, index);
    }

    public void clickRemoveButton() {
        clickRemoveButtonByIndex(0);
    }

    public void clickRemoveButtonByIndex(int index) {
        click(removeButtons, index);
    }


    public boolean isProductReferencePresent() {
        return isElementPresent(reference);
    }
}
