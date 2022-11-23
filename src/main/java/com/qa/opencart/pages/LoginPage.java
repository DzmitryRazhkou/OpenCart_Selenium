package com.qa.opencart.pages;

import com.qa.opencart.basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //    Login Section:
    private WebElement getLoginLink() {
        By loginLinkLocator = By.cssSelector("ul[class='breadcrumb'] li:last-of-type a");
        wait.until(ExpectedConditions.presenceOfElementLocated(loginLinkLocator));
        return driver.findElement(loginLinkLocator);
    }
    public boolean getLoginLinkValidate() {
        try {
            log.info(" =====> Login Link has been displayed <===== ");
            System.out.println(" =====> " + getLoginLink().getText() + " <===== ");
            return getLoginLink().isDisplayed();
        } catch (TimeoutException y) {
            log.warn(" <=== !!! Please provide a right locator !!! ===> ");
            return false;
        }
    }

    //    Validate Title Page:
    public String getLoginPageTitle() {
        log.info("User validates the title page. ");
        System.out.println(" =====> My Your Page Title Is: " + driver.getTitle() + " <===== ");
        return driver.getTitle();
    }

//    Login Feature:
    private WebElement getEmail() {
        By emailLocator = By.id("input-email");
        wait.until(ExpectedConditions.presenceOfElementLocated(emailLocator));
        return driver.findElement(emailLocator);
    }
    private WebElement getPassword() {
        By passwordLocator = By.id("input-password");
        wait.until(ExpectedConditions.presenceOfElementLocated(passwordLocator));
        return driver.findElement(passwordLocator);
    }
    private WebElement submitBtn() {
        By submitLocator = By.cssSelector("input[type='submit']");
        wait.until(ExpectedConditions.presenceOfElementLocated(submitLocator));
        return driver.findElement(submitLocator);
    }
    public MyAccountPage loginCorrectCredentials(String email, String password) {
        log.info("User types an email. ");
        getEmail().clear();
        getEmail().sendKeys(email);

        log.info("User types a password. ");
        getPassword().clear();
        getPassword().sendKeys(password);

        log.info("User clicks on the submit button. ");
        submitBtn().click();
        return new MyAccountPage(driver);
    }
    public void loginIncorrectCredentials(String email, String password) {
        log.info("User types an invalid email. ");
        getEmail().clear();
        getEmail().sendKeys(email);

        log.info("User types a invalid password. ");
        getPassword().clear();
        getPassword().sendKeys(password);

        log.info("User clicks on the submit button. ");
        submitBtn().click();
    }
    private WebElement getAlert() {
        By alertLocator = By.xpath("//div[contains(text(),' Warning')]");
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
    private WebElement getLogo() {
        By getLogoLocator = By.cssSelector("img[title='naveenopencart']");
        wait.until(ExpectedConditions.presenceOfElementLocated(getLogoLocator));
        return driver.findElement(getLogoLocator);
    }
    public YourStorePage returnToYourStorePage(){
        getLogo().click();
        return new YourStorePage(driver);
    }

}

