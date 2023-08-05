package com.GameDev.TaskManager.service.Juego;

import com.GameDev.TaskManager.domain.Juego;
import com.GameDev.TaskManager.model.dto.DesarrolladorDTO;
import com.GameDev.TaskManager.model.dto.JuegoDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IJuegoService {


    Juego agregarJuego(JuegoDTO juegoDTO);

    List<JuegoDTO> mostrarJuegos();

    List<JuegoDTO> listaJuegosFinalizados();
    List<DesarrolladorDTO> listarDesarrolladoresPorJuego(String juegoId);
}
