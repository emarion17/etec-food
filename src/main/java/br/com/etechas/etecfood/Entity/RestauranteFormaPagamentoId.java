package br.com.etechas.etecfood.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestauranteFormaPagamentoId {
    private Long restauranteId;
    private Long formaPagamentoId;

}
