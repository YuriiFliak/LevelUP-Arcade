package usuarios.dao;

import usuarios.model.Producto;
import java.sql.*;
import java.util.*;

public class ProductoDAOImpl implements ProductoDAO {

    public void insertar(Producto p) {

        String sql = "INSERT INTO producto(nombre, descripcion, precio, stock, id_categoria, id_proveedor) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = DatabaseConexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getNombre());
            ps.setString(2, p.getDescripcion());
            ps.setDouble(3, p.getPrecio());
            ps.setInt(4, p.getStock());
            ps.setInt(5, p.getIdCategoria());
            ps.setInt(6, p.getIdProveedor());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Producto> listar() {

        List<Producto> list = new ArrayList<>();

        String sql = "SELECT * FROM producto";

        try (Connection con = DatabaseConexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Producto p = new Producto();

                p.setId(rs.getInt("id_producto"));
                p.setNombre(rs.getString("nombre"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setPrecio(rs.getDouble("precio"));
                p.setStock(rs.getInt("stock"));
                p.setIdCategoria(rs.getInt("id_categoria"));
                p.setIdProveedor(rs.getInt("id_proveedor"));

                list.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public Producto buscarPorId(int id) {

        String sql = "SELECT * FROM producto WHERE id_producto = ?";

        try (Connection con = DatabaseConexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Producto p = new Producto();

                p.setId(rs.getInt("id_producto"));
                p.setNombre(rs.getString("nombre"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setPrecio(rs.getDouble("precio"));
                p.setStock(rs.getInt("stock"));
                p.setIdCategoria(rs.getInt("id_categoria"));
                p.setIdProveedor(rs.getInt("id_proveedor"));

                return p;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void actualizar(Producto p) {

        String sql = "UPDATE producto SET nombre=?, descripcion=?, precio=?, stock=?, id_categoria=?, id_proveedor=? WHERE id_producto=?";

        try (Connection con = DatabaseConexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getNombre());
            ps.setString(2, p.getDescripcion());
            ps.setDouble(3, p.getPrecio());
            ps.setInt(4, p.getStock());
            ps.setInt(5, p.getIdCategoria());
            ps.setInt(6, p.getIdProveedor());
            ps.setInt(7, p.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminar(int id) {

        String sql = "DELETE FROM producto WHERE id_producto=?";

        try (Connection con = DatabaseConexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}