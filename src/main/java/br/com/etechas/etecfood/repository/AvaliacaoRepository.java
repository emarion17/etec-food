package br.com.etechas.etecfood.repository;

import br.com.etechas.etecfood.entity.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
}
