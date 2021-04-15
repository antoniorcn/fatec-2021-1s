package edu.curso;

public interface Publicador {
    void adicionar(Observador o);
    void remover(Observador o);
    void avisar(String noticia);
}
