package reusableComponents;

import org.apache.commons.lang3.StringUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesOperations {

    private static final Properties properties = new Properties();
    private static final String propFilePath = System.getProperty("user.dir") + "/src/test/resources/config.properties";

    public static String getPropertyValueByKey(String key) throws IOException {

        // Load data from properties file
        try (FileInputStream fileInputStream = new FileInputStream(propFilePath)) {
            properties.load(fileInputStream);
        }

        // Read data
        String value = properties.getProperty(key);

        if (StringUtils.isEmpty(value)) {
            throw new IOException("Value is not specified for key: " + key + " in properties file.");
        }

        return value;
    }
}
