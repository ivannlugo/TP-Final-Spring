package com.GameDev.TaskManager.model.dto;

import com.GameDev.TaskManager.domain.Rol;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DesarrolladorDTO {

  private  String nombre;
  private  String correo;
  private Rol rol;
}
