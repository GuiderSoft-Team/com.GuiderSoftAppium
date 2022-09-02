package appiumTest.day05;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class C03_RealDevicesTest {
    @Test
    public void realDevicesTest01() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "4100312e447491a3");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0.1");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Mehmet\\Desktop\\GuiderSoft Gün Package\\com.GuiderSoftAppium\\src\\app\\apidemos.apk");
        // ! Yukarıdaki path i kendinize göre ayarlayınız.
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http:127.0.0.1:4723/wd/hub"), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Views\"));");
        WebElement views=driver.findElementByAccessibilityId("Views");
        views.click();

        //WebView2
        driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView2\"));");

        driver.findElementByAccessibilityId("WebView2").click();

        driver.findElement(By.xpath("//android.view.View[@content-desc=\"i am a link\"]")).click();
    }
}
