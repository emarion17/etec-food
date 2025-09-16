package br.com.etechas.etecfood.Entity;
import br.com.etechas.etecfood.enums.TipoCozinhaEnum;


public class Restaurante {
    private Long id;
    private String cnpj;
    private String nome;
    private String descricao;
    private String cep;
    private String endereco;
    private Double taxaDeEntrega;
    private Integer tempoDeEntregaMinimo;
    private Integer tempoDeEntregaMaximo;
    private boolean aprovado;

    private TipoCozinhaEnum tipoDeCozinha;
    private Usuario usuario;


}
