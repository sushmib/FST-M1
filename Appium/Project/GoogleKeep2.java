import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import static org.testng.Assert.assertTrue;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleKeep2 {

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

        String title = "Reminder Note Aditi ";
        String note = "This is my Test Note with Reminder";

        driver.findElementById("editable_title").sendKeys(title);
        driver.findElementById("edit_note_text").sendKeys(note);
        driver.findElementByAccessibilityId("Reminder").click();
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView[1]").click();
        driver.findElementByAccessibilityId("Open navigation drawer").click();
        String noteTitleFromGUI = driver.findElementById("index_note_title").getText();
        Assert.assertEquals(noteTitleFromGUI, title);
        MobileElement notewithReminder = driver.findElementById("reminder_chip_text");
        assertTrue(notewithReminder.isDisplayed());

    }

    @AfterClass
    public void tearDown() {
    //close the driver
        driver.quit();

    }
}