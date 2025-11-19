package br.com.etechas.etecfood.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


    @Getter
    @Setter
    @Entity
    @Table(name = "TBL_ENTREGADOR")
    public class Entregador {
        @Id
        @Column(name ="ID_ENTREGADOR")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name ="NOME")
        private String nome;

        @Column(name ="TELEFONE")
        private String telefone;

        @Column(name ="ATIVO")
        private Boolean ativo;

        @GetMapping("/quantidade")
        public long quantidade() {
            return entregadorRepository.count();
        }

        @PutMapping("/{id}")
        public ResponseEntity<Entregador> atualizar(
                @PathVariable Long id,
                @RequestBody Entregador novo
        ){
            return entregadorRepository.findById(id)
                    .map(e -> {
                        e.setNome(novo.getNome());
                        e.setTelefone(novo.getTelefone());
                        e.setAtivo(novo.getAtivo());
                        return ResponseEntity.ok(entregadorRepository.save(e));
                    })
                    .orElse(ResponseEntity.notFound().build());
        }

    }
