package br.com.etechas.etecfood.controller

import br.com.etechas.ingresso.entity.Filme;
import br.com.etechas.ingresso.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cardapios")

    public class CardapioController {

        @Autowired
        private CardapioRepository cardapioRepository;

        @GetMapping
        public List <Cardapio> listar() {return cardapioRepository.findAll();}

         @GetMapping("/{Id}")
        public Cardapio BuscarPorId(@PathVariable Long Id){
        var cardapio = cardapioRepository.findById(Id);
        if(cardapio.isPresent()){
            return cardapio.get();
        }
        return null;
    }
        @PostMapping 
        public void cadastrar(@RequestBody Cardapio cardapio) {cardapioRepository.save(cardapio); }

        @DeleteMapping
        public void excluir (@PathVariable Long id){
            var existe = cardapioRepository.findById(id);
            if(existe.isPresent()){
                cardapioRepository.delete(existe.get());
            }
        }
    }
