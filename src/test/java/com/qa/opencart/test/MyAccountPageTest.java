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
public class MyAccountPageTest extends BaseTest {

    @Test(priority = 1)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Validate My Account Page Title Test")
    @Story("Story Name: To Check My Account Page Title")
    public void validateMyAccountTitlePageTest() {
        YourStorePage yourStorePage = new YourStorePage(driver);
        String email = prop.getProperty("email");
        String password = prop.getProperty("password");

        LoginPage loginPage = yourStorePage.doNavigateLoginPage();
        MyAccountPage myAccountPage = loginPage.loginCorrectCredentials(email, password);

        String expectedMyAccountTitlePage = prop.getProperty("myAccountTitlePage");
        String actualMyAccountTitlePage = myAccountPage.getMyAccountPageTitle();
        Assert.assertEquals(expectedMyAccountTitlePage, actualMyAccountTitlePage);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.MINOR)
    @Description("Test Case Description: My Account Edit Your Account Information Test")
    @Story("Story Name: To Check My Account Edit Your Account Information Feature")
    public void myAccountEditYourAccountInformationTest() {
        YourStorePage yourStorePage = new YourStorePage(driver);
        String email = prop.getProperty("email");
        String password = prop.getProperty("password");
        String firstName = prop.getProperty("firstName");
        String lastName = prop.getProperty("lastName");
        String phone = prop.getProperty("phone");

        LoginPage loginPage = yourStorePage.doNavigateLoginPage();
        MyAccountPage myAccountPage = loginPage.loginCorrectCredentials(email, password);
        myAccountPage.clickEditYourAccountInformation();
        myAccountPage.editPersonalDetails(firstName, lastName, email, phone);
        myAccountPage.clickContinueBtn();
        Assert.assertTrue(myAccountPage.validateSuccessYourAccountHasBeenSuccessfullyUpdated());
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: My Account Edit Your Account Information Back Test")
    @Story("Story Name: To Check My Account Edit Your Account Information Back Feature")
    public void myAccountEditYourAccountInformationBackTest() {
        YourStorePage yourStorePage = new YourStorePage(driver);
        String email = prop.getProperty("email");
        String password = prop.getProperty("password");
        String firstName = prop.getProperty("firstName");
        String lastName = prop.getProperty("lastName");
        String phone = prop.getProperty("phone");

        LoginPage loginPage = yourStorePage.doNavigateLoginPage();
        MyAccountPage myAccountPage = loginPage.loginCorrectCredentials(email, password);
        myAccountPage.clickEditYourAccountInformation();
        myAccountPage.editPersonalDetails(firstName, lastName, email, phone);
        myAccountPage.clickBackBtn();
        String expectedMyAccountTitlePage = prop.getProperty("myAccountTitlePage");
        String actualMyAccountTitlePage = myAccountPage.getMyAccountPageTitle();
        Assert.assertEquals(expectedMyAccountTitlePage, actualMyAccountTitlePage);
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.MINOR)
    @Description("Test Case Description: My Account Change Your Password Test")
    @Story("Story Name: To Check My Account Change Your Password Feature")
    public void myAccountChangeYourPasswordTest() {
        YourStorePage yourStorePage = new YourStorePage(driver);
        String email = prop.getProperty("email");
        String password = prop.getProperty("password");

        LoginPage loginPage = yourStorePage.doNavigateLoginPage();
        MyAccountPage myAccountPage = loginPage.loginCorrectCredentials(email, password);
        myAccountPage.clickChangeYourPassword();
        myAccountPage.doChangePassword(password);
        myAccountPage.clickContinueBtn();
        Assert.assertTrue(myAccountPage.validateSuccessYourPasswordHasBeenSuccessfullyUpdated());
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.MINOR)
    @Description("Test Case Description: My Account Change Your Password Back Test")
    @Story("Story Name: To Check My Account Change Your Password Back Feature")
    public void myAccountChangeYourPasswordBackTest() {
        YourStorePage yourStorePage = new YourStorePage(driver);
        String email = prop.getProperty("email");
        String password = prop.getProperty("password");

        LoginPage loginPage = yourStorePage.doNavigateLoginPage();
        MyAccountPage myAccountPage = loginPage.loginCorrectCredentials(email, password);
        myAccountPage.clickChangeYourPassword();
        myAccountPage.doChangePassword(password);
        myAccountPage.clickBackBtn();
        String expectedMyAccountTitlePage = prop.getProperty("myAccountTitlePage");
        String actualMyAccountTitlePage = myAccountPage.getMyAccountPageTitle();
        Assert.assertEquals(expectedMyAccountTitlePage, actualMyAccountTitlePage);
    }

    @Test(priority = 6)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Case Description: My Account Modify Your Address Book Entries Test")
    @Story("Story Name: To Check My Account Modify Your Address Book Entries Feature")
    public void modifyYourAddressBookEntriesTest() {
        YourStorePage yourStorePage = new YourStorePage(driver);
        Faker faker = new Faker();
        String email = prop.getProperty("email");
        String password = prop.getProperty("password");
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String company = faker.company().name();
        String address1stLine = faker.address().streetAddress();
        String address2ndLine = faker.address().secondaryAddress();
        String city = faker.address().city();
        String zipCode = faker.address().zipCode();
        String country = prop.getProperty("country");
        String state = faker.address().state();

        LoginPage loginPage = yourStorePage.doNavigateLoginPage();
        MyAccountPage myAccountPage = loginPage.loginCorrectCredentials(email, password);
        myAccountPage.clickModifyYourAddressBookEntries();
        myAccountPage.clickOnNewAddress();
        myAccountPage.doAddAddress(firstName, lastName, company, address1stLine, address2ndLine, city, zipCode, country, state);
        myAccountPage.clickContinueBtn();
        Assert.assertTrue(myAccountPage.validateSuccessYourAccountHasBeenSuccessfullyUpdated());
    }

    @Test(priority = 7)
    @Severity(SeverityLevel.MINOR)
    @Description("Test Case Description: My Account Modify Your Address Book Entries Back Test")
    @Story("Story Name: To Check My Account Modify Your Address Book Entries Back Feature")
    public void modifyYourAddressBookEntriesBackTest() {
        YourStorePage yourStorePage = new YourStorePage(driver);
        Faker faker = new Faker();
        String email = prop.getProperty("email");
        String password = prop.getProperty("password");
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String company = faker.company().name();
        String address1stLine = faker.address().streetAddress();
        String address2ndLine = faker.address().secondaryAddress();
        String city = faker.address().city();
        String zipCode = faker.address().zipCode();
        String country = prop.getProperty("country");
        String state = faker.address().state();

        LoginPage loginPage = yourStorePage.doNavigateLoginPage();
        MyAccountPage myAccountPage = loginPage.loginCorrectCredentials(email, password);
        myAccountPage.clickModifyYourAddressBookEntries();
        myAccountPage.clickOnNewAddress();
        myAccountPage.doAddAddress(firstName, lastName, company, address1stLine, address2ndLine, city, zipCode, country, state);
        myAccountPage.clickBackBtn();
        String expectedMyAccountTitlePage = prop.getProperty("addressBookTitlePage");
        String actualMyAccountTitlePage = myAccountPage.getMyAccountPageTitle();
        Assert.assertEquals(expectedMyAccountTitlePage, actualMyAccountTitlePage);
    }
}
