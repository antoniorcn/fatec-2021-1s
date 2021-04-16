package edu.curso;

import java.util.PriorityQueue;

class Pessoa implements Comparable<Pessoa>{
    String nome;
    int idade;
    Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    @Override
    public int compareTo(Pessoa outra) {
//        if (this.nome.compareTo(outra.nome) < 0) {
//            return -1
//        }
        return outra.idade - this.idade;
    }
}

public class TestePriorityQueueComparable {

    public static void main(String[] args) {
        PriorityQueue<Pessoa> fila = new PriorityQueue<>();

        fila.add(new Pessoa("João", 23));
        fila.add(new Pessoa("Maria", 20));
        fila.add(new Pessoa("Carlos Eduardo", 34));
        fila.add(new Pessoa("Antonio", 40));
        fila.add(new Pessoa("Nicolas", 53));
        fila.add(new Pessoa("Sara", 39));
        fila.add(new Pessoa("Juliana", 20));

        Pessoa p;
        while ((p = fila.poll()) != null){
            System.out.println(p.nome + " - " + p.idade);
        }

    }
}
