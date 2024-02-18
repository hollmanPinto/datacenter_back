package repositories;

import entities.models.Usuario;

import java.util.List;

public interface UsuarioRepo {
    Usuario findById(Long id);
    List<Usuario> findAll();
    Long save(Usuario usuario);
    Boolean delete(Long id);
    Usuario update(Usuario usuario);
}
