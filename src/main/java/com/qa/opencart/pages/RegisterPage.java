package com.qa.opencart.pages;

import com.qa.opencart.basepage.BasePage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterPage extends BasePage {
    public RegisterPage(WebDriver driver) {
        super(driver);
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

    public String generateString(int lengthOfString){
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:'\",<.>/?";
        String psd = RandomStringUtils.random( lengthOfString, characters );
        System.out.println( psd );
        return psd;
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
    public void doRegisterUnmatchedPsw(String first, String last, String email, String password, String passwordConfirm, String phone) {
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
        getConfirmPassword().sendKeys(passwordConfirm);

        log.info("User checks agreement checkbox. ");
        agreeCheckBox().click();

        log.info("User clicks on the submit button. ");
        submitBtn().click();
    }
    public void doRegisterWithoutAgreementPolicy(String first, String last, String email, String password, String phone) {
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
        By alertLocator = By.cssSelector("div[class='text-danger']");
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

    private WebElement getWarningAlert() {
        By warningAlertLocator = By.cssSelector("div[class='alert alert-danger alert-dismissible']");
        wait.until(ExpectedConditions.presenceOfElementLocated(warningAlertLocator));
        return driver.findElement(warningAlertLocator);
    }
    public boolean getWarningAlertMessage() {
        try {
            log.info("User receives an warning message. ");
            System.out.println(" =====> " +getWarningAlert().getText()+ " <===== ");
            return getWarningAlert().isDisplayed();
        } catch (TimeoutException y) {
            log.warn("Please provide another locator. ");
            return false;
        }
    }

//    Forgotten Password:
    private WebElement getForgottenPassword() {
        By forgottenPasswordLocator = By.cssSelector("div[class='list-group'] a:nth-of-type(3)");
        wait.until(ExpectedConditions.presenceOfElementLocated(forgottenPasswordLocator));
        return driver.findElement(forgottenPasswordLocator);
    }
    public void clickOnTheForgottenPassword(){
        log.info("User clicks on the forgotten password section.");
        getForgottenPassword().click();
    }
    private WebElement getForgottenPasswordLink() {
        By forgottenPasswordLocator = By.cssSelector("#content h1");
        wait.until(ExpectedConditions.presenceOfElementLocated(forgottenPasswordLocator));
        return driver.findElement(forgottenPasswordLocator);
    }
    public boolean getForgottenPasswordLinkValidate() {
        try {
            log.info(" =====> Forgotten Password Link has been displayed <===== ");
            System.out.println(" =====> " + getForgottenPasswordLink().getText() + " <===== ");
            return getForgottenPasswordLink().isDisplayed();
        } catch (TimeoutException y) {
            log.warn(" <=== !!! Please provide a right locator !!! ===> ");
            return false;
        }
    }
    private WebElement getEmailAddressForgottenField() {
        By emailAddressForgottenFieldLocator = By.id("input-email");
        wait.until(ExpectedConditions.presenceOfElementLocated(emailAddressForgottenFieldLocator));
        return driver.findElement(emailAddressForgottenFieldLocator);
    }
    private WebElement getContinueBtn() {
        By continueBtnLocator = By.cssSelector("input[type='submit']");
        wait.until(ExpectedConditions.presenceOfElementLocated(continueBtnLocator));
        return driver.findElement(continueBtnLocator);
    }
    public void sendEmailForPassword(String email){
        log.warn("User types email for sending a new password. ");
        getEmailAddressForgottenField().sendKeys(email);
        log.info("User clicks on the 'Continue' button. ");
        getContinueBtn().click();
    }
    private WebElement getSuccessAlert() {
        By successAlertLocator = By.cssSelector("div[class='alert alert-success alert-dismissible']");
        wait.until(ExpectedConditions.presenceOfElementLocated(successAlertLocator));
        return driver.findElement(successAlertLocator);
    }
    public boolean getSuccessAlertMessage() {
        try {
            log.info("User receives an success message. ");
            System.out.println(" =====> " +getSuccessAlert().getText()+ " <===== ");
            return getSuccessAlert().isDisplayed();
        } catch (TimeoutException y) {
            log.warn("Please provide another locator. ");
            return false;
        }
    }

}

