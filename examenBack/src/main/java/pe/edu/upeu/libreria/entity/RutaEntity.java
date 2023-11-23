package pe.edu.upeu.libreria.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="RUTA")
@Entity
public class RutaEntity implements Serializable {
    @Id
    @Column(name = "RU_CODIRUTA")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqRu_CodiRuta")
    @SequenceGenerator(sequenceName = "SEQ_RU_CODIRUTA", allocationSize = 1, name = "seqRu_CodiRuta")
    private Integer ru_CodiRuta;

    @Column(name = "RU_NOMBRUTA")
    private String ru_NombRuta;

    @Column(name = "RU_VALOPASAJE")
    private String ru_ValoPasaje;

}