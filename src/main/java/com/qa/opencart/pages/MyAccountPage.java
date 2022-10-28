package com.qa.opencart.pages;

import com.qa.opencart.basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyAccountPage extends BasePage {

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

//    My Account Section:
    private WebElement getMyAccountLink() {
        By myAccountLinkLocator = By.cssSelector("#content h2:first-of-type");
        wait.until(ExpectedConditions.presenceOfElementLocated(myAccountLinkLocator));
        return driver.findElement(myAccountLinkLocator);
    }

    public boolean getMyAccountValidate() {
        try {
            log.info(" =====> My Account Link has been displayed <===== ");
            System.out.println(" =====> " + getMyAccountLink().getText() + " <===== ");
            return getMyAccountLink().isDisplayed();
        } catch (TimeoutException y) {
            log.warn(" <=== !!! Please provide a right locator !!! ===> ");
            return false;
        }
    }

    private WebElement getMyAccount() {
        By myAccountLocator = By.cssSelector("a[title='My Account']");
        wait.until(ExpectedConditions.presenceOfElementLocated(myAccountLocator));
        return driver.findElement(myAccountLocator);
    }

    private WebElement getLogOutButton() {
        By registerButtonLocator = By.cssSelector("ul[class='dropdown-menu dropdown-menu-right'] li:last-of-type");
        wait.until(ExpectedConditions.presenceOfElementLocated(registerButtonLocator));
        return driver.findElement(registerButtonLocator);
    }

    public void logOut() {
        log.info("User clicks on the my account button. ");
        getMyAccount().click();
        log.info("User clicks on the log out button. ");
        getLogOutButton().click();
    }

    private WebElement getAccountLogOut() {
        By accountLogOutLocator = By.cssSelector("#content h1");
        wait.until(ExpectedConditions.presenceOfElementLocated(accountLogOutLocator));
        return driver.findElement(accountLogOutLocator);
    }

    public boolean getAccountLogOutValidate() {
        try {
            log.info(" =====> Account Log Out Link has been displayed <===== ");
            System.out.println(" =====> " + getAccountLogOut().getText() + " <===== ");
            return getAccountLogOut().isDisplayed();
        } catch (TimeoutException y) {
            log.warn(" <=== !!! Please provide a right locator !!! ===> ");
            return false;
        }
    }

}

