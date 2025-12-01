package br.com.etechas.etecfood.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TBL_CARDAPIO")
public class Cardapio
  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cardapio")
    private Long id;

    @ManyToOne
    @Column(name = "id_restaurante")
    private Restaurante restaurante;
  }
