package pe.edu.upeu.libreria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.libreria.dto.RutaDto;
import pe.edu.upeu.libreria.entity.RutaEntity;
import pe.edu.upeu.libreria.service.RutaService;

import java.util.List;


@RestController
@RequestMapping("/api/BUS")
@CrossOrigin(origins = {"http://localhost:4200, http://localhost:8080 "})
public class RutaController {
    @Autowired
    private RutaService rutaService;

    @GetMapping("/listRuta") //GET
    public ResponseEntity<List<RutaEntity>> listarRuta(){
        List<RutaEntity> rutas = rutaService.rutaListar();
        return new ResponseEntity<>(rutas, HttpStatus.OK);
    }

    @GetMapping("/buscarRutaPorId/{ru_CodiRuta}") //GET
    public ResponseEntity<RutaEntity> buscarRutaPorId(@PathVariable Integer ru_CodiRuta){
        RutaEntity bus = rutaService.buscarRutaPorID(ru_CodiRuta);
        return new ResponseEntity<>(bus, HttpStatus.OK);
    }

    @PostMapping("/addRuta") // POST
    public ResponseEntity<RutaEntity> crearRuta(@RequestBody RutaDto ruta){
        RutaEntity newRuta = rutaService.guardarRuta(ruta);
        if (newRuta != null){
            return new ResponseEntity<>(newRuta, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateRuta/{ru_CodiRuta}") //PUT
    public ResponseEntity<RutaEntity> updateRuta(@PathVariable Integer ru_CodiRuta, @RequestBody RutaDto newRuta){
        RutaEntity updateRuta = rutaService.editarRuta(ru_CodiRuta, newRuta);
        if (updateRuta != null){
            return new ResponseEntity<>(updateRuta, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteRuta/{ru_CodiRuta}") //DELETE
    public ResponseEntity<Void> deleteRuta(@PathVariable Integer ru_CodiRuta){
        rutaService.eliminarRuta(ru_CodiRuta);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
