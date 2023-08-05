package com.GameDev.TaskManager.controller;

import com.GameDev.TaskManager.domain.Juego;
import com.GameDev.TaskManager.model.dto.DesarrolladorDTO;
import com.GameDev.TaskManager.model.dto.JuegoDTO;
import com.GameDev.TaskManager.service.Juego.IJuegoService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@NoArgsConstructor
@RequestMapping("/api/v1/juego")
public class JuegoController {

    IJuegoService juegoService;

    @Autowired
    public JuegoController(IJuegoService juegoService) {
        this.juegoService = juegoService;
    }

    //GET --> Obtener un recurso
    @GetMapping
    public ResponseEntity<List<JuegoDTO>> mostrarJuegos() {
        List<JuegoDTO> juegos = juegoService.mostrarJuegos();
        return ResponseEntity.ok(juegos);
    }

    //POST --> Crear un recurso
    @PostMapping()
    public ResponseEntity crearJuego(@RequestBody JuegoDTO juegoDTO) {
        Juego juegoCreado = juegoService.agregarJuego(juegoDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/juego/" + juegoCreado.getUuid_juego());
        return new ResponseEntity(headers, HttpStatus.CREATED);

    }

    @GetMapping("/finalizados")
    public ResponseEntity<List<JuegoDTO>> listaJuegosFinalizados() {
        List<JuegoDTO> juegosFinalizados = juegoService.listaJuegosFinalizados();
        return ResponseEntity.ok(juegosFinalizados);
    }
    @GetMapping("/desarrolladores")
    public ResponseEntity<List<DesarrolladorDTO>> listaDesarrolladoresPorJuego(@RequestParam String id ){
        List<DesarrolladorDTO> desarrolladores = juegoService.listarDesarrolladoresPorJuego(id);
        return ResponseEntity.ok(desarrolladores);
    }

}