package com.GameDev.TaskManager.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Tarea {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name ="UUID",strategy="org.hibernate.id.UUIDGenerator")
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length=100,columnDefinition ="varchar(36)",updatable = false,nullable = false )
    private UUID uuid_Tarea;


    @Column(length = 40,columnDefinition ="varchar(36)",updatable = true,nullable = false)
    private String descripcion;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinColumn(name = "uuid_desarrollador")
    private Desarrollador desarrollador;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinColumn(name = "uuid_juego")
    private Juego juego;

    @Column(length = 40,columnDefinition ="varchar(36)",updatable = true,nullable = false)
    @Enumerated(EnumType.STRING)
    private Estado estado;

    @Column(length = 40,columnDefinition ="varchar(36)",updatable = true,nullable = false)
     private LocalDate fechaLimite;

    public void setDesarrollador(Desarrollador desarrollador) {
        this.desarrollador = desarrollador;
        desarrollador.getListaTareas().add(this);
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
        juego.getListaTareas().add(this);
    }
}
