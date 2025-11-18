package br.com.etechas.etecfood.controller;

import br.com.etechas.etecfood.entity.Cardapio;
import br.com.etechas.etecfood.repository.CardapioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cardapios")
public class CardapioController {

    @Autowired
    private CardapioRepository cardapioRepository;

    @GetMapping
    public List<Cardapio> listar() {
        return cardapioRepository.findAll();
    }
    // Buscar pelo nome
    @GetMapping("/buscar/{nome}")
    public List<Cardapio> buscarPorNome(@PathVariable String nome) {
    return cardapioRepository.findByNomeContainingIgnoreCase(nome);
}

    @GetMapping("/{id}")
    public Cardapio buscarPorId(@PathVariable Long id) {
        Optional<Cardapio> cardapio = cardapioRepository.findById(id);
        return cardapio.orElse(null);
    }

    @PostMapping
    public Cardapio cadastrar(@RequestBody Cardapio cardapio) {
        return cardapioRepository.save(cardapio);
    }

    @PutMapping("/{id}")
    public Cardapio atualizar(@PathVariable Long id, @RequestBody Cardapio dadosAtualizados) {
        Optional<Cardapio> existente = cardapioRepository.findById(id);

        if (existente.isPresent()) {
            Cardapio cardapio = existente.get();

            // Para atualizar o que desejar
            cardapio.setNome(dadosAtualizados.getNome());
            cardapio.setDescricao(dadosAtualizados.getDescricao());
            cardapio.setPreco(dadosAtualizados.getPreco());

            return cardapioRepository.save(cardapio);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        Optional<Cardapio> existe = cardapioRepository.findById(id);
        existe.ifPresent(cardapioRepository::delete);
    }
}
