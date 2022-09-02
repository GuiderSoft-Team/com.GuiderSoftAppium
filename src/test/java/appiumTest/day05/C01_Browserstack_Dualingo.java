package appiumTest.day05;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class C01_Browserstack_Dualingo {
    String userName ="guidersoft_VpU1gf";
    String accessKey ="gGqzVpZqTg5DkonwStcD";

    @Test
    public void browserstackTest01() throws MalformedURLException {
        // Use Java Client v6.0.0 or above
        DesiredCapabilities capabilities = new DesiredCapabilities();
        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        browserstackOptions.put("buildName", "DualingoTest");
        browserstackOptions.put("sessionName", "CreateTest");
        browserstackOptions.put("acceptInsecureCerts", "true");
        browserstackOptions.put("debug", "true");
        browserstackOptions.put("networkLogs", "true");
        browserstackOptions.put("appiumLogs", "false");
        capabilities.setCapability("bstack:options", browserstackOptions);
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("platformVersion", "11.0");
        capabilities.setCapability("deviceName", "Samsung Galaxy M52");
        capabilities.setCapability("app", "bs://cff0ecf9c045be4d4b72fe7fb4b2f0242852e64e");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("https://" + userName + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub"), capabilities);
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement getStart = driver.findElement(By.id("com.duolingo:id/introFlowNewUserButton"));
        String getaText = getStart.getText();
        System.out.println("getaText = " + getaText);
        getStart.click();




        WebElement english = driver.findElement(By.xpath("//*[@text=\"English\"]"));
        english.click();

        driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Turkish\"));");


        WebElement turksh = driver.findElement(By.xpath("//*[@text=\"Turkish\"]"));
        turksh.click();

        WebElement willOk = driver.findElement(By.id("android:id/button1"));
        willOk.click();

        WebElement okul = driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"school\"]/android.widget.TextView"));
        okul.click();

        WebElement ciddi = driver.findElement(By.xpath("//*[@text=\"günde 15 dakika\"]"));
        ciddi.click();

        driver.findElement(By.id("com.duolingo:id/xpGoalContinueButton")).click();
        driver.findElement(By.id("com.duolingo:id/placementHeader")).click();

        WebElement testBasla = driver.findElement(By.id("com.duolingo:id/primaryButton"));
        Assert.assertTrue(testBasla.isDisplayed());
        System.out.println("testBasla.getText() = " + testBasla.getText());
        testBasla.click();

        WebElement skip = driver.findElement(By.id("com.duolingo:id/skipButton"));
        Assert.assertTrue(skip.isDisplayed());


    }
}
