import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PracticeTest {

    @Test
    public void google(){
        UserManager um = new UserManager();
        System.out.println(um.getUser("pali").getEmail() + " " + um.getUser("pali").getPassword());
        System.out.println(um.getUserEmail("pali") + " " + um.getUserPassword("pali"));
        WebDriver chrome = BrowserManager.getBrowser(BrowserType.CHROME);
        chrome.get("http://mindmegette.hu");
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
