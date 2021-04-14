package edu.fatec;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepositorio extends JpaRepository<Turma, Long>{
	
	Turma findByNome(String nome);

}
