package com.qa.opencart.opencart.test;

import com.github.javafaker.Faker;
import com.qa.opencart.browser.BrowserFactory;
import com.qa.opencart.enums.Browsers;
import com.qa.opencart.pages.ContactUsPage;
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
public class MyAccountPageTest {

    private WebDriver driver;
    private Faker faker;
    private YourStorePage yourStorePage;
    private ContactUsPage contactUsPage;

    @BeforeMethod
    public void startUp() throws MalformedURLException {
        driver = BrowserFactory.getBrowser(Browsers.CHROME_HEADLESS);
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
    public void validateMyAccountTitleTest() {
        YourStorePage yourStorePage = new YourStorePage(driver);
        ContactUsPage contactUsPage = yourStorePage.clickContactUsBtn();
        String expectedContactUsTitlePage = "Contact Us";
        String actualContactUsTitlePage = contactUsPage.getContactUsPageTitle();
        Assert.assertEquals(expectedContactUsTitlePage, actualContactUsTitlePage);
    }

    @Test(priority = 2)
    public void doMyAccountTest() {
        yourStorePage = new YourStorePage(driver);
        faker = new Faker();

        String yourName = faker.name().fullName();
        String email = faker.internet().emailAddress();
        String enquiry = faker.address().fullAddress();

        ContactUsPage contactUsPage = yourStorePage.clickContactUsBtn();
        contactUsPage.doContactUs(yourName, email, enquiry);

        String expectedSuccessMessage = "Your enquiry has been successfully sent to the store owner!";
        String actualSuccessMessage = contactUsPage.getSuccessMessage();
        Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage);
    }


}
