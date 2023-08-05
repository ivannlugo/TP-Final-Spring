package com.GameDev.TaskManager.repository.tarea;

import com.GameDev.TaskManager.domain.Desarrollador;
import com.GameDev.TaskManager.domain.Estado;
import com.GameDev.TaskManager.domain.Juego;
import com.GameDev.TaskManager.domain.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
@Repository
public interface TareaRepository extends JpaRepository <Tarea, UUID> {
    List<Tarea> findByDesarrollador(Desarrollador desarrollador);
    List<Tarea> findByEstado(Estado estado);
    List<Tarea> findByJuego(Juego juego);
    List<Tarea> findByFechaLimiteBefore(LocalDate fechaLimite);
    List<Tarea> findByFechaLimiteBeforeAndEstadoNot(LocalDate fechaLimite,Estado estado);
}

