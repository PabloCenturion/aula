package com.exemplo.Service;
import com.exemplo.Model.Livro;
import com.exemplo.Repository.LivroRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {
    private  final  LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository, LivroRepository livroRepository1){
        this.livroRepository = livroRepository1;
    }
    public List<Livro> findAll() {
        return livroRepository.findAll();
    }


    public Livro save(Livro livro){
        return livroRepository.save(livro);
    }

    public Livro findById(Integer id){
        return livroRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}


