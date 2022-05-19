package pageobjects.screens;

import locators.ProductTemplatesScreenConstants;
import org.openqa.selenium.By;
import pageobjects.base.BaseScreen;

public class ProductTemplatesScreen extends BaseScreen {

    private By brands = By.className(ProductTemplatesScreenConstants.BRAND_ITEMS);
    private By watchTypes = By.className(ProductTemplatesScreenConstants.WATCH_TYPES);

    public BrandTypeScreen clickBrandByIndex(int index) {
        click(brands, index);
        return new BrandTypeScreen();
    }

    public BrandTypeScreen clickWatchByIndex(int index) {
        click(watchTypes, index);
        return new BrandTypeScreen();
    }
}
