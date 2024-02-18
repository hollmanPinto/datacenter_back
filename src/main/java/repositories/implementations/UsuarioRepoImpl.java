package repositories.implementations;

import entities.models.Usuario;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import repositories.UsuarioRepo;

import java.util.List;

@RequestScoped
public class UsuarioRepoImpl implements UsuarioRepo {
    @Inject
    private EntityManager em;
    @Override
    public Usuario findById(Long id) {
        return em.find(Usuario.class,id);
    }

    @Override
    public List<Usuario> findAll() {
        Query query = em.createQuery("select u FROM Usuario u");
        List<Usuario> usuarios = (List<Usuario>) query.getResultList();
        return usuarios;
    }

    @Override
    public Long save(Usuario usuario) {
        em.getTransaction().begin();
        Usuario usuarioSave = em.merge(usuario);
        em.getTransaction().commit();
        return usuarioSave.getId().longValue();
    }

    @Override
    public Boolean delete(Long id) {
        try{
            Usuario usuario = this.findById(id);
            em.getTransaction().begin();
            em.remove(usuario);
            em.getTransaction().commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Usuario update(Usuario usuario) {
        Usuario usuarioBase = this.findById(usuario.getId().longValue());
        if(usuarioBase.getId().equals(usuario.getId())){
            Usuario usuarioActualizado = em.merge(usuario);
            return usuarioActualizado;
        }
        return null;
    }
}
