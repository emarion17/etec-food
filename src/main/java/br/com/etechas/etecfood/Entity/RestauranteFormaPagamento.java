package br.com.etechas.etecfood.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "RestauranteFormaPagamento")
public class RestauranteFormaPagamento {
    @EmbeddedId
    private RestauranteFormaPagamentoId  id;

    @ManyToOne
    @JoinColumn(name = "id_restaurante")
    private Restaurante restaurante;

    //private FormaPagamento formaPagamento;
}
