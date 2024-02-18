package repositories;

import entities.dtos.ConsOperador;
import entities.models.Recarga;
import entities.models.Usuario;

import java.util.List;
import java.util.Optional;

public interface RecargaRepo {
    Recarga findById(Long id);
    List<Recarga> findAll();
    Long save(Recarga recarga);
    Boolean delete(Long id);
    Recarga update(Recarga recarga);
    Optional<List<ConsOperador>> consolidadoOperadores(Long idOperador);
}
