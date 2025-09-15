package br.com.etechas.etecfood.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table (name = "TBL_CLIENTE")
@Getter
@Setter
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLIENTE")
    private Long id;
    @Column(name = "TX_CPF")
    private String cpf;
    @Column(name = "TX_EMAIL")
    private String email;
    @Column(name = "TX_TELEFONE")
    private String telefone;
    @Column(name = "IN_VALIDADO")
    private Boolean validado;
}

