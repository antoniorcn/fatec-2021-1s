package edu.curso;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TesteCollectionSet {
    public static void main(String[] args) {

        Set<String> alunos = new HashSet<>();

        alunos.add("João Silva");
        alunos.add("Maria Silva");
        alunos.add("Carlos Eduardo");
        alunos.add("Maria Silva");
        // alunos.add(false);
        alunos.add(null);

        System.out.println("Alfredo está no grupo => " +
                alunos.contains("Alfredo"));
        System.out.println("Carlos está no grupo => " +
                alunos.contains("Carlos Eduardo"));

        System.out.println("Membros do Grupo");
        for (String membro : alunos) {
            System.out.println(membro);
        }

        Iterator<String> it = alunos.iterator();
        while(it.hasNext()) {
            System.out.println("Elemento ==> " + it.next());
        }

    }
}
