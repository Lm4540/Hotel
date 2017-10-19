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
public class platos {
    private int id_plato;
    private String imagen;
    private String titulo;
    private String descripcion;
    private int categoria;

    public platos() {
    }

    public platos(int id_plato, String imagen, String titulo, String descripcion, int categoria) {
        this.id_plato = id_plato;
        this.imagen = imagen;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.categoria = categoria;
    }

    public int getId_plato() {
        return id_plato;
    }

    public String getImagen() {
        return imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCategoria() {
        return categoria;
    }
    
    
    
    
}
