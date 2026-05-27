package usuarios.dao;

import usuarios.model.Cliente;
import java.sql.*;
import java.util.*;

public class ClienteDAOImpl implements ClienteDAO {

    public void insertar(Cliente c) {

        String sql = "INSERT INTO cliente(nombre, apellidos, email, telefono, direccion) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DatabaseConexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

        	ps.setString(1, c.getNombre());
        	ps.setString(2, c.getApellido());
        	ps.setString(3, c.getEmail());
        	ps.setString(4, c.getTelefono());
        	ps.setString(5, c.getDireccion());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Cliente> listar() {

        List<Cliente> list = new ArrayList<>();

        String sql = "SELECT * FROM cliente";

        try (Connection con = DatabaseConexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Cliente c = new Cliente();

                c.setId(rs.getInt("id_cliente"));
                c.setNombre(rs.getString("nombre"));
                c.setApellido(rs.getString("apellidos"));
                c.setEmail(rs.getString("email"));
                c.setTelefono(rs.getString("telefono"));
                c.setDireccion(rs.getString("direccion"));

                list.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public Cliente buscarPorId(int id) {

        String sql = "SELECT * FROM cliente WHERE id_cliente = ?";

        try (Connection con = DatabaseConexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Cliente c = new Cliente();

                c.setId(rs.getInt("id_cliente"));
                c.setNombre(rs.getString("nombre"));
                c.setApellido(rs.getString("apellido"));
                c.setEmail(rs.getString("email"));
                c.setTelefono(rs.getString("telefono"));
                c.setDireccion(rs.getString("direccion"));

                return c;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void actualizar(Cliente c) {

        String sql = "UPDATE cliente SET nombre=?, email=?, telefono=?, direccion=? WHERE id_cliente=?";

        try (Connection con = DatabaseConexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, c.getNombre());
            ps.setString(2, c.getEmail());
            ps.setString(3, c.getTelefono());
            ps.setString(4, c.getDireccion());
            ps.setInt(5, c.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminar(int id) {

        String sql = "DELETE FROM cliente WHERE id_cliente=?";

        try (Connection con = DatabaseConexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}