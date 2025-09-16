package br.com.etechas.etecfood.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity

@Table(name = "TBL_AVALIACAO")
public class Avaliacao {
    @Id
    @Column(name = "ID_AVALIACAO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NR_NOTA")
    private Integer nota;

    @Column(name = "TP_COMENTARIO")
    private String comentario;

    @Column(name = "ID_PEDIDO")
    @ManyToOne
    private Pedido pedido;


}
