package pe.edu.upeu.libreria.dto;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.upeu.libreria.entity.BusEntity;
import pe.edu.upeu.libreria.entity.ConductorEntity;
import pe.edu.upeu.libreria.entity.RutaEntity;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViajeDto {

    private Integer vi_NumeVuelta;

    private Integer vi_CodiRuta; //FK

    private String vi_NumePasajero;

    private Date vi_FechaViaje;

    private Integer vi_CodiConduc; //FK

    private Integer vi_placa; //FK

    private Integer vi_ValoPasaj;
}
