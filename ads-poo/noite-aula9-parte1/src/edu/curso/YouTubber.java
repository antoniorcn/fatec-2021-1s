package edu.curso;

import java.util.ArrayList;
import java.util.List;

public class YouTubber implements Publicador {
    private String nome;

    private List<Assinante> lista = new ArrayList<>();

    public YouTubber(String nome) {
        this.nome = nome;
    }

    @Override
    public void adicionar(Assinante a) {
        lista.add(a);
    }

    @Override
    public void remover(Assinante a) {
        lista.remove(a);
    }

    @Override
    public void notificar(String mensagem) {
        for ( Assinante a : lista ) {
            String texto = String.format("%s informa => %s", this.nome, mensagem);
            a.receberMensagem(texto);
        }
    }
}
