package edu.curso;

import java.util.PriorityQueue;
import java.util.Queue;

public class FilaBanco {

    static class Pessoa implements Comparable<Pessoa> {
        private String nome;
        private int idade;
        public Pessoa(String nome, int idade) {
            this.nome = nome;
            this.idade = idade;
        }

        @Override
        public int compareTo(Pessoa outra) {
            if (this.idade > outra.idade) {
                return -1;
            } else if (this.idade < outra.idade) {
                return 1;
            } else {
                return 0;
            }
        }
    }
    public static void main(String[] args) {
        Queue<Pessoa> pessoas = new PriorityQueue<>();
        pessoas.add(new Pessoa("Joao", 23));
        pessoas.add(new Pessoa("Maria", 21));
        pessoas.add(new Pessoa("Pedro", 19));
        pessoas.add(new Pessoa("Laura", 44));
        for (Pessoa p : pessoas) {
            System.out.println(p.nome);
        }
    }
}
