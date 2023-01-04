package com.qa.opencart.pages;

import com.qa.opencart.basepage.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

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

    public String getMyAccountPageTitle() {
        log.info("User validates the 'My Account Page' title page. ");
        System.out.println(" =====> My Account Page Title Is: " + driver.getTitle() + " <===== ");
        return driver.getTitle();
    }

//    My Account Edit Your Account Information Feature:

    private WebElement editYourAccountInformationLink() {
        By editYourAccountInformationLinkLocator = By.xpath(prop.getProperty("editYourAccountInformationLinkXpathLocator"));
        wait.until(ExpectedConditions.presenceOfElementLocated(editYourAccountInformationLinkLocator));
        return driver.findElement(editYourAccountInformationLinkLocator);
    }

    public void clickEditYourAccountInformation() {
        log.info("User clicks on the 'Edit Your Account Information'. ");
        editYourAccountInformationLink().click();
    }

    private WebElement firstNameFieldEditYourAccountInfo() {
        By firstNameFieldEditYourAccountInfoLocator = By.id(prop.getProperty("firstNameIdLocator"));
        wait.until(ExpectedConditions.presenceOfElementLocated(firstNameFieldEditYourAccountInfoLocator));
        return driver.findElement(firstNameFieldEditYourAccountInfoLocator);
    }

    private WebElement lastNameFieldEditYourAccountInfo() {
        By lastNameFieldEditYourAccountInfoLocator = By.id(prop.getProperty("lastNameIdLocator"));
        wait.until(ExpectedConditions.presenceOfElementLocated(lastNameFieldEditYourAccountInfoLocator));
        return driver.findElement(lastNameFieldEditYourAccountInfoLocator);
    }

    private WebElement emailFieldEditYourAccountInfo() {
        By emailFieldEditYourAccountInfoLocator = By.id(prop.getProperty("emailIdLocator"));
        wait.until(ExpectedConditions.presenceOfElementLocated(emailFieldEditYourAccountInfoLocator));
        return driver.findElement(emailFieldEditYourAccountInfoLocator);
    }

    private WebElement phoneFieldEditYourAccountInfo() {
        By phoneFieldEditYourAccountInfoLocator = By.id(prop.getProperty("phoneIdLocator"));
        wait.until(ExpectedConditions.presenceOfElementLocated(phoneFieldEditYourAccountInfoLocator));
        return driver.findElement(phoneFieldEditYourAccountInfoLocator);
    }

    public void editPersonalDetails(String firstName, String lastName, String email, String phone) {
        log.info("User clears the first name field. ");
        firstNameFieldEditYourAccountInfo().clear();
        log.info("User types the first name into first name field. ");
        firstNameFieldEditYourAccountInfo().sendKeys(firstName);
        log.info("User clears the last name field. ");
        lastNameFieldEditYourAccountInfo().clear();
        log.info("User types the last name into last name field. ");
        lastNameFieldEditYourAccountInfo().sendKeys(lastName);
        log.info("User clears the email field. ");
        emailFieldEditYourAccountInfo().clear();
        log.info("User types the email into email field. ");
        emailFieldEditYourAccountInfo().sendKeys(email);
        log.info("User clears the phone field. ");
        phoneFieldEditYourAccountInfo().clear();
        log.info("User types the phone into phone field. ");
        phoneFieldEditYourAccountInfo().sendKeys(phone);
    }

    private WebElement getSuccessYourAccountHasBeenSuccessfullyUpdated() {
        By getSuccessYourAccountHasBeenSuccessfullyUpdatedLocator = By.cssSelector(prop.getProperty("SuccessYourAccountHasBeenSuccessfullyUpdatedCssLocator"));
        wait.until(ExpectedConditions.presenceOfElementLocated(getSuccessYourAccountHasBeenSuccessfullyUpdatedLocator));
        return driver.findElement(getSuccessYourAccountHasBeenSuccessfullyUpdatedLocator);
    }

    public boolean validateSuccessYourAccountHasBeenSuccessfullyUpdated() {
        try {
            log.info(" =====> 'Success Your Account Has Been Successfully Updated' Link has been displayed <===== ");
            System.out.println(" =====> " + getSuccessYourAccountHasBeenSuccessfullyUpdated().getText() + " <===== ");
            return getSuccessYourAccountHasBeenSuccessfullyUpdated().isDisplayed();
        } catch (TimeoutException y) {
            log.warn(" <=== !!! Please provide a right locator !!! ===> ");
            return false;
        }
    }

