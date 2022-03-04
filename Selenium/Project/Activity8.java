package org.example;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

import java.time.Duration;

public class Activity8 {
    WebDriver driver;

    @Test
    public void applyingForLeave() throws InterruptedException {
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@id=\"menu_dashboard_index\"]/b")).click();
        driver.findElement(By.xpath("//*[@id=\"dashboard-quick-launch-panel-menu_holder\"]/table/tbody/tr/td[4]/div/a/img")).click();
        Select drpCountry = new Select(driver.findElement(By.id("applyleave_txtLeaveType")));
        drpCountry.selectByVisibleText("privilege leaves");

        //From date selected
        driver.findElement(By.xpath("//*[@id=\"frmLeaveApply\"]/fieldset/ol/li[3]/img")).click();

        Select year = new Select(driver.findElement(By.className("ui-datepicker-year")));
        year.selectByVisibleText("2021");
        Select month = new Select(driver.findElement(By.className("ui-datepicker-month")));
        month.selectByVisibleText("Oct");
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[1]/a")).click();

        //To date selected
        driver.findElement(By.xpath("//*[@id=\"frmLeaveApply\"]/fieldset/ol/li[4]/img")).click();
        Select year1 = new Select(driver.findElement(By.className("ui-datepicker-year")));
        year1.selectByVisibleText("2021");
        Select month1 = new Select(driver.findElement(By.className("ui-datepicker-month")));
        month1.selectByVisibleText("Oct");
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[1]/a")).click();
        Select country = new Select(driver.findElement(By.id("applyleave_duration_duration")));
        country.selectByVisibleText("Full Day");
        driver.findElement(By.id("applyBtn")).click();
        driver.findElement(By.id("menu_leave_viewMyLeaveList")).click();
        //From date selected
        driver.findElement(By.xpath("//*[@id=\"frmFilterLeave\"]/fieldset/ol/li[1]/img")).click();
        Select year2 = new Select(driver.findElement(By.className("ui-datepicker-year")));
        year2.selectByVisibleText("2021");
        Select month2 = new Select(driver.findElement(By.className("ui-datepicker-month")));
        month2.selectByVisibleText("Oct");

        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[1]/a")).click();

        //To date selected
        driver.findElement(By.xpath("//*[@id=\"frmFilterLeave\"]/fieldset/ol/li[2]/img")).click();
        Select year3 = new Select(driver.findElement(By.className("ui-datepicker-year")));
        year3.selectByVisibleText("2021");
        Select month3 = new Select(driver.findElement(By.className("ui-datepicker-month")));
        month3.selectByVisibleText("Oct");
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[1]/a")).click();
        driver.findElement(By.id("btnSearch")).click();

        System.out.println("Activity 8 executed successfully");

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