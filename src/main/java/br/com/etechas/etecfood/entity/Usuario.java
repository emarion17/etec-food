package br.com.etechas.etecfood.entity;

import br.com.etechas.etecfood.enums.StatusUsuarioEnum;

import java.time.LocalDateTime;

public class Usuario {
    private Long ID;

    private String nome;

    private String senha;

    //para deixar permissões:List neste espaço

    private Integer tentativasAcesso;

    private LocalDateTime dataBloqueio;

    private LocalDateTime dataInativacao;

    private StatusUsuarioEnum status;
}
