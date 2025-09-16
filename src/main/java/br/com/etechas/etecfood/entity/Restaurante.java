package br.com.etechas.etecfood.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity

@Table(name = "TBL_RESTAURANTE")
public class Restaurante {
    @Id
    @Column(name = "ID_RESTAURANTE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
