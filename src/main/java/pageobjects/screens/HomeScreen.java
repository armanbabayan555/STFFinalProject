package pageobjects.screens;

import locators.HomeScreenConstants;
import org.openqa.selenium.By;
import pageobjects.base.BaseScreen;

public class HomeScreen extends BaseScreen {

    private By favoritesButton = By.className(HomeScreenConstants.FAVORITES_BUTTON);
    private By bagButton = By.className(HomeScreenConstants.BAG_BUTTON);
    private By brandsButton = By.xpath(HomeScreenConstants.BRANDS_BUTTON);
    private By watchesButton = By.xpath(HomeScreenConstants.WATCHES_BUTTON);

    public ProductTemplatesScreen clickBrandsButton() {
        click(brandsButton);
        return new ProductTemplatesScreen();
    }

    public CartAndWishlistScreen clickFavoritesButton() {
        click(favoritesButton);
        return new CartAndWishlistScreen();
    }


    public ProductTemplatesScreen clickWatchesButton() {
        click(watchesButton);
        return new ProductTemplatesScreen();
    }

    public CartAndWishlistScreen clickBagButton() {
        click(bagButton);
        return new CartAndWishlistScreen();
    }
}
