import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class PracticeTest {
    @Test
    public void google(){
        WebDriver chrome = BrowserManager.getBrowser(Browsers.CHROME);
        chrome.get("https://google.hu");
    }

    @Test
    public void mozilla() {
        WebDriver firefox = BrowserManager.getBrowser(Browsers.FIREFOX);
        firefox.get("https://mozilla.com");
    }

    @Test
    public void microsoft(){
        WebDriver edge = BrowserManager.getBrowser(Browsers.EDGE);
        edge.get("https://microsoft.com");
    }

    @AfterClass
    public static void tearDown(){
        BrowserManager.closeBrowsers();
    }
}
