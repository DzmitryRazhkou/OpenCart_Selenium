package com.qa.opencart.opencart.test;

import com.qa.opencart.browser.BrowserFactory;
import com.qa.opencart.enums.Browsers;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.MyAccountPage;
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
public class LoginPageTest {

    private WebDriver driver;
    private LoginPage loginPage;

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
    public void validateContactUsTitleTest() {
        YourStorePage yourStorePage = new YourStorePage(driver);
        loginPage = yourStorePage.doNavigateLoginPage();
        String expectedLoginTitlePage = "Account Login";
        String actualLoginTitlePage = loginPage.getLoginPageTitle();
        Assert.assertEquals(expectedLoginTitlePage, actualLoginTitlePage);
    }

    @Test(priority = 2)
    public void doLoginValidCredentialsTest() {
        YourStorePage yourStorePage = new YourStorePage(driver);
        loginPage = yourStorePage.doNavigateLoginPage();
        String email = "dimagadjilla@gmail.com";
        String password = "3036057Dr";
        MyAccountPage myAccountPage = loginPage.loginCorrectCredentials(email, password);
        Assert.assertTrue(myAccountPage.getMyAccountValidate());
    }

    @Test(priority = 3)
    public void doLoginInvalidCredentialsTest() {
        YourStorePage yourStorePage = new YourStorePage(driver);
        loginPage = yourStorePage.doNavigateLoginPage();
        String email = "dimagadjilla_@gmail.com";
        String password = "3036057_Dr";
        loginPage.loginIncorrectCredentials(email, password);
        Assert.assertTrue(loginPage.getAlertMessage());
    }
}
