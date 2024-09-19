package utils;

import java.io.IOException;
import java.util.Properties;

public final class PropertiesUtil {
    private static final Properties PROPERTIES = new Properties();

    static {
        loadProperties();
        System.out.println("Properties loaded");
    }

    public static String get(String key) {
        return PROPERTIES.getProperty(key);
    }

    private static void loadProperties() {

        try (var inputstream = PropertiesUtil.class.
                getClassLoader().getResourceAsStream("app.properties")){
            PROPERTIES.load(inputstream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
