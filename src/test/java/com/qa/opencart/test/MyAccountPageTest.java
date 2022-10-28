package com.qa.opencart.test;

import com.github.javafaker.Faker;
import com.qa.opencart.basetest.BaseTest;
import com.qa.opencart.pages.ContactUsPage;
import com.qa.opencart.pages.YourStorePage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
public class MyAccountPageTest extends BaseTest {

    @Test(priority = 1)
    @Severity(SeverityLevel.TRIVIAL)
    @Description("Test Case Description: Validate Add To Cart Product Test")
    @Story("Story Name: To Check Add To Cart Product")
    public void validateMyAccountTitleTest() {
        YourStorePage yourStorePage = new YourStorePage(driver);
        ContactUsPage contactUsPage = yourStorePage.clickContactUsBtn();
        String expectedContactUsTitlePage = prop.getProperty("contactUsTitlePage");
        String actualContactUsTitlePage = contactUsPage.getContactUsPageTitle();
        Assert.assertEquals(expectedContactUsTitlePage, actualContactUsTitlePage);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Do MyAccount Test")
    @Story("Story Name: To Check MyAccount Feature")
    public void doMyAccountTest() {
        YourStorePage yourStorePage = new YourStorePage(driver);
        Faker faker = new Faker();

        String yourName = faker.name().fullName();
        String email = faker.internet().emailAddress();
        String enquiry = faker.address().fullAddress();

        ContactUsPage contactUsPage = yourStorePage.clickContactUsBtn();
        contactUsPage.doContactUs(yourName, email, enquiry);

        String expectedSuccessMessage = prop.getProperty("successMessage");
        String actualSuccessMessage = contactUsPage.getSuccessMessage();
        Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage);
    }
}
