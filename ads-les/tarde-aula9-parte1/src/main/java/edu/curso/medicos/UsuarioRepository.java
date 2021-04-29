package edu.curso.medicos;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    Usuario findByUsuario(String usuario);
}