//    Left/Right:

    private WebElement getBackBtn() {
        By getBackBtnLocator = By.xpath(prop.getProperty("backBtnXpathLocator"));
        wait.until(ExpectedConditions.presenceOfElementLocated(getBackBtnLocator));
        return driver.findElement(getBackBtnLocator);
    }

    private WebElement getContinueBtn() {
        By getContinueBtnLocator = By.xpath(prop.getProperty("continueBtnXpathLocator"));
        wait.until(ExpectedConditions.presenceOfElementLocated(getContinueBtnLocator));
        return driver.findElement(getContinueBtnLocator);
    }

    public void clickBackBtn() {
        log.info("User clicks on the Back Button. ");
        getBackBtn().click();
    }

    public void clickContinueBtn() {
        log.info("User clicks on the Continue Button. ");
        getContinueBtn().click();
    }

//    Change Your Password:

    private WebElement changeYourPasswordLink() {
        By changeYourPasswordLinkLocator = By.xpath(prop.getProperty("changeYourPasswordLinkXpathLocator"));
        wait.until(ExpectedConditions.presenceOfElementLocated(changeYourPasswordLinkLocator));
        return driver.findElement(changeYourPasswordLinkLocator);
    }

    public void clickChangeYourPassword() {
        log.info("User clicks on the 'Change Your Password'. ");
        changeYourPasswordLink().click();
    }

    private WebElement getPassword() {
        By getPasswordLocator = By.id(prop.getProperty("passwordIdLocator"));
        wait.until(ExpectedConditions.presenceOfElementLocated(getPasswordLocator));
        return driver.findElement(getPasswordLocator);
    }

    private WebElement getPasswordConfirm() {
        By getPasswordConfirmLocator = By.id(prop.getProperty("passwordConfirmIdLocator"));
        wait.until(ExpectedConditions.presenceOfElementLocated(getPasswordConfirmLocator));
        return driver.findElement(getPasswordConfirmLocator);
    }

    public void doChangePassword(String psw) {
        log.info("User enters password. ");
        getPassword().sendKeys(psw);
        log.info("User confirms password. ");
        getPasswordConfirm().sendKeys(psw);
    }

    private WebElement getSuccessYourPasswordHasBeenSuccessfullyUpdated() {
        By getSuccessYourAccountHasBeenSuccessfullyUpdatedLocator = By.cssSelector(prop.getProperty("SuccessYourAccountHasBeenSuccessfullyUpdatedCssLocator"));
        wait.until(ExpectedConditions.presenceOfElementLocated(getSuccessYourAccountHasBeenSuccessfullyUpdatedLocator));
        return driver.findElement(getSuccessYourAccountHasBeenSuccessfullyUpdatedLocator);
    }

    public boolean validateSuccessYourPasswordHasBeenSuccessfullyUpdated() {
        try {
            log.info(" =====> 'Success Your Password Has Been Successfully Updated' Link has been displayed <===== ");
            System.out.println(" =====> " + getSuccessYourPasswordHasBeenSuccessfullyUpdated().getText() + " <===== ");
            return getSuccessYourAccountHasBeenSuccessfullyUpdated().isDisplayed();
        } catch (TimeoutException y) {
            log.warn(" <=== !!! Please provide a right locator !!! ===> ");
            return false;
        }
    }

