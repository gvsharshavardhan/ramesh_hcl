package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class PropertyUtil {
    private static final Properties prop = new Properties();
    private static final String propertyFilePath
            = System.getProperty("user.dir") + "/src/test/resources/config/config.properties";

    private PropertyUtil() {

    }

    static {
        try {
            FileInputStream fileInputStream = new FileInputStream(propertyFilePath);
            prop.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getPropertyValue(String key) throws Exception {
        if (Objects.isNull(key)) {
            throw new Exception("property name :" + key + " is not found. Please check config.properties file!!");
        } else {
            return prop.getProperty(key.toLowerCase());
        }
    }
}