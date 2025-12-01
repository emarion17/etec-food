package br.com.etechas.etecfood.entity;
import br.com.etechas.etecfood.enums.TipoCozinhaEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Restaurante")
public class Restaurante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_restaurante")
    private Long id;

    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "Cep")
    private String cep;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "taxaDeEntrega")
    private Double taxaDeEntrega;

    @Column(name = "TempoDeEntregaMinimo")
    private Integer tempoDeEntregaMinimo;

    @Column(name = "TempoDeEntregaMaximo")
    private Integer tempoDeEntregaMaximo;

    @Column(name = "aprovado")
    private boolean aprovado;

    @Column(name = "tipoCozinha")
    @Enumerated(EnumType.STRING)
    private TipoCozinhaEnum tipoDeCozinha;

    // private Usuario usuario;
}
