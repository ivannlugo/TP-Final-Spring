package com.GameDev.TaskManager.service.Desarrollador;

import com.GameDev.TaskManager.domain.Desarrollador;
import com.GameDev.TaskManager.model.dto.DesarrolladorDTO;

import java.util.List;

public interface IDesarrolladorService {

    Desarrollador agregarDesarrollador(DesarrolladorDTO desarrolladorDTO);

    List<DesarrolladorDTO> mostrarDesarrollador();
    void asignarDesarrolladorAJuego(String desarrolladorId, String juegoId);


}
