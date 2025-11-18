package br.com.etechas.etecfood.controller;

import br.com.etechas.etecfood.entity.ItemCardapio;
import br.com.etechas.etecfood.repository.ItemCardapioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itemCardapios")
public class ItemCardapioController {

    @Autowired
    private ItemCardapioRepository itemCardapioRepository;

    @GetMapping
    public List<ItemCardapio> listar() {
        return itemCardapioRepository.findAll();
    }
    
    // Buscar pelo nome
    @GetMapping("/buscar/{nome}")
public List<ItemCardapio> buscarPorNome(@PathVariable String nome) {
    return itemCardapioRepository.findByNomeContainingIgnoreCase(nome);
}


    @GetMapping("/{id}")
    public ItemCardapio buscarPorId(@PathVariable Long id) {
        Optional<ItemCardapio> itemCardapio = itemCardapioRepository.findById(id);
        return itemCardapio.orElse(null);
    }

    @PostMapping
    public ItemCardapio cadastrar(@RequestBody ItemCardapio itemCardapio) {
        return itemCardapioRepository.save(itemCardapio);
    }

    @PutMapping("/{id}")
    public ItemCardapio atualizar(@PathVariable Long id, @RequestBody ItemCardapio dadosAtualizados) {
        Optional<ItemCardapio> existente = itemCardapioRepository.findById(id);

        if (existente.isPresent()) {
            ItemCardapio itemCardapio = existente.get();

            // Para atualizar os campos da entidade
            itemCardapio.setNome(dadosAtualizados.getNome());
            itemCardapio.setDescricao(dadosAtualizados.getDescricao());
            itemCardapio.setPreco(dadosAtualizados.getPreco());
            itemCardapio.setCategoria(dadosAtualizados.getCategoria());

            return itemCardapioRepository.save(itemCardapio);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        Optional<ItemCardapio> existe = itemCardapioRepository.findById(id);
        existe.ifPresent(itemCardapioRepository::delete);
    }
}
