package com.GameDev.TaskManager.controller;


import com.GameDev.TaskManager.domain.Desarrollador;
import com.GameDev.TaskManager.model.dto.AsignacionDTO;
import com.GameDev.TaskManager.model.dto.DesarrolladorDTO;
import com.GameDev.TaskManager.service.Desarrollador.IDesarrolladorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/desarrollador")
public class DesarrolladorController {


    IDesarrolladorService desarrolladorService;
    @Autowired
    public DesarrolladorController(IDesarrolladorService desarrolladorService) {
        this.desarrolladorService = desarrolladorService;
    }


    //GET --> Obtener un recurso
    @GetMapping()
    public List<DesarrolladorDTO> mostrarDesarrollador() {
        return desarrolladorService.mostrarDesarrollador();
    }

    //POST --> Crear un recurso
    @PostMapping()
    public Desarrollador crearDesarrollador(@RequestBody DesarrolladorDTO desarrolladorDTO) {
        return desarrolladorService.agregarDesarrollador(desarrolladorDTO);
    }

    @PostMapping("/asignar-juego")
    public ResponseEntity<Void> asignarDesarrolladorAJuego(@RequestBody AsignacionDTO asignacionDTO) {
        desarrolladorService.asignarDesarrolladorAJuego(asignacionDTO.getUuid_desarrollador(), asignacionDTO.getUuid_juego());
        return ResponseEntity.ok().build();
    }
}