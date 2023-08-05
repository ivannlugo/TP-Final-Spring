package com.GameDev.TaskManager.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Desarrollador {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name ="UUID",strategy="org.hibernate.id.UUIDGenerator")
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length=36,columnDefinition ="varchar(36)",updatable = false,nullable = false )
    private UUID uuid_desarrollador;

    @Column(length = 40,columnDefinition ="varchar(100)",updatable = true,nullable = false)
    private String nombre;

    @Column(length = 40,columnDefinition ="varchar(100)",updatable = true,nullable = false)
    private String correo;

    @Column(length = 40,columnDefinition ="varchar(100)",updatable = true,nullable = false)
    @Enumerated(EnumType.STRING)
    private Rol rol;

   // @OneToMany(mappedBy = "desarrollador")
   @OneToMany(mappedBy = "desarrollador", cascade = CascadeType.ALL)
    private List<Tarea> listaTareas;

    @ManyToOne
    @JoinColumn(name = "uuid_juego")
    private Juego juego;

}
