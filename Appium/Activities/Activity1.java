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



public class Activity1 {

    // Declare Android driver

    AndroidDriver<MobileElement> driver;



    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Set the Desired Capabilities

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "appiumClass");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.calculator");
        caps.setCapability("appActivity", "com.android.calculator2.Calculator");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);

    }
    @Test
    public void add() {

        driver.findElementById("digit_5").click();
        driver.findElementByAccessibilityId("multiply").click();
        driver.findElementByXPath("//android.widget.Button[@text='9']").click();
        driver.findElementById("eq").click();
        String result = driver.findElement(MobileBy.id("result")).getText();
        System.out.println(result);

        // Assertion to check
        Assert.assertEquals(result, "45");
    }
    @AfterClass
    public void tearDown() {

    // Close app
        driver.quit();
    }



}