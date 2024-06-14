package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class configFileReader {

    private Properties properties;
    private final String propertyFilePath = "configuration//config.properties";


    public configFileReader() {
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
            throw new RuntimeException("Config.properties not found at " + propertyFilePath);
        }
    }

    public String getdeviceName () {
        String deviceName = properties.getProperty("deviceName");
        if (deviceName != null) return deviceName;
        else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
    }

    public String getplatformVersion ()  {
        String platformVersion  = properties.getProperty("platformVersion");
        if (platformVersion!= null) return platformVersion;
        else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
    }

    public String getautomationName() {
        String automationName = properties.getProperty("automationName");
        if (automationName != null) return automationName;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }
    public String getplatformName() {
        String platformName = properties.getProperty("platformName");
        if (platformName != null) return platformName;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }
    public String getapp() {
        String app = properties.getProperty("app");
        if (app != null) return app;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }
    public String getappiumServerPath() {
        String appiumServerPath = properties.getProperty("appiumServerPath");
        if (appiumServerPath != null) return appiumServerPath;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }

    public String getExcelPath(){

        String deviceName = properties.getProperty("excelPath");
        if(deviceName!=null) return deviceName;
        else throw new RuntimeException("deviceName not found");

    }
}

