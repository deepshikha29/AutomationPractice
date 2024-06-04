package utils;

import com.fasterxml.jackson.databind.annotation.JsonAppend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Property {
     private static Properties loadProperties (String filePath){

        Properties properties = new Properties();
        try (FileInputStream newFile = new FileInputStream(filePath)){
            properties.load(newFile);
        }
        catch(IOException e){
            e.printStackTrace();

        }
       return properties;
    }

    //loadProperties method initializes Properties class and returns the obj for same.
    //loadProperties loads the file.
    //below method returns the values from config file by calling loadProperties Method above
    // using Properties Instance
    public static String getconfig(String key){
        return loadProperties("resources/testData/config.properties").getProperty(key).trim();

    }


}


