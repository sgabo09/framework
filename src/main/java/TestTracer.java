import org.apache.commons.io.FileUtils;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestTracer extends TestWatcher{
    private WebDriver driver;

    public TestTracer(WebDriver driver){
        this.driver = driver;
    }

    @Override
    protected void failed(Throwable e, Description description){
        String dateStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()).toString();
        String methodName = description.getMethodName();
        String fileName = description.getTestClass().getSimpleName() + "-" + methodName + dateStamp +".png";
        File folder = new File(new ConfigReader().getScreenshotDirectory());
        if(!folder.exists())
        {
            folder.mkdir();
        }
        try {
            File screenshot = (((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE));
            File target = new File(new ConfigReader().getScreenshotDirectory(),fileName);
            FileUtils.copyFile(screenshot,target);
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    @Override
    protected void finished(Description description){
        driver.quit();
    }
}
