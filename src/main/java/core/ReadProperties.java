package core;

import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    private static Properties properties;
    private static ReadProperties instance;

    public static synchronized ReadProperties getInstance() {
        if (instance == null) {
            instance = new ReadProperties();
            instance.properties = new Properties();

            try {
                instance.properties.load(ReadProperties.class.getClassLoader().getResourceAsStream("config.properties"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    public static String getURL() {
        return getInstance().properties.getProperty("url");
    }

    public static String getBrowserName() {
        return getInstance().properties.getProperty("browser");
    }

    public static int getTimeout() {
        return Integer.parseInt(getInstance().properties.getProperty("timeout"));
    }
}
