package pe.edu.upeu.libreria.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.libreria.dto.BusDto;
import pe.edu.upeu.libreria.entity.BusEntity;
import pe.edu.upeu.libreria.entity.FlotaEntity;
import pe.edu.upeu.libreria.repository.BusInterface;
import pe.edu.upeu.libreria.repository.FlotaInterface;
import pe.edu.upeu.libreria.service.BusService;

import java.util.List;
@Service
public class BusServiceImpl implements BusService {
    @Autowired
    private BusInterface busInterface;

    @Autowired //Verificar que exista la flota
    private FlotaInterface flotaInterface;

    //Inicializacion de los objetos
    @Override
    public List<BusEntity> busListar() {
        return busInterface.findAll();
    }

    @Override
    public BusEntity buscarBusPorID(int bu_placa) {
        return busInterface.findById(bu_placa)
                .orElseThrow(null);
    }

    @Override
    public BusEntity guardarBus(BusDto busDto) {
        FlotaEntity flotaEncontrado = flotaInterface.findById(busDto.getBu_CodiFlot()).orElse(null);

        BusEntity nuevoBus = new BusEntity();
        nuevoBus.setBu_Placa(busDto.getBu_Placa());
        nuevoBus.setBu_CodiFlot(flotaEncontrado);
        nuevoBus.setBu_Capacidad(busDto.getBu_Capacidad());
        nuevoBus.setBu_FechaFabri(busDto.getBu_FechaFabri());
        nuevoBus.setBu_Tipo(busDto.getBu_Tipo());
        return busInterface.save(nuevoBus);
    }

    @Override
    public BusEntity editarBus(int bu_placa, BusDto busDto) {
        BusEntity busEncontrado = busInterface.findById(busDto.getBu_Placa()).orElse(null);
        FlotaEntity flotaEncontrado = flotaInterface.findById(busDto.getBu_CodiFlot()).orElse(null);

        if (busEncontrado != null){
            busEncontrado.setBu_CodiFlot(flotaEncontrado);
            busEncontrado.setBu_Capacidad(busDto.getBu_Capacidad());
            busEncontrado.setBu_FechaFabri(busDto.getBu_FechaFabri());
            busEncontrado.setBu_Tipo(busDto.getBu_Tipo());
            return busInterface.save(busEncontrado);
        }
        return null;
    }

    @Override
    public void eliminarBus(int bu_placa) {
        busInterface.deleteById(bu_placa);
    }
}
