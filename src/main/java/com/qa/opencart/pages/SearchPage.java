package com.qa.opencart.pages;

import com.qa.opencart.basepage.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends BasePage {
    public SearchPage(WebDriver driver) {
        super(driver);
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

    //    Product List:
    private List<String> getSearchedProductList() {
        By productLocator = By.cssSelector("div[class='row'] div div div div div h4 a");
        wait.until(ExpectedConditions.visibilityOfElementLocated(productLocator));

        List<WebElement> listProducts = driver.findElements(productLocator);
        List<String> listOfProductsText = new ArrayList<>();

        for (WebElement s : listProducts) {
            listOfProductsText.add(s.getText());
        }
        log.info("User sees the list of the product. ");
        System.out.println("\n =====> \nProduct List: " + listOfProductsText + "\n <===== \n");
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

    //    Wish List:
    public void addToWishList(String productName) {
        By wishButtonLocator = By.cssSelector("div[class='row'] div div div div div button:nth-of-type(2)");
        wait.until(ExpectedConditions.presenceOfElementLocated(wishButtonLocator));
        List<WebElement> wishBtnList = driver.findElements(wishButtonLocator);

        List<String> list = getSearchedProductList();
        for (String set : list) {
            for (WebElement s : wishBtnList) {
                if (set.contains(productName)) {
                    s.click();
                    break;
                } else {
                    System.out.println("Provide another product");
                }
            }
        }
    }

    private WebElement clickWishList() {
        By wishListLocator = By.cssSelector("div[class='alert alert-success alert-dismissible'] a:last-of-type");
        wait.until(ExpectedConditions.presenceOfElementLocated(wishListLocator));
        return driver.findElement(wishListLocator);
    }

    public MyWishListPage doClickWishList() {
        log.info("User clicks in the wish list into success message");
        clickWishList().click();
        log.info("User navigates on the my wish page. ");
        return new MyWishListPage(driver);
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

    //    Proceed To CheckOut:
    private void customWait(By by) {
        for (int i = 0; i < 100; i++) {
            try {
                driver.findElement(by);
            } catch (NoSuchElementException yy) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ignored) {
                }
            }
        }
    }

    private WebElement getCart() {
        By cartLocator = By.cssSelector("#cart");
        wait.until(ExpectedConditions.elementToBeClickable(cartLocator));
        return driver.findElement(cartLocator);
    }

    private WebElement getCheckOuBtn() {
        By checkOuBtnLocator = By.cssSelector("p[class='text-right'] a:last-of-type");
        wait.until(ExpectedConditions.presenceOfElementLocated(checkOuBtnLocator));
        return driver.findElement(checkOuBtnLocator);
    }

    public ShoppingCartPage doClickOnTheCheckOut() {
        log.warn(" =====>  Custom Waiter <===== ");
        customWait(By.id("cart"));
        log.info("User clicks on the cart. ");
        getCart().click();
        log.warn(" =====>  Custom Waiter <===== ");
        customWait(By.cssSelector("p[class='text-right'] a:last-of-type"));
        log.info("User clicks on the checkout button. ");
        getCheckOuBtn().click();
        return new ShoppingCartPage(driver);
    }
}

