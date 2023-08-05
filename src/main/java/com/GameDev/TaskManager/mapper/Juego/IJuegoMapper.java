package com.GameDev.TaskManager.mapper.Juego;

import com.GameDev.TaskManager.domain.Juego;
import com.GameDev.TaskManager.model.dto.JuegoDTO;

import java.util.List;

public interface IJuegoMapper {

    Juego juegoDTOAjuego(JuegoDTO juego);
    JuegoDTO juegoAjuegoDTO(Juego juegodto);
    List<JuegoDTO> listaJuegoAListaJuegoDTO (List<Juego> juegos);
}
