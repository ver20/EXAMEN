package pe.edu.upeu.libreria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.libreria.dto.BusDto;
import pe.edu.upeu.libreria.entity.BusEntity;
import pe.edu.upeu.libreria.service.BusService;

import java.util.List;


@RestController
@RequestMapping("/api/BUS")
@CrossOrigin(origins = {"http://localhost:4200, http://localhost:8080 "})
public class BusController {
    @Autowired
    private BusService busService;

    @GetMapping("/listBus") //GET
    public ResponseEntity<List<BusEntity>> listarBus(){
        List<BusEntity> buss = busService.busListar();
        return new ResponseEntity<>(buss, HttpStatus.OK);
    }

    @GetMapping("/buscarBusPorId/{bu_placa}") //GET
    public ResponseEntity<BusEntity> buscarBusPorId(@PathVariable Integer bu_placa){
        BusEntity bus = busService.buscarBusPorID(bu_placa);
        return new ResponseEntity<>(bus, HttpStatus.OK);
    }

    @PostMapping("/addBus") // POST
    public ResponseEntity<BusEntity> crearBus(@RequestBody BusDto bus){
        BusEntity newBus = busService.guardarBus(bus);
        if (newBus != null){
            return new ResponseEntity<>(newBus, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateBus/{bu_placa}") //PUT
    public ResponseEntity<BusEntity> updateBus(@PathVariable Integer bu_placa, @RequestBody BusDto newBus){
        BusEntity updateBus = busService.editarBus(bu_placa, newBus);
        if (updateBus != null){
            return new ResponseEntity<>(updateBus, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteBus/{bu_placa}") //DELETE
    public ResponseEntity<Void> deleteBus(@PathVariable Integer bu_placa){
        busService.eliminarBus(bu_placa);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
