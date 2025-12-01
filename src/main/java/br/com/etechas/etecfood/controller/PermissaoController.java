package br.com.etechas.etecfood.controller;

import br.com.etechas.etecfood.entity.Permissao;
import br.com.etechas.etecfood.repository.PermissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permissoes")
public class PermissaoController {
    @Autowired
    private PermissaoRepository permissaoRepository;

    @GetMapping
    public List<Permissao> listar(){
        return permissaoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Permissao> buscarPorId(@PathVariable Long id){
        var permissao = permissaoRepository.findById(id);
        if(permissao.isPresent()){
            return ResponseEntity.ok(permissao.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public void cadastrar(@RequestBody Permissao permissao){
        permissaoRepository.save(permissao);
    }

    @DeleteMapping("/{id}")
    public void apagar(@PathVariable Long id){
        var existe = permissaoRepository.findById(id);
        if(existe.isPresent()){
            permissaoRepository.delete(existe.get());
        }
    }
}
