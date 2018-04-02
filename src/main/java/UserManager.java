import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class UserManager {
    private Map<String,User> users = new HashMap<String, User>();
    Map<String,String> userpasswords = new HashMap<String, String>();
    Map<String,String> useremails = new HashMap<String, String>();
    private String usersPath;
    private Properties properties;

    public UserManager(){
        this.usersPath = "src/main/config/users.properties";
        readPropertyFile();
        usersLoad();
    }

    public UserManager(String usersPath){
        this.usersPath = usersPath;
        readPropertyFile();
        usersLoad();
    }

    private void readPropertyFile(){
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader(usersPath));
            properties = new Properties();
            try{
                properties.load(reader);
                reader.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
            throw new RuntimeException("A users file nem található a " + usersPath + " útvonalon!");
        }
    }

    private void usersLoad(){
        ArrayList<String> usernames = new ArrayList<String>();
        Enumeration keys = properties.keys();
        while (keys.hasMoreElements()){
            String propertyname = (String) keys.nextElement();
            String value = properties.getProperty(propertyname);
            String [] parts = propertyname.split("[.]");
            if(parts[1].equals("email")){
                useremails.put(parts[0],value);
            }else if (parts[1].equals("password")){
                userpasswords.put(parts[0],value);
            }
            if(!usernames.contains(parts[0])){
                usernames.add(parts[0]);
            }
        }
        for(int i = 0; i < usernames.size(); i++)
        {
            users.put(usernames.get(i), new User(useremails.get(usernames.get(i)), userpasswords.get(usernames.get(i))));
        }
    }

    public User getUser(String username){
        return users.get(username);
    }

    public String getUserEmail(String username){
        return useremails.get(username);
    }

    public String getUserPassword(String username){
        return userpasswords.get(username);
    }

}
