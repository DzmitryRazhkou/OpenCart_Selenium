package com.qa.opencart.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShoppingCartPage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Logger log;

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

    //    Billing Details:
    private WebElement getFirstName() {
        By firstNameLocator = By.id("input-payment-firstname");
        wait.until(ExpectedConditions.presenceOfElementLocated(firstNameLocator));
        return driver.findElement(firstNameLocator);
    }

    private WebElement getLastName() {
        By lastNameLocator = By.id("input-payment-lastname");
        wait.until(ExpectedConditions.presenceOfElementLocated(lastNameLocator));
        return driver.findElement(lastNameLocator);
    }

    private WebElement getCompany() {
        By companyLocator = By.id("input-payment-company");
        wait.until(ExpectedConditions.presenceOfElementLocated(companyLocator));
        return driver.findElement(companyLocator);
    }

    private WebElement getAddressFirst() {
        By addressFirstLocator = By.id("input-payment-address-1");
        wait.until(ExpectedConditions.presenceOfElementLocated(addressFirstLocator));
        return driver.findElement(addressFirstLocator);
    }

    private WebElement getAddressSecond() {
        By addressSecondLocator = By.id("input-payment-address-2");
        wait.until(ExpectedConditions.presenceOfElementLocated(addressSecondLocator));
        return driver.findElement(addressSecondLocator);
    }

    private WebElement getCity() {
        By cityLocator = By.id("input-payment-city");
        wait.until(ExpectedConditions.presenceOfElementLocated(cityLocator));
        return driver.findElement(cityLocator);
    }

    private WebElement getZip() {
        By zipLocator = By.id("input-payment-postcode");
        wait.until(ExpectedConditions.presenceOfElementLocated(zipLocator));
        return driver.findElement(zipLocator);
    }

    private void getCountry(String countryName) {
        By countryLocator = By.id("input-payment-country");
        wait.until(ExpectedConditions.presenceOfElementLocated(countryLocator));
        WebElement country = driver.findElement(countryLocator);
        country.click();
        Select select = new Select(country);
        select.selectByVisibleText(countryName);
    }

    private void getState(String stateName) {
        By stateLocator = By.id("input-payment-zone");
        wait.until(ExpectedConditions.presenceOfElementLocated(stateLocator));
        WebElement state = driver.findElement(stateLocator);
        state.click();
        Select select = new Select(state);
        select.selectByVisibleText(stateName);
    }

    private WebElement continueBtn() {
        By continueBtnLocator = By.cssSelector("input[value='Continue']");
        wait.until(ExpectedConditions.presenceOfElementLocated(continueBtnLocator));
        return driver.findElement(continueBtnLocator);
    }
    private WebElement getExistingAddressRadio() {
        By newAddressRadioLocator = By.xpath("(//div[@class='radio'])[1]/label/input");
        wait.until(ExpectedConditions.presenceOfElementLocated(newAddressRadioLocator));
        return driver.findElement(newAddressRadioLocator);
    }
    private WebElement getNewAddressRadio() {
        By newAddressRadioLocator = By.xpath("(//div[@class='radio'])[2]/label/input");
        wait.until(ExpectedConditions.presenceOfElementLocated(newAddressRadioLocator));
        return driver.findElement(newAddressRadioLocator);
    }
    private void customWait(By by) {;
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
    public void existingAddressRadio(){
        customWait(By.xpath("(//div[@class='radio'])[1]/label/input"));
        getExistingAddressRadio().click();
        continueExistButton().click();
    }
    public void newAddressRadio(){
        customWait(By.xpath("(//div[@class='radio'])[2]/label/input"));
        getNewAddressRadio().click();
    }

    private void scrollToElement() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)", "");
    }

    public void doFillUpBillingDetails(String firstName, String lastName, String company, String address1, String address2, String city, String zip, String country, String state) {
        log.info("User types the first name. ");
        getFirstName().sendKeys(firstName);
        log.info("User types the last name. ");
        getLastName().sendKeys(lastName);
        log.info("User types the company's name. ");
        getCompany().sendKeys(company);
        log.info("User types the first lina address. ");
        getAddressFirst().sendKeys(address1);
        log.info("User types the second lina address. ");
        getAddressSecond().sendKeys(address2);
        log.info("User types the city name. ");
        getCity().sendKeys(city);
        log.info(" =====> Scroll To Element <===== ");
        scrollToElement();
        log.info("User types the zip. ");
        getZip().sendKeys(zip);
        log.info("User types the country name. ");
        getCountry(country);
        log.info("User types the state name. ");
        getState(state);
        log.info("User clicks the the continue button. ");
        continueBtn().click();
    }

    private WebElement addComments(){
        By addCommentsLocator = By.cssSelector("textarea[name='comment']");
        wait.until(ExpectedConditions.presenceOfElementLocated(addCommentsLocator));
        return driver.findElement(addCommentsLocator);
    }
    private WebElement termsAndConditions(){
        By termsAndConditionsLocator = By.cssSelector("textarea[name='comment']");
        wait.until(ExpectedConditions.presenceOfElementLocated(termsAndConditionsLocator));
        return driver.findElement(termsAndConditionsLocator);
    }
    private WebElement continueButton(){
        By termsAndConditionsLocator = By.cssSelector("input[id='button-payment-method']");
        wait.until(ExpectedConditions.presenceOfElementLocated(termsAndConditionsLocator));
        return driver.findElement(termsAndConditionsLocator);
    }
    private WebElement continueExistButton(){
        By continueExistButtonLocator = By.cssSelector("input[id='button-payment-address']");
        wait.until(ExpectedConditions.presenceOfElementLocated(continueExistButtonLocator));
        return driver.findElement(continueExistButtonLocator);
    }

    public void paymentMethod(String comments){
        log.info("User enters the comments. ");
        addComments().sendKeys(comments);
        log.info("User checks the terms and conditions. ");
        termsAndConditions().click();
        log.info("User clicks on the continue button. ");
        continueButton().click();
    }
}
