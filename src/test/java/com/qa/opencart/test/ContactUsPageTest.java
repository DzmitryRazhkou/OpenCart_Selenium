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

        String expectedSuccessMessage = prop.getProperty("successMessage");
        String actualSuccessMessage = contactUsPage.getSuccessMessage();
        Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Do ContactUs Invalid Your Name Minimum Value Test")
    @Story("Story Name: To Check ContactUs Your Name Minimum Value Test")
    public void doContactUsInvalidYourNameMinimumValueTest() {
        yourStorePage = new YourStorePage(driver);
        faker = new Faker();

        String email = faker.internet().emailAddress();
        String enquiry = faker.address().fullAddress();
        int lengthOgString = Integer.parseInt(prop.getProperty("lengthYourNameMinimumValue"));

        ContactUsPage contactUsPage = yourStorePage.clickContactUsBtn();
        String yourName = contactUsPage.createString(lengthOgString);

        contactUsPage.doContactUs(yourName, email, enquiry);
        Assert.assertTrue(contactUsPage.getDangerInvalidMessage());
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Do ContactUs Invalid Your Name Maximum Value Test")
    @Story("Story Name: To Check ContactUs Your Name Maximum Value Test")
    public void doContactUsInvalidYourNameMaximumValueTest() {
        yourStorePage = new YourStorePage(driver);
        faker = new Faker();

        String email = faker.internet().emailAddress();
        String enquiry = faker.address().fullAddress();
        int lengthOfString = Integer.parseInt(prop.getProperty("lengthYourNameMaximumValue"));

        ContactUsPage contactUsPage = yourStorePage.clickContactUsBtn();
        String yourName = contactUsPage.createString(lengthOfString);

        contactUsPage.doContactUs(yourName, email, enquiry);
        Assert.assertTrue(contactUsPage.getDangerInvalidMessage());
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Case Description: Do ContactUs Invalid Email Address Test")
    @Story("Story Name: To Check ContactUs Invalid Email Address Test")
    public void doContactUsInvalidEmailAddressTest() {
        yourStorePage = new YourStorePage(driver);
        faker = new Faker();
        String yourName = faker.name().fullName();
        String email = faker.internet().emailAddress().replace("@", "");
        String enquiry = faker.address().fullAddress();

        ContactUsPage contactUsPage = yourStorePage.clickContactUsBtn();
        contactUsPage.doContactUs(yourName, email, enquiry);
        Assert.assertTrue(contactUsPage.getDangerInvalidMessage());
    }

    @Test(priority = 6)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Do ContactUs Invalid Enquiry Minimum Value Test")
    @Story("Story Name: To Check ContactUs Your Name Minimum Value Test")
    public void doContactUsInvalidEnquiryMinimumValueTest() {
        yourStorePage = new YourStorePage(driver);
        faker = new Faker();

        String yourName = faker.name().fullName();
        String email = faker.internet().emailAddress();
        int lengthOfString = Integer.parseInt(prop.getProperty("lengthEnquiryMinimumValue"));

        ContactUsPage contactUsPage = yourStorePage.clickContactUsBtn();
        String enquiry = contactUsPage.createString(lengthOfString);

        contactUsPage.doContactUs(yourName, email, enquiry);
        Assert.assertTrue(contactUsPage.getDangerInvalidMessage());
    }

    @Test(priority = 7)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Do ContactUs Invalid Enquiry Minimum Value Test")
    @Story("Story Name: To Check ContactUs Your Name Minimum Value Test")
    public void doContactUsInvalidEnquiryMaximumValueTest() {
        yourStorePage = new YourStorePage(driver);
        faker = new Faker();

        String yourName = faker.name().fullName();
        String email = faker.internet().emailAddress();
        int lengthOfString = Integer.parseInt(prop.getProperty("lengthEnquiryMaximumValue"));

        ContactUsPage contactUsPage = yourStorePage.clickContactUsBtn();
        String enquiry = contactUsPage.createString(lengthOfString);

        contactUsPage.doContactUs(yourName, email, enquiry);
        Assert.assertTrue(contactUsPage.getDangerInvalidMessage());
    }
}
