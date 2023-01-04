package com.qa.opencart.testng;

import com.qa.opencart.test.LoginPageTest;
import org.testng.TestNG;

public class TestRunner {
    static TestNG testNG;

    public static void main(String[] args) {
        testNG = new TestNG();
        testNG.setTestClasses(new Class[] {LoginPageTest.class});
        testNG.run();
    }
}
