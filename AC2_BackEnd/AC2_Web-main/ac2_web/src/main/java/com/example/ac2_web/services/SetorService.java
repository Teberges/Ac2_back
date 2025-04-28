package com.example.ac2_web.services;

import com.example.ac2_web.models.Setor;

import java.util.List;

public interface SetorService {
    void adicionar(Setor setor);
    Setor buscarSetorPorId(Integer id);
    List<Setor> getAll();
}