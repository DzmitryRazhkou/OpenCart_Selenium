package com.qa.opencart.basetest;

import com.qa.opencart.browser.BrowserFactory;
import com.qa.opencart.enums.Browsers;
import com.qa.opencart.utils.ConfigReader;
import com.qa.opencart.utils.ScreenShot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.util.Properties;

@Listeners(com.qa.opencart.listeners.Listeners.class)
public class BaseTest {
    protected WebDriver driver;
    protected Properties prop;

    @Parameters({"browser"})
    @BeforeMethod
    public void startUp(String browser) throws MalformedURLException {
        prop = ConfigReader.initProp();
        Browsers browserType = browser.equalsIgnoreCase("chrome") ? Browsers.CHROME: Browsers.FIREFOX;
        driver = BrowserFactory.getBrowser(browserType);
        driver.get(prop.getProperty("url"));
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.FAILURE == result.getStatus()) {
            ScreenShot.takeScreenshot(driver, result.getTestName());
        }
        driver.quit();
    }
}
