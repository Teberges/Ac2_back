package com.example.ac2_web.controllers;

import com.example.ac2_web.dto.FuncionarioDTO;
import com.example.ac2_web.models.Funcionario;
import com.example.ac2_web.models.Projeto;
import com.example.ac2_web.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping
    public void adicionar(@RequestBody FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = new Funcionario(null, funcionarioDTO.getNome(), null, null);
        funcionarioService.adicionar(funcionario);
    }

    @GetMapping("/{id}/projetos")
    public List<Projeto> buscarProjetos(@PathVariable Integer id) {
        List<Projeto> projetos = funcionarioService.buscarProjetosPorFuncionarioId(id);
        if (projetos == null || projetos.isEmpty()) {
            throw new RuntimeException("Funcionário com ID " + id + " não encontrado ou sem projetos vinculados.");
        }
        return projetos;
    }

    @GetMapping
    public List<FuncionarioDTO> getAllFuncionarios() {
        List<Funcionario> funcionarios = funcionarioService.getAll();
        return funcionarios.stream().map(funcionario -> new FuncionarioDTO(
            funcionario.getId(),
            funcionario.getNome()
        )).toList();
    }
}