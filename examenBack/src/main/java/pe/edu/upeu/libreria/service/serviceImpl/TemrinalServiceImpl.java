package pe.edu.upeu.libreria.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.libreria.dto.TerminalDto;
import pe.edu.upeu.libreria.entity.TerminalEntity;
import pe.edu.upeu.libreria.repository.TerminalInterface;
import pe.edu.upeu.libreria.service.TerminalService;

import java.util.List;

@Service
public class TemrinalServiceImpl implements TerminalService {
    @Autowired
    private TerminalInterface terminalInterface;

    //Inicializacion de los objetos
    @Override
    public List<TerminalEntity> terminalListar() {
        return terminalInterface.findAll();
    }

    @Override
    public TerminalEntity buscarTerminalPorID(int te_CodiTerm) {
        return terminalInterface.findById(te_CodiTerm)
                .orElseThrow(null);
    }

    @Override
    public TerminalEntity guardarTerminal(TerminalDto terminalDto) {

        TerminalEntity nuevoTerminal = new TerminalEntity();
        nuevoTerminal.setTe_CodiTerm(terminalDto.getTe_CodiTerm());
        nuevoTerminal.setTe_DireTerm(terminalDto.getTe_DireTerm());
        nuevoTerminal.setTe_NombTerm(terminalDto.getTe_NombTerm());

        return terminalInterface.save(nuevoTerminal);
    }

    @Override
    public TerminalEntity editarTerminal(int te_CodiTerm, TerminalDto terminalDto) {
        TerminalEntity terminalEncontrado = terminalInterface.findById(terminalDto.getTe_CodiTerm()).orElse(null);

        if (terminalEncontrado != null){
            terminalEncontrado.setTe_DireTerm(terminalDto.getTe_DireTerm());
            terminalEncontrado.setTe_NombTerm(terminalDto.getTe_NombTerm());
            return terminalInterface.save(terminalEncontrado);
        }
        return null;
    }

    @Override
    public void eliminarTerminal(int te_CodiTerm) {
        terminalInterface.deleteById(te_CodiTerm);
    }
}
