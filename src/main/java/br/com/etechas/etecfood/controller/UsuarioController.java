package br.com.etechas.etecfood.controller;

import br.com.etechas.etecfood.entity.Usuario;
import br.com.etechas.etecfood.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> listar(){return usuarioRepository.findAll();}

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id){
        var usuario = usuarioRepository.findById(id);
        if(usuario.isPresent()){
            return ResponseEntity.ok(usuario.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public void cadastrar(@RequestBody Usuario usuario){
        usuarioRepository.save(usuario);
    }

    @DeleteMapping("/{id}")
    public void apagar(@PathVariable Long id){
        var existe = usuarioRepository.findById(id);
        if(existe.isPresent()){
            usuarioRepository.delete(existe.get());
        }
    }
}
