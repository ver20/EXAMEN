package pe.edu.upeu.libreria.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.libreria.dto.ConductorDto;
import pe.edu.upeu.libreria.entity.ConductorEntity;
import pe.edu.upeu.libreria.repository.ConductorInterface;
import pe.edu.upeu.libreria.service.ConductorService;

import java.util.List;

@Service
public class ConductorServiceImpl implements ConductorService {
    @Autowired
    private ConductorInterface conductorInterface;

    //Inicializacion de los objetos
    @Override
    public List<ConductorEntity> conductorListar() {
        return conductorInterface.findAll();
    }

    @Override
    public ConductorEntity buscarConductorPorID(int co_CodiConduc) {
        return conductorInterface.findById(co_CodiConduc)
                .orElseThrow(null);
    }

    @Override
    public ConductorEntity guardarConductor(ConductorDto conductorDto) {

        ConductorEntity nuevoConductor = new ConductorEntity();
        nuevoConductor.setCo_CodiConduc(conductorDto.getCo_CodiConduc());
        nuevoConductor.setCo_NombConduc(conductorDto.getCo_NombConduc());
        nuevoConductor.setCo_DireConduc(conductorDto.getCo_DireConduc());
        nuevoConductor.setCo_FechNaci(conductorDto.getCo_FechNaci());
        return conductorInterface.save(nuevoConductor);
    }

    @Override
    public ConductorEntity editarConductor(int co_CodiConduc, ConductorDto conductorDto) {
        ConductorEntity conductorEncontrado = conductorInterface.findById(conductorDto.getCo_CodiConduc()).orElse(null);

        if (conductorEncontrado != null){
            conductorEncontrado.setCo_NombConduc(conductorDto.getCo_NombConduc());
            conductorEncontrado.setCo_DireConduc(conductorDto.getCo_DireConduc());
            conductorEncontrado.setCo_FechNaci(conductorDto.getCo_FechNaci());
            return conductorInterface.save(conductorEncontrado);
        }
        return null;
    }

    @Override
    public void eliminarConductor(int co_CodiConduc) {
        conductorInterface.deleteById(co_CodiConduc);
    }
}
