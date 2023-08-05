package com.GameDev.TaskManager.service.Tarea.Impl;

import com.GameDev.TaskManager.domain.Desarrollador;
import com.GameDev.TaskManager.domain.Estado;
import com.GameDev.TaskManager.domain.Juego;
import com.GameDev.TaskManager.domain.Tarea;
import com.GameDev.TaskManager.mapper.Tarea.ITareaMapper;
import com.GameDev.TaskManager.model.dto.JuegoDTO;
import com.GameDev.TaskManager.model.dto.TareaDTO;
import com.GameDev.TaskManager.repository.desarrollador.DesarrolladorRepository;
import com.GameDev.TaskManager.repository.juego.JuegoRepository;
import com.GameDev.TaskManager.repository.tarea.TareaRepository;
import com.GameDev.TaskManager.service.Tarea.ITareaService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Primary
@Service
@AllArgsConstructor
public class TareaServiceJPAImpl implements ITareaService {

    private final TareaRepository tareaRepository;
    private final DesarrolladorRepository desarrolladorRepository;
    private final JuegoRepository juegoRepository;
    private final ITareaMapper tareaMapper;
   @Override
    public List<Tarea> mostrarTarea(){
        return tareaRepository.findAll();
   }
   @Override

   public Tarea agregarTarea(TareaDTO tareaDTO){

       Tarea nuevaTarea = tareaMapper.tareaDTOATarea(tareaDTO);

       Optional<Desarrollador> desarrollador = desarrolladorRepository.findById(UUID.fromString(tareaDTO.getUuid_desarrollador()) );
        Optional<Juego> juego = juegoRepository.findById(UUID.fromString(tareaDTO.getUuid_juego()));
        if(desarrollador.isPresent()) {

             nuevaTarea.setDesarrollador(desarrollador.get());
       }
         if(juego.isPresent()) {

           nuevaTarea.setJuego(juego.get());
         }
         return  tareaRepository.save(nuevaTarea);
   }

   public List <TareaDTO> buscarTareasPorJuego(String uuid_juego){
       Optional<Juego> juego = juegoRepository.findById(UUID.fromString(uuid_juego));
     List<Tarea> tareas = juego.get().getListaTareas();
     return tareaMapper.listaAListaDTO(tareas);

   }
   public List<TareaDTO> mostrarTareaPorDesarrollador(String uuid_desarrollador){
       Optional <Desarrollador> desarrollador = desarrolladorRepository.findById(UUID.fromString(uuid_desarrollador));
       List<Tarea> tareas =  desarrollador.get().getListaTareas();
    return tareaMapper.listaAListaDTO(tareas);
   }
   public List<TareaDTO> buscarTareasFinalizadas(){
      List<Tarea> tareasFueraDePlazo = tareaRepository.findByFechaLimiteBeforeAndEstadoNot(LocalDate.now(), Estado.Completada);
      return tareaMapper.listaAListaDTO(tareasFueraDePlazo);
      }
    public List<TareaDTO> buscarTareasPorEstado(Estado estado) {
        List<Tarea> tareas = tareaRepository.findByEstado(estado);
        return tareaMapper.listaAListaDTO(tareas);
    }
    public void actualizarEstadoTarea( String uuid_tarea, Estado estado) {
        Tarea tarea = tareaRepository.findById(UUID.fromString(uuid_tarea))
                .orElseThrow(() -> new EntityNotFoundException("Tarea no encontrada"));
        tarea.setEstado(estado);
        tareaRepository.save(tarea);
    }
    public List<TareaDTO> buscarTareasPorFechaLimite(LocalDate fechaLimite) {
        List<Tarea> tareas=  tareaRepository.findByFechaLimiteBefore(fechaLimite);
        return  tareaMapper.listaAListaDTO(tareas);
    }
  }


