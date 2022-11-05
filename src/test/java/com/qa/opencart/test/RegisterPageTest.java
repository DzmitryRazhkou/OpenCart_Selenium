package com.qa.opencart.test;

import com.github.javafaker.Faker;
import com.qa.opencart.basetest.BaseTest;
import com.qa.opencart.pages.RegisterPage;
import com.qa.opencart.pages.YourStorePage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterPageTest extends BaseTest {
    private RegisterPage registerPage;
    private Faker faker;

    @Test(priority = 1)
    @Severity(SeverityLevel.TRIVIAL)
    @Description("Test Case Description: Validate Register Page Title Test")
    @Story("Story Name: To Check Register Page Title Feature")
    public void validateRegisterTitleTest() {
        YourStorePage yourStorePage = new YourStorePage(driver);
        registerPage = yourStorePage.doNavigateRegisterPage();
        String expectedRegisterTitlePage = prop.getProperty("registerTitlePage");
        String actualRegisterTitlePage = registerPage.getRegisterAccountPageTitle();
        Assert.assertEquals(expectedRegisterTitlePage, actualRegisterTitlePage);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Case Description: Do Register New Customer Test")
    @Story("Story Name: To Check Register New Customer")
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

    @Test(priority = 3)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Do Register Existing Customer Test")
    @Story("Story Name: To Check Register Existing Customer")
    public void doRegisterExistingCustomerTest() {
        YourStorePage yourStorePage = new YourStorePage(driver);
        faker = new Faker();

        String firstName = prop.getProperty("firstName");
        String lastName = prop.getProperty("lastName");
        String email = prop.getProperty("email");
        String phone = prop.getProperty("phone");
        String psw = prop.getProperty("password");

        registerPage = yourStorePage.doNavigateRegisterPage();
        registerPage.doRegister(firstName, lastName, email, phone, psw);
        Assert.assertTrue(registerPage.getWarningAlertMessage());
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Case Description: Do Register New Customer Minimum Phone Number Value Test")
    @Story("Story Name: To Check Register New Customer Minimum Phone Number Value")
    public void doRegisterNewCustomerMinimumPhoneNumberValueTest() {
        YourStorePage yourStorePage = new YourStorePage(driver);
        faker = new Faker();


        String firstName = faker.address().firstName();
        String lastName = faker.address().lastName();
        String email = faker.internet().emailAddress();
        String psw = faker.internet().password();

        registerPage = yourStorePage.doNavigateRegisterPage();
        int lengthOfString = Integer.parseInt(prop.getProperty("lengthOfStringPhoneMinimumValue"));
        String phone = registerPage.generateString(lengthOfString);

        registerPage.doRegister(firstName, lastName, email, psw, phone);
        Assert.assertTrue(registerPage.getAlertMessage());
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Case Description: Do Register New Customer Maximum Phone Number Value Test")
    @Story("Story Name: To Check Register New Customer Maximum Phone Number Value")
    public void doRegisterNewCustomerMaximumPhoneNumberValueTest() {
        YourStorePage yourStorePage = new YourStorePage(driver);
        faker = new Faker();


        String firstName = faker.address().firstName();
        String lastName = faker.address().lastName();
        String email = faker.internet().emailAddress();
        String psw = faker.internet().password();

        registerPage = yourStorePage.doNavigateRegisterPage();
        int lengthOfString = Integer.parseInt(prop.getProperty("lengthOfStringPhoneMaximumValue"));
        String phone = registerPage.generateString(lengthOfString);

        registerPage.doRegister(firstName, lastName, email, psw, phone);
        Assert.assertTrue(registerPage.getAlertMessage());
    }

    @Test(priority = 6)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Case Description: Do Register New Customer Minimum Password Value Test")
    @Story("Story Name: To Check Register New Customer Minimum Password Value")
    public void doRegisterNewCustomerMinimumPasswordValueTest() {
        YourStorePage yourStorePage = new YourStorePage(driver);
        faker = new Faker();

        String firstName = faker.address().firstName();
        String lastName = faker.address().lastName();
        String email = faker.internet().emailAddress();
        String phone = faker.phoneNumber().cellPhone();
        int lengthOfString = Integer.parseInt(prop.getProperty("lengthOfStringPasswordMinimumValue"));

        registerPage = yourStorePage.doNavigateRegisterPage();
        String psw = registerPage.generateString(lengthOfString);
        registerPage.doRegister(firstName, lastName, email, psw, phone);
        Assert.assertTrue(registerPage.getAlertMessage());
    }

    @Test(priority = 7)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Case Description: Do Register New Customer Maximum Password Value Test")
    @Story("Story Name: To Check Register New Customer Maximum Password Value")
    public void doRegisterNewCustomerMaximumPasswordValueTest() {
        YourStorePage yourStorePage = new YourStorePage(driver);
        faker = new Faker();

        String firstName = faker.address().firstName();
        String lastName = faker.address().lastName();
        String email = faker.internet().emailAddress();
        String phone = faker.phoneNumber().cellPhone();
        int lengthOfString = Integer.parseInt(prop.getProperty("lengthOfStringPasswordMaximumValue"));

        registerPage = yourStorePage.doNavigateRegisterPage();
        String psw = registerPage.generateString(lengthOfString);
        registerPage.doRegister(firstName, lastName, email, psw, phone);
        Assert.assertTrue(registerPage.getAlertMessage());
    }

    @Test(priority = 8)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Do Register New Customer Unmatched Password Value Test")
    @Story("Story Name: To Check Register New Customer Unmatched Password Value Value")
    public void doRegisterNewCustomerUnmatchedPasswordValueTest() {
        YourStorePage yourStorePage = new YourStorePage(driver);
        faker = new Faker();

        String firstName = faker.address().firstName();
        String lastName = faker.address().lastName();
        String email = faker.internet().emailAddress();
        String phone = faker.phoneNumber().cellPhone();
        String psw = faker.internet().password();
        String pswConfirm = faker.internet().password();

        registerPage = yourStorePage.doNavigateRegisterPage();
        registerPage.doRegisterUnmatchedPsw(firstName, lastName, email, psw, phone, pswConfirm);
        Assert.assertTrue(registerPage.getAlertMessage());
    }

    @Test(priority = 9)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Do Register New Customer Minimum Password Value/Unmatched Test")
    @Story("Story Name: To Check Register New Customer Minimum Password Value/Unmatched")
    public void doRegisterNewCustomerMinimumPasswordValueUnmatchedTest() {
        YourStorePage yourStorePage = new YourStorePage(driver);
        faker = new Faker();

        String firstName = faker.address().firstName();
        String lastName = faker.address().lastName();
        String email = faker.internet().emailAddress();
        String phone = faker.phoneNumber().cellPhone();

        registerPage = yourStorePage.doNavigateRegisterPage();
        String psw = registerPage.generateString(Integer.parseInt(prop.getProperty("unmatched2")));
        String pswConfirm = registerPage.generateString(Integer.parseInt(prop.getProperty("unmatched3")));
        registerPage.doRegisterUnmatchedPsw(firstName, lastName, email, psw, phone, pswConfirm);
        Assert.assertTrue(registerPage.getAlertMessage());
    }

    @Test(priority = 10)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Case Description: Do Register New Customer Without Agreement Policy Test")
    @Story("Story Name: To Check Register New Customer Without Agreement Policy")
    public void doRegisterNewCustomerWithoutAgreementPolicyTest() {
        YourStorePage yourStorePage = new YourStorePage(driver);
        faker = new Faker();

        String firstName = faker.address().firstName();
        String lastName = faker.address().lastName();
        String email = faker.internet().emailAddress();
        String phone = faker.phoneNumber().cellPhone();
        String psw = faker.internet().password();

        registerPage = yourStorePage.doNavigateRegisterPage();
        registerPage.doRegisterWithoutAgreementPolicy(firstName, lastName, email, psw, phone);
        Assert.assertTrue(registerPage.getWarningAlertMessage());
    }
}
