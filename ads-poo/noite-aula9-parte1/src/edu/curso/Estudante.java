package edu.curso;

public class Estudante implements Assinante {

    private String nome;

    public Estudante(String nome) {
        this.nome = nome;
    }

    @Override
    public void receberMensagem(String msg) {
        System.out.printf("%s está lendo a mensagem %s no intervalo da aula%n",
                this.nome, msg);
    }
}
