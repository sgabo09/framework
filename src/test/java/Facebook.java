import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Facebook {

    @FindBy(css = "a[class='facebook-login social-login']")
    protected  WebElement fb_log_button;

    @FindBy(id = "email")
    private WebElement fb_email_input;

    @Test
    public void loginViaFacebook(){
        WebDriver driver = BrowserManager.getBrowser(BrowserType.EDGE);
        driver.get("http://www.mindmegette.hu/bejelentkezes/");
        WebElement fb_log = driver.findElement(By.cssSelector("a[class='facebook-login social-login']"));
        fb_log.click();
        FacebookLogin.popUpLogin("gabo09@indamail.hu","chelshika96",driver);
    }
}
