package entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Date;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ConsOperador {
    private String usuario;
    private String operador;
    private String telefono;
    private BigInteger valor;
    private Date fecha;
}
