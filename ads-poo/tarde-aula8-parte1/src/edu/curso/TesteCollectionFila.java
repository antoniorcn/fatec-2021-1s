package edu.curso;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class TesteCollectionFila {

    public static void main(String[] args) {

        // Queue<String> fila = new LinkedList<>();
        Queue<String> fila = new ArrayDeque<>();

        fila.add("Z");
        fila.add("C");
        fila.add("B");
        fila.add("D");


        System.out.println("Elementos na fila ==> " + fila.size());
        String elemento = "";
        while (elemento != null) {
            elemento = fila.poll();
            System.out.println(elemento);
            System.out.println("Elementos na fila ==> " + fila.size());
        }
    }
}
