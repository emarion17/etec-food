package br.com.etechas.etecfood.controller;

import br.com.etechas.etecfood.entity.Cardapio;
import br.com.etechas.etecfood.repository.CardapioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cardapios")
public class CardapioController {

    private final CardapioRepository cardapioRepository;

    @Autowired
    public CardapioController(CardapioRepository cardapioRepository) {
        this.cardapioRepository = cardapioRepository;
    }

    @GetMapping
    public List<Cardapio> listarTodos() {
        return cardapioRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cardapio> buscarPorId(@PathVariable Long id) {
        Optional<Cardapio> cardapio = cardapioRepository.findById(id);
        
        return cardapio.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cardapio criar(@RequestBody Cardapio cardapio) {
        return cardapioRepository.save(cardapio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cardapio> atualizar(@PathVariable Long id, @RequestBody Cardapio detalhesCardapio) {
        return cardapioRepository.findById(id)
            .map(cardapioExistente -> {
                
                Cardapio cardapioAtualizado = cardapioRepository.save(detalhesCardapio);
                return ResponseEntity.ok(cardapioAtualizado);
            })
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (cardapioRepository.existsById(id)) {
            cardapioRepository.deleteById(id);
            return ResponseEntity.noContent().build(); // HTTP 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // HTTP 404 Not Found
        }
    }
}
