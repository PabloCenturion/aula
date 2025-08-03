package com.exemplo.Service;

import com.exemplo.Model.Biblioteca;
import com.exemplo.Repository.BibliotecaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BibliotecaService {

    private final BibliotecaRepository bibliotecaRepository;

    public BibliotecaService(BibliotecaRepository bibliotecaRepository) {
        this.bibliotecaRepository = bibliotecaRepository;
    }

    public Biblioteca save(Biblioteca biblioteca) {
        return bibliotecaRepository.save(biblioteca);
    }

    public Biblioteca findById(Integer id) {
        return bibliotecaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Biblioteca não encontrada"));
    }

    public List<Biblioteca> findAll() {
        return bibliotecaRepository.findAll();
    }

    public void delete(Integer id) {
        bibliotecaRepository.deleteById(id);
    }

    public Biblioteca update(Integer id, Biblioteca bibliotecaAtualizada) {
        Biblioteca bibliotecaExistente = findById(id);
        bibliotecaExistente.setNome(bibliotecaAtualizada.getNome());
        bibliotecaExistente.setTelefone(bibliotecaAtualizada.getTelefone());
        return bibliotecaRepository.save(bibliotecaExistente);
    }
}
