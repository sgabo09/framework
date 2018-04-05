import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PracticeTest {
    WebDriver chrome = BrowserManager.getBrowser(BrowserType.CHROME);

    @Test
    public void login(){
        UserManager um = new UserManager();
        chrome.get("http://mindmegette.hu/bejelentkezes");
        chrome.findElement(By.cssSelector("span[class='button button-green medium i-agree']")).click();
        chrome.findElement(By.id("right-label")).sendKeys("somogyi.gabor");
        chrome.findElement(By.id("password")).sendKeys("gabo96");
        chrome.findElement(By.id("btnLoginSubmit")).click();
        chrome.findElement(By.cssSelector("a[class='button button-green with-icon edit']")).click();
        chrome.findElement(By.cssSelector("span[class='add dz-clickable']")).click();
        FileUploadManager.fileUploadWindow("D:\\MIK\\Szakdolgozat\\Project\\eatingkid.jpg");
    }
}
