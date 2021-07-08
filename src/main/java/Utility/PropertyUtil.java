package Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtil {

    public String getGlobalProperty(String key) throws IOException {
        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream("src/main/resources/global.properties");
        properties.load(fis);
        return properties.getProperty(key);
    }
}
