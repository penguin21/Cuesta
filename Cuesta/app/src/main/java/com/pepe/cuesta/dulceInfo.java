package com.pepe.cuesta;

/**
 * Created by CHENAO on 3/07/2017.
 */

public class dulceinfo {

    private String nombre;
    private String info;
    private int foto;

    public dulceinfo(){

    }

    public dulceinfo(String nombre, String info, int foto) {
        this.nombre = nombre;
        this.info = info;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
