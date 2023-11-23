package pe.edu.upeu.libreria.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.libreria.dto.ViajeDto;
import pe.edu.upeu.libreria.entity.*;
import pe.edu.upeu.libreria.repository.*;
import pe.edu.upeu.libreria.service.ViajeService;

import java.util.List;

@Service
public class ViajeServiceImpl implements ViajeService {
    @Autowired
    private ViajeInterface viajeInterface;

    @Autowired //Verificar que exista la ruta
    private RutaInterface rutaInterface;

    @Autowired //Verificar que exista el conductor
    private ConductorInterface conductorInterface;

    @Autowired //Verificar que exista el bus
    private BusInterface busInterface;

    //Inicializacion de los objetos
    @Override
    public List<ViajeEntity> viajeListar() {
        return viajeInterface.findAll();
    }

    @Override
    public ViajeEntity buscarViajePorID(int vi_NumeVuelta) {
        return viajeInterface.findById(vi_NumeVuelta)
                .orElseThrow(null);
    }

    @Override
    public ViajeEntity guardarViaje(ViajeDto viajeDto) {
        RutaEntity rutaEncontrado = rutaInterface.findById(viajeDto.getVi_CodiRuta()).orElse(null);
        ConductorEntity conductorEncontrado = conductorInterface.findById(viajeDto.getVi_CodiConduc()).orElse(null);
        BusEntity busEncontrado = busInterface.findById(viajeDto.getVi_placa()).orElse(null);

        ViajeEntity nuevoViaje = new ViajeEntity();

        nuevoViaje.setVi_NumeVuelta(viajeDto.getVi_NumeVuelta());
        nuevoViaje.setVi_placa(busEncontrado);
        nuevoViaje.setVi_CodiRuta(rutaEncontrado);
        nuevoViaje.setVi_NumePasajero(viajeDto.getVi_NumePasajero());
        nuevoViaje.setVi_FechaViaje(viajeDto.getVi_FechaViaje());
        nuevoViaje.setVi_CodiConduc(conductorEncontrado);
        nuevoViaje.setVi_ValoPasaj(viajeDto.getVi_ValoPasaj());
        return viajeInterface.save(nuevoViaje);
    }

    @Override
    public ViajeEntity editarViaje(int vi_NumeVuelta, ViajeDto viajeDto) {
        ViajeEntity viajeEncontrado = viajeInterface.findById(viajeDto.getVi_NumeVuelta()).orElse(null);
        RutaEntity rutaEncontrado = rutaInterface.findById(viajeDto.getVi_CodiRuta()).orElse(null);
        ConductorEntity conductorEncontrado = conductorInterface.findById(viajeDto.getVi_CodiConduc()).orElse(null);
        BusEntity busEncontrado = busInterface.findById(viajeDto.getVi_placa()).orElse(null);


        if (viajeEncontrado != null){
            viajeEncontrado.setVi_placa(busEncontrado);
            viajeEncontrado.setVi_CodiRuta(rutaEncontrado);
            viajeEncontrado.setVi_NumePasajero(viajeDto.getVi_NumePasajero());
            viajeEncontrado.setVi_FechaViaje(viajeDto.getVi_FechaViaje());
            viajeEncontrado.setVi_CodiConduc(conductorEncontrado);
            viajeEncontrado.setVi_ValoPasaj(viajeDto.getVi_ValoPasaj());
            return viajeInterface.save(viajeEncontrado);
        }
        return null;
    }

    @Override
    public void eliminarViaje(int vi_NumeVuelta) {
        viajeInterface.deleteById(vi_NumeVuelta);
    }
}
