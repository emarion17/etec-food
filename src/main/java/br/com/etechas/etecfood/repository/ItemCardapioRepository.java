package br.com.etechas.etecfood.repository;

import br.com.etechas.etecfood.entity.ItemCardapio;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface ItemCardapioRepository extends JpaRepository<ItemCardapio, Long> {
}
