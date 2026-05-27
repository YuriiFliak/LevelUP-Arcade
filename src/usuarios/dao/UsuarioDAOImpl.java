package usuarios.dao;

import java.sql.*;

import usuarios.model.Usuario;
import usuarios.security.PasswordUtil;

public class UsuarioDAOImpl implements UsuarioDAO {

    @Override
    public Usuario login(String username, String password) {

        String sql = "SELECT * FROM usuario WHERE nombre = ? AND (contrasena = ? OR contrasena = ?)";

        try (Connection con = DatabaseConexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, PasswordUtil.hash(password));
            ps.setString(3, password);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    return new Usuario(
                            rs.getInt("id_usuario"),
                            rs.getString("nombre"),
                            rs.getString("contrasena"),
                            rs.getString("rol")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
