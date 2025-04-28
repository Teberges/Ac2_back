package com.example.ac2_web.services;

import com.example.ac2_web.models.Setor;
import com.example.ac2_web.repositories.SetorRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SetorServiceImpl implements SetorService {
    private final SetorRepository setorRepository;

    public SetorServiceImpl(SetorRepository setorRepository) {
        this.setorRepository = setorRepository;
    }

    @Override
    public void adicionar(Setor setor) {
        setorRepository.save(setor);
    }

    @Override
    public Setor buscarSetorPorId(Integer id) {
        return setorRepository.findById(id).orElseThrow(() -> new RuntimeException("Setor com ID " + id + " não encontrado."));
    }

    @Override
    public List<Setor> getAll() {
        return setorRepository.findAll();
    }
}