import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleTasks {



// Declare Android driver

    WebDriverWait wait;
    AndroidDriver<MobileElement> driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {

// Set the Desired Capabilities

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("deviceName", "appiumClass");

        caps.setCapability("platformName", "Android");

        caps.setCapability("automationName", "UiAutomator2");

        caps.setCapability("appPackage", "com.google.android.apps.tasks");

        caps.setCapability("appActivity", ".ui.TaskListsActivity");

        caps.setCapability("noReset", true);



// Instantiate Appium Driver

        URL appServer = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver<MobileElement>(appServer, caps);

        wait = new WebDriverWait(driver, 10);

    }



    @Test

    public void googleTasks() {

// click on new task

        driver.findElementByXPath("//android.widget.LinearLayout[@content-desc='New list']").click();

//add three activities

        String task1 = "Complete Activity with Google Tasks";
        String task2 = "Complete Activity with Google Keep";
        String task3 = "Complete the second Activity Google Keep";
        String taskNameFromGUI = "";

        driver.findElementById("edit_list_title").sendKeys(task1);
        driver.findElementById("done_button").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.widget.LinearLayout[@content-desc='"+task1+"']")));
        taskNameFromGUI = driver.findElementByXPath("//android.widget.LinearLayout[@content-desc='Complete Activity with Google Tasks']/android.widget.TextView").getText();

// Assertion

        Assert.assertEquals(taskNameFromGUI, task1);
        driver.findElementByAccessibilityId("New list").click();
        driver.findElementById("edit_list_title").sendKeys(task2);
        driver.findElementById("done_button").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.widget.LinearLayout[@content-desc='"+task2+"']")));
        taskNameFromGUI = driver.findElementByXPath("//android.widget.LinearLayout[@content-desc='Complete Activity with Google Keep']/android.widget.TextView").getText();

// Assertion

        Assert.assertEquals(taskNameFromGUI, task2);
        driver.findElementByAccessibilityId("New list").click();
        driver.findElementById("edit_list_title").sendKeys(task3);
        driver.findElementById("done_button").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.widget.LinearLayout[@content-desc='"+task3+"']")));
        taskNameFromGUI = driver.findElementByXPath("//android.widget.LinearLayout[@content-desc='Complete second activity with Google tasks']/android.widget.TextView").getText();

// Assertion

        Assert.assertEquals(taskNameFromGUI, task3);

    }
    @AfterClass
    public void tearDown() {

// Close app

        driver.quit();

    }

}