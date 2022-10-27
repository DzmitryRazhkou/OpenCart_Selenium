package com.qa.opencart.test;

import com.qa.opencart.basetest.BaseTest;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.MyAccountPage;
import com.qa.opencart.pages.YourStorePage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    private LoginPage loginPage;

    @Test(priority = 1)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Validate Login Page Title Test")
    @Story("Story Name: To Check Page Login Page Feature")
    public void validateContactUsTitleTest() {
        YourStorePage yourStorePage = new YourStorePage(driver);
        loginPage = yourStorePage.doNavigateLoginPage();
        String expectedLoginTitlePage = prop.getProperty("loginTitlePage");
        String actualLoginTitlePage = loginPage.getLoginPageTitle();
        Assert.assertEquals(expectedLoginTitlePage, actualLoginTitlePage);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Case Description: Validate Login With Correct Credentials Test")
    @Story("Story Name: To Check Login With Correct Credentials")
    public void doLoginValidCredentialsTest() {
        YourStorePage yourStorePage = new YourStorePage(driver);
        loginPage = yourStorePage.doNavigateLoginPage();
        String email = prop.getProperty("email");
        String password = prop.getProperty("password");
        MyAccountPage myAccountPage = loginPage.loginCorrectCredentials(email, password);
        Assert.assertTrue(myAccountPage.getMyAccountValidate());
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Case Description: Validate Login With Invalid Credentials Test")
    @Story("Story Name: To Check Login With Invalid Credentials")
    public void doLoginInvalidCredentialsTest() {
        YourStorePage yourStorePage = new YourStorePage(driver);
        loginPage = yourStorePage.doNavigateLoginPage();
        String email = prop.getProperty("wrong_email");
        String password = prop.getProperty("wrong_password");
        loginPage.loginIncorrectCredentials(email, password);
        Assert.assertTrue(loginPage.getAlertMessage());
    }
}
