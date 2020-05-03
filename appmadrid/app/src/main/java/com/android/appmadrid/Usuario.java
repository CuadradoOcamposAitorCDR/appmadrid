package com.android.appmadrid;

public class Usuario {
    private static String idUsuario;

    private static Usuario usuario=null;

    private Usuario(){
    }

    public static String getIdUsuario() {
        return idUsuario;
    }

    public static void setIdUsuario(String idUsuario) {
        Usuario.idUsuario = idUsuario;
    }

    public static Usuario construirUsuario(){
     if (usuario==null){
         usuario = new Usuario();
     }
     return usuario;
    }
}



