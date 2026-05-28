/**
 * Clase encargada de leer configuración externa.
 * Autor: Yurii Fliak
 * Version: 1.0
 */
package usuarios.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {

    private static Properties properties = new Properties();

    static {

        try {

            InputStream file;

            try {
                file = new FileInputStream("config.properties");
            } catch (IOException e) {
                file = ConfigLoader.class.getClassLoader()
                        .getResourceAsStream("config.properties");
            }

            if (file == null) {
                throw new RuntimeException("No se encuentra config.properties");
            }

            properties.load(file);

        } catch (IOException e) {

            System.out.println("Error cargando config.properties");
            e.printStackTrace();
        }
    }

    public static String getUrl() {
        return properties.getProperty("db.url");
    }

    public static String getUser() {
        return properties.getProperty("db.user");
    }

    public static String getPassword() {
        return properties.getProperty("db.password");
    }

    public static String getOpenRouterApiKey() {
        return properties.getProperty("openrouter.api.key");
    }
}
