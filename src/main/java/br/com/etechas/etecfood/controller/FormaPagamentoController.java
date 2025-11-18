package br.com.etechas.etecfood.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestController
@RequestMapping({"/formaPagamento"})

public class FormaPagamentoController {
    @Autowired
    private FormaPagamentoRepository formaPagamentoRepository;

    @GetMapping
    public List<FormaPagamento> listar(){
        return this.formaPagamentoRepository.findAll();
    }
}
