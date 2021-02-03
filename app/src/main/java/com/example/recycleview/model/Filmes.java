package com.example.recycleview.model;

public class Filmes {

    private String tituloFilme;
    private String ano;
    private String genero;

    public String getTituloFilme() {
        return tituloFilme;
    }

    public void setTituloFilme(String tituloFilme) {
        this.tituloFilme = tituloFilme;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Filmes() {

    }

    public Filmes(String tituloFilme, String ano, String genero) {
        this.tituloFilme = tituloFilme;
        this.ano = ano;
        this.genero = genero;
    }
}
