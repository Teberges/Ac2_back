package com.example.ac2_web.repositories;

import com.example.ac2_web.models.Funcionario;
import com.example.ac2_web.models.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
    @Query("SELECT f.projetos FROM Funcionario f WHERE f.id = :id")
    List<Projeto> findProjetosByFuncionarioId(Integer id);
}