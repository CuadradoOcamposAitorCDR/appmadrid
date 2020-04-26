package com.android.appmadrid.ui.buscar;

import java.util.Date;
import java.util.GregorianCalendar;

class Busqueda {
    private String titulo, distrito;
    private Date fechaInicio;
    private boolean gratuito,favorito;

    public Busqueda(){
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public boolean isGratuito() {
        return gratuito;
    }

    public void setGratuito(boolean gratuito) {
        this.gratuito = gratuito;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    public Busqueda(String titulo, String distrito, int agno, int mes, int dia, boolean gratuito, boolean favorito) {
        this.titulo = titulo;
        this.distrito = distrito;

        GregorianCalendar fecha=new GregorianCalendar(agno,mes-1,dia);
        fechaInicio=fecha.getTime();

        this.gratuito = gratuito;
        this.favorito = favorito;
    }
}
