package pe.edu.upeu.libreria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.libreria.dto.ConductorDto;
import pe.edu.upeu.libreria.entity.ConductorEntity;
import pe.edu.upeu.libreria.service.ConductorService;

import java.util.List;


@RestController
@RequestMapping("/api/CONDUCTOR")
@CrossOrigin(origins = {"http://localhost:4200, http://localhost:8080 "})
public class ConductorController {
    @Autowired
    private ConductorService conductorService;

    @GetMapping("/listConductor") //GET
    public ResponseEntity<List<ConductorEntity>> listarConductor(){
        List<ConductorEntity> conductors = conductorService.conductorListar();
        return new ResponseEntity<>(conductors, HttpStatus.OK);
    }

    @GetMapping("/buscarConductorPorId/{co_CodiConduc}") //GET
    public ResponseEntity<ConductorEntity> buscarConductorPorId(@PathVariable Integer co_CodiConduc){
        ConductorEntity conductor = conductorService.buscarConductorPorID(co_CodiConduc);
        return new ResponseEntity<>(conductor, HttpStatus.OK);
    }

    @PostMapping("/addConductor") // POST
    public ResponseEntity<ConductorEntity> crearConductor(@RequestBody ConductorDto conductor){
        ConductorEntity newConductor = conductorService.guardarConductor(conductor);
        if (newConductor != null){
            return new ResponseEntity<>(newConductor, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateConductor/{co_CodiConduc}") //PUT
    public ResponseEntity<ConductorEntity> updateConductor(@PathVariable Integer co_CodiConduc, @RequestBody ConductorDto newConductor){
        ConductorEntity updateConductor = conductorService.editarConductor(co_CodiConduc, newConductor);
        if (updateConductor != null){
            return new ResponseEntity<>(updateConductor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteConductor/{co_CodiConduc}") //DELETE
    public ResponseEntity<Void> deleteConductor(@PathVariable Integer co_CodiConduc){
        conductorService.eliminarConductor(co_CodiConduc);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
