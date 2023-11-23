package pe.edu.upeu.libreria.service;
import pe.edu.upeu.libreria.dto.FlotaDto;
import pe.edu.upeu.libreria.entity.FlotaEntity;

import java.util.List;

public interface FlotaService {
    List<FlotaEntity> flotaListar();
    FlotaEntity buscarFlotaPorID(int fl_CodiFlot);
    FlotaEntity guardarFlota(FlotaDto flotaDto);
    FlotaEntity editarFlota(int fl_CodiFlot, FlotaDto flotaDto);
    void eliminarFlota(int fl_CodiFlot);
}
