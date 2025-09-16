package br.com.etechas.etecfood.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Entity

@Getter
@Setter

@Table(name = "TBL_FORMA_PAGAMENTO")
public class FormaPagamento {
    @Id
    @Column(name = "ID_FORMA_PAGAMENTO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TX_NOME")
    private String nome;

    @Column(name = "TP_TIPO")
    private String tipo;
}
