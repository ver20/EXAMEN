package pe.edu.upeu.libreria.service;
import pe.edu.upeu.libreria.dto.ViajeDto;
import pe.edu.upeu.libreria.entity.ViajeEntity;

import java.util.List;

public interface ViajeService {
    List<ViajeEntity> viajeListar();
    ViajeEntity buscarViajePorID(int vi_NumeVuelta);
    ViajeEntity guardarViaje(ViajeDto viajeDto);
    ViajeEntity editarViaje(int vi_NumeVuelta, ViajeDto viajeDto);
    void eliminarViaje(int vi_NumeVuelta);
}
