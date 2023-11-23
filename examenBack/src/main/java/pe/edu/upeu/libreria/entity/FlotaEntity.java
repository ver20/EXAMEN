package pe.edu.upeu.libreria.entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="FLOTA")
@Entity
public class FlotaEntity implements Serializable {

    @Id
    @Column(name = "FL_CODIFLOT")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqFL_CodiFlot")
    @SequenceGenerator(sequenceName = "SEQ_FL_CODIFLOT", allocationSize = 1, name = "seqFl_CodiFlot")
    private Integer fl_CodiFlot;

    @Column(name = "FL_NOMBFLOT")
    private String fl_NombFlot;

    @ManyToOne //FK
    @JoinColumn(name = "TE_CODITERM")
    private TerminalEntity fl_CodiTerm;
}
