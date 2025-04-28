package com.example.ac2_web.dto;

import java.time.LocalDate;
import java.util.List;
import com.example.ac2_web.models.Funcionario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjetoDTO {
    private int id;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private List<Funcionario> funcionarios;
}