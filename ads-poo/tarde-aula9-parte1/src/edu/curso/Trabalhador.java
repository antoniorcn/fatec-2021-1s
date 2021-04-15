package edu.curso;

public class Trabalhador implements Observador {
    private String nome;

    public Trabalhador(String nome) {
        this.nome = nome;
    }

    @Override
    public void receberNoticia(String noticia) {
        System.out.printf(
                "Trabalhador %s lendo a notificia %s na cervejaria depois do expediente%n",
                this.nome, noticia);
    }
}
