package pageobjects.screens;

import locators.ProductPreviewScreenConstants;
import org.openqa.selenium.By;
import pageobjects.base.BaseScreen;

public class ProductPreviewScreen extends BaseScreen {

    private By reference = By.className(ProductPreviewScreenConstants.REFERENCE);
    private By addToBagButton = By.className(ProductPreviewScreenConstants.ADD_TO_BAG_BUTTON);
    private By addToFavoritesButton = By.xpath(ProductPreviewScreenConstants.ADD_TO_FAVORITES_BUTTON);

    public void clickAddToBagButton() {
        click(addToBagButton);
    }

    public void clickAddToFavoritesButton() {
        click(addToFavoritesButton);
    }

    public String getReferenceNumberByIndex(int index) {
        return getTextByIndex(reference, index);
    }
}
