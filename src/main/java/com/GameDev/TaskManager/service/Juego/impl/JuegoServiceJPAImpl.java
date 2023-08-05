package com.GameDev.TaskManager.service.Juego.impl;

import com.GameDev.TaskManager.domain.Desarrollador;
import com.GameDev.TaskManager.domain.Juego;
import com.GameDev.TaskManager.mapper.Desarrolador.IDesarrolladorMapper;
import com.GameDev.TaskManager.mapper.Juego.IJuegoMapper;
import com.GameDev.TaskManager.model.dto.DesarrolladorDTO;
import com.GameDev.TaskManager.model.dto.JuegoDTO;
import com.GameDev.TaskManager.repository.desarrollador.DesarrolladorRepository;
import com.GameDev.TaskManager.repository.juego.JuegoRepository;
import com.GameDev.TaskManager.service.Juego.IJuegoService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@Primary
@AllArgsConstructor
public class JuegoServiceJPAImpl implements IJuegoService {

    private final JuegoRepository juegoRepository ;
    private final DesarrolladorRepository desarrolladorRepository;
    private final IJuegoMapper juegoMapper;
    private final IDesarrolladorMapper desarrolladorMapper;

    @Override
    public Juego agregarJuego(JuegoDTO juegoDTO) {
        Juego nuevoJuego = juegoMapper.juegoDTOAjuego(juegoDTO);
       return juegoRepository.save(nuevoJuego);
    }
    @Override
    public List<JuegoDTO> mostrarJuegos() {
        List<Juego> juegos = juegoRepository.findAll();
        return juegoMapper.listaJuegoAListaJuegoDTO(juegos);
    }
    @Override
    public List<JuegoDTO> listaJuegosFinalizados() {
        List<Juego> juegosFinalizados = juegoRepository.findAllByFechaDeLanzamientoBefore(LocalDate.now());
        return juegoMapper.listaJuegoAListaJuegoDTO(juegosFinalizados);
    }
    public List<DesarrolladorDTO> listarDesarrolladoresPorJuego(String juegoId) {
        Juego juego = juegoRepository.findById(UUID.fromString(juegoId))
                .orElseThrow(() -> new EntityNotFoundException("Juego no encontrado"));
        return desarrolladorMapper.listaDesarrolladorAListaDesarrolladorDTO(juego.getDesarrolladores());
    }

}
