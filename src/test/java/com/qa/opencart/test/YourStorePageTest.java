package com.qa.opencart.test;

import com.qa.opencart.basetest.BaseTest;
import com.qa.opencart.pages.*;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

public class YourStorePageTest extends BaseTest {

    private YourStorePage yourStorePage;

    @Test(priority = 1)
    @Severity(SeverityLevel.TRIVIAL)
    @Description("Test Case Description: Validate YourPage Logo Test")
    @Story("Story Name: To YourPage Logo Test")
    public void validateYourPageLogoTest() {
        yourStorePage = new YourStorePage(driver);
        Assert.assertTrue(yourStorePage.getLogoValidate());
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Validate YourPage Page Title Test")
    @Story("Story Name: YourPage Page Title Test")
    public void validateYourPageTitleTest() {
        yourStorePage = new YourStorePage(driver);
        String expectedYourStoreTitlePage = prop.getProperty("yourStoreTitlePage");
        String actualYourStoreTitlePage = yourStorePage.getYourStorePageTitle();
        Assert.assertEquals(expectedYourStoreTitlePage, actualYourStoreTitlePage);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Currency Test")
    @Story("Story Name: To Check Currency Feature")
    public void getCurrencyTest() {
        yourStorePage = new YourStorePage(driver);
        yourStorePage.getCurrencyList(prop.getProperty("currencySignText"));
        String actualCurrencySign = yourStorePage.getCurrencySign();
        String expectedCurrencySign = prop.getProperty("currencySign");
        Assert.assertEquals(actualCurrencySign, expectedCurrencySign);
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.TRIVIAL)
    @Description("Test Case Description: Click On The ContactUs Icon Test")
    @Story("Story Name: To Check ContactUs Feature")
    public void doClickOnTheContactUsIconTest() {
        yourStorePage = new YourStorePage(driver);
        ContactUsPage contactUsPage = yourStorePage.clickContactUsBtn();
        Assert.assertTrue(contactUsPage.getContactUsLinkValidate());
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.TRIVIAL)
    @Description("Test Case Description: Click On The Register Page Test")
    @Story("Story Name: To Check Register Page Feature")
    public void doClickOnTheRegisterPage() {
        yourStorePage = new YourStorePage(driver);
        RegisterPage registerPage = yourStorePage.doNavigateRegisterPage();
        Assert.assertTrue(registerPage.getRegisterAccountLinkValidate());
    }

    @Test(priority = 6)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Click On The Login Page Test")
    @Story("Story Name: To Check Login Page Feature")
    public void doClickOnTheLoginPage() {
        yourStorePage = new YourStorePage(driver);
        LoginPage loginPage = yourStorePage.doNavigateLoginPage();
        Assert.assertTrue(loginPage.getLoginLinkValidate());
    }

    @Test(priority = 7)
    @Severity(SeverityLevel.TRIVIAL)
    @Description("Test Case Description: Click On The ShoppingCart Page Test")
    @Story("Story Name: To Check ShoppingCart Page Feature")
    public void doClickOnTheShoppingCartPage() {
        yourStorePage = new YourStorePage(driver);
        ShoppingCartPage shoppingCartPage = yourStorePage.doNavigateShoppingCartPage();
        Assert.assertTrue(shoppingCartPage.getShoppingCartLinkValidate());
    }

    @Test(priority = 8)
    @Severity(SeverityLevel.TRIVIAL)
    @Description("Test Case Description: Click On The CheckOut Page Test")
    @Story("Story Name: To Check CheckOut Page Feature")
    public void doClickOnTheCheckOutPage() {
        yourStorePage = new YourStorePage(driver);
        CheckOutPage checkOutPage = yourStorePage.doNavigateCheckoutPage();
        Assert.assertTrue(checkOutPage.getCheckOutLinkValidate());
    }

    @Test(priority = 9)
    @Severity(SeverityLevel.TRIVIAL)
    @Description("Test Case Description: Validate Navigation Bars Test")
    @Story("Story Name: To Check Navigation Bars Feature")
    public void validateNavigationBarsTest() {
        String typeOfProduct = prop.getProperty("navigationBars");
        yourStorePage = new YourStorePage(driver);
        Assert.assertTrue(yourStorePage.validateNavigationBars(typeOfProduct));
    }

    @Test(priority = 10)
    @Severity(SeverityLevel.TRIVIAL)
    @Description("Test Case Description: Validate Feature Test")
    @Story("Story Name: To Check Feature Test")
    public void featuredTest() {
        String productName = prop.getProperty("productName");
        yourStorePage = new YourStorePage(driver);
        Assert.assertTrue(yourStorePage.featured(productName));
    }

    @Test(priority = 11)
    @Severity(SeverityLevel.MINOR)
    @Description("Test Case Description: Ads Quantity Test")
    @Story("Story Name: To Check Ads Quantity Feature Test")
    public void adsQuantityTest() {
        yourStorePage = new YourStorePage(driver);
        int actualAdsQuantity = yourStorePage.adsQuantity();
        int expectedAdsQuantity = Integer.parseInt(prop.getProperty("adsQuantity"));
        Assert.assertEquals(expectedAdsQuantity, actualAdsQuantity);
    }

    @Test(priority = 12)
    @Severity(SeverityLevel.MINOR)
    @Description("Test Case Description: Ads Test")
    @Story("Story Name: To Check Ads Feature Test")
    public void adsTest() {
        String brand = prop.getProperty("brand");
        yourStorePage = new YourStorePage(driver);
        Assert.assertTrue(yourStorePage.ads(brand));

    }

}
