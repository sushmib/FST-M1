package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity5 {
    WebDriver driver;


    @Test
    public void editInfo() throws InterruptedException {
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
        WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"menu_pim_viewMyDetails\"]/b"))));
        driver.findElement(By.xpath("//*[@id=\"menu_pim_viewMyDetails\"]/b")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.elementToBeClickable(By.id("btnSave"))));
        driver.findElement(By.id("btnSave")).click();
        wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(By.name("personal[txtEmpFirstName]"))));
        driver.findElement(By.name("personal[txtEmpFirstName]")).clear();
        driver.findElement(By.name("personal[txtEmpFirstName]")).sendKeys("Jerry");
        driver.findElement(By.name("personal[txtEmpLastName]")).clear();
        driver.findElement(By.name("personal[txtEmpLastName]")).sendKeys("Perry");
        driver.findElement(By.xpath("//*[@id=\"frmEmpPersonalDetails\"]/fieldset/ol[3]/li[1]/ul/li[1]/label")).click();
        Select country = new Select(driver.findElement(By.name("personal[cmbNation]")));
        country.selectByVisibleText("Indian");
        wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(By.className("ui-datepicker-trigger"))));
        driver.findElement(By.className("ui-datepicker-trigger")).click();
        Thread.sleep(2000);
        Select year = new Select(driver.findElement(By.className("ui-datepicker-year")));
        year.selectByVisibleText("1997");
        Thread.sleep(1000);
        Select month = new Select(driver.findElement(By.className("ui-datepicker-month")));
        month.selectByVisibleText("Dec");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[1]/a")).click();
        driver.findElement(By.id("btnSave")).click();
        System.out.println("Activity 5 executed successfully");
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
