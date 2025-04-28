package com.example.ac2_web.repositories;

import com.example.ac2_web.models.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ProjetoRepository extends JpaRepository<Projeto, Integer> {
    @Query("SELECT p FROM Projeto p LEFT JOIN FETCH p.funcionarios WHERE p.id = :id")
    Projeto findProjetoWithFuncionariosById(Integer id);

    @Query("SELECT p FROM Projeto p WHERE p.dataInicio BETWEEN :startDate AND :endDate")
    List<Projeto> findProjetosByDateRange(LocalDate startDate, LocalDate endDate);
}
