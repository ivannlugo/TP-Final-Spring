package com.GameDev.TaskManager.model.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JuegoDTO {
    private String titulo;
    private String descripcion;
    private LocalDate fechaDeLanzamiento;

}
