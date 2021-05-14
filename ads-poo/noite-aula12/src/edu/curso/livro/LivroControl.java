package edu.curso.livro;

import java.util.ArrayList;
import java.util.List;

public class LivroControl {

    private List<Livro> livros = new ArrayList<>();

    public void adicionar(Livro l) {
        livros.add(l);
    }

    public Livro pesquisarPorTitulo(String titulo) {
        for (Livro l : livros) {
            if (l.getTitulo().contains(titulo)) {
                return l;
            }
        }
        return null;
    }

}
