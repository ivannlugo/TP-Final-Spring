package com.GameDev.TaskManager.domain;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Juego {


    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name ="UUID",strategy="org.hibernate.id.UUIDGenerator")
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length=100,columnDefinition ="varchar(100)",updatable = false,nullable = false )
    private UUID uuid_juego;


    @Column(length = 40,columnDefinition ="varchar(100)",updatable = true,nullable = false)
    private String titulo;

    @Column(length = 40,columnDefinition ="varchar(300)",updatable = true,nullable = false)
    private String descripcion;
    @OneToMany(mappedBy = "juego", cascade = CascadeType.ALL)
       private List <Desarrollador> desarrolladores = new ArrayList<>();

    @OneToMany(mappedBy = "juego")
    private List<Tarea> listaTareas = new ArrayList<>();


    @Column(length = 40,columnDefinition ="varchar(36)",updatable = true,nullable = false)
    private LocalDate fechaDeLanzamiento;


}
