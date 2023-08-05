package com.GameDev.TaskManager.mapper.Desarrolador;

import com.GameDev.TaskManager.domain.Desarrollador;
import com.GameDev.TaskManager.model.dto.DesarrolladorDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class DesarrolladorMapper implements IDesarrolladorMapper{

    public Desarrollador desarrolladorDTOADesarrollador(DesarrolladorDTO desarrolladorDTO) {
        return Desarrollador.builder()
                .uuid_desarrollador(UUID.randomUUID())
                .nombre(desarrolladorDTO.getNombre())
                .correo(desarrolladorDTO.getCorreo())
                .rol(desarrolladorDTO.getRol())
                .build();
    }

    public DesarrolladorDTO desarrolladorADesarrolladorDTO(Desarrollador desarrollador) {
        return DesarrolladorDTO.builder()
                .nombre(desarrollador.getNombre())
                .correo(desarrollador.getCorreo())
                .rol(desarrollador.getRol())
                .build();
    }


    public List<DesarrolladorDTO> listaDesarrolladorAListaDesarrolladorDTO(List<Desarrollador> desarrolladores) {
        return desarrolladores.stream().map(this::desarrolladorADesarrolladorDTO).collect(Collectors.toList());
    }
}