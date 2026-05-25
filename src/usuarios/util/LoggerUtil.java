package usuarios.util;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class LoggerUtil {

    public static void log(String mensaje) {

        try {

            FileWriter fw = new FileWriter(
                    "logs.txt",
                    true
            );

            fw.write(
                    LocalDateTime.now()
                    + " -> "
                    + mensaje
                    + "\n"
            );

            fw.close();

        } catch(IOException e) {

            System.out.println("Error escribiendo log");
        }
    }
}