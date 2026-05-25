/**
 * Clase encargada de leer configuración externa.
 * Autor: Yurii Fliak
 * Version: 1.0
 */
package usuarios.config;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {

    private static Properties properties = new Properties();

    static {

        try {

            FileInputStream file = new FileInputStream("config.properties");

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
}