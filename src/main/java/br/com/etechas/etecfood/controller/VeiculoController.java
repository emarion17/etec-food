package br.com.etechas.etecfood.controller;

import br.com.etechas.etecfood.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoRepository veiculoRepository;

}
