package appiumTest.day05;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class C01_Browserstack_Dualingo01 {
    public static String userName ="guidersoft_VpU1gf";
    public static String accessKey ="gGqzVpZqTg5DkonwStcD";
    @Test
    public void browserTest01() throws MalformedURLException, InterruptedException {

        // Use Java Client v6.0.0 or above
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("platformVersion", "12.0");
        capabilities.setCapability("deviceName", "Samsung Galaxy S22 Ultra");
        capabilities.setCapability("app", "bs://cff0ecf9c045be4d4b72fe7fb4b2f0242852e64e");
        // AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http:127.0.0.1:4723/wd/hub"), desiredCapabilities);
      //  AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), capabilities);
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), capabilities);
        WebElement getStart= driver.findElement(By.id("com.duolingo:id/introFlowNewUserButton"));
        String getaText=getStart.getText();
        System.out.println("getaText = " + getaText);
        getStart.click();


        WebElement english=driver.findElement(By.xpath("//*[@text=\"English\"]"));
        english.click();
        // TouchAction touchAction=new TouchAction(driver);
        Thread.sleep(5000);
     /*   TouchAction touchAction = new TouchAction(driver);

        touchAction.longPress(PointOption.point(843, 1645))
                .moveTo(PointOption.point(868, 466))
                .release()
                .perform();
/*(new TouchAction(driver))
  .press(PointOption.point(843, 1645}))
  .moveTo(PointOption.point(868, 466}))
  .release()
  .perform();*/




        WebElement turksh=driver.findElement(By.xpath("//*[@text=\"Turkish\"]"));
        turksh.click();

        WebElement willOk=driver.findElement(By.id("android:id/button1"));
        willOk.click();

        WebElement okul=driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"school\"]/android.widget.TextView"));
        okul.click();

        WebElement ciddi= driver.findElement(By.xpath("//*[@text=\"günde 15 dakika\"]"));
        ciddi.click();

        driver.findElement(By.id("com.duolingo:id/xpGoalContinueButton")).click();
        driver.findElement(By.id("com.duolingo:id/placementHeader")).click();

        WebElement testBasla=driver.findElement(By.id("com.duolingo:id/primaryButton"));
        Assert.assertTrue(testBasla.isDisplayed());
        System.out.println("testBasla.getText() = " + testBasla.getText());
        testBasla.click();

        WebElement skip=driver.findElement(By.id("com.duolingo:id/skipButton"));
        Assert.assertTrue(skip.isDisplayed());

    }
}
