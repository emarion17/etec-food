package br.com.etechas.etecfood.controller;

import br.com.etechas.etecfood.entity.Entregador;
import br.com.etechas.etecfood.repository.EntregadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Entregadores")
public class EntregadorController {

    @Autowired
    private EntregadorRepository entregadorRepository;

    @GetMapping
    public List<Entregador> listar(){
        return entregadorRepository.findAll();
    }

}
