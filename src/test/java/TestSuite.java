import base.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageobjects.screens.*;

import static Messages.AssertionMessages.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestSuite extends BaseTest {

    @Test
    public void addToFavoritesFunctionality() {
        HomeScreen homeScreen = new HomeScreen();
        ProductTemplatesScreen productTemplatesScreen;
        BrandTypeScreen brandTypeScreen;
        CartAndWishlistScreen cartAndWishlistScreen;
        ProductPreviewScreen productPreviewScreen;

        productTemplatesScreen = homeScreen.clickBrandsButton();
        brandTypeScreen = productTemplatesScreen.clickBrandByIndex(2);
        productPreviewScreen = brandTypeScreen.clickOnProductByIndex(0);
        String previewReference = productPreviewScreen.getReferenceNumberByIndex(0);
        productPreviewScreen.clickAddToFavoritesButton();
        cartAndWishlistScreen = homeScreen.clickFavoritesButton();
        String wishlistReference = cartAndWishlistScreen.getReferenceNumberByIndex(0);
        assertEquals(previewReference, wishlistReference, PRODUCT_WAS_NOT_ADDED_TO_FAVORITES);
    }

    @Test
    public void removeFromFavoritesFunctionality() {
        SoftAssert softAssert = new SoftAssert();
        HomeScreen homeScreen = new HomeScreen();
        ProductTemplatesScreen productTemplatesScreen;
        BrandTypeScreen brandTypeScreen;
        CartAndWishlistScreen cartAndWishlistScreen;
        ProductPreviewScreen productPreviewScreen;

        productTemplatesScreen = homeScreen.clickBrandsButton();
        brandTypeScreen = productTemplatesScreen.clickBrandByIndex(2);
        productPreviewScreen = brandTypeScreen.clickOnProductByIndex(0);
        String previewReference = productPreviewScreen.getReferenceNumberByIndex(0);
        productPreviewScreen.clickAddToFavoritesButton();
        cartAndWishlistScreen = homeScreen.clickFavoritesButton();
        String wishlistReference = cartAndWishlistScreen.getReferenceNumberByIndex(0);
        softAssert.assertEquals(previewReference, wishlistReference, PRODUCT_WAS_NOT_ADDED_TO_FAVORITES);
        cartAndWishlistScreen.clickRemoveButton();
        softAssert.assertTrue(cartAndWishlistScreen.isTextPresent("Your Wish List is empty!"), YOUR_WISH_LIST_IS_EMPTY_TEXT_WAS_NOT_PRESENT);
        softAssert.assertFalse(cartAndWishlistScreen.isProductReferencePresent(), PRODUCT_WAS_NOT_REMOVED);
        softAssert.assertAll();
    }

    @Test
    public void watchesPriceFilterFunctionality() {
        HomeScreen homeScreen = new HomeScreen();
        ProductTemplatesScreen productTemplatesScreen;
        BrandTypeScreen brandTypeScreen;

        productTemplatesScreen = homeScreen.clickWatchesButton();
        brandTypeScreen = productTemplatesScreen.clickWatchByIndex(1);
        brandTypeScreen.clickOnFilterTypeByIndex(5);
        brandTypeScreen.clickOnPriceFilterButtonsByIndex(1);
        assertTrue(brandTypeScreen.isPriceOfFirstItemWithinTheFilteredRange(200000, 500000), WATCH_PRICE_NOT_IN_THE_GIVEN_RANGE);
    }

    @Test
    public void addToBagFunctionality() {
        HomeScreen homeScreen = new HomeScreen();
        SoftAssert softAssert = new SoftAssert();
        ProductTemplatesScreen productTemplatesScreen;
        BrandTypeScreen brandTypeScreen;
        ProductPreviewScreen productPreviewScreen;
        CartAndWishlistScreen cartAndWishlistScreen;

        productTemplatesScreen = homeScreen.clickBrandsButton();
        brandTypeScreen = productTemplatesScreen.clickBrandByIndex(0);
        productPreviewScreen = brandTypeScreen.clickOnProductByIndex(0);
        productPreviewScreen.clickAddToBagButton();
        String previewReferenceOne = productPreviewScreen.getReferenceNumberByIndex(0);
        cartAndWishlistScreen = homeScreen.clickBagButton();
        String cartReferenceOne = cartAndWishlistScreen.getReferenceNumberByIndex(0);
        softAssert.assertEquals(previewReferenceOne, cartReferenceOne, ITEM_WAS_NOT_ADDED_TO_CART);
        cartAndWishlistScreen.clickBackButton();
        cartAndWishlistScreen.clickBackButton();
        brandTypeScreen.clickOnProductByIndex(1);
        productPreviewScreen.clickAddToBagButton();
        String previewReferenceTwo = productPreviewScreen.getReferenceNumberByIndex(0);
        homeScreen.clickBagButton();
        String cartReferenceTwo = cartAndWishlistScreen.getReferenceNumberByIndex(1);
        softAssert.assertEquals(previewReferenceTwo, cartReferenceTwo, ITEM_WAS_NOT_ADDED_TO_CART);
        softAssert.assertAll();
    }

    @Test
    public void removeFromCartFunctionality() {
        HomeScreen homeScreen = new HomeScreen();
        SoftAssert softAssert = new SoftAssert();
        ProductTemplatesScreen productTemplatesScreen;
        BrandTypeScreen brandTypeScreen;
        ProductPreviewScreen productPreviewScreen;
        CartAndWishlistScreen cartAndWishlistScreen;

        productTemplatesScreen = homeScreen.clickBrandsButton();
        brandTypeScreen = productTemplatesScreen.clickBrandByIndex(0);
        productPreviewScreen = brandTypeScreen.clickOnProductByIndex(0);
        productPreviewScreen.clickAddToBagButton();
        String previewReferenceOne = productPreviewScreen.getReferenceNumberByIndex(0);
        cartAndWishlistScreen = homeScreen.clickBagButton();
        String cartReferenceOne = cartAndWishlistScreen.getReferenceNumberByIndex(0);
        softAssert.assertEquals(previewReferenceOne, cartReferenceOne, ITEM_WAS_NOT_ADDED_TO_CART);
        cartAndWishlistScreen.clickRemoveButtonByIndex(0);
        softAssert.assertTrue(cartAndWishlistScreen.isTextPresent("Your Bag is Empty"), YOUR_BAG_IS_EMPTY_TITLE_WAS_NOT_PRESENT);
        softAssert.assertAll();
    }
}
