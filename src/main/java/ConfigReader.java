import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private Properties properties;
    private String configPath;

    public ConfigReader(){
        this.configPath = "src/main/config/config.properties";
        loadConfig();
    }

    public ConfigReader(String configPath){
        this.configPath = configPath;
        loadConfig();
    }

    private void loadConfig(){
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader(configPath));
            properties = new Properties();
            try{
                properties.load(reader);
                reader.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
            throw new RuntimeException("A config file nem található a " + configPath + " útvonalon!");
        }
    }

    public String getChromeDriverPath(){
        return properties.getProperty("chromeDriver");
    }

    public String getFirefoxDriverPath(){
        return properties.getProperty("firefoxDriver");
    }

    public String getEdgeDriverPath(){
        return properties.getProperty("edgeDriver");
    }

    public Boolean getMaximized(){
        return Boolean.parseBoolean(properties.getProperty("browserMaximize"));
    }

    public int getBrowserWidth(){
        return Integer.parseInt(properties.getProperty("browserWidth"));
    }

    public int getBrowserHeight(){
        return Integer.parseInt(properties.getProperty("browserHeight"));
    }

    public long getDefaultWait(){
        return Long.parseLong(properties.getProperty("defaultWait"));
    }

    public long getImplicitlyWait(){
        return Long.parseLong(properties.getProperty("implicitlyWait"));
    }

    public String getScreenshotDirectory() { return  properties.getProperty("screenshotDirectory"); }
}
