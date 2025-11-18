package br.com.etechas.etecfood.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.etechas.etecfood.Entity.Pagamento;

import java.util.List;

@RestController
@RequestMapping("/pagamentos")

public class PagamentoController {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @GetMapping
    public List<Pagamento> listar() { return pagamentoRepository.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Pagamento> buscaPorId(@PathVariable Long id){
        var pagamento = pagamentoRepository.findById(id);

        if (pagamento.isPresent()) {
            return ResponseEntity.ok(pagamento.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public void cadastrar(@RequestBody Pagamento pagamento) { pagamentoRepository.save(pagamento); }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pagamento> deletar(@PathVariable Long id){
        if (pagamentpRepository.existsById(id)){
            pagamentoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();

    }

}
