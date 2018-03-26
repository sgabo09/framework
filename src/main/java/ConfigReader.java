import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private Properties properties;
    private static final String configPath = "src/main/config/timeout.properties";

    public ConfigReader(){
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

    public long getDefaultWait(){
        return Long.parseLong(properties.getProperty("defaultWait"));
    }

    public long getImplicitlyWait(){
        return Long.parseLong(properties.getProperty("implicitlyWait"));
    }

    //public boolean getIsMaximized


}
