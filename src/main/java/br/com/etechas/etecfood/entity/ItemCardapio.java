package br.com.etechas.etecfood.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity

@Table(name = "TBL_ITEM_CARDAPIO")
public class ItemCardapio {
    @Id
    @Column(name = "ID_ITEM_CARDAPIO")
    private Long id;
}
