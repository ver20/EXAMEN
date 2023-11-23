package pe.edu.upeu.libreria.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.libreria.dto.RutaDto;
import pe.edu.upeu.libreria.entity.RutaEntity;
import pe.edu.upeu.libreria.repository.RutaInterface;
import pe.edu.upeu.libreria.service.RutaService;

import java.util.List;

@Service
public class RutaServiceImpl implements RutaService {
    @Autowired
    private RutaInterface rutaInterface;

    //Inicializacion de los objetos
    @Override
    public List<RutaEntity> rutaListar() {
        return rutaInterface.findAll();
    }

    @Override
    public RutaEntity buscarRutaPorID(int ru_CodiRuta) {
        return rutaInterface.findById(ru_CodiRuta)
                .orElseThrow(null);
    }

    @Override
    public RutaEntity guardarRuta(RutaDto rutaDto) {

        RutaEntity nuevoRuta = new RutaEntity();
        nuevoRuta.setRu_CodiRuta(rutaDto.getRu_CodiRuta());
        nuevoRuta.setRu_NombRuta(rutaDto.getRu_NombRuta());
        nuevoRuta.setRu_ValoPasaje(rutaDto.getRu_ValoPasaje());

        return rutaInterface.save(nuevoRuta);
    }

    @Override
    public RutaEntity editarRuta(int ru_CodiRuta, RutaDto rutaDto) {
        RutaEntity rutaEncontrado = rutaInterface.findById(rutaDto.getRu_CodiRuta()).orElse(null);

        if (rutaEncontrado != null){
            rutaEncontrado.setRu_NombRuta(rutaDto.getRu_NombRuta());
            rutaEncontrado.setRu_ValoPasaje(rutaDto.getRu_ValoPasaje());
            return rutaInterface.save(rutaEncontrado);
        }
        return null;
    }

    @Override
    public void eliminarRuta(int ru_CodiRuta) {
        rutaInterface.deleteById(ru_CodiRuta);
    }
}
