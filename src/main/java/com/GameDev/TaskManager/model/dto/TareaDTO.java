package com.GameDev.TaskManager.model.dto;

import com.GameDev.TaskManager.domain.Estado;
import lombok.*;

import java.security.PrivateKey;
import java.time.LocalDate;
import java.util.UUID;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TareaDTO {


    private String   uuid_juego;
    private String    uuid_desarrollador;
    private String    descripcion ;
    private LocalDate fechaLimite;
    private Estado     estado;



}
