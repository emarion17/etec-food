package br.com.etechas.etecfood.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.etechas.etecfood.Entity.Pagamento;

@RestController
@RequestMapping("/pagamentos")

public class PagamentoController {

    @Autowired
    private PagamentoRepository filmeRepository;

    @GetMapping
    public List<Pagamento> listar() { return pagamentoRepository.findAll() }

}
