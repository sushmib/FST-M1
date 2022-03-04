package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;


public class Activity4 {
    WebDriver driver;

    public void addEmployee() {
        WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(30));
        driver.get("http://alchemy.hguy.co/orangehrm");
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("orange");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("orangepassword123");
        driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='welcome']"))));
        driver.findElement(By.xpath("//*[@id=\"menu_pim_viewPimModule\"]/b")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("menu_pim_addEmployee"))));
        driver.findElement(By.id("menu_pim_addEmployee")).click();
//     fill required details
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Anusha");
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Reddy");
        //click on save
        driver.findElement(By.xpath("//input[@id='btnSave']")).click();
        driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("menu_pim_addEmployee"))));
        driver.findElement(By.id("empsearch_id")).sendKeys("Anusha");
        driver.findElement(By.id("searchBtn")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("//*[@id=\"resultTable\"]/tbody/tr/td[2]/a"))));
        WebElement we=driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td[2]/a"));
        System.out.println("Activity 4 executed successfully");
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