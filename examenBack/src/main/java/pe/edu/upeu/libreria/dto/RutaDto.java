package pe.edu.upeu.libreria.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RutaDto {

    private Integer ru_CodiRuta;

    private String ru_NombRuta;

    private String ru_ValoPasaje;
}
