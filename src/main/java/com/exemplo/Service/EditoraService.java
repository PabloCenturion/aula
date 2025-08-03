package com.exemplo.Service;

import com.exemplo.Model.Editora;
import com.exemplo.Repository.EditoraRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditoraService {

    private final EditoraRepository repository;

    public EditoraService(EditoraRepository repository) {
        this.repository = repository;
    }

    public Editora save(Editora editora) {
        return repository.save(editora);
    }

    public Editora findById(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    public List<Editora> findAll() {
        return repository.findAll();
    }

    public Editora update(Integer id, Editora editora) {
        Editora existing = repository.findById(id).orElseThrow();
        existing.setNome(editora.getNome());
        existing.setEndereço(editora.getEndereço());
        existing.setTelefone(editora.getTelefone());
        return repository.save(existing);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
