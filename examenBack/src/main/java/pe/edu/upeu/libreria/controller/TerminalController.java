package pe.edu.upeu.libreria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.libreria.dto.TerminalDto;
import pe.edu.upeu.libreria.entity.TerminalEntity;
import pe.edu.upeu.libreria.service.TerminalService;

import java.util.List;


@RestController
@RequestMapping("/api/BUS")
@CrossOrigin(origins = {"http://localhost:4200, http://localhost:8080 "})
public class TerminalController {
    @Autowired
    private TerminalService terminalService;

    @GetMapping("/listTerminal") //GET
    public ResponseEntity<List<TerminalEntity>> listarTerminal(){
        List<TerminalEntity> terminals = terminalService.terminalListar();
        return new ResponseEntity<>(terminals, HttpStatus.OK);
    }

    @GetMapping("/buscarTerminalPorId/{ru_CodiRuta}") //GET
    public ResponseEntity<TerminalEntity> buscarTerminalPorId(@PathVariable Integer te_CodiTerm){
        TerminalEntity terminal = terminalService.buscarTerminalPorID(te_CodiTerm);
        return new ResponseEntity<>(terminal, HttpStatus.OK);
    }

    @PostMapping("/addTerminal") // POST
    public ResponseEntity<TerminalEntity> crearTerminal(@RequestBody TerminalDto terminal){
        TerminalEntity newTerminal = terminalService.guardarTerminal(terminal);
        if (newTerminal != null){
            return new ResponseEntity<>(newTerminal, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateTerminal/{te_CodiTerm}") //PUT
    public ResponseEntity<TerminalEntity> updateTerminal(@PathVariable Integer te_CodiTerm, @RequestBody TerminalDto newTerminal){
        TerminalEntity updateTerminal = terminalService.editarTerminal(te_CodiTerm, newTerminal);
        if (updateTerminal != null){
            return new ResponseEntity<>(updateTerminal, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteTerminal/{te_CodiTerm}") //DELETE
    public ResponseEntity<Void> deleteTerminal(@PathVariable Integer te_CodiTerm){
        terminalService.eliminarTerminal(te_CodiTerm);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
