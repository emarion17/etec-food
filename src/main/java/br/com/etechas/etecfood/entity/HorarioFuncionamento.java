package br.com.etechas.etecfood.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "HorarioFuncionamento")
public class HorarioFuncionamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_HF")
    private Long id;

    @Column(name = "diaSemana")
    private String diaSemana;

    @Column(name = "horarioAbertura")
    private LocalTime horarioAbertura;

    @Column(name = "horarioFechamento")
    private LocalTime horarioFechamento;

    @ManyToOne
    @JoinColumn(name = "id_restaurante")
    private Restaurante restaurante;
}
