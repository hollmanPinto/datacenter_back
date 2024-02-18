package entities.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "OPERADORES")
public class Operador {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "esta_activo", nullable = false)
    private Boolean estaActivo;
}
