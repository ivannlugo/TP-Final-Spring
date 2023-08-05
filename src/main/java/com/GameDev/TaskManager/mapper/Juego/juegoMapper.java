package com.GameDev.TaskManager.mapper.Juego;

import com.GameDev.TaskManager.domain.Juego;
import com.GameDev.TaskManager.model.dto.JuegoDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class juegoMapper implements IJuegoMapper {

    public Juego juegoDTOAjuego(JuegoDTO juego) {

        return  Juego.builder()
                .uuid_juego(UUID.randomUUID())
                .titulo(juego.getTitulo())
                .descripcion(juego.getDescripcion())
                .fechaDeLanzamiento(juego.getFechaDeLanzamiento())
                .build();
    }
    public List<JuegoDTO> listaJuegoAListaJuegoDTO (List<Juego> juegos) {
        return juegos.stream().map(this::juegoAjuegoDTO).collect(Collectors.toList());
    }
    public JuegoDTO juegoAjuegoDTO(Juego juegodto){
        return  JuegoDTO.builder()
                .titulo(juegodto.getTitulo())
                .descripcion(juegodto.getDescripcion())
                .fechaDeLanzamiento(juegodto.getFechaDeLanzamiento())
                .build();
    }
}
