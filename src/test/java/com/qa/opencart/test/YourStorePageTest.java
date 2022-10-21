package com.qa.opencart.test;

import com.qa.opencart.basetest.BaseTest;
import com.qa.opencart.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class YourStorePageTest extends BaseTest {

    private YourStorePage yourStorePage;

    @Test(priority = 1)
    public void validateYourPageLogoTest() {
        yourStorePage = new YourStorePage(driver);
        Assert.assertTrue(yourStorePage.getLogoValidate());
    }

    @Test(priority = 2)
    public void validateYourPageTitleTest() {
        yourStorePage = new YourStorePage(driver);
        String expectedYourStoreTitlePage = "Your Store";
        String actualYourStoreTitlePage = yourStorePage.getYourStorePageTitle();
        Assert.assertEquals(expectedYourStoreTitlePage, actualYourStoreTitlePage);
    }

    @Test(priority = 3)
    public void getCurrencyTest() {
        yourStorePage = new YourStorePage(driver);
        yourStorePage.getCurrencyList("$ US Dollar");
        String actualCurrencySign = yourStorePage.getCurrencySign();
        String expectedCurrencySign = "$";
        Assert.assertEquals(actualCurrencySign, expectedCurrencySign);
    }

    @Test(priority = 4)
    public void doClickOnTheContactUsIconTest() {
        yourStorePage = new YourStorePage(driver);
        ContactUsPage contactUsPage = yourStorePage.clickContactUsBtn();
        Assert.assertTrue(contactUsPage.getContactUsLinkValidate());
    }

    @Test(priority = 5)
    public void doClickOnTheRegisterPage() {
        yourStorePage = new YourStorePage(driver);
        RegisterPage registerPage = yourStorePage.doNavigateRegisterPage();
        Assert.assertTrue(registerPage.getRegisterAccountLinkValidate());
    }

    @Test(priority = 6)
    public void doClickOnTheLoginPage() {
        yourStorePage = new YourStorePage(driver);
        LoginPage loginPage = yourStorePage.doNavigateLoginPage();
        Assert.assertTrue(loginPage.getLoginLinkValidate());
    }

    @Test(priority = 7)
    public void doClickOnTheShoppingCartPage() {
        yourStorePage = new YourStorePage(driver);
        ShoppingCartPage shoppingCartPage = yourStorePage.doNavigateShoppingCartPage();
        Assert.assertTrue(shoppingCartPage.getShoppingCartLinkValidate());
    }

    @Test(priority = 8)
    public void doClickOnTheCheckOutPage() {
        yourStorePage = new YourStorePage(driver);
        CheckOutPage checkOutPage = yourStorePage.doNavigateCheckoutPage();
        Assert.assertTrue(checkOutPage.getCheckOutLinkValidate());
    }

    @Test(priority = 9)
    public void validateNavigationBarsTest() {
        String typeOfProduct = "Software";
        yourStorePage = new YourStorePage(driver);
        Assert.assertTrue(yourStorePage.validateNavigationBars(typeOfProduct));
    }

    @Test(priority = 10)
    public void featuredTest() {
        String productName = "iPhone";
        yourStorePage = new YourStorePage(driver);
        Assert.assertTrue(yourStorePage.featured(productName));
    }

    @Test(priority = 11)
    public void adsQuantityTest() {
        yourStorePage = new YourStorePage(driver);
        int actualAdsQuantity = yourStorePage.adsQuantity();
        int expectedAdsQuantity = 21;
        Assert.assertEquals(expectedAdsQuantity, actualAdsQuantity);
    }

    @Test(priority = 12)
    public void adsTest() {
        String brand = "Burger King";
        yourStorePage = new YourStorePage(driver);
        Assert.assertTrue(yourStorePage.ads(brand));

    }

}
