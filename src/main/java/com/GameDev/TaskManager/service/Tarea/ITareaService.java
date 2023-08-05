package com.GameDev.TaskManager.service.Tarea;

import com.GameDev.TaskManager.domain.Estado;
import com.GameDev.TaskManager.domain.Tarea;
import com.GameDev.TaskManager.model.dto.TareaDTO;

import java.util.List;

public interface ITareaService {

    Tarea agregarTarea(TareaDTO tareaDTO);

     List<Tarea> mostrarTarea();

    List<TareaDTO> mostrarTareaPorDesarrollador(String uuid_desarrollador);

    List <TareaDTO> buscarTareasPorJuego(String uuid_juego);
    List<TareaDTO> buscarTareasFinalizadas();

    List<TareaDTO> buscarTareasPorEstado(Estado estado);
    public void actualizarEstadoTarea( String uuid_tarea, Estado estado);
}
