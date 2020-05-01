package com.android.appmadrid;

import android.content.Context;

class Usuario {
    private static String idUsuario,nombre,pass,mail;

    private static Usuario usuario=null;

    private Usuario(String idUsuario){
        this.idUsuario=idUsuario;
    }

    public static String getIdUsuario() {
        return idUsuario;
    }

    public static void setIdUsuario(String idUsuario) {
        Usuario.idUsuario = idUsuario;
    }

    public static Usuario getUsuario(String idUsuario){
     if (usuario==null){
         usuario = new Usuario(idUsuario);
     }
     return usuario;
    }
}



