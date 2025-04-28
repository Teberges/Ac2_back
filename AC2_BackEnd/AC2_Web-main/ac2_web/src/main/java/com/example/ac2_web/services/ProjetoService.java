package com.example.ac2_web.services;

import com.example.ac2_web.models.Projeto;

import java.time.LocalDate;
import java.util.List;

public interface ProjetoService {
    void adicionar(Projeto projeto);
    Projeto buscarProjetoPorId(Integer id);
    List<Projeto> buscarProjetosPorData(LocalDate inicio, LocalDate fim);
    void vincularFuncionario(Integer idProjeto, Integer idFuncionario);
    List<Projeto> getAll();
}