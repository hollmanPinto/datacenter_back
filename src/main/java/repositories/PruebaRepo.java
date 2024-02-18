package repositories;

import entities.models.Prueba;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
@RequestScoped
public class PruebaRepo {
    @Inject
    private EntityManager em;

    public Prueba find(){
       return em.find(Prueba.class,1L);
    }
}
