package pe.edu.upeu.libreria.service;
import pe.edu.upeu.libreria.dto.TerminalDto;
import pe.edu.upeu.libreria.entity.TerminalEntity;

import java.util.List;

public interface TerminalService {
    List<TerminalEntity> terminalListar();
    TerminalEntity buscarTerminalPorID(int te_CodiTerm);
    TerminalEntity guardarTerminal(TerminalDto terminalDto);
    TerminalEntity editarTerminal(int te_CodiTerm, TerminalDto terminalDto);
    void eliminarTerminal(int te_CodiTerm);
}
