package com.qa.opencart.test;

import com.qa.opencart.basetest.BaseTest;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.MyWishListPage;
import com.qa.opencart.pages.SearchPage;
import com.qa.opencart.pages.YourStorePage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchPageTest extends BaseTest {
    private SearchPage searchPage;
    private MyWishListPage myWishListPage;

    @Test(priority = 1)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Validate Search Page Title Test")
    @Story("Story Name: To Check Search Page Title Feature")
    public void validateSearchPageTitleTest() {
        YourStorePage yourStorePage = new YourStorePage(driver);
        String productName = prop.getProperty("productNameSearch");
        searchPage = yourStorePage.doSearch(productName);
        String expectedSearchPageTitlePage = prop.getProperty("searchPageTitlePage");
        String actualSearchPageTitlePage = searchPage.getSearchPageTitle();
        Assert.assertEquals(expectedSearchPageTitlePage, actualSearchPageTitlePage);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Case Description: Validate Add To Cart Product Test")
    @Story("Story Name: To Check Add To Cart Product")
    public void doAddToCartProductTest() {
        String productName = prop.getProperty("productNameSearch");
        String currency = prop.getProperty("currencySignText");

        YourStorePage yourStorePage = new YourStorePage(driver);
        yourStorePage.getCurrencyList(currency);
        searchPage = yourStorePage.doSearch(productName);
        searchPage.addToCartProduct(productName);
        Assert.assertTrue(searchPage.getSuccessMessageValidate());
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Validate Add To Wish List Product Test")
    @Story("Story Name: To Check Add To Wish List Product")
    public void doAddToWishListProductTest() {
        String productName = prop.getProperty("productNameSearch");
        String currency = prop.getProperty("currencySignText");
        String email = prop.getProperty("email");
        String password = prop.getProperty("password");

        YourStorePage yourStorePage = new YourStorePage(driver);
        LoginPage loginPage = yourStorePage.doNavigateLoginPage();
        loginPage.loginCorrectCredentials(email, password);
        yourStorePage = loginPage.returnToYourStorePage();
        yourStorePage.getCurrencyList(currency);
        searchPage = yourStorePage.doSearch(productName);
        searchPage.addToWishList(productName);
        Assert.assertTrue(searchPage.getSuccessMessageValidate());
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Validate Wish List Product Test")
    @Story("Story Name: To Check Wish List Product")
    public void validateWishListProductTest() {
        String productName = prop.getProperty("productNameSearch");
        String currency = prop.getProperty("currencySignText");
        String email = prop.getProperty("email");
        String password = prop.getProperty("password");

        YourStorePage yourStorePage = new YourStorePage(driver);
        LoginPage loginPage = yourStorePage.doNavigateLoginPage();
        loginPage.loginCorrectCredentials(email, password);
        yourStorePage = loginPage.returnToYourStorePage();
        yourStorePage.getCurrencyList(currency);
        searchPage = yourStorePage.doSearch(productName);
        searchPage.addToWishList(productName);
        myWishListPage = searchPage.doClickWishList();
        Assert.assertTrue(myWishListPage.validateWishList(productName));
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.MINOR)
    @Description("Test Case Description: Validate Add To Cart Thru Wish List Product Test")
    @Story("Story Name: To Check Add To Cart Thru Wish List Product")
    public void addToCartThruWishListProductTest() {
        String productName = prop.getProperty("productNameSearch");
        String currency = prop.getProperty("currencySignText");
        String email = prop.getProperty("email");
        String password = prop.getProperty("password");

        YourStorePage yourStorePage = new YourStorePage(driver);
        LoginPage loginPage = yourStorePage.doNavigateLoginPage();
        loginPage.loginCorrectCredentials(email, password);
        yourStorePage = loginPage.returnToYourStorePage();
        yourStorePage.getCurrencyList(currency);
        searchPage = yourStorePage.doSearch(productName);
        searchPage.addToWishList(productName);
        myWishListPage = searchPage.doClickWishList();
        myWishListPage.doAddToCartWishList(productName);
        Assert.assertTrue(myWishListPage.getSuccessMessageValidate());
    }

    @Test(priority = 6)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Validate Remove From Cart Thru Wish List Product Test")
    @Story("Story Name: To Check Remove From Cart Thru Wish List Product")
    public void removeFromCartThruWishListProductTest() {
        String productName = prop.getProperty("productNameSearch");
        String currency = prop.getProperty("currencySignText");
        String email = prop.getProperty("email");
        String password = prop.getProperty("password");

        YourStorePage yourStorePage = new YourStorePage(driver);
        LoginPage loginPage = yourStorePage.doNavigateLoginPage();
        loginPage.loginCorrectCredentials(email, password);
        yourStorePage = loginPage.returnToYourStorePage();
        yourStorePage.getCurrencyList(currency);
        searchPage = yourStorePage.doSearch(productName);
        searchPage.addToWishList(productName);
        myWishListPage = searchPage.doClickWishList();
        myWishListPage.doRemoveFromCartWishList(productName);
        Assert.assertTrue(myWishListPage.getSuccessMessageValidate());
    }
}



