package com.GameDev.TaskManager.model.Csv;

import com.opencsv.bean.CsvBindAndJoinByName;
import com.opencsv.bean.CsvBindByName;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JuegoCsvRecord {
       
       @CsvBindByName(column = "titulo")
       private String titulo;

       @CsvBindByName(column = "tarea"  )
       private String tarea;

       @CsvBindByName(column= "desarrolladores" )
       private String desarrolladores;

       @CsvBindByName(column= "descripcion")
       private String descripcion;

}
