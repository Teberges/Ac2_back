package com.example.ac2_web.controllers;

import com.example.ac2_web.dto.SetorDTO;
import com.example.ac2_web.dto.FuncionarioDTO;
import com.example.ac2_web.dto.DadosSetorDTO;
import com.example.ac2_web.models.Setor;
import com.example.ac2_web.services.SetorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/setores")
public class SetorController {

    @Autowired
    private SetorService setorService;

    @PostMapping
    public void adicionar(@RequestBody SetorDTO setorDTO) {
        Setor setor = new Setor(null, setorDTO.getNome(), null);
        setorService.adicionar(setor);
    }

    @GetMapping("/{id}")
    public DadosSetorDTO buscarSetorPorId(@PathVariable Integer id) {
        Setor setor = setorService.buscarSetorPorId(id);
        if (setor == null) {
            throw new RuntimeException("Setor com ID " + id + " não encontrado.");
        }
        List<FuncionarioDTO> funcionarios = setor.getFuncionarios().stream()
            .map(funcionario -> new FuncionarioDTO(funcionario.getId(), funcionario.getNome()))
            .toList();
        return new DadosSetorDTO(setor.getId(), setor.getNome(), funcionarios);
    }

    @GetMapping
    public List<SetorDTO> getAllSetores() {
        List<Setor> setores = setorService.getAll();
        return setores.stream().map(setor -> new SetorDTO(
            setor.getId(),
            setor.getNome()
        )).toList();
    }
}