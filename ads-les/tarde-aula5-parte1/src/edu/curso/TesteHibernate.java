package edu.curso;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TesteHibernate {
	
	public static void criarMedicos(EntityManagerFactory emf) { 
		Medico m1 = new Medico();
		m1.setCrm("000002");
		m1.setNome("Dr. Hans Chucrutte");
		m1.setEspecialidade("Clinica Geral");
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(m1);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void consultarMedicos(EntityManagerFactory emf) { 
		EntityManager em = emf.createEntityManager();
		TypedQuery<Medico> qry = 
				em.createQuery("select m from Medico m", Medico.class);
		List<Medico> medicos = qry.getResultList();
		for (Medico m : medicos) { 
			System.out.printf("ID: %d\t\tCRM: %s\t\tNome: %s%n", 
					m.getId(),
					m.getCrm(),
					m.getNome());
		}
		em.close();
	}

	public static void main(String[] args) {
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("MEDICOS");
		
		// criarMedicos(emf);
		consultarMedicos(emf);
		
		emf.close();
	}

}
