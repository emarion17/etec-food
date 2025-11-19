package br.com.etechas.etecfood.controller;

import br.com.etechas.etecfood.entity.HorarioFuncionamento;
import br.com.etechas.etecfood.repository.HorarioFuncionamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/horarios")
public class HorarioFuncionamentoController {


    @Autowired
    private HorarioFuncionamentoRepository horarioFuncionamentoRepository;

    @GetMapping
    public List<HorarioFuncionamento> listar() {
        return horarioFuncionamentoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HorarioFuncionamento> buscarPorId(@PathVariable Long id) {
        var horario = horarioFuncionamentoRepository.findById(id);
        if (horario.isPresent()) {
            return ResponseEntity.ok(horario.get());
        }
        return ResponseEntity.notFound().build();

    }


    @PostMapping
    public void cadastrar(@RequestBody HorarioFuncionamento horario) {
        horarioFuncionamentoRepository.save(horario);
    }


    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        var horario = horarioFuncionamentoRepository.findById(id);
        if (horario.isPresent()) {
            horarioFuncionamentoRepository.delete(horario.get());
        }
    }

}
