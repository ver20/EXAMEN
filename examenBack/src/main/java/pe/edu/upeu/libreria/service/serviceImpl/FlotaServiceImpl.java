package pe.edu.upeu.libreria.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.libreria.dto.FlotaDto;
import pe.edu.upeu.libreria.entity.FlotaEntity;
import pe.edu.upeu.libreria.entity.TerminalEntity;
import pe.edu.upeu.libreria.repository.FlotaInterface;
import pe.edu.upeu.libreria.repository.TerminalInterface;
import pe.edu.upeu.libreria.service.FlotaService;

import java.util.List;

@Service
public class FlotaServiceImpl implements FlotaService {
    @Autowired
    private FlotaInterface flotaInterface;

    @Autowired //Verificar que exista el terminal
    private TerminalInterface terminalInterface;

    //Inicializacion de los objetos
    @Override
    public List<FlotaEntity> flotaListar() {
        return flotaInterface.findAll();
    }

    @Override
    public FlotaEntity buscarFlotaPorID(int fl_CodiFlot) {
        return flotaInterface.findById(fl_CodiFlot)
                .orElseThrow(null);
    }

    @Override
    public FlotaEntity guardarFlota(FlotaDto flotaDto) {
        TerminalEntity terminalEncontrado = terminalInterface.findById(flotaDto.getFl_CodiTerm()).orElse(null);

        FlotaEntity nuevoFlota = new FlotaEntity();
        nuevoFlota.setFl_NombFlot(flotaDto.getFl_NombFlot());
        nuevoFlota.setFl_CodiTerm(terminalEncontrado);
        return flotaInterface.save(nuevoFlota);
    }

    @Override
    public FlotaEntity editarFlota(int fl_CodiFlot, FlotaDto flotaDto) {
        TerminalEntity terminalEncontrado = terminalInterface.findById(flotaDto.getFl_CodiTerm()).orElse(null);
        FlotaEntity flotaEncontrado = flotaInterface.findById(flotaDto.getFl_CodiFlot()).orElse(null);

        if (flotaEncontrado != null){
            flotaEncontrado.setFl_NombFlot(flotaDto.getFl_NombFlot());
            flotaEncontrado.setFl_CodiTerm(terminalEncontrado);
            return flotaInterface.save(flotaEncontrado);
        }
        return null;
    }

    @Override
    public void eliminarFlota(int fl_CodiFlot) {
        flotaInterface.deleteById(fl_CodiFlot);
    }

}
