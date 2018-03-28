import org.junit.AfterClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PracticeTest {
    @Test
    public void google(){
        WebDriver chrome = BrowserManager.getBrowser(BrowserType.CHROME);
        chrome.get("https://google.hu");
    }

    @Test
    public void mozilla(){
        WebDriver firefox = BrowserManager.getBrowser(BrowserType.FIREFOX);
        firefox.get("https://index.hu");
    }

    @Test
    public void edge(){
        WebDriver edge = BrowserManager.getBrowser(BrowserType.EDGE);
        edge.get("https://microsoft.com");
    }

    @AfterClass
    public static void tearDown(){
        BrowserManager.closeBrowsers();
    }
}
