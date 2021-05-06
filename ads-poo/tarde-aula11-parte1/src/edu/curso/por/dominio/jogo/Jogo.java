package edu.curso.por.dominio.jogo;

import java.time.LocalDate;

public class Jogo {
    private long id;
    private String titulo;
    private String genero;
    private int classificacao;
    private String estudio;
    private LocalDate lancamento;
    private String midia;
    private String descricao;

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

    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getClassificacao() {
        return classificacao;
    }
    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public String getEstudio() {
        return estudio;
    }
    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public LocalDate getLancamento() {
        return lancamento;
    }
    public void setLancamento(LocalDate lancamento) {
        this.lancamento = lancamento;
    }

    public String getMidia() {
        return midia;
    }
    public void setMidia(String midia) {
        this.midia = midia;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
