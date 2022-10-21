package com.qa.opencart.test;

import com.github.javafaker.Faker;
import com.qa.opencart.basetest.BaseTest;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.SearchPage;
import com.qa.opencart.pages.ShoppingCartPage;
import com.qa.opencart.pages.YourStorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingCartPageTest extends BaseTest {

    @Test(priority = 1)
    public void validateRegisterTitleTest() {
        YourStorePage yourStorePage = new YourStorePage(driver);
        ShoppingCartPage shoppingCartPage = yourStorePage.doNavigateShoppingCartPage();
        String expectedShoppingCartTitlePage = "Shopping Cart";
        String actualShoppingCartTitlePage = shoppingCartPage.getShoppingCartPageTitle();
        Assert.assertEquals(expectedShoppingCartTitlePage, actualShoppingCartTitlePage);
    }

    @Test(priority = 2)
    public void doCheckOutProductExistingAddressTest() {
        YourStorePage yourStorePage = new YourStorePage(driver);
        Faker faker = new Faker();
        String email = "dimagadjilla@gmail.com";
        String password = "3036057Dr";
        String productName = "MacBook";
        String currency = "$ US Dollar";
        String comments = faker.name().title();

        LoginPage loginPage = yourStorePage.doNavigateLoginPage();
        loginPage.loginCorrectCredentials(email, password);
        yourStorePage = loginPage.returnToYourStorePage();
        yourStorePage.getCurrencyList(currency);
        SearchPage searchPage = yourStorePage.doSearch(productName);
        searchPage.addToCartProduct(productName);
        ShoppingCartPage shoppingCartPage = searchPage.doClickOnTheCheckOut();
        shoppingCartPage.existingAddressRadio();
        shoppingCartPage.paymentMethod(comments);
    }

    @Test(priority = 3)
    public void doCheckOutProductNewAddressTest() {
        YourStorePage yourStorePage = new YourStorePage(driver);
        Faker faker = new Faker();

        String email = "dimagadjilla@gmail.com";
        String password = "3036057Dr";
        String productName = "MacBook";
        String currency = "$ US Dollar";
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String company = faker.company().name();
        String address1 = faker.address().streetName();
        String address2 = faker.address().streetAddressNumber();
        String city = faker.address().city();
        String zip = faker.address().zipCode();
        String country = "United States";
        String state = "Texas";
//        String state = faker.address().state();
        String comments = faker.name().title();

        LoginPage loginPage = yourStorePage.doNavigateLoginPage();
        loginPage.loginCorrectCredentials(email, password);
        yourStorePage = loginPage.returnToYourStorePage();
        yourStorePage.getCurrencyList(currency);
        SearchPage searchPage = yourStorePage.doSearch(productName);
        searchPage.addToCartProduct(productName);
        ShoppingCartPage shoppingCartPage = searchPage.doClickOnTheCheckOut();
        shoppingCartPage.newAddressRadio();
        shoppingCartPage.doFillUpBillingDetails(firstName, lastName, company, address1, address2, city, zip, country, state);
        shoppingCartPage.paymentMethod(comments);
    }
}
