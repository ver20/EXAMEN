package pe.edu.upeu.libreria.service;
import pe.edu.upeu.libreria.dto.BusDto;
import pe.edu.upeu.libreria.entity.BusEntity;

import java.util.List;

public interface BusService {
    List<BusEntity> busListar();
    BusEntity buscarBusPorID(int bu_placa);
    BusEntity guardarBus(BusDto busDto);
    BusEntity editarBus(int bu_placa, BusDto busDto);
    void eliminarBus(int bu_placa);
}
