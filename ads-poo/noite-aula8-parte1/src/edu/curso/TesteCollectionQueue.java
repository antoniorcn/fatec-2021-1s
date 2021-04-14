package edu.curso;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TesteCollectionQueue {

    public static void main(String[] args) {
        Queue<String> fila = new LinkedList<>();

        fila.add("B");
        fila.add("C");
        fila.add("A");
        fila.add("X");
        fila.add("J");

        System.out.println("A fila tem => " + fila.size());
        System.out.println(fila.poll());
        System.out.println(fila.poll());
        System.out.println("A fila tem => " + fila.size());
    }
}
