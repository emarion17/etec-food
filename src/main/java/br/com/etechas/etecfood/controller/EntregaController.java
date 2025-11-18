package br.com.etechas.etecfood.controller;


import br.com.etechas.etecfood.entity.Entrega;
import br.com.etechas.etecfood.repository.EntregaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/entregas")
public class EntregaController {
    @Autowired
    private EntregaRepository entregaRepository;

    @GetMapping
    public List<Entrega> listar(){
        return entregaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entrega> buscarPorId(@PathVariable Long id){
        var entrega = entregaRepository.findById(id);
        if(entrega.isPresent()){
            return ResponseEntity.ok(entrega.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public void cadastrar(@RequestBody Entrega entrega){
        entregaRepository.save(entrega);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id){
        var existe = entregaRepository.findById(id);
        if(existe.isPresent()){
            entregaRepository.delete(existe.get());
        }
    }
}

