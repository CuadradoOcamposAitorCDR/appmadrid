package com.android.appmadrid.ui.inicio;

import java.util.Date;
import java.util.GregorianCalendar;

class Favoritos {
    private String titulo, distrito;
    private Date fechaInicio;
    private boolean gratuito, eliminar;

    public Favoritos() {
    }

    public Favoritos(String titulo, String distrito, int agno, int mes, int dia, boolean gratuito, boolean eliminar) {
        this.titulo = titulo;
        this.distrito = distrito;

        GregorianCalendar fecha=new GregorianCalendar(agno,mes-1,dia);
        fechaInicio=fecha.getTime();

        this.gratuito = gratuito;
        this.eliminar = eliminar;
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

    public boolean isEliminar() {
        return eliminar;
    }

    public void setEliminar(boolean eliminar) {
        this.eliminar = eliminar;
    }
}
