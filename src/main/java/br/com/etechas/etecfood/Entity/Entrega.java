package br.com.etechas.etecfood.Entity;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

@Table(name = "TBL_ENTREGA")
@Getter
@Setter
public class Entrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ENTREGA")
    private Long id;
    @OneToMany
    @JoinColumn(name = "ID_CLIENTE")
    private Cliente cliente;
    @Column(name = "TX_CPF")
    private String cep;
    @Column(name = "TX_COMPLEMENTO")
    private String complemento;
    @ManyToOne
    @JoinColumn("ID_PEDIDO")
    private Pedido pedido;
}
