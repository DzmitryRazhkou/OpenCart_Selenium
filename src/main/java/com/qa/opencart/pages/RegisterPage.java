package com.qa.opencart.pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Logger log;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        log = Logger.getLogger(RegisterPage.class);
    }

//    Register Section:
    private WebElement getRegisterAccountLink() {
        By loginLinkLocator = By.cssSelector("ul[class='breadcrumb'] li:last-of-type a");
        wait.until(ExpectedConditions.presenceOfElementLocated(loginLinkLocator));
        return driver.findElement(loginLinkLocator);
    }
    public boolean getRegisterAccountLinkValidate() {
        try {
            log.info(" =====> Register New Customer Link has been displayed <===== ");
            System.out.println(" =====> " + getRegisterAccountLink().getText() + " <===== ");
            return getRegisterAccountLink().isDisplayed();
        } catch (TimeoutException y) {
            log.warn(" <=== !!! Please provide a right locator !!! ===> ");
            return false;
        }
    }

//    Validate Title Page:
    public String getRegisterAccountPageTitle() {
        log.info("User validates the title page. ");
        System.out.println(" =====> Register Page Title Is: " + driver.getTitle() + " <===== ");
        return driver.getTitle();
    }

//    Register Feature:

    private WebElement getFirstName() {
        By getFirstNameLocator = By.id("input-firstname");
        wait.until(ExpectedConditions.presenceOfElementLocated(getFirstNameLocator));
        return driver.findElement(getFirstNameLocator);
    }
    private WebElement getLastName() {
        By getLastNameLocator = By.id("input-lastname");
        wait.until(ExpectedConditions.presenceOfElementLocated(getLastNameLocator));
        return driver.findElement(getLastNameLocator);
    }
    private WebElement getEmail() {
        By emailLocator = By.id("input-email");
        wait.until(ExpectedConditions.presenceOfElementLocated(emailLocator));
        return driver.findElement(emailLocator);
    }
    private WebElement getPhone() {
        By getPhoneLocator = By.id("input-telephone");
        wait.until(ExpectedConditions.presenceOfElementLocated(getPhoneLocator));
        return driver.findElement(getPhoneLocator);
    }
    private WebElement getPassword() {
        By passwordLocator = By.id("input-password");
        wait.until(ExpectedConditions.presenceOfElementLocated(passwordLocator));
        return driver.findElement(passwordLocator);
    }
    private WebElement getConfirmPassword() {
        By passwordConfirmLocator = By.id("input-confirm");
        wait.until(ExpectedConditions.presenceOfElementLocated(passwordConfirmLocator));
        return driver.findElement(passwordConfirmLocator);
    }
    private WebElement agreeCheckBox() {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0, 250)", "");

        By agreeCheckBoxLocator = By.cssSelector("input[name='agree']");
        wait.until(ExpectedConditions.presenceOfElementLocated(agreeCheckBoxLocator));
        return driver.findElement(agreeCheckBoxLocator);
    }
    private WebElement submitBtn() {
        By submitLocator = By.cssSelector("input[type='submit']");
        wait.until(ExpectedConditions.presenceOfElementLocated(submitLocator));
        return driver.findElement(submitLocator);
    }

    public String generatePasswordTwoDigits(){
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";
        String pwd = RandomStringUtils.random( 2, characters );
        System.out.println( pwd );
        return pwd;
    }

    public void doRegister(String first, String last, String email, String password, String phone) {
        log.info("User types the first name. ");
        getFirstName().clear();
        getFirstName().sendKeys(first);

        log.info("User types the last name. ");
        getLastName().clear();
        getLastName().sendKeys(last);

        log.info("User types the email. ");
        getEmail().clear();
        getEmail().sendKeys(email);

        log.info("User types the phone number. ");
        getPhone().clear();
        getPhone().sendKeys(phone);

        log.info("User types a password. ");
        getPassword().clear();
        getPassword().sendKeys(password);

        log.info("User types a confirm password. ");
        getConfirmPassword().clear();
        getConfirmPassword().sendKeys(password);

        log.info("User checks agreement checkbox. ");
        agreeCheckBox().click();

        log.info("User clicks on the submit button. ");
        submitBtn().click();
    }
    private WebElement getSuccessCreatedMessage() {
        By successCreatedMessageLocator = By.cssSelector("#content h1");
        wait.until(ExpectedConditions.presenceOfElementLocated(successCreatedMessageLocator));
        return driver.findElement(successCreatedMessageLocator);
    }
    public boolean getAccountCreatedSuccessMessage() {
        try {
            log.info("User receives an success created message message. ");
            System.out.println(" =====> " +getSuccessCreatedMessage().getText()+ " <===== ");
            return getSuccessCreatedMessage().isDisplayed();
        } catch (TimeoutException y) {
            log.warn("Please provide another locator. ");
            return false;
        }
    }

    private WebElement getAlert() {
        By alertLocator = By.xpath("//div[contains(text(),'Password must be between 4 and 20 characters!')]");
        wait.until(ExpectedConditions.presenceOfElementLocated(alertLocator));
        return driver.findElement(alertLocator);
    }
    public boolean getAlertMessage() {
        try {
            log.info("User receives an alert message. ");
            System.out.println(" =====> " +getAlert().getText()+ " <===== ");
            return getAlert().isDisplayed();
        } catch (TimeoutException y) {
            log.warn("Please provide another locator. ");
            return false;
        }
    }

}

