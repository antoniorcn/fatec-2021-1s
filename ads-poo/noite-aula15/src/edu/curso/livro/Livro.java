package edu.curso.livro;

import java.time.LocalDate;

public class Livro {
    private long id;
    private String titulo = "";
    private LocalDate lancamento = LocalDate.now();
    private int edicao = 1;
    private String autor = "";
    private String editora = "";
    private String isbn = "";

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getLancamento() {
        return lancamento;
    }
    public void setLancamento(LocalDate lancamento) {
        this.lancamento = lancamento;
    }

    public int getEdicao() {
        return edicao;
    }
    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }
    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
