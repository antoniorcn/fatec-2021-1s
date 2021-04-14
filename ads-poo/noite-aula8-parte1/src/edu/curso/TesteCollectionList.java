package edu.curso;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class TesteCollectionList {

    public static void main(String[] args) {
        List<String> clientes = new LinkedList<>();
        adicionarClientes(clientes);
        listarClientes(clientes);

        clientes.set(3, "Bradesco");
        System.out.println( "Elemento 3 => " + clientes.get(3));
        listarClientes(clientes);
    }

    public static void adicionarClientes(List<String> lista) {
        lista.add("IBM");               // 0
        lista.add("Microsoft");         // 1
        lista.add("Banco do Brasil");   // 2
        lista.add("Itau");              // 3
        lista.add("Volkswagen");        // 4
    }

    public static void listarClientes(List<String> lista) {
        for(String cliente : lista) {
            System.out.println("Cliente => " + cliente);
        }
    }
}