//    Modify Your Address Book Entries:

    private WebElement modifyYourAddressBookEntriesLink() {
        By modifyYourAddressBookEntriesLinkLocator = By.xpath(prop.getProperty("modifyYourAddressBookEntriesLinkXpathLocator"));
        wait.until(ExpectedConditions.presenceOfElementLocated(modifyYourAddressBookEntriesLinkLocator));
        return driver.findElement(modifyYourAddressBookEntriesLinkLocator);
    }

    public void clickModifyYourAddressBookEntries() {
        log.info("User clicks on the 'Modify Your Address Book Entries'. ");
        modifyYourAddressBookEntriesLink().click();
    }

    private WebElement getNewAddress() {
        By getNewAddressLocator = By.cssSelector(prop.getProperty("newAddressCssLocator"));
        wait.until(ExpectedConditions.presenceOfElementLocated(getNewAddressLocator));
        return driver.findElement(getNewAddressLocator);
    }

    private void scrollToWebElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void clickOnNewAddress() {
        log.debug("User scroll toward the 'New Address'. ");
        scrollToWebElement(getNewAddress());
        log.info("User clicks on the 'New Address'. ");
        getNewAddress().click();
    }

    private WebElement getFirstName() {
        By getFirstNameLocator = By.id(prop.getProperty("firstNameIdLocator"));
        wait.until(ExpectedConditions.presenceOfElementLocated(getFirstNameLocator));
        return driver.findElement(getFirstNameLocator);
    }

    private WebElement getLastName() {
        By getLastNameLocator = By.id(prop.getProperty("lastNameIdLocator"));
        wait.until(ExpectedConditions.presenceOfElementLocated(getLastNameLocator));
        return driver.findElement(getLastNameLocator);
    }

    private WebElement getCompany() {
        By getCompanyLocator = By.id(prop.getProperty("companyIdLocator"));
        wait.until(ExpectedConditions.presenceOfElementLocated(getCompanyLocator));
        return driver.findElement(getCompanyLocator);
    }

    private WebElement getAddressFirstLine() {
        By getAddressFirstLineLocator = By.id(prop.getProperty("addressFirstLineIdLocator"));
        wait.until(ExpectedConditions.presenceOfElementLocated(getAddressFirstLineLocator));
        return driver.findElement(getAddressFirstLineLocator);
    }

    private WebElement getAddressSecondLine() {
        By getAddressSecondLineLocator = By.id(prop.getProperty("addressSecondLineLocator"));
        wait.until(ExpectedConditions.presenceOfElementLocated(getAddressSecondLineLocator));
        return driver.findElement(getAddressSecondLineLocator);
    }

    private WebElement getCity() {
        By getCityLocator = By.id(prop.getProperty("cityIdLocator"));
        wait.until(ExpectedConditions.presenceOfElementLocated(getCityLocator));
        return driver.findElement(getCityLocator);
    }

    private WebElement getPostCode() {
        By getPostCodeLocator = By.id(prop.getProperty("postCodeIdLocator"));
        wait.until(ExpectedConditions.presenceOfElementLocated(getPostCodeLocator));
        return driver.findElement(getPostCodeLocator);
    }

    private void getCountry(String countryName) {
        By countryFieldLocator = By.cssSelector(prop.getProperty("countryCssLocator"));
        wait.until(ExpectedConditions.presenceOfElementLocated(countryFieldLocator));
        List<WebElement> list = driver.findElements(countryFieldLocator);
        for (WebElement s : list) {
            if (s.getText().equals(countryName)) {
                s.click();
                break;
            }
        }
    }

    private void getState(String state) {
        for (int retry = 0; retry < 5; retry++) {
            try {
                By stateFieldLocator = By.cssSelector(prop.getProperty("stateCssLocator"));
                wait.until(ExpectedConditions.presenceOfElementLocated(stateFieldLocator));
                List<WebElement> list = driver.findElements(stateFieldLocator);
                for (WebElement s : list) {
                    if (s.getText().equals(state)) {
                        s.click();
                        break;
                    }
                }
            } catch (StaleElementReferenceException y) {
                System.out.println(y.toString());
            }
        }
    }

    private WebElement getDefaultAddressRadioBtn() {
        By defaultAddressRadioBtnLocator = By.xpath(prop.getProperty("radioBtnXpathLocator"));
        wait.until(ExpectedConditions.presenceOfElementLocated(defaultAddressRadioBtnLocator));
        return driver.findElement(defaultAddressRadioBtnLocator);
    }

    public void doAddAddress(String firstName, String lastName, String company, String address1stLine, String address2ndLine, String city, String zipCode, String country, String state) {
        log.info("User enters a first name for adding new address. ");
        getFirstName().sendKeys(firstName);
        log.info("User enters a last name for adding new address. ");
        getLastName().sendKeys(lastName);
        log.info("User enters a company name for adding new address. ");
        getCompany().sendKeys(company);
        log.info("User enters a address first line for adding new address. ");
        getAddressFirstLine().sendKeys(address1stLine);
        log.info("User enters a address second line for adding new address. ");
        getAddressSecondLine().sendKeys(address2ndLine);
        log.info("User enters a city name for adding new address. ");
        getCity().sendKeys(city);
        log.info("User enters a zip code for adding new address. ");
        getPostCode().sendKeys(zipCode);
        log.info("User selects '" + country + "' from drop down menu of country list. ");
        getCountry(country);
        log.info("User selects '" + state + "' from drop down menu of states. ");
        getState(state);
        log.info("User checks radio button default address. ");
        getDefaultAddressRadioBtn().click();

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

    //    Log Out Feature:
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

