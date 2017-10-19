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
public class tipos_de_habitaciones {
    private int id_tipo;
    private String nombre;
    private double precio;
    private String caracteristicas;
    private int cantidad;

    public tipos_de_habitaciones() {
    }

    public tipos_de_habitaciones(int id_tipo, String nombre, double precio, String caracteristicas, int cantidad) {
        this.id_tipo = id_tipo;
        this.nombre = nombre;
        this.precio = precio;
        this.caracteristicas = caracteristicas;
        this.cantidad = cantidad;
    }

    public int getId_tipo() {
        return id_tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public int getCantidad() {
        return cantidad;
    }
    
    
}
