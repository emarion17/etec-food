package br.com.etechas.etecfood.controller

import br.com.etechas.ingresso.entity.Filme;
import br.com.etechas.ingresso.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itemCardapios")

    public class ItemCardapioController {

        @Autowired
        private ItemCardapioRepository itemCardapioRepository;

        @GetMapping
        public List <ItemCardapio> listar() {return itemCardapioRepository.findAll();}

         @GetMapping("/{Id}")
        public ItemCardapio BuscarPorId(@PathVariable Long Id){
        var itemCardapio = itemCardapioRepository.findById(Id);
        if(itemCardapio.isPresent()){
            return itemCardapio.get();
        }
        return null;
    }
        @PostMapping 
        public void cadastrar(@RequestBody ItemCardapio itemCardapio) {itemCardapioRepository.save(itemCardapio); }

        @DeleteMapping
        public void excluir (@PathVariable Long id){
            var existe = itemCardapioRepository.findById(id);
            if(existe.isPresent()){
                itemCardapioRepository.delete(existe.get());
            }
        }
    }
