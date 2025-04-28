package com.example.ac2_web.controllers;

import com.example.ac2_web.dto.ProjetoDTO;
import com.example.ac2_web.dto.DadosProjetoDTO;
import com.example.ac2_web.dto.FuncionarioDTO;
import com.example.ac2_web.models.Projeto;
import com.example.ac2_web.services.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @PostMapping
    public void adicionar(@RequestBody ProjetoDTO projetoDTO) {
        Projeto projeto = new Projeto(
            null,
            projetoDTO.getDescricao(),
            projetoDTO.getDataInicio(),
            projetoDTO.getDataFim(),
            null
        );
        projetoService.adicionar(projeto);
    }

    @GetMapping("/{id}")
    public DadosProjetoDTO buscarProjetoPorId(@PathVariable Integer id) {
        Projeto projeto = projetoService.buscarProjetoPorId(id);
        if (projeto == null) {
            throw new RuntimeException("Projeto com ID " + id + " não encontrado.");
        }
        List<FuncionarioDTO> funcionarios = projeto.getFuncionarios().stream()
            .map(funcionario -> new FuncionarioDTO(funcionario.getId(), funcionario.getNome()))
            .toList();
        return new DadosProjetoDTO(
            projeto.getId(),
            projeto.getDescricao(),
            projeto.getDataInicio(),
            projeto.getDataFim(),
            funcionarios
        );
    }

    @PostMapping("/{idProjeto}/vincular-funcionario/{idFuncionario}")
    public void vincularFuncionario(@PathVariable Integer idProjeto, @PathVariable Integer idFuncionario) {
        projetoService.vincularFuncionario(idProjeto, idFuncionario);
    }

    @GetMapping
    public List<ProjetoDTO> getAllProjetos() {
        List<Projeto> projetos = projetoService.getAll();
        return projetos.stream().map(projeto -> new ProjetoDTO(
            projeto.getId(),
            projeto.getDescricao(),
            projeto.getDataInicio(),
            projeto.getDataFim(),
            projeto.getFuncionarios()
        )).toList();
    }
}