package com.GameDev.TaskManager.repository.desarrollador;

import com.GameDev.TaskManager.domain.Desarrollador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface DesarrolladorRepository extends JpaRepository<Desarrollador, UUID> {

}