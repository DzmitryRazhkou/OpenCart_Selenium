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

public class ContactUsPageTest extends BaseTest {
    private Faker faker;
    private YourStorePage yourStorePage;

    @Test(priority = 1)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Validate ContactUs Title Page")
    @Story("Story Name: To Check ContactUs Title Test")
    public void validateContactUsTitleTest() {
        YourStorePage yourStorePage = new YourStorePage(driver);
        ContactUsPage contactUsPage = yourStorePage.clickContactUsBtn();
        String expectedContactUsTitlePage = prop.getProperty("contactUsTitlePage");
        String actualContactUsTitlePage = contactUsPage.getContactUsPageTitle();
        Assert.assertEquals(expectedContactUsTitlePage, actualContactUsTitlePage);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Case Description: Do ContactUs Test")
    @Story("Story Name: To Check ContactUs Test")
    public void doContactUsTest() {
        yourStorePage = new YourStorePage(driver);
        faker = new Faker();

        String yourName = faker.name().fullName();
        String email = faker.internet().emailAddress();
        String enquiry = faker.address().fullAddress();

        ContactUsPage contactUsPage = yourStorePage.clickContactUsBtn();
        contactUsPage.doContactUs(yourName, email, enquiry);

        String expectedSuccessMessage = prop.getProperty("expectedSuccessMessage");
        String actualSuccessMessage = contactUsPage.getSuccessMessage();
        Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Case Description: Do ContactUs Invalid Data Test")
    @Story("Story Name: To Check ContactUs Invalid Data Test")
    public void doContactUsInvalidDataTest() {
        yourStorePage = new YourStorePage(driver);
        faker = new Faker();

        String email = faker.internet().emailAddress().replace("@", "");
        String enquiry = faker.address().fullAddress();

        ContactUsPage contactUsPage = yourStorePage.clickContactUsBtn();
        String yourName = contactUsPage.getSaltString();
        contactUsPage.doContactUs(yourName, email, enquiry);
        Assert.assertTrue(contactUsPage.getDangerInvalidMessage());
    }
}
