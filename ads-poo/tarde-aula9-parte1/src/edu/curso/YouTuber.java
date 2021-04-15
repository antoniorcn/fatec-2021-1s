package edu.curso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class YouTuber implements Publicador {
    private List<Observador> lista = new ArrayList<>();

    @Override
    public void adicionar(Observador o) {
        lista.add(o);
    }

    @Override
    public void remover(Observador o) {
        lista.remove(o);
    }

    @Override
    public void avisar(String noticia) {
        for (Observador o : lista) {
            o.receberNoticia(noticia);
        }
    }
}
