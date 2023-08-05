package com.GameDev.TaskManager.service.Desarrollador.Impl;

import com.GameDev.TaskManager.domain.Desarrollador;
import com.GameDev.TaskManager.domain.Juego;
import com.GameDev.TaskManager.mapper.Desarrolador.IDesarrolladorMapper;
import com.GameDev.TaskManager.model.dto.DesarrolladorDTO;
import com.GameDev.TaskManager.model.dto.JuegoDTO;
import com.GameDev.TaskManager.repository.desarrollador.DesarrolladorRepository;
import com.GameDev.TaskManager.repository.juego.JuegoRepository;
import com.GameDev.TaskManager.service.Desarrollador.IDesarrolladorService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
@Primary
@AllArgsConstructor
public class DesarrolladorServiceJPAImpl  implements IDesarrolladorService {


    private final DesarrolladorRepository desarrolladorRepository;
    private final JuegoRepository juegoRepository;
    private final IDesarrolladorMapper desarrolladorMapper ;

   @Override
   public Desarrollador agregarDesarrollador(DesarrolladorDTO desarrolladorDTO) {

       Desarrollador desarrolladorNuevo = desarrolladorMapper.desarrolladorDTOADesarrollador(desarrolladorDTO);
       desarrolladorRepository.save(desarrolladorNuevo);

       return desarrolladorNuevo;
   }

    public void asignarDesarrolladorAJuego(String desarrolladorId, String juegoId) {
        Desarrollador desarrollador = desarrolladorRepository.findById(UUID.fromString(desarrolladorId))
                .orElseThrow(() -> new EntityNotFoundException("Desarrollador no encontrado "));
        Juego juego = juegoRepository.findById(UUID.fromString(juegoId))
                .orElseThrow(() -> new EntityNotFoundException("Juego no encontrado "));

        desarrollador.setJuego(juego);
        desarrolladorRepository.save(desarrollador);
    }

    public List<DesarrolladorDTO> mostrarDesarrollador() {
        List<Desarrollador> desarrolladores= desarrolladorRepository.findAll();
        return desarrolladorMapper.listaDesarrolladorAListaDesarrolladorDTO(desarrolladores);
    }
}
