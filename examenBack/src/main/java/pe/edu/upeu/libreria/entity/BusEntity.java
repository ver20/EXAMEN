package pe.edu.upeu.libreria.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="BUS")
@Entity
public class BusEntity implements Serializable {

    @Id
    @Column(name = "BU_PLACA")
    private Integer bu_Placa;

    @ManyToOne //FK
    @JoinColumn(name = "FL_CODIFLOT")
    private FlotaEntity bu_CodiFlot;

    @Column(name = "BU_CAPACIDAD")
    private String bu_Capacidad;

    @Column(name = "BU_FECHAFABRI")
    private String bu_FechaFabri;

    @Column(name = "BU_TIPO")
    private String bu_Tipo;
}
