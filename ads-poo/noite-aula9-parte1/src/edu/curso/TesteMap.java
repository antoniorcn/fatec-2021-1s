package edu.curso;

import java.util.*;
import java.util.stream.Stream;

public class TesteMap {

    public static void main(String[] args) {

        Map<String, Pessoa> timeVolei = new TreeMap<>();

        Pessoa p1 = new Pessoa("João", 23);
        Pessoa p2 = new Pessoa("Maria", 20);
        Pessoa p3 = new Pessoa("Carlos Eduardo", 34);
        Pessoa p4 = new Pessoa("Davi", 22);
        Pessoa p5 = new Pessoa("Juliana", 21);
        Pessoa p6 = new Pessoa("Fabio", 26);

        timeVolei.put("LEVANTADOR", p1);
        timeVolei.put("LIBERO", p2);
        timeVolei.put("PONTA1", p3);
        timeVolei.put("ARMADOR", p4);
        timeVolei.put("PONTA2", p5);
        timeVolei.put("CENTRO", p6);
        // timeVolei.put("CENTRO", p5);
        // timeVolei.put(null, p6);

        Pessoa p = timeVolei.get("ARMADOR");
        System.out.println(p.nome  + " - " + p.idade);

        Set<String> chaves = timeVolei.keySet();

        for (String c : chaves) {
            System.out.println(c);
        }

        Collection<Pessoa> values = timeVolei.values();
        for (Pessoa pessoa : values) {
            System.out.println(pessoa.nome);
        }

        Stream<String> valuesTransformados =
                values.stream().map((item) -> {
            return "*" + item.nome + "*";
        });

        valuesTransformados.forEach(System.out::println);
    }
}
