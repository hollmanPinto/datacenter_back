package entities.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Date;
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "RECARGAS")
public class Recarga {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    @Column(name = "valor", nullable = false)
    private BigInteger valor;
    @Column(name = "telefono", nullable = false)
    private String telefono;
    @Column(name = "usuario", nullable = false)
    private BigInteger usuario;
    @Column(name = "operador", nullable = false)
    private BigInteger operador;
    @Transient
    private Date fecha;
}
