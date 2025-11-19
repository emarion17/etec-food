package br.com.etechas.etecfood.controller;

import br.com.etechas.etecfood.entity.Veiculo;
import br.com.etechas.etecfood.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoRepository veiculoRepository;
    @GetMapping
    public List<Veiculo> listar(){
        return veiculoRepository.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> buscarPorId(@PathVariable Long id){
        var veiculo = veiculoRepository.findById(id);
        if(veiculo.isPresent()){
            return ResponseEntity.ok(veiculo.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

}
