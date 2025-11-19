package br.com.etechas.etecfood.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "RestauranteFormaPagamento")
public class RestauranteFormaPagamento {

    @JoinColumn(name = "id_formaPagamento")
    private RestauranteFormaPagamentoId id;

    @ManyToOne
    @JoinColumn(name = "id_restaurante")
    private Restaurante restaurante;

    //private FormaPagamento formaPagamento;
}
