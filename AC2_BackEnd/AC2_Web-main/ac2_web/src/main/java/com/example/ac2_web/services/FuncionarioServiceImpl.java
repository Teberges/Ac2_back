package com.example.ac2_web.services;

import com.example.ac2_web.models.Funcionario;
import com.example.ac2_web.models.Projeto;
import com.example.ac2_web.repositories.FuncionarioRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioServiceImpl(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @Override
    public void adicionar(Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
    }

    @Override
    public List<Projeto> buscarProjetosPorFuncionarioId(Integer id) {
        List<Projeto> projetos = funcionarioRepository.findProjetosByFuncionarioId(id);
        if (projetos == null || projetos.isEmpty()) {
            throw new RuntimeException("Funcionário com ID " + id + " não encontrado ou sem projetos vinculados.");
        }
        return projetos;
    }

    @Override
    public List<Funcionario> getAll() {
        return funcionarioRepository.findAll();
    }
}