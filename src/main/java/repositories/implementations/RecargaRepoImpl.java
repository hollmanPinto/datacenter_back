package repositories.implementations;

import entities.dtos.ConsOperador;
import entities.models.Recarga;
import entities.models.Usuario;
import jakarta.annotation.Resource;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import repositories.RecargaRepo;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestScoped
public class RecargaRepoImpl implements RecargaRepo {
    @Inject
    EntityManager em;
    @Override
    public Recarga findById(Long id) {
        return em.find(Recarga.class,id);
    }

    @Override
    public List<Recarga> findAll() {
        Query query = em.createQuery("select r FROM Recarga r");
        List<Recarga> recargas = (List<Recarga>) query.getResultList();
        return recargas;
    }

    @Override
    public Long save(Recarga recarga) {
        em.persist(recarga);
        return recarga.getId().longValue();
    }

    @Override
    public Boolean delete(Long id) {
        try{
            Recarga recarga = this.findById(id);
            em.remove(recarga);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Recarga update(Recarga recarga) {
        Recarga recargaBase = this.findById(recarga.getId().longValue());
        if(recargaBase.getId().equals(recarga.getId())){
            Recarga recargaActualizada = em.merge(recarga);
            return recargaActualizada;
        }
        return null;
    }

    @Override
    public Optional<List<ConsOperador>> consolidadoOperadores(Long idOperador) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        List<ConsOperador> salida = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("select \n");
        sb.append("	u.username as usuario, \n");
        sb.append("	o.nombre as operador, \n");
        sb.append("	r.telefono, \n");
        sb.append("	r.valor, \n");
        sb.append("	r.fecha \n");
        sb.append("from RECARGAS r \n");
        sb.append("join USUARIOS u on r.usuario = u.id \n");
        sb.append("join OPERADORES o on r.operador = o.id \n");
        sb.append("where o.id = :idOperador ");
        try{
            Query nativeQuery = em.createNativeQuery(sb.toString());
            nativeQuery.setParameter("idOperador",idOperador);
            List<Object[]> res = nativeQuery.getResultList();
            for(Object[] o:res){
                ConsOperador consOperador = new ConsOperador();
                consOperador.setUsuario(""+o[0]);
                consOperador.setOperador(""+o[1]);
                consOperador.setTelefono(""+o[2]);
                consOperador.setValor(new BigInteger(""+o[3]));
                consOperador.setFecha(sdf.parse(""+o[4]));
                salida.add(consOperador);
            }
            return Optional.of(salida);
        }catch (NoResultException e){
            return Optional.empty();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
