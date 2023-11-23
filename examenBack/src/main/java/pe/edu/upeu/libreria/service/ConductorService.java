package pe.edu.upeu.libreria.service;

import pe.edu.upeu.libreria.dto.ConductorDto;
import pe.edu.upeu.libreria.entity.ConductorEntity;

import java.util.List;
public interface ConductorService {
    List<ConductorEntity> conductorListar();
    ConductorEntity buscarConductorPorID(int co_CodiConduc);
    ConductorEntity guardarConductor(ConductorDto conductorDto);
    ConductorEntity editarConductor(int co_CodiConduc, ConductorDto conductorDto);
    void eliminarConductor(int co_CodiConduc);
}
