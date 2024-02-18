package entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class MensajeSalidaDto {
    private Boolean error;
    private Object objeto;
    private String mensaje;
}
