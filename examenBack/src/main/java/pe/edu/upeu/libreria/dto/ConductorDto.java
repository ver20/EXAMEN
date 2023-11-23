package pe.edu.upeu.libreria.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConductorDto {

    private Integer co_CodiConduc;

    private String co_NombConduc;

    private String co_DireConduc;

    private String co_FechNaci;

}
