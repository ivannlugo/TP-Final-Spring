package com.GameDev.TaskManager.mapper.Tarea;

import com.GameDev.TaskManager.domain.Tarea;
import com.GameDev.TaskManager.model.dto.TareaDTO;
import org.springframework.stereotype.Component;

import java.util.List;


public interface ITareaMapper {

   Tarea tareaDTOATarea(TareaDTO tareaDTO);

   TareaDTO tareaATareaDTO(Tarea tarea);

   List<TareaDTO> listaAListaDTO(List<Tarea> tareas);
}
