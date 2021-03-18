package edu.curso;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TesteHibernate {
	
	public static void criarAlunos(EntityManager em) { 
		Aluno a1 = new Aluno();
		//a1.setId(1l);
		a1.setRa("00001");
		a1.setNome("João Silva");
		a1.setNascimento("07-09-2000");
		
		Aluno a2 = new Aluno();
		//a2.setId(2l);
		a2.setRa("00002");
		a2.setNome("Maria Silva");
		a2.setNascimento("10-03-2001");
		
		em.getTransaction().begin();
		em.persist(a1);
		em.persist(a2);
		em.getTransaction().commit();
	}
	
	public static void listarAlunos(EntityManager em) { 
		TypedQuery<Aluno> qry = 
				em.createQuery("select a from Aluno a", Aluno.class);
		List<Aluno> lista = qry.getResultList();
		for (Aluno a : lista) { 
			System.out.printf("RA: %s\t-\tNome: %s %n", a.getRa(), a.getNome());
		}
	}
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ALUNOS");
		
		EntityManager em = emf.createEntityManager();
		// criarAlunos(em);
		listarAlunos(em);
		em.close();
		
		emf.close();
	}

}
