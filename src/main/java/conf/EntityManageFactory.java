package conf;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RequestScoped
public class EntityManageFactory {
    @PersistenceContext(name = "postgresDB")
    private EntityManager em;
    @Produces
    @RequestScoped
    private EntityManager emBean(){
        return em;
    }
}
