package br.com.etechas.etecfood.entity;

import br.com.etechas.etecfood.Enum.TipoVeiculoEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TBL_VEICULO")
public class Veiculo {

    @Id
    @Column(name = "ID_VEICULO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="PLACA")
    private String placa;

    @Enumerated(EnumType.STRING)
    @Column(name ="TP_VEICULO")
    private TipoVeiculoEnum tipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ENTREGADOR")
    private Entregador entregador;

    @GetMapping("/count")
    public Long contarVeiculos() {
        return veiculoRepository.count();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> atualizar(
            @PathVariable Long id,
            @RequestBody Veiculo novo
    ){
        return veiculoRepository.findById(id)
                .map(v -> {
                    v.setModelo(novo.getModelo());
                    v.setPlaca(novo.getPlaca());
                    v.setTipo(novo.getTipo());
                    v.setAtivo(novo.getAtivo());
                    return ResponseEntity.ok(veiculoRepository.save(v));
                })
                .orElse(ResponseEntity.notFound().build());
    }




}
