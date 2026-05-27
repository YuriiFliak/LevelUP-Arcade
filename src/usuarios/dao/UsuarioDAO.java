package usuarios.dao;

import usuarios.model.Usuario;

public interface UsuarioDAO {
    Usuario login(String username, String password);
}