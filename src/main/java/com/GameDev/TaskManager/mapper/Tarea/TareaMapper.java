package com.GameDev.TaskManager.mapper.Tarea;

import com.GameDev.TaskManager.domain.Desarrollador;
import com.GameDev.TaskManager.domain.Juego;
import com.GameDev.TaskManager.domain.Tarea;
import com.GameDev.TaskManager.model.dto.TareaDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class TareaMapper implements  ITareaMapper {

    public Tarea tareaDTOATarea(TareaDTO tareaDTO) {

        return Tarea.builder()
                .uuid_Tarea(UUID.randomUUID())
                .descripcion(tareaDTO.getDescripcion())
                .fechaLimite(tareaDTO.getFechaLimite())
                .estado(tareaDTO.getEstado())
                .build();
    }

    public TareaDTO tareaATareaDTO(Tarea tarea) {
        Desarrollador desarrollador = tarea.getDesarrollador();
        Juego juego = tarea.getJuego();
        return TareaDTO.builder()
                .uuid_juego(juego.getUuid_juego().toString())
                .uuid_desarrollador(desarrollador.getUuid_desarrollador().toString())
                .descripcion(tarea.getDescripcion())
                .fechaLimite(tarea.getFechaLimite())
                .estado(tarea.getEstado())
                .build();
    }

    public List<TareaDTO> listaAListaDTO(List<Tarea> tareas) {
        return tareas.stream().map(this::tareaATareaDTO).collect(Collectors.toList());
    }
}