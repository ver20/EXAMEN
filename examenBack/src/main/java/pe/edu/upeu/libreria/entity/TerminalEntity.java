package pe.edu.upeu.libreria.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="TERMINAL")
@Entity
public class TerminalEntity implements Serializable {
    @Id
    @Column(name = "TE_CODITERM")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqTe_CodiTerm")
    @SequenceGenerator(sequenceName = "SEQ_TE_CODITERM", allocationSize = 1, name = "seqTe_CodiTerm")
    private Integer te_CodiTerm;

    @Column(name = "TE_DIRETERM")
    private String te_DireTerm;

    @Column(name = "TE_NOMBTERM")
    private String te_NombTerm;

}
