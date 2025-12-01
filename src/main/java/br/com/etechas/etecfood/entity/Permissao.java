package br.com.etechas.etecfood.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Permissao")
@Data
public class Permissao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String authority;
}
