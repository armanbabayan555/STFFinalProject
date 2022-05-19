package pageobjects.screens;

import locators.BrandTypeScreenConstants;
import org.openqa.selenium.By;
import pageobjects.base.BaseScreen;


public class BrandTypeScreen extends BaseScreen {

    private By priceFilterTypes = By.xpath(BrandTypeScreenConstants.PRICE_FILTER_TYPES);
    private By productItems = By.cssSelector(BrandTypeScreenConstants.PRODUCT_ITEMS);
    private By filterTypes = By.className(BrandTypeScreenConstants.FILTER_TYPES);
    private By firstItemPrice = By.xpath(BrandTypeScreenConstants.FIRST_ITEM_PRICE);


    public void clickOnFilterTypeByIndex(int index) {
        click(filterTypes, index);
    }

    public void clickOnPriceFilterButtonsByIndex(int index) {
        click(priceFilterTypes, index);
    }

    public ProductPreviewScreen clickOnProductByIndex(int index) {
        click(productItems, index);
        return new ProductPreviewScreen();
    }

    public boolean isPriceOfFirstItemWithinTheFilteredRange(int start, int end) {
        String price = getText(firstItemPrice).replace(",", "");
        int parsed = Integer.parseInt(price);
        return (parsed >= start && parsed <= end);
    }
}
