package com.example.AlejandroSantos.Toast;

/**
 * Created by ger on 02/06/2015.
 */
public class Lista_entrada {

    private int idImagen;
    private String textoDia;
    private String textoEstado;
    private String textoGrados;

    public Lista_entrada (int idImagen, String textoDia, String textoEstado, String textoGrados) {
        this.idImagen = idImagen;
        this.textoDia = textoDia;
        this.textoEstado = textoEstado;
        this.textoGrados = textoGrados;
    }

    public String get_textoDia() {
        return textoDia;
    }

    public String get_textoEstado() {return textoEstado;}

    public String get_textoGrados() {
        return textoGrados;
    }

    public int get_idImagen() {
        return idImagen;
    }
}
