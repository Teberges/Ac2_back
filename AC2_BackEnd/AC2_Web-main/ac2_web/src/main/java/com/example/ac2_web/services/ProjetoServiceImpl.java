package com.example.ac2_web.services;

import com.example.ac2_web.models.Funcionario;
import com.example.ac2_web.models.Projeto;
import com.example.ac2_web.repositories.FuncionarioRepository;
import com.example.ac2_web.repositories.ProjetoRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProjetoServiceImpl implements ProjetoService {
    private final ProjetoRepository projetoRepository;
    private final FuncionarioRepository funcionarioRepository;

    public ProjetoServiceImpl(ProjetoRepository projetoRepository, FuncionarioRepository funcionarioRepository) {
        this.projetoRepository = projetoRepository;
        this.funcionarioRepository = funcionarioRepository;
    }

    @Override
    public void adicionar(Projeto projeto) {
        projetoRepository.save(projeto);
    }

    @Override
    public Projeto buscarProjetoPorId(Integer id) {
        Projeto projeto = projetoRepository.findProjetoWithFuncionariosById(id);
        if (projeto == null) {
            throw new RuntimeException("Projeto com ID " + id + " não encontrado.");
        }
        return projeto;
    }

    @Override
    public List<Projeto> buscarProjetosPorData(LocalDate inicio, LocalDate fim) {
        return projetoRepository.findProjetosByDateRange(inicio, fim);
    }

    @Override
    public void vincularFuncionario(Integer idProjeto, Integer idFuncionario) {
        Projeto projeto = projetoRepository.findById(idProjeto).orElseThrow(() -> new RuntimeException("Projeto não encontrado"));
        Funcionario funcionario = funcionarioRepository.findById(idFuncionario).orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));
        projeto.getFuncionarios().add(funcionario);
        projetoRepository.save(projeto);
    }

    @Override
    public List<Projeto> getAll() {
        return projetoRepository.findAll();
    }
}