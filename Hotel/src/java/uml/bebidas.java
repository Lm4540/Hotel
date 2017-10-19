/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uml;

/**
 *
 * @author Admòn
 */
public class bebidas {
    private int id_bebida;
    private String imagen;
    private String titulo;
    private String descipcion;

    public bebidas() {
    }

    public bebidas(int id_bebida, String imagen, String titulo, String descipcion) {
        this.id_bebida = id_bebida;
        this.imagen = imagen;
        this.titulo = titulo;
        this.descipcion = descipcion;
    }

    public int getId_bebida() {
        return id_bebida;
    }

    public String getImagen() {
        return imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescipcion() {
        return descipcion;
    }
    
    
}
