package com.exemplo.Service;

import com.exemplo.Model.Proprietario;
import com.exemplo.Repository.ProprietarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProprietarioService {

    private final ProprietarioRepository proprietarioRepository;

    public ProprietarioService(ProprietarioRepository proprietarioRepository) {
        this.proprietarioRepository = proprietarioRepository;
    }

    // Criar proprietário
    public Proprietario criar(Proprietario proprietario) {
        return proprietarioRepository.save(proprietario);
    }

    // Listar todos os proprietários
    public List<Proprietario> listarTodos() {
        return proprietarioRepository.findAll();
    }

    // Buscar proprietário por ID
    public Proprietario buscarPorId(Integer id) {
        return proprietarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proprietário não encontrado!"));
    }

    // Atualizar proprietário
    public Proprietario atualizar(Integer id, Proprietario dados) {
        Proprietario existente = buscarPorId(id);
        existente.setNome(dados.getNome());
        existente.setCpf(dados.getCpf());
        return proprietarioRepository.save(existente);
    }

    // Deletar proprietário
    public void deletar(Integer id) {
        if (!proprietarioRepository.existsById(id)) {
            throw new RuntimeException("Proprietário não encontrado!");
        }
        proprietarioRepository.deleteById(id);
    }
}
