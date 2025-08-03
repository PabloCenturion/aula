package com.exemplo.Service;

import com.exemplo.Model.Autor;
import com.exemplo.Repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public Autor save(Autor autor) {
        return autorRepository.save(autor);
    }

    public Autor findById(Integer id) {
        return autorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autor não encontrado"));
    }

    public List<Autor> findAll() {
        return autorRepository.findAll();
    }

    public void delete(Integer id) {
        autorRepository.deleteById(id);
    }

    public Autor update(Integer id, Autor autorAtualizado) {
        Autor autorExistente = findById(id);
        autorExistente.setNome(autorAtualizado.getNome());
        autorExistente.setCpf(autorAtualizado.getCpf());
        autorExistente.setIdade(autorAtualizado.getIdade());
        return autorRepository.save(autorExistente);
    }
}
