package br.com.etechas.etecfood.entity;

import br.com.etechas.etecfood.enums.StatusPedidoEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter

@Entity

@Table(name = "TBL_PEDIDO")
public class Pedido {

    @Id // -> Chave Primária (PK)
    @Column(name = "ID_PEDIDO")
    private Long id;

    @Column(name = "DT_CRIACAO")
    private LocalDateTime dataCriacao;

    @Column(name = "TP_STATUS")
    private StatusPedidoEnum status;

    @Column(name = "ID_RESTAURANTE")
    @ManyToOne
    private Restaurante restaurante;


}
