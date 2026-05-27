package usuarios.dao;

import usuarios.model.Proveedor;
import java.sql.*;
import java.util.*;

public class ProveedorDAOImpl implements ProveedorDAO {

    public void insertar(Proveedor p) {

        String sql = "INSERT INTO proveedor(nombre, telefono, email, direccion) VALUES (?, ?, ?, ?)";

        try (Connection con = DatabaseConexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

        	ps.setString(1, p.getNombre());
        	ps.setString(2, p.getTelefono());
        	ps.setString(3, p.getEmail());
        	ps.setString(4, p.getDireccion());

            ps.executeUpdate();
            System.out.println("Proveedor insertado correctamente");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Proveedor> listar() {

        List<Proveedor> list = new ArrayList<>();

        String sql = "SELECT * FROM proveedor";

        try (Connection con = DatabaseConexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Proveedor p = new Proveedor();

                p.setId(rs.getInt("id_proveedor"));
                p.setNombre(rs.getString("nombre"));
                p.setTelefono(rs.getString("telefono"));
                p.setEmail(rs.getString("email"));
                p.setDireccion(rs.getString("direccion"));

                list.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public Proveedor buscarPorId(int id) {

        String sql = "SELECT * FROM proveedor WHERE id_proveedor = ?";

        try (Connection con = DatabaseConexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    Proveedor p = new Proveedor();

                    p.setId(rs.getInt("id_proveedor"));
                    p.setNombre(rs.getString("nombre"));
                    p.setTelefono(rs.getString("telefono"));
                    p.setEmail(rs.getString("email"));
                    p.setDireccion(rs.getString("direccion"));

                    return p;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void actualizar(Proveedor p) {

        String sql = "UPDATE proveedor SET nombre=?, telefono=?, email=?, direccion=? WHERE id_proveedor=?";

        try (Connection con = DatabaseConexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getNombre());
            ps.setString(2, p.getTelefono());
            ps.setString(3, p.getEmail());
            ps.setString(4, p.getDireccion());
            ps.setInt(5, p.getId());

            int filas = ps.executeUpdate();

            if (filas == 0) {
                System.out.println("No existe un proveedor con ID " + p.getId());
            } else {
                System.out.println("Proveedor actualizado correctamente");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminar(int id) {

        String sql = "DELETE FROM proveedor WHERE id_proveedor=?";

        try (Connection con = DatabaseConexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            int filas = ps.executeUpdate();

            if (filas == 0) {
                System.out.println("No existe un proveedor con ID " + id);
            } else {
                System.out.println("Proveedor eliminado correctamente");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
