package com.qa.opencart.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckOutPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Logger log;
    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        log = Logger.getLogger(CheckOutPage.class);
    }

//    Check Out Section:
    private WebElement getCheckOutLink() {
        By checkOutLinkLocator = By.cssSelector("#content h1");
        wait.until(ExpectedConditions.presenceOfElementLocated(checkOutLinkLocator));
        return driver.findElement(checkOutLinkLocator);
    }
    public boolean getCheckOutLinkValidate() {
        try {
            log.info(" =====> Check Out Link has been displayed <===== ");
            System.out.println(" =====> " + getCheckOutLink().getText() + " <===== ");
            return getCheckOutLink().isDisplayed();
        } catch (TimeoutException y) {
            log.warn(" <=== !!! Please provide a right locator !!! ===> ");
            return false;
        }
    }

//    Validate Title Page:
    public String getCheckOutPageTitle() {
        log.info("User validates the title page. ");
        System.out.println(" =====> My Shopping Cart Title Is: " + driver.getTitle() + " <===== ");
        return driver.getTitle();
    }

}
