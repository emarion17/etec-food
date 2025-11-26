package br.com.etechas.etecfood.repository;

import br.com.etechas.etecfood.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long > {
}
