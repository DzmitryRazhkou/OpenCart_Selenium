package com.qa.opencart.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SearchPage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Logger log;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        log = Logger.getLogger(SearchPage.class);
    }

    //    Validate Title Page:
    public String getSearchPageTitle() {
        log.warn("User waits for loading search page. ");

        By searchLinkLocator = By.cssSelector("#content h1");
        wait.until(ExpectedConditions.presenceOfElementLocated(searchLinkLocator));

        log.info("User validates the title page. ");
        System.out.println(" =====> My Search Page Title Is: " + driver.getTitle() + " <===== ");
        return driver.getTitle();
    }

    private List<String> getSearchedProductList() {
        By productLocator = By.cssSelector("div[class='row'] div div div div div h4 a");
        wait.until(ExpectedConditions.visibilityOfElementLocated(productLocator));

        List<WebElement> listProducts = driver.findElements(productLocator);
        List<String> listOfProductsText = new ArrayList<>();

        for (WebElement s : listProducts) {
            System.out.println(s.getText());
            listOfProductsText.add(s.getText());
        }
        return listOfProductsText;
    }

    public void addToCartProduct(String productName) {
        By cartButtonLocator = By.cssSelector("div[class='row'] div div div div div div:nth-child(2):nth-child(2) button:nth-of-type(1):first-of-type");
        wait.until(ExpectedConditions.presenceOfElementLocated(cartButtonLocator));
        List<WebElement> cartList = driver.findElements(cartButtonLocator);

        List<String> list = getSearchedProductList();
        for (String set : list) {
            for (WebElement s : cartList) {
                if (set.contains(productName)) {
                    s.click();
                    break;
                } else {
                    System.out.println("Provide another product");
                }
            }
        }
    }

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
            System.out.println(" =====> " + dangerAlert().getText() + " <===== ");
            return dangerAlert().isDisplayed();
        } catch (TimeoutException y) {
            log.warn("Please provide another locator. ");
            return false;
        }
    }

}

