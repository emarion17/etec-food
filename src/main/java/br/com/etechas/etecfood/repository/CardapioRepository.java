package br.com.etechas.etecfood.repository;

import br.com.etechas.etecfood.entity.Cardapio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface CardapioRepository extends JpaRepository<Cardapio, Long> {
}
