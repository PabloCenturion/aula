package com.exemplo.Controller;

import com.exemplo.Model.Proprietario;
import com.exemplo.Repository.ProprietarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proprietarios")

public class ProprietarioController {

    private final ProprietarioRepository proprietarioRepository;

    public ProprietarioController(ProprietarioRepository proprietarioRepository) {
        this.proprietarioRepository = proprietarioRepository;
    }

    // Criar proprietário
    @PostMapping("/save")
    public Proprietario criarProprietario(@RequestBody Proprietario proprietario) {
        return proprietarioRepository.save(proprietario);
    }

    // Listar todos os proprietários
    @GetMapping("/listAll")
    public List<Proprietario> listarProprietarios() {
        return proprietarioRepository.findAll();
    }

    // Buscar proprietário por ID
    @GetMapping("/{id}")
    public Proprietario buscarPorId(@PathVariable Integer id) {
        return proprietarioRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Proprietário não encontrado!")
        );
    }

    // Atualizar proprietário
    @PutMapping("/{id}")
    public Proprietario atualizarProprietario(@PathVariable Integer id, @RequestBody Proprietario dados) {
        Proprietario p = proprietarioRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Proprietário não encontrado!")
        );
        p.setNome(dados.getNome());
        p.setCpf(dados.getCpf());
        return proprietarioRepository.save(p);
    }

    // Deletar proprietário
    @DeleteMapping("/{id}")
    public void deletarProprietario(@PathVariable Integer id) {
        proprietarioRepository.deleteById(id);
    }
}
