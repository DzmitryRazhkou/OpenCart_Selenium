package com.qa.opencart.opencart.test;

import com.qa.opencart.browser.BrowserFactory;
import com.qa.opencart.enums.Browsers;
import com.qa.opencart.pages.*;
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
public class YourStorePageTest {

    private WebDriver driver;
    private YourStorePage yourStorePage;

    @BeforeMethod
    public void startUp() throws MalformedURLException {
        driver = BrowserFactory.getBrowser(Browsers.CHROME_HEADLESS);
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
