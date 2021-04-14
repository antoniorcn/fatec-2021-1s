package edu.curso;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TesteCollectionSet {

    public static void main(String[] args) {

        Set conjunto = new HashSet();

        conjunto.add(10);
        conjunto.add("João");
        conjunto.add("ADMIN");
        conjunto.add(true);

        System.out.println("Contem numero 10 ==> "+ conjunto.contains(10));
        System.out.println("Contem numero 20 ==> "+ conjunto.contains(20));

        Set<String> acessos = new TreeSet<>();
        acessos.add("USUARIO");
        acessos.add("ADMIN");
        acessos.add("GERENTE");
        acessos.add("ADMIN");

        // acessos.add(100);
        System.out.println("Acessos no conjunto ==> " + acessos.size());

        Iterator<String> it = acessos.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
;