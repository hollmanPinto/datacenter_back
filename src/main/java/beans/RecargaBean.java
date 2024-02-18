package beans;

import entities.dtos.ConsOperador;
import entities.dtos.MensajeSalidaDto;
import entities.dtos.SalidaBeanDto;
import entities.models.Recarga;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import repositories.implementations.RecargaRepoImpl;

import java.util.List;
import java.util.Optional;

@RequestScoped
@Transactional
public class RecargaBean {
    @Inject
    RecargaRepoImpl recargaRepo;

    /**
     * Metodo para obtener la lista de recargas totales registradas en la base de datos
     * @return
     */
    public List<Recarga> listarRecargas(){
        return recargaRepo.findAll();
    }

    /**
     * Metodo para crear una recarga en la base de datos
     * @param recarga
     * @return
     */
    public SalidaBeanDto crearRecarga(Recarga recarga){
        SalidaBeanDto salidaBeanDto = new SalidaBeanDto();
        MensajeSalidaDto mensajeSalidaDto = new MensajeSalidaDto();
        try{
            Long idRecarga = recargaRepo.save(recarga);
            salidaBeanDto.setStatus(Response.Status.OK);
            mensajeSalidaDto.setError(false);
            mensajeSalidaDto.setObjeto(idRecarga);
            mensajeSalidaDto.setMensaje("Creacion Exitosa");
        }catch (Exception e){
            e.printStackTrace();
            salidaBeanDto.setStatus(Response.Status.INTERNAL_SERVER_ERROR);
            mensajeSalidaDto.setError(true);
            mensajeSalidaDto.setObjeto(e.getMessage());
            mensajeSalidaDto.setMensaje("Ha ocurrido un error creando recarga");
        }
        salidaBeanDto.setMensajeSalidaDto(mensajeSalidaDto);
        return salidaBeanDto;
    }

    /**
     * Metodo que entrega un consolidado de recargas por operador
     * @param idOperadorS
     * @return
     */
    public SalidaBeanDto consolidadoRecargasOperador(String idOperadorS){
        SalidaBeanDto salidaBeanDto = new SalidaBeanDto();
        MensajeSalidaDto mensajeSalidaDto = new MensajeSalidaDto();
        try{
            Long idOperador = Long.parseLong(idOperadorS);
            Optional<List<ConsOperador>> query = recargaRepo.consolidadoOperadores(idOperador);
            if(query.isPresent()){
                mensajeSalidaDto.setError(false);
                mensajeSalidaDto.setMensaje("Consolidado de recargas por operador");
                mensajeSalidaDto.setObjeto(query.get());
                salidaBeanDto.setStatus(Response.Status.OK);
            }
            else{
                mensajeSalidaDto.setError(false);
                mensajeSalidaDto.setMensaje("No se encuentra informacion");
                mensajeSalidaDto.setObjeto(query.get());
                salidaBeanDto.setStatus(Response.Status.NO_CONTENT);
            }
        }catch (Exception e){
            e.printStackTrace();
            mensajeSalidaDto.setError(true);
            mensajeSalidaDto.setMensaje("Ha ocurrido un error obteniendo consolidados");
            mensajeSalidaDto.setObjeto(e.getMessage());
            salidaBeanDto.setStatus(Response.Status.INTERNAL_SERVER_ERROR);
        }
        salidaBeanDto.setMensajeSalidaDto(mensajeSalidaDto);
        return salidaBeanDto;
    }
}
