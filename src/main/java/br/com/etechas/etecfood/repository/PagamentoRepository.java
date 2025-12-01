package br.com.etechas.etecfood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.etechas.etecfood.Entity.Pagamento;

public interface PagamentoRepository extends
        JpaRepository<Pagamento, Long> {

}
