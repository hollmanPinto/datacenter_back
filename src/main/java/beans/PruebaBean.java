package beans;

import entities.dtos.CapsulaString;
import entities.models.Prueba;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import repositories.PruebaRepo;

@RequestScoped
public class PruebaBean {
    @Inject
    PruebaRepo pruebaRepo;
    public Prueba prueba1(){
        return pruebaRepo.find();
    }
}
