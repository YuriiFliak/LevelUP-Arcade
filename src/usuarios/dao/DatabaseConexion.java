/**
 * Clase para conectarse a la base de datos
 * Autor: Yurii Fliak
 * Version: 1.0
 */



package usuarios.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import usuarios.config.ConfigLoader;

public class DatabaseConexion {

    public static Connection getConnection() {

        Connection con = null;

        try {

            con = DriverManager.getConnection(
                    ConfigLoader.getUrl(),
                    ConfigLoader.getUser(),
                    ConfigLoader.getPassword()
            );

            System.out.println("Conexión correcta");

        } catch (SQLException e) {

            System.out.println("Error de conexión");

            e.printStackTrace();
        }

        return con;
    }
}