package hu.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class FacebookLogin {
    public FacebookLogin() {
    }

    public static void popUpLogin(String fb_email, String fb_password, WebDriver driver){
        String parentHandle = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        String currentHandle = driver.getWindowHandle();
        driver.findElement(By.id("email")).sendKeys(fb_email);
        driver.findElement(By.id("pass")).sendKeys(fb_password);
        driver.findElement(By.id("loginbutton")).click();
        driver.switchTo().window(parentHandle);
        if(driver.getWindowHandles().size()>1){
            driver.switchTo().window(currentHandle);
            driver.findElement(By.name("__CONFIRM__")).click();
            driver.switchTo().window(parentHandle);
        }
    }

    public static void siteLogin(String fb_email, String fb_password, WebDriver driver){
        driver.findElement(By.id("email")).sendKeys(fb_email);
        driver.findElement(By.id("pass")).sendKeys(fb_password);
        driver.findElement(By.id("loginbutton")).click();
    }
}
