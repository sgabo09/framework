import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public final class BrowserManager {
    private static Map<String, WebDriver> drivers = new HashMap<String, WebDriver>();

    public BrowserManager(){
    }


    public static WebDriver getBrowser(BrowserType browser){
        WebDriver driver = null;
        switch(browser)
        {
            case CHROME:
            {
                driver = drivers.get("Chrome");
                if(driver == null){
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--disable-notifications");
                    System.setProperty("webdriver.chrome.driver", new ConfigReader().getChromeDriverPath());
                    driver = new ChromeDriver(options);
                    driver.manage().timeouts().pageLoadTimeout(new ConfigReader().getDefaultWait(),TimeUnit.SECONDS);
                    driver.manage().timeouts().implicitlyWait(new ConfigReader().getImplicitlyWait(),TimeUnit.SECONDS);
                    driver.manage().timeouts().setScriptTimeout(new ConfigReader().getDefaultWait(),TimeUnit.SECONDS);
                    if(new ConfigReader().getMaximized()){
                        driver.manage().window().maximize();
                    }else{
                        driver.manage().window().setPosition(new Point(0,0));
                        driver.manage().window().setSize(new Dimension(new ConfigReader().getBrowserWidth(),new ConfigReader().getBrowserHeight()));
                    }
                    drivers.put("Chrome", driver);
                }
            }
            break;
            case FIREFOX:
            {
                driver = drivers.get("Firefox");
                if(driver == null){
                    System.setProperty("webdriver.gecko.driver", new ConfigReader().getFirefoxDriverPath());
                    driver = new FirefoxDriver();
                    driver.manage().timeouts().pageLoadTimeout(new ConfigReader().getDefaultWait(),TimeUnit.SECONDS);
                    driver.manage().timeouts().implicitlyWait(new ConfigReader().getImplicitlyWait(),TimeUnit.SECONDS);
                    driver.manage().timeouts().setScriptTimeout(new ConfigReader().getDefaultWait(),TimeUnit.SECONDS);
                    if(new ConfigReader().getMaximized()){
                        driver.manage().window().maximize();
                    }else{
                        driver.manage().window().setPosition(new Point(0,0));
                        driver.manage().window().setSize(new Dimension(new ConfigReader().getBrowserWidth(),new ConfigReader().getBrowserHeight()));
                    }
                    drivers.put("Firefox", driver);
                }
            }
            break;
            case EDGE:
            {
                driver = drivers.get("EDGE");
                if(driver == null){
                    System.setProperty("webdriver.edge.driver", new ConfigReader().getEdgeDriverPath());
                    driver = new EdgeDriver();
                    driver.manage().timeouts().pageLoadTimeout(new ConfigReader().getDefaultWait(),TimeUnit.SECONDS);
                    driver.manage().timeouts().implicitlyWait(new ConfigReader().getImplicitlyWait(),TimeUnit.SECONDS);
                    driver.manage().timeouts().setScriptTimeout(new ConfigReader().getDefaultWait(),TimeUnit.SECONDS);
                    if(new ConfigReader().getMaximized()){
                        driver.manage().window().maximize();
                    }else{
                        driver.manage().window().setPosition(new Point(0,0));
                        driver.manage().window().setSize(new Dimension(new ConfigReader().getBrowserWidth(),new ConfigReader().getBrowserHeight()));
                    }
                    drivers.put("Edge", driver);
                }
            }
        }
        return driver;
    }

    public static void closeBrowsers(){
        for (String i : drivers.keySet())
        {
            drivers.get(i).quit();
        }
    }

}
