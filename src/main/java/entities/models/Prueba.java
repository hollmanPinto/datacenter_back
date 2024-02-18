package entities.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "prueba")
public class Prueba {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "prueba")
    private String prueba;
}
