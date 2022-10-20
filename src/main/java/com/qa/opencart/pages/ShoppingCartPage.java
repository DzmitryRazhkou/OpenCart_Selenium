package com.qa.opencart.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShoppingCartPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Logger log;
    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        log = Logger.getLogger(ShoppingCartPage.class);
    }

//    Shopping Cart Section:
    private WebElement getShoppingCartLink() {
        By shoppingCartLinkLocator = By.cssSelector("#content h1");
        wait.until(ExpectedConditions.presenceOfElementLocated(shoppingCartLinkLocator));
        return driver.findElement(shoppingCartLinkLocator);
    }
    public boolean getShoppingCartLinkValidate() {
        try {
            log.info(" =====> Shopping Cart Link has been displayed <===== ");
            System.out.println(" =====> " + getShoppingCartLink().getText() + " <===== ");
            return getShoppingCartLink().isDisplayed();
        } catch (TimeoutException y) {
            log.warn(" <=== !!! Please provide a right locator !!! ===> ");
            return false;
        }
    }

//    Validate Title Page:
    public String getShoppingCartPageTitle() {
        log.info("User validates the title page. ");
        System.out.println(" =====> My Shopping Cart Title Is: " + driver.getTitle() + " <===== ");
        return driver.getTitle();
    }

}
