package br.com.etechas.etecfood.Entity;

import br.com.etechas.etecfood.Enum.StatusPagamentoEnum;
import br.com.etechas.etecfood.Enum.TipoFormaPagamentoEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity

@Getter
@Setter

@Table(name = "TBL_PAGAMENTO")
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PAGAMENTO")
    private Long id;

    @Column(name = "NR_VALOR")
    private Double valor;

    @Column(name = "TX_NOME")
    private String nome;

    @Column(name = "NR_NUMERO")
    private String numero;

    @Column(name = "TX_EXPIRACAO")
    private String expiracao;

    @Column(name = "TX_CODIGO")
    private String codigo;

    @Column(name = "TX_STATUS")
    private StatusPagamentoEnum status;

    @OneToMany
    @JoinColumn(name = "ID_FORMA_PAGAMENTO")
    private FormaPagamento formaPagamento;

    @OneToOne
    @JoinColumn(name = "ID_PEDIDO")
    private Pedido pedido;

}
