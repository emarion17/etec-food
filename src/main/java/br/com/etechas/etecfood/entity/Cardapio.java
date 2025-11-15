package br.com.etechas.etecfood.entity

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

public class Cardapio
  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Colunm(name = "id")
    private Long id_cardapio

    @ManyToOne
    @Colunm(name = "restaurante")
    private Restaurante restaurante
  }
