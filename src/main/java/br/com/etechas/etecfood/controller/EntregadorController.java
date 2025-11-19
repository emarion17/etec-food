package br.com.etechas.etecfood.controller;

import br.com.etechas.etecfood.entity.Entregador;
import br.com.etechas.etecfood.repository.EntregadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/entregadores")
public class EntregadorController {

    @Autowired
    private EntregadorRepository entregadorRepository;

    @GetMapping
    public List<Entregador> listar(){
        return entregadorRepository.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Entregador> buscarPorId(@PathVariable Long id){
        var entregador = entregadorRepository.findById(id); // criou o objeto so que sem colocar tipo
        if(entregador.isPresent()){
            return ResponseEntity.ok(entregador.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deletarPorId(@PathVariable Long id){
        var entregador = entregadorRepository.findById(id);
        if(entregador.isPresent()) {
            entregadorRepository.delete(entregador.get());
        }
        else{
            ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public void cadastrar(@RequestBody Entregador entregador){
        entregadorRepository.save(entregador);
    }

}

