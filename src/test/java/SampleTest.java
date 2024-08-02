// This sample code supports Appium Java client >=9
// https://github.com/appium/java-client

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class SampleTest {

    private AndroidDriver driver;

    private URL getUrl() {
        try {
            return new URL("http://127.0.0.1:4723");
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }
        @BeforeEach
        public void setUp() {
            var options = new DesiredCapabilities();
            options.setCapability("platformName", "Android");
            options.setCapability("appium:deviceName", "some name");
            options.setCapability("appium:appPackage", "ru.netology.testing.uiautomator");
            options.setCapability("appium:appActivity", ".MainActivity");
            options.setCapability("appium:automationName", "uiautomator2");
            options.setCapability("appium:ensureWebviewsHavePages", true);
            options.setCapability("appium:nativeWebScreenshot", true);
            options.setCapability("appium:newCommandTimeout", 3600);
            options.setCapability("appium:connectHardwareKeyboard", true);;

            driver = new AndroidDriver(this.getUrl(), options);
        }



    @Test
    public void sampleTest() {
        var el1 = driver.findElement(By.id("ru.netology.testing.uiautomator:id/userInput"));
        el1.isDisplayed();
        el1.click();
        el1.sendKeys("");
        var el2 = driver.findElement(By.id("ru.netology.testing.uiautomator:id/buttonChange"));
        el2.isDisplayed();
        el2.click();
        var el3 = driver.findElement(By.id("ru.netology.testing.uiautomator:id/textToBeChanged"));
        el3.isDisplayed();
        el3.click();
        Assertions.assertEquals("Hello UiAutomator!",el3.getText());
    }
    @Test
    public void sampleTest1() {
        var el1 = driver.findElement(By.id("ru.netology.testing.uiautomator:id/userInput"));
        el1.isDisplayed();
        el1.click();
        el1.sendKeys("test");
        var el2 = driver.findElement(By.id("ru.netology.testing.uiautomator:id/buttonActivity"));
        el2.isDisplayed();
        el2.click();


        var el5 = driver.findElement(By.id("ru.netology.testing.uiautomator:id/text"));

        el5.isDisplayed();
        Assertions.assertEquals("test",el5.getText());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
