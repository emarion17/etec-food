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
    private PagamentoRepository filmeRepository;

    @GetMapping
    public List<Pagamento> listar() { return pagamentoRepository.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Pagamento> buscaPorId(@PathVariable Long id){
        var pagamento = pagamentoRepository.findById(id);

        if (filme.isPresent()) {
            return ResponseEntity.ok(pagamento.get());
        }

        return ReponseEntity.notFound().build();
    }

    @PostMapping
    public void cadastrar(@RequestMapping Pagamento pagamento) { pagamentoRepository.save(filme); }

}
