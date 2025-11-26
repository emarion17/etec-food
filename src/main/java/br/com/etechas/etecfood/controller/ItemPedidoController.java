package br.com.etechas.etecfood.controller;

import br.com.etechas.etecfood.entity.ItemPedido;
import br.com.etechas.etecfood.repository.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RequestMapping("/itenspedido")
@RestController
public class ItemPedidoController {
     @Autowired
     private ItemPedidoRepository itemPedidoRepository;

     @GetMapping
     public List<ItemPedido> listarItens(){
          return itemPedidoRepository.findAll();
     }

     @GetMapping("/{id}")
     public ResponseEntity<ItemPedido> buscarItemPorId(@PathVariable Long id){
          var itemPedido = itemPedidoRepository.findById(id);
          if (itemPedido.isPresent())
               return ResponseEntity.ok(itemPedido.get());
          else
               return ResponseEntity.notFound().build();
     }

     @PostMapping
     public void cadastrarItem(@RequestBody ItemPedido itemPedido){
          itemPedidoRepository.save(itemPedido);
     }

     @DeleteMapping("/{id}")
     public void deletarItemPorId(@PathVariable Long id){
          var itemPedido = itemPedidoRepository.findById(id);
          if(itemPedido.isPresent())
               itemPedidoRepository.delete(itemPedido.get());
     }
}
