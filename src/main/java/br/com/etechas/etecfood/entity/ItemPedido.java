package br.com.etechas.etecfood.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

@Entity

@Table(name = "TBL_ITEM_PEDIDO")
public class ItemPedido {

    @Id
    @Column(name = "ID_ITEM_PEDIDO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NR_QUANTIDADE")
    private Integer quantidade;

    @Column(name = "TP_OBSERVACAO")
    private String observacao;

    @ManyToOne
    @Column(name = "ID_PEDIDO")
    private Pedido pedido;

    @ManyToOne
    @Column(name = "ID_ITEM_CARDAPIO")
    private ItemCardapio itemCardapio;
}

