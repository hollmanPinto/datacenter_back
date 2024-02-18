package beans;

import entities.models.Usuario;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import repositories.implementations.UsuarioRepoImpl;

import java.util.List;
@RequestScoped
public class UsuarioBean {
    @Inject
    UsuarioRepoImpl usuarioRepo;
    public List<Usuario> listarTodos(){
        return usuarioRepo.findAll();
    }
}
