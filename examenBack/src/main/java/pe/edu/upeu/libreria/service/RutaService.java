package pe.edu.upeu.libreria.service;
import pe.edu.upeu.libreria.dto.RutaDto;
import pe.edu.upeu.libreria.entity.RutaEntity;

import java.util.List;

public interface RutaService {
    List<RutaEntity> rutaListar();
    RutaEntity buscarRutaPorID(int ru_CodiRuta);
    RutaEntity guardarRuta(RutaDto rutaDto);
    RutaEntity editarRuta(int ru_CodiRuta, RutaDto rutaDto);
    void eliminarRuta(int ru_CodiRuta);
}
