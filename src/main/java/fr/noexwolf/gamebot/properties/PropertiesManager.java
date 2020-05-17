package fr.noexwolf.gamebot.properties;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesManager {

    private final Properties properties;
    private InputStream propertiesStream;

    public PropertiesManager(String file) throws IOException {
        properties = new Properties();
        propertiesStream = getClass().getClassLoader().getResourceAsStream(file);

        if (propertiesStream == null) {
            throw new FileNotFoundException("Properties file '" + file + "' not found.");
        }

        properties.load(propertiesStream);
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

}
