package com.qa.opencart.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class ContactUsPage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Logger log;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        log = Logger.getLogger(ContactUsPage.class);
    }

    //    Contact Us Section:
    private WebElement getContactUsLink() {
        By contactUsLinkLocator = By.cssSelector("#content h1");
        wait.until(ExpectedConditions.presenceOfElementLocated(contactUsLinkLocator));
        return driver.findElement(contactUsLinkLocator);
    }
    public boolean getContactUsLinkValidate() {
        try {
            log.info(" =====> Contact Us Link has been displayed <===== ");
            System.out.println(" =====> " + getContactUsLink().getText() + " <===== ");
            return getContactUsLink().isDisplayed();
        } catch (TimeoutException y) {
            log.warn(" <=== !!! Please provide a right locator !!! ===> ");
            return false;
        }
    }

    //    Validate Title Page:
    public String getContactUsPageTitle() {
        log.info("User validates the title page. ");
        System.out.println(" =====> My Your Page Title Is: " + driver.getTitle() + " <===== ");
        return driver.getTitle();
    }

//    Contact Us:
    private WebElement getYourName() {
        By yourNameLocator = By.id("input-name");
        wait.until(ExpectedConditions.presenceOfElementLocated(yourNameLocator));
        return driver.findElement(yourNameLocator);
    }
    private WebElement getEmail() {
        By emailLocator = By.id("input-email");
        wait.until(ExpectedConditions.presenceOfElementLocated(emailLocator));
        return driver.findElement(emailLocator);
    }
    private WebElement getEnquiry() {
        By enquiryLocator = By.id("input-enquiry");
        wait.until(ExpectedConditions.presenceOfElementLocated(enquiryLocator));
        return driver.findElement(enquiryLocator);
    }
    private WebElement submitBtn() {
        By submitLocator = By.cssSelector("input[type='submit']");
        wait.until(ExpectedConditions.presenceOfElementLocated(submitLocator));
        return driver.findElement(submitLocator);
    }
    public String getSuccessMessage() {
        log.info("User receives a success message. ");
        By enquiryLocator = By.cssSelector("#content p");
        wait.until(ExpectedConditions.presenceOfElementLocated(enquiryLocator));
        return driver.findElement(enquiryLocator).getText();
    }
    public void doContactUs(String name, String email, String enquiry) {
        log.info("User types the full names. ");
        getYourName().clear();
        getYourName().sendKeys(name);

        log.info("User types an email. ");
        getEmail().clear();
        getEmail().sendKeys(email);

        log.info("User types an enquiry. ");
        getEnquiry().clear();
        getEnquiry().sendKeys(enquiry);

        log.info("User clicks on the submit button. ");
        submitBtn().click();
    }

    //    Invalid Your Name:
    public String getSaltString() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder str = new StringBuilder();
        Random rnd = new Random();
        while (str.length() < 5) { // length of the random string.
            int index = (int) (rnd.nextFloat() * characters.length());
            str.append(characters.charAt(index));
        }
        return str.toString();
    }
    private WebElement dangerAlert() {
        By dangerLocator = By.cssSelector("div[class='text-danger']");
        wait.until(ExpectedConditions.presenceOfElementLocated(dangerLocator));
        return driver.findElement(dangerLocator);
    }
    public boolean getDangerInvalidMessage() {
        try {
            log.info("User receives an alert message. ");
            System.out.println(" =====> " +dangerAlert().getText()+ " <===== ");
            return dangerAlert().isDisplayed();
        } catch (TimeoutException y) {
            log.warn("Please provide another locator. ");
            return false;
        }
    }

}

