package pe.edu.upeu.libreria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.libreria.dto.FlotaDto;
import pe.edu.upeu.libreria.entity.FlotaEntity;
import pe.edu.upeu.libreria.service.FlotaService;

import java.util.List;

@RestController
@RequestMapping("/api/FLOTA")
@CrossOrigin(origins = {"http://localhost:4200, http://localhost:8080 "})
public class FlotaController {
    @Autowired
    private FlotaService flotaService;

    @GetMapping("/listFlota") //GET
    public ResponseEntity<List<FlotaEntity>> listarFlota(){
        List<FlotaEntity> flotas = flotaService.flotaListar();
        return new ResponseEntity<>(flotas, HttpStatus.OK);
    }

    @GetMapping("/buscarFlotaPorId/{fl_CodiFlot}") //GET
    public ResponseEntity<FlotaEntity> buscarFlotaPorId(@PathVariable Integer fl_CodiFlot){
        FlotaEntity flota = flotaService.buscarFlotaPorID(fl_CodiFlot);
        return new ResponseEntity<>(flota, HttpStatus.OK);
    }

    @PostMapping("/addFlota") // POST
    public ResponseEntity<FlotaEntity> crearFlota(@RequestBody FlotaDto flota){
        FlotaEntity newFlota = flotaService.guardarFlota(flota);
        if (newFlota != null){
            return new ResponseEntity<>(newFlota, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateFlota/{fl_CodiFlot}") //PUT
    public ResponseEntity<FlotaEntity> updateFlota(@PathVariable Integer fl_CodiFlot, @RequestBody FlotaDto newFlota){
        FlotaEntity updateFlota = flotaService.editarFlota(fl_CodiFlot, newFlota);
        if (updateFlota != null){
            return new ResponseEntity<>(updateFlota, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteFlota/{fl_CodiFlot}") //DELETE
    public ResponseEntity<Void> deleteFlota(@PathVariable Integer fl_CodiFlot){
        flotaService.eliminarFlota(fl_CodiFlot);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
