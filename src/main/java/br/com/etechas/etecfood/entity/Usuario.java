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
    @Column(name = "id_usuario")
    private Long Id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "senha")
    private String senha;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Usuario_Permissao", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "permisso_id"))
    private List<Permissao> permissaoList;


    @Column(name = "tentativasAcesso")
    private Integer tentativasAcesso;

    @Column(name = "dataBloqueio")
    private LocalDateTime dataBloqueio;


    @Column(name= "dataInativacao")
    private LocalDateTime dataInativacao;

    @Enumerated(EnumType.STRING)
    private StatusUsuarioEnum status;
}