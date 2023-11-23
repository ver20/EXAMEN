package pe.edu.upeu.libreria.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="VIAJE")
@Entity
public class ViajeEntity implements Serializable {

    @Id
    @Column(name = "VI_NUMEVUELTA")
    private Integer vi_NumeVuelta;

    @ManyToOne //FK
    @JoinColumn(name = "RU_CODIRUTA")
    private RutaEntity vi_CodiRuta;

    @Column(name = "VI_NUMEPASAJERO")
    private String vi_NumePasajero;

    @Column(name = "VI_FECHAVIAJE")
    private Date vi_FechaViaje;

    @ManyToOne //FK
    @JoinColumn(name = "CO_CODICONDUC")
    private ConductorEntity vi_CodiConduc;

    @ManyToOne //FK
    @JoinColumn(name = "BU_PLACA")
    private BusEntity vi_placa;


    @Column(name = "VI_VALOPASAJ")
    private Integer vi_ValoPasaj;
}
