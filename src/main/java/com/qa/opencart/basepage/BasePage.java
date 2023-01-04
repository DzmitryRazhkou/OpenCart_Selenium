package com.qa.opencart.basepage;

import com.qa.opencart.pages.CheckOutPage;
import com.qa.opencart.utils.ConfigReader;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Properties;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Logger log;
    protected Properties prop;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        log = Logger.getLogger(CheckOutPage.class);
        prop = ConfigReader.initProp();
    }
}
