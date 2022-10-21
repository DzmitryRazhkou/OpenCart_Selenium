package com.qa.opencart.test;

import com.github.javafaker.Faker;
import com.qa.opencart.basetest.BaseTest;
import com.qa.opencart.pages.RegisterPage;
import com.qa.opencart.pages.YourStorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterPageTest extends BaseTest {
    private RegisterPage registerPage;
    private Faker faker;

    @Test(priority = 1)
    public void validateRegisterTitleTest() {
        YourStorePage yourStorePage = new YourStorePage(driver);
        registerPage = yourStorePage.doNavigateRegisterPage();
        String expectedRegisterTitlePage = "Register Account";
        String actualRegisterTitlePage = registerPage.getRegisterAccountPageTitle();
        Assert.assertEquals(expectedRegisterTitlePage, actualRegisterTitlePage);
    }

    @Test(priority = 2)
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
    public void doRegisterNewCustomerTwoDigitsTest() {
        YourStorePage yourStorePage = new YourStorePage(driver);
        faker = new Faker();

        String firstName = faker.address().firstName();
        String lastName = faker.address().lastName();
        String email = faker.internet().emailAddress();
        String phone = faker.phoneNumber().cellPhone();

        registerPage = yourStorePage.doNavigateRegisterPage();
        String psw = registerPage.generatePasswordTwoDigits();
        registerPage.doRegister(firstName, lastName, email, psw, phone);
        Assert.assertTrue(registerPage.getAlertMessage());
    }
}
