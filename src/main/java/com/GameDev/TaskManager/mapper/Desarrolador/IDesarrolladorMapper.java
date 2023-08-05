package com.GameDev.TaskManager.mapper.Desarrolador;

import com.GameDev.TaskManager.domain.Desarrollador;
import com.GameDev.TaskManager.model.dto.DesarrolladorDTO;

import java.util.List;

public interface IDesarrolladorMapper {
    Desarrollador desarrolladorDTOADesarrollador(DesarrolladorDTO desarrolladorDTO);

    public DesarrolladorDTO desarrolladorADesarrolladorDTO(Desarrollador desarrollador);
    List<DesarrolladorDTO> listaDesarrolladorAListaDesarrolladorDTO(List<Desarrollador> desarrolladores);
}
