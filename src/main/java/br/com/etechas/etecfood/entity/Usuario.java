package br.com.etechas.etecfood.entity;

import br.com.etechas.etecfood.enums.StatusUsuarioEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

import java.time.LocalDateTime;
@Getter
@Setter
@Entity
@Table(name = "TBL_Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long ID;

    @Column(name = "nome")
    private String nome;

    @Column(name = "senha")
    private String senha;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "")
    private List<Permissao> permissaoList;

    //para deixar permissões:List neste espaço

    @Column(name = "tentativaAcesso")
    private Integer tentativasAcesso;

    @Column(name = "dataBloqueio")
    private LocalDateTime dataBloqueio;


    @Column(name= "dataInativacao")
    private LocalDateTime dataInativacao;

    @Enumerated(EnumType.STRING)
    private StatusUsuarioEnum status;
}
