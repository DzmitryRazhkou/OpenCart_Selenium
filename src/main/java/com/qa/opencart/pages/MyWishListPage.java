package com.qa.opencart.pages;

import com.qa.opencart.basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class MyWishListPage extends BasePage {

    public MyWishListPage(WebDriver driver) {
        super(driver);
    }

    private List<String> getAddedWishList() {
        By wishListLocator = By.cssSelector("table[class='table table-bordered table-hover'] tr td:nth-of-type(2) a");
        wait.until(ExpectedConditions.visibilityOfElementLocated(wishListLocator));

        List<WebElement> wishList = driver.findElements(wishListLocator);
        List<String> wishListText = new ArrayList<>();

        for (WebElement s : wishList) {
            wishListText.add(s.getText());
        }
        log.info("User sees the wish list of the added product. ");
        System.out.println("\n =====> \nWish List: " + wishListText + "\n <===== \n");
        return wishListText;
    }

    public boolean validateWishList(String productName) {
        By wishListLocator = By.cssSelector("table[class='table table-bordered table-hover'] tr td:nth-of-type(2) a");
        wait.until(ExpectedConditions.presenceOfElementLocated(wishListLocator));
        List<String> list = getAddedWishList();
        for (String s : list) {
            if (s.contains(productName)) {
                System.out.println(" =====> " + s + " <===== ");
                log.info("The Added Product into wish list is included. ");
                return true;
            }
        }
        log.warn("The Added Product is absent!!! ");
        System.out.println("Provide another product");
        return false;
    }

    private WebElement getCartBtn() {
        By cartLocator = By.cssSelector("button[data-original-title='Add to Cart']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartLocator));
        return driver.findElement(cartLocator);


    }

    public void doAddToCartWishList(String productName) {
        By wishListLocator = By.cssSelector("table[class='table table-bordered table-hover'] tr td:nth-of-type(2) a");
        wait.until(ExpectedConditions.presenceOfElementLocated(wishListLocator));
        List<String> list = getAddedWishList();
        for (String s : list) {
            if (s.contains(productName)) {
                System.out.println(" =====> " + s + " <===== ");
                log.info("The Added Product into wish list is included. ");
                log.info("User clicks on the product. ");
                getCartBtn().click();
            } else {
                log.warn("The Added Product is absent!!! ");
                System.out.println("Provide another product");
            }
        }
    }

    private WebElement getRemoveBtn() {
        By removeLocator = By.cssSelector("a[data-original-title='Remove']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(removeLocator));
        return driver.findElement(removeLocator);


    }

    public void doRemoveFromCartWishList(String productName) {
        By wishListLocator = By.cssSelector("table[class='table table-bordered table-hover'] tr td:nth-of-type(2) a");
        wait.until(ExpectedConditions.presenceOfElementLocated(wishListLocator));
        List<String> list = getAddedWishList();
        for (String s : list) {
            if (s.contains(productName)) {
                System.out.println(" =====> " + s + " <===== ");
                log.info("The Added Product into wish list is included. ");
                log.info("User clicks on the product. ");
                getRemoveBtn().click();
            } else {
                log.warn("The Added Product is absent!!! ");
                System.out.println("Provide another product");
            }
        }
    }

//    Success Message:
    private WebElement getSuccessMessage() {
        By successMessageLocator = By.cssSelector("div[class='alert alert-success alert-dismissible']");
        wait.until(ExpectedConditions.presenceOfElementLocated(successMessageLocator));
        return driver.findElement(successMessageLocator);
    }

    public boolean getSuccessMessageValidate() {
        try {
            log.info(" =====> Success message has been displayed <===== ");
            System.out.println(" =====> " + getSuccessMessage().getText() + " <===== ");
            return getSuccessMessage().isDisplayed();
        } catch (TimeoutException y) {
            log.warn(" <=== !!! Please provide a right locator !!! ===> ");
            return false;
        }
    }
}
