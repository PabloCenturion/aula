package com.exemplo.Model;

import com.exemplo.Model.Biblioteca;
import com.exemplo.Model.Proprietario;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;
    private String tema;
    //private String autor;

    @ManyToOne
    @JoinColumn(name = "biblioteca_id") // FK para a tabela Biblioteca
    @JsonIgnoreProperties("livros")
    private Biblioteca biblioteca;


    @ManyToOne
    @JoinColumn(name = "editora_id")
    @JsonIgnoreProperties("livros")
    private Editora editora;


    @ManyToOne
    @JoinColumn(name = "autor_id")
    @JsonIgnoreProperties("livros") // Evita loop de serialização
    private Autor autor;

    @ManyToMany
    @JoinTable(
            name = "livro_proprietario",
            joinColumns = @JoinColumn(name = "livro_id"),
            inverseJoinColumns = @JoinColumn(name = "proprietario_id")
    )
    private List<Proprietario> proprietarios;



    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    /*public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }*/
}
