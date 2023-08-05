package com.GameDev.TaskManager.repository.juego;

import com.GameDev.TaskManager.domain.Juego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface JuegoRepository extends JpaRepository<Juego, UUID> {

    List<Juego> findAllByFechaDeLanzamientoBefore(LocalDate fecha);
}
