package com.qa.opencart.test;

import com.qa.opencart.basetest.BaseTest;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.MyAccountPage;
import com.qa.opencart.pages.YourStorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    private LoginPage loginPage;

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
