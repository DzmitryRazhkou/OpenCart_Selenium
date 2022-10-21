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

}

