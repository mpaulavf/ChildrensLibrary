package com.example.lista;

public class actividad_elegible {
    private String acti, descricion;
    private int foto;

    public actividad_elegible() {
    }

    public actividad_elegible(String acti, String descricion, int foto) {
        this.acti = acti;
        this.descricion = descricion;
        this.foto = foto;
    }

    public String getActi() {
        return acti;
    }

    public void setActi(String acti) {
        this.acti = acti;
    }

    public String getDescricion() {
        return descricion;
    }

    public void setDescricion(String descricion) {
        this.descricion = descricion;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
