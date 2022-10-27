package com.qa.opencart.test;

import com.qa.opencart.basetest.BaseTest;
import com.qa.opencart.pages.SearchPage;
import com.qa.opencart.pages.YourStorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchPageTest extends BaseTest {
    private SearchPage searchPage;

    @Test(priority = 1)
    public void validateSearchPageTitleTest() {
        YourStorePage yourStorePage = new YourStorePage(driver);
        String productName = "Macbook";
        searchPage = yourStorePage.doSearch(productName);
        String expectedSearchPageTitlePage = "Search - Macbook";
        String actualSearchPageTitlePage = searchPage.getSearchPageTitle();
        Assert.assertEquals(expectedSearchPageTitlePage, actualSearchPageTitlePage);
    }

    @Test(priority = 2)
    public void doAddToCartProductTest() {
        String productName = "MacBook";
        String currency = "$ US Dollar";

        YourStorePage yourStorePage = new YourStorePage(driver);
        yourStorePage.getCurrencyList(currency);
        searchPage = yourStorePage.doSearch(productName);
        searchPage.addToCartProduct(productName);
        Assert.assertTrue(searchPage.getSuccessMessageValidate());
    }
}
