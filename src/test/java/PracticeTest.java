import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PracticeTest {
    WebDriver chrome = BrowserManager.getBrowser(BrowserType.CHROME);

    @Rule
    public TestTracer testTracer = new TestTracer(chrome);

    @Test
    public void google(){
        UserManager um = new UserManager();
        chrome.get("http://mindmegette.hu");
        chrome.findElement(By.id("aaaaaaasasdasadsadsadsad"));
    }
/*
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
*/
    @AfterClass
    public static void cleanUp(){
        BrowserManager.closeBrowsers();
    }
}
