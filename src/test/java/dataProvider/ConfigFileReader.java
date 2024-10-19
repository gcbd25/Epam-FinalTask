package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    public Properties properties;
    private final String propertyFilePath= "./Configuration/config.properties";
    public ConfigFileReader(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getBrowser(){
        String browser = properties.getProperty("browser");
        if(browser != null){
            return browser;
        } else {
            throw new RuntimeException("url not specified in the Configuration.properties file.");
        }
    }

    public String getURL(){
        String url = properties.getProperty("baseURL");
        if(url != null){
            return url;
        } else {
            throw new RuntimeException("url not specified in the Configuration.properties file.");
        }
    }

    public String getFirstName(){
        String firstName = properties.getProperty("firstName");
        if(firstName != null){
            return firstName;
        } else {
            throw new RuntimeException("firstName not specified in the Configuration.properties file.");
        }
    }

    public String getLastName(){
        String lastName = properties.getProperty("lastName");
        if(lastName != null){
            return lastName;
        } else {
            throw new RuntimeException("lastName not specified in the Configuration.properties file.");
        }
    }

    public String getEmail(){
        String email = properties.getProperty("email");
        if(email != null){
            return email;
        } else {
            throw new RuntimeException("email not specified in the Configuration.properties file.");
        }
    }

    public String getValidCreateAccountPsw(){
        String validCreateAccPsw = properties.getProperty("validCreateAccPsw");
        if(validCreateAccPsw != null){
            return validCreateAccPsw;
        } else {
            throw new RuntimeException("validCreateAccPsw not specified in the Configuration.properties file.");
        }
    }
}
