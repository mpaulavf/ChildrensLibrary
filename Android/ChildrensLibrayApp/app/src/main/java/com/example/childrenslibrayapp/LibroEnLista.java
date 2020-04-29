package com.example.childrenslibrayapp;

public class LibroEnLista {
    private String titulo, autor, genero, codigo;

    private int imgLibro;

    public LibroEnLista() {

    }

    public LibroEnLista(String titulo, String autor, String genero, String codigo, int imgLibro) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.codigo = codigo;
        this.imgLibro = imgLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getImgLibro() {
        return imgLibro;
    }

    public void setImgLibro(int imgLibro) {
        this.imgLibro = imgLibro;
    }
}
