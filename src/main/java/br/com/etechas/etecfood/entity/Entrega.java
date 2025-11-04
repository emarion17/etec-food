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
    @JoinColumn("ID_PEDIDO")
    private Pedido pedido;
}
