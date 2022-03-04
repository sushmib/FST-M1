import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
public class GoogleKeep1 {

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
        caps.setCapability("appPackage", "com.google.android.keep");
        caps.setCapability("appActivity", ".activities.BrowseActivity");
        caps.setCapability("noReset", true);

// Instantiate Appium Driver

        URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 10);

    }
    @Test
    public void googleKeep() {

// click on new task

        driver.findElementByAccessibilityId("New text note").click();

        String title = "New Note Aditi";
        String note = "This is my Test Note";

        driver.findElementById("editable_title").sendKeys(title);
        driver.findElementById("edit_note_text").sendKeys(note);
        driver.findElementByAccessibilityId("Open navigation drawer").click();
        String noteTitleFromGUI = driver.findElementById("index_note_title").getText();

// Assert validation

        Assert.assertEquals(noteTitleFromGUI, title);

    }

    @AfterClass

    public void tearDown() {

        driver.quit();

    }



}