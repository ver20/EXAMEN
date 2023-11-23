package pe.edu.upeu.libreria.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlotaDto {

    private Integer fl_CodiFlot;

    private String fl_NombFlot;

    private Integer fl_CodiTerm; //FK
}
