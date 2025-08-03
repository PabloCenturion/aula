package com.exemplo.Repository;

import com.exemplo.Model.Livro;
import jakarta.annotation.PostConstruct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer>{
}
