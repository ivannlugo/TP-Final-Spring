package com.GameDev.TaskManager.controller;

import com.GameDev.TaskManager.domain.Estado;
import com.GameDev.TaskManager.domain.Tarea;
import com.GameDev.TaskManager.model.dto.TareaDTO;
import com.GameDev.TaskManager.service.Tarea.ITareaService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@RestController
@Slf4j
@RequestMapping("/api/v1/tarea")
public class TareaController {


    //IoC Inversion de control
    ITareaService tareaService;
@Autowired
    public TareaController(ITareaService tareaService) {
        this.tareaService = tareaService;
    }


    //GET --> Obtener un recurso
    @GetMapping()
    public List<Tarea> mostrarTareas(){
    log.info("se agrego una tarea");
             return  tareaService.mostrarTarea();
    }

    //POST --> Crear un recurso
    @PostMapping()
    public Tarea crearTarea(@RequestBody TareaDTO tareaDTO){
        return  tareaService.agregarTarea(tareaDTO);
    }

    @GetMapping("/{desarrolladorId}")
    public ResponseEntity<List<TareaDTO>> listarTareasPorDesarrollador(@PathVariable String desarrolladorId) {
        List<TareaDTO> tareas = tareaService.mostrarTareaPorDesarrollador(desarrolladorId);
        return ResponseEntity.ok(tareas);
    }
    @GetMapping("/buscar-por-juego")
    public ResponseEntity<List<TareaDTO>> buscarTareasPorJuego(@RequestParam String id_juego) {
        List<TareaDTO> tareas = tareaService.buscarTareasPorJuego(id_juego);
        return ResponseEntity.ok(tareas);
    }
    @GetMapping("/buscar-fuera-de-plazo")
    public ResponseEntity<List<TareaDTO>> buscarTareasFueraDePlazo() {
        List<TareaDTO> tareas = tareaService.buscarTareasFinalizadas();
        return ResponseEntity.ok(tareas);
     }
    @GetMapping("/buscar-por-estado")
    public ResponseEntity<List<TareaDTO>> buscarTareasPorEstado(@RequestParam Estado estado) {
        List<TareaDTO> tareas = tareaService.buscarTareasPorEstado(estado);
        return ResponseEntity.ok(tareas);
    }

    @PutMapping("/{uuid_tarea}/estado")
    public ResponseEntity<Void> actualizarEstadoTarea(
            @PathVariable(value = "uuid_tarea")  String uuid_tarea, @RequestParam Estado estado) {
        tareaService.actualizarEstadoTarea(uuid_tarea, estado);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/buscar-por-fecha-limite")
    public ResponseEntity<List<TareaDTO>> buscarTareasPorFechaLimite(@RequestParam LocalDate fecha) {
        List<TareaDTO> tareas = tareaService.buscarTareasPorFechaLimite(fecha);
        return ResponseEntity.ok(tareas);
    }
}
