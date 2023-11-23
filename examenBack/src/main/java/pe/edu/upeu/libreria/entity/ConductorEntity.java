package pe.edu.upeu.libreria.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="CONDUCTOR")
public class ConductorEntity implements Serializable {
    private static final long serialVersionUID = -2170897015344177815L;

    @Id
    @Column(name = "CO_CODICONDUC")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCo_CodiConduc")
    @SequenceGenerator(sequenceName = "SEQ_CO_CODICONDUC", allocationSize = 1, name = "seqCo_CodiConduc")
    private Integer co_CodiConduc;

    @Column(name = "CO_NOMBCONDUC")
    private String co_NombConduc;

    @Column(name = "CO_DIRECONDUC")
    private String co_DireConduc;

    @Column(name = "CO_FECHNACI")
    private String co_FechNaci;
}
