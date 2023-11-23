package pe.edu.upeu.libreria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.libreria.dto.ViajeDto;
import pe.edu.upeu.libreria.entity.ViajeEntity;
import pe.edu.upeu.libreria.service.ViajeService;

import java.util.List;


@RestController
@RequestMapping("/api/CONDUCTOR")
@CrossOrigin(origins = {"http://localhost:4200, http://localhost:8080 "})
public class ViajeController {
    @Autowired
    private ViajeService viajeService;

    @GetMapping("/listViaje") //GET
    public ResponseEntity<List<ViajeEntity>> listarViaje(){
        List<ViajeEntity> viajes = viajeService.viajeListar();
        return new ResponseEntity<>(viajes, HttpStatus.OK);
    }

    @GetMapping("/buscarViajePorId/{vi_NumeVuelta}") //GET
    public ResponseEntity<ViajeEntity> buscarViajePorId(@PathVariable Integer vi_NumeVuelta){
        ViajeEntity viaje = viajeService.buscarViajePorID(vi_NumeVuelta);
        return new ResponseEntity<>(viaje, HttpStatus.OK);
    }

    @PostMapping("/addViaje") // POST
    public ResponseEntity<ViajeEntity> crearViaje(@RequestBody ViajeDto viaje){
        ViajeEntity newViaje = viajeService.guardarViaje(viaje);
        if (newViaje != null){
            return new ResponseEntity<>(newViaje, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateViaje/{vi_NumeVuelta}") //PUT
    public ResponseEntity<ViajeEntity> updateViaje(@PathVariable Integer vi_NumeVuelta, @RequestBody ViajeDto newViaje){
        ViajeEntity updateViaje = viajeService.editarViaje(vi_NumeVuelta, newViaje);
        if (updateViaje != null){
            return new ResponseEntity<>(updateViaje, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteViaje/{vi_NumeVuelta}") //DELETE
    public ResponseEntity<Void> deleteViaje(@PathVariable Integer vi_NumeVuelta){
        viajeService.eliminarViaje(vi_NumeVuelta);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
