package br.com.etechas.etecfood.repository;

import br.com.etechas.etecfood.entity.Cardapio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardapioRepository extends JpaRepository<Cardapio, Long> {
    List<Cardapio> findByCategoria(String categoria);
}
