package com.qa.opencart.pages;

import com.qa.opencart.basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckOutPage extends BasePage {

    public CheckOutPage(WebDriver driver) {
        super(driver);
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

}
