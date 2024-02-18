package entities.dtos;

import jakarta.ws.rs.core.Response;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class SalidaBeanDto {
    private MensajeSalidaDto mensajeSalidaDto;
    private Response.Status status;
}
