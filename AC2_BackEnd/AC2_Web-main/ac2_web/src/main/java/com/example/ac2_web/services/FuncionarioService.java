package com.example.ac2_web.services;

import com.example.ac2_web.models.Funcionario;
import com.example.ac2_web.models.Projeto;

import java.util.List;

public interface FuncionarioService {
    void adicionar(Funcionario funcionario);
    List<Projeto> buscarProjetosPorFuncionarioId(Integer id);
    List<Funcionario> getAll();
}