/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uml;

import java.util.Date;

/**
 *
 * @author Admòn
 */
public class reservaciones {
    int numero_habitacion;
    int id_huesped;
    Date entrada;
    Date salida;
    String estado;
    Date fecha_reservacion;
    String comentarios;

    public reservaciones() {
    }

    public reservaciones(int numero_habitacion, int id_huesped, Date entrada, Date salida, String estado, Date fecha_reservacion, String comentarios) {
        this.numero_habitacion = numero_habitacion;
        this.id_huesped = id_huesped;
        this.entrada = entrada;
        this.salida = salida;
        this.estado = estado;
        this.fecha_reservacion = fecha_reservacion;
        this.comentarios = comentarios;
    }

    public int getNumero_habitacion() {
        return numero_habitacion;
    }

    public int getId_huesped() {
        return id_huesped;
    }

    public Date getEntrada() {
        return entrada;
    }

    public Date getSalida() {
        return salida;
    }

    public String getEstado() {
        return estado;
    }

    public Date getFecha_reservacion() {
        return fecha_reservacion;
    }

    public String getComentarios() {
        return comentarios;
    }
    
    
}
