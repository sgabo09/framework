import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.WebDriver;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class BrowserManager {
    private long defaultWait;
    private long implicitlyWait;
    private ConfigReader configReader;
    private WebDriver driver;
    public BrowserManager(){

    }

    public WebDriver getBrowser(){
        WebDriver driver = this.driver;

        driver.manage().timeouts().pageLoadTimeout(configReader.getDefaultWait(),TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(configReader.getImplicitlyWait(),TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(configReader.getDefaultWait(),TimeUnit.SECONDS);

        return driver;
    }

}
