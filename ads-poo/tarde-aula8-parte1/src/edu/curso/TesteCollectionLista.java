package edu.curso;

import javax.management.relation.RoleList;
import java.util.*;

public class TesteCollectionLista {
    public static void main(String[] args) {
        List<String> minhaLista = new Stack<>();
        adicionarElementos(minhaLista);
        // listarElementos(minhaLista);
        ordenarLista(minhaLista);
        listarElementosComForEach(minhaLista);
    }
    public static void adicionarElementos(List<String> lista) {
         lista.add("Elemento B");  // 0
         lista.add("Elemento A");  // 1
         lista.add("Elemento D");  // 2
         lista.add("Elemento C");  // 3


         // lista.set(3, "Elemento D");

    }
    public static void listarElementos(List<String> lista) {
        Iterator<String> it = lista.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public static void listarElementosComForEach(List<String> lista) {
//        for (int i = 0; i < lista.size(); i++) {
//            String elemento = lista.get(i);
//            System.out.println(elemento);
//        }
        for (String elemento : lista) {
            System.out.println(elemento);
        }
    }

    public static void ordenarLista(List<String> lista) {
        Collections.sort(lista);
    }
}
