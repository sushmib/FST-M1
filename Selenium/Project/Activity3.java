package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();

        //Open browser
        driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login");
    }

    @Test
    public void loginTest() {
        //Find the username and password fields
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));

        //Enter credentials
        username.sendKeys("orange");
        password.sendKeys("orangepassword123");

        //Click login
        driver.findElement(By.xpath("//button[text()='LOGIN']")).click();

        //Read login message
        String loginMessage = driver.findElement(By.id("welcome")).getText();
        Assert.assertEquals("Welcome Reeta", loginMessage);
    }

    @AfterClass
    public void afterClass() {
        //Close browser
        driver.close();
    }
}
