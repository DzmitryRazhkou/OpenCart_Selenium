package com.qa.opencart.opencart.test;

import com.github.javafaker.Faker;
import com.qa.opencart.browser.BrowserFactory;
import com.qa.opencart.enums.Browsers;
import com.qa.opencart.pages.ContactUsPage;
import com.qa.opencart.pages.SearchPage;
import com.qa.opencart.pages.YourStorePage;
import com.qa.opencart.utils.ScreenShot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

@Listeners(com.qa.opencart.opencart.listeners.Listeners.class)
public class SearchPageTest {

    private WebDriver driver;
    private SearchPage searchPage;

    @BeforeMethod
    public void startUp() throws MalformedURLException {
        driver = BrowserFactory.getBrowser(Browsers.FIREFOX);
        driver.get("https://naveenautomationlabs.com/opencart/");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.FAILURE == result.getStatus()) {
            ScreenShot.takeScreenshot(driver, result.getTestName());
        }
        driver.quit();
    }


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
    public void doProductSearchTest() {
        YourStorePage yourStorePage = new YourStorePage(driver);
        String productName = "MacBook Air";
        searchPage = yourStorePage.doSearch(productName);
        searchPage.addToCartProduct(productName);
        Assert.assertTrue(searchPage.getSuccessMessageValidate());
    }











    @Test(priority = 3)
    public void doContactUsInvalidDataTest() {
        YourStorePage yourStorePage = new YourStorePage(driver);
        Faker faker = new Faker();

        String email = faker.internet().emailAddress().replace("@", "");
        String enquiry = faker.address().fullAddress();

        ContactUsPage contactUsPage = yourStorePage.clickContactUsBtn();
        String yourName = contactUsPage.getSaltString();
        contactUsPage.doContactUs(yourName, email, enquiry);
        Assert.assertTrue(contactUsPage.getDangerInvalidMessage());
    }

}
