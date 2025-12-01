package br.com.etechas.etecfood.entity;

import br.com.etechas.etecfood.enums.TipoItemCardapioEnum;
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

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    private TipoItemCardapioEnum tipo;

    @Column(name = "preco")
    private Double preco;

    @Column(name = "preco_promocional")
    private Double precoPromocional;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cardapio")
    private Cardapio cardapio;

}
