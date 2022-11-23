package com.qa.opencart.test;

import com.github.javafaker.Faker;
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
    public void validateLoginPageTitleTest() {
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
    @Description("Test Case Description: Validate Login With Not Existing Credentials Test")
    @Story("Story Name: To Check Login With Not Existing Credentials")
    public void doLoginNotExistingCredentialsTest() {
        Faker faker = new Faker();
        YourStorePage yourStorePage = new YourStorePage(driver);
        loginPage = yourStorePage.doNavigateLoginPage();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        loginPage.loginIncorrectCredentials(email, password);
        Assert.assertTrue(loginPage.getAlertMessage());
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Validate Login With Wrong Email Valid Password Credentials Test")
    @Story("Story Name: To Check Login With Wrong Email Valid Password Credentials")
    public void doLoginWrongEmailValidPswCredentialsTest() {
        YourStorePage yourStorePage = new YourStorePage(driver);
        Faker faker = new Faker();
        loginPage = yourStorePage.doNavigateLoginPage();
        String email = faker.rockBand().name();
        String password = prop.getProperty("password");
        loginPage.loginIncorrectCredentials(email, password);
        Assert.assertTrue(loginPage.getAlertMessage());
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Validate Login With Valid Email Wrong Password Credentials Test")
    @Story("Story Name: To Check Login With Valid Email Wrong Password Credentials")
    public void doLoginValidEmailWrongPswCredentialsTest() {
        YourStorePage yourStorePage = new YourStorePage(driver);
        Faker faker = new Faker();
        loginPage = yourStorePage.doNavigateLoginPage();
        String email = prop.getProperty("email");
        String password = faker.internet().password();
        loginPage.loginIncorrectCredentials(email, password);
        Assert.assertTrue(loginPage.getAlertMessage());
    }

    @Test(priority = 6)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Validate Login Between One To Four Valid Password Credentials Test")
    @Story("Story Name: To Check Login Between One To Four Valid Password Credentials")
    public void doLoginBetweenOneToFourValidPswCredentialsTest() {
        YourStorePage yourStorePage = new YourStorePage(driver);
        Faker faker = new Faker();
        loginPage = yourStorePage.doNavigateLoginPage();
        String numberBetweenOneToFour = String.valueOf(faker.number().numberBetween(1, 4));
        String password = prop.getProperty("password");
        loginPage.loginIncorrectCredentials(numberBetweenOneToFour, password);
        Assert.assertTrue(loginPage.getAlertMessage());
    }

    @Test(priority = 7)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Validate Login Valid Email Just Numbers Password Credentials Test")
    @Story("Story Name: To Check Login Valid Email Just Numbers Password Credentials")
    public void doLoginValidEmailJustNumbersPswCredentialsTest() {
        YourStorePage yourStorePage = new YourStorePage(driver);
        Faker faker = new Faker();
        loginPage = yourStorePage.doNavigateLoginPage();
        String email = prop.getProperty("email");
        String justPswNumbers = String.valueOf(faker.number().numberBetween(1, 1000000000));
        loginPage.loginIncorrectCredentials(email, justPswNumbers);
        Assert.assertTrue(loginPage.getAlertMessage());
    }

    @Test(priority = 8)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Validate Login Between One To Four Email Just Numbers Password Credentials Test")
    @Story("Story Name: To Check Login Between One To Four Email Just Numbers Password Credentials")
    public void doLoginBetweenOneToFourEmailJustNumbersPswCredentialsTest() {
        YourStorePage yourStorePage = new YourStorePage(driver);
        Faker faker = new Faker();
        loginPage = yourStorePage.doNavigateLoginPage();
        String numberBetweenOneToFour = String.valueOf(faker.number().numberBetween(1, 4));
        String justPswNumbers = String.valueOf(faker.number().numberBetween(1, 1000000000));
        loginPage.loginIncorrectCredentials(numberBetweenOneToFour, justPswNumbers);
        Assert.assertTrue(loginPage.getAlertMessage());
    }

    @Test(priority = 9)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Case Description: Validate Login With Invalid Credentials Test")
    @Story("Story Name: To Check Login With Invalid Credentials")
    public void doLoginInvalidCredentialsTest() {
        YourStorePage yourStorePage = new YourStorePage(driver);
        Faker faker = new Faker();
        loginPage = yourStorePage.doNavigateLoginPage();
        String email = faker.internet().emailAddress().replace("@", "");
        String psw = faker.internet().password();
        loginPage.loginIncorrectCredentials(email, psw);
        Assert.assertTrue(loginPage.getAlertMessage());
    }

    @Test(priority = 10)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Validate Login Out Test")
    @Story("Story Name: To Check Login Out")
    public void doLogOutTest() {
        YourStorePage yourStorePage = new YourStorePage(driver);
        loginPage = yourStorePage.doNavigateLoginPage();
        String email = prop.getProperty("email");
        String password = prop.getProperty("password");
        MyAccountPage myAccountPage = loginPage.loginCorrectCredentials(email, password);
        myAccountPage.logOut();
        Assert.assertTrue(myAccountPage.getAccountLogOutValidate());
    }
}
