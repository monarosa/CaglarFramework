package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties config;


    static {
        try {
            FileInputStream  input = new FileInputStream("configuration.properties");
            config =new Properties();
            config.load(input);
        } catch (IOException  e) {
           System.out.println("Failed to load configuration.properties file!");
            e.printStackTrace();
        }
    }


    public static String getProperty(String key){
        return config.getProperty(key);
    }




}
