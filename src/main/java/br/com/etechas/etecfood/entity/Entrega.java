package br.com.etechas.etecfood.entity;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TBL_ENTREGA")
@Getter
@Setter
public class Entrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ENTREGA")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "TX_CPF")
    private Cliente cliente;
    @Column(name = "TX_CEP")
    private String cep;
    @Column(name = "TX_ENDERECO")
    private String endereco;
    @Column(name = "TX_COMPLEMENTO")
    private String complemento;
    @OneToMany
    @JoinColumn(name = "ID_PEDIDO")
    private Pedido pedido;
}
