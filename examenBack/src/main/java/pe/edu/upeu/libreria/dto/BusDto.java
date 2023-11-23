package pe.edu.upeu.libreria.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusDto {

    private Integer bu_Placa;

    private Integer bu_CodiFlot; //FK

    private String bu_Capacidad;

    private String bu_FechaFabri;

    private String bu_Tipo;
}
