package br.com.etechas.etecfood.controller;

import br.com.etechas.etecfood.entity.FormaPagamento;
import br.com.etechas.etecfood.repository.FormaPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping({"/formaPagamento"})

public class FormaPagamentoController {
    @Autowired
    private FormaPagamentoRepository formaPagamentoRepository;

    @GetMapping
    public List<FormaPagamento> listar(){
        return this.formaPagamentoRepository.findAll();
    }

    @GetMapping({"/{id"})
    public ResponseEntity<FormaPagamento> buscarporId(@PathVariable Long id) {
        Optional<FormaPagamento> formaPagamento = this.formaPagamentoRepository.findById(id);
        return formaPagamento.isPresent() ? ResponseEntity.ok((FormaPagamento)formaPagamento.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public void cadastrar(@RequestBody FormaPagamento formaPagamento) { this.formaPagamentoRepository.save(formaPagamento); }

    @DeleteMapping({"/{id"})
    public void deletar(@PathVariable Long id) {
        if (this.formaPagamentoRepository.existsById(id)) {
            this.formaPagamentoRepository.deleteById(id);
        }
    }
}
