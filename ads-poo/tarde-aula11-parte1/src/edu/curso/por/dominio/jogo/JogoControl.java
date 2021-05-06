package edu.curso.por.dominio.jogo;

import java.util.ArrayList;
import java.util.List;

public class JogoControl {

    private List<Jogo> lista = new ArrayList<>();

    public void adicionar(Jogo j) {
        lista.add(j);
    }

    public Jogo pesquisarPorTitulo(String titulo) {
        for (Jogo j : lista) {
            if (j.getTitulo().contains(titulo)) {
                return j;
            }
        }
        return null;
    }
}
