package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity7 {
    WebDriver driver;

    @Test
    public void addQualification() throws InterruptedException {
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@id='menu_pim_viewMyDetails']/b")).click();
        WebElement qualificationElement = driver.findElement(By.xpath("//ul[@id='sidenav']/li[9]/a[contains(text(), 'Qualifications')]"));

        qualificationElement.click();
        driver.findElement(By.xpath("//input[@id='addWorkExperience']")).click();
        driver.findElement(By.xpath("//input[@id=\"experience_employer\"]")).sendKeys("IBM");
        driver.findElement(By.xpath("//input[@id=\"experience_jobtitle\"]")).sendKeys("Software Testing");
        driver.findElement(By.xpath("//input[@id=\"btnWorkExpSave\"]")).click();
        System.out.println("Activity 7 executed successfully");
    }

    @BeforeMethod
    public void beforeMethod() {
        driver=new FirefoxDriver();
        driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login");
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();

    }
}