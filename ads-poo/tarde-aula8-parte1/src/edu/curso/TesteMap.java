package edu.curso;

import java.util.*;

public class TesteMap {

    static class Aluno {
        private String ra;
        private String nome;
        public Aluno(String ra, String nome){
            this.ra = ra;
            this.nome = nome;
        }
    }

    public static void main(String[] args) {
//        Map<String, Long> mapaPopulacao = new TreeMap<>();
//        mapaPopulacao.put("CHINA", 2000000000l);
//        mapaPopulacao.put("BRAZIL", 220000000l);
//        mapaPopulacao.put("USA", 330000000l);
//        mapaPopulacao.put("BANGLADESH", 330000000l);
//        mapaPopulacao.put("BRAZIL", 225000000l);
//        long pop = mapaPopulacao.get("BRAZIL");
//        System.out.println(pop);
//        Set<String> chaves = mapaPopulacao.keySet();
//        for (String chave : chaves) {
//            long valor = mapaPopulacao.get(chave);
//            System.out.println(chave + " ==> " + valor);
//        }
//
//        Collection<Long> valores = mapaPopulacao.values();
//        for (Long l : valores) {
//            System.out.println(l);
//        }

        Map<Aluno, Integer> mapaAlunoIdade = new HashMap<>();
        mapaAlunoIdade.put(new Aluno("001", "JOAO"), 23);
        mapaAlunoIdade.put(new Aluno("002", "MARIA"), 22);
        mapaAlunoIdade.put(new Aluno("003", "PEDRO"), 18);

        Set<Aluno> alunos = mapaAlunoIdade.keySet();
        for (Aluno a : alunos) {
            long idade = mapaAlunoIdade.get(a);
            System.out.println(a.nome + " ==> " + idade);
        }

//        Iterator<String> it = chaves.iterator();
//        while(it.hasNext()) {
//            System.out.println(it.next());
//        }

    }
}
