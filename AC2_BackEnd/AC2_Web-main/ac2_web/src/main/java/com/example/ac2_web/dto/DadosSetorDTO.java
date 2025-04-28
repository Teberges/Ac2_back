package com.example.ac2_web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DadosSetorDTO {
    private int id;
    private String nome;
    private List<FuncionarioDTO> funcionarios;
}