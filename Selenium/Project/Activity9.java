package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Activity9 {
    WebDriver driver;

    @Test
    public void emergencyContacts(){
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        Actions actions = new Actions(driver);
        WebElement mainMenu = driver.findElement(By.xpath("//*[@id=\"sidenav\"]/li[3]/a"));
        actions.moveToElement(mainMenu);
        mainMenu.click();
        List<WebElement> allRows = driver.findElements(By.id("emgcontact_list"));
        for (WebElement row : allRows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            for (WebElement cell : cells) {
                System.out.println(cell.getText());
            }
        }
        System.out.println("Activity 9 executed successfully");
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