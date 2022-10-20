package com.qa.opencart.opencart.test;

import com.github.javafaker.Faker;
import com.qa.opencart.browser.BrowserFactory;
import com.qa.opencart.enums.Browsers;
import com.qa.opencart.pages.RegisterPage;
import com.qa.opencart.pages.ShoppingCartPage;
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
public class ShoppingCartPageTest {

    private WebDriver driver;
    private RegisterPage registerPage;
    private ShoppingCartPage shoppingCartPage;
    private Faker faker;

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
    public void validateRegisterTitleTest() {
        YourStorePage yourStorePage = new YourStorePage(driver);
        shoppingCartPage = yourStorePage.doNavigateShoppingCartPage();
        String expectedShoppingCartTitlePage = "Shopping Cart";
        String actualShoppingCartTitlePage = shoppingCartPage.getShoppingCartPageTitle();
        Assert.assertEquals(expectedShoppingCartTitlePage, actualShoppingCartTitlePage);
    }

    @Test(enabled = false, priority = 2)
    public void doRegisterNewCustomerTest() {
        YourStorePage yourStorePage = new YourStorePage(driver);
        faker = new Faker();

        String firstName = faker.address().firstName();
        String lastName = faker.address().lastName();
        String email = faker.internet().emailAddress();
        String phone = faker.phoneNumber().cellPhone();
        String psw = faker.internet().password();

        registerPage = yourStorePage.doNavigateRegisterPage();
        registerPage.doRegister(firstName, lastName, email, phone, psw);
        Assert.assertTrue(registerPage.getAccountCreatedSuccessMessage());
    }
}
