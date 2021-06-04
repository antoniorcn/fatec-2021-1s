package edu.curso.livro;

import java.util.List;

public interface LivroDAO {
    void adicionar(Livro l);
    List<Livro> pesquisarPorTitulo(String titulo);
    void apagarPorId(long id);
    void atualizar(long id, Livro l);
}
