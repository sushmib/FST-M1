package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity1 {
        WebDriver driver;

        @BeforeMethod
        public void beforeMethod() {
            //Create a new instance of the Firefox driver
            driver = new FirefoxDriver();
            //Open browser
            driver.get("http://alchemy.hguy.co/orangehrm");
        }

        @Test
        public void exampleTestCase() {
            // Check the title of the page
            String title = driver.getTitle();

            //Print the title of the page
            System.out.println("Page title is: " + title);
            //Assert.assertEquals("OrangeHRM", title);
            Assert.assertEquals(driver.getTitle(), "OrangeHRM");
        }

        @AfterMethod
        public void afterMethod() {
            //Close the browser
            driver.quit();
        }


}
