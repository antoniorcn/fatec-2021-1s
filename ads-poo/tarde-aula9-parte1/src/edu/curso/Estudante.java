package edu.curso;

public class Estudante implements Observador {

    private String nome;

    public Estudante(String nome) {
        this.nome = nome;
    }

    @Override
    public void receberNoticia(String noticia) {
        System.out.printf(
                "Estudante %s está lendo a noticia %s no parque tomando coca-cola%n",
                this.nome, noticia);
    }
}
