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
public class clientes {
    private String email;
    private String nombre;
    private String tipo_documento;
    private String numero_documento;
    private int id_cliente;

    public clientes() {
    }

    public clientes(String email, String nombre, String tipo_documento, String numero_documento, int id_cliente) {
        this.email = email;
        this.nombre = nombre;
        this.tipo_documento = tipo_documento;
        this.numero_documento = numero_documento;
        this.id_cliente = id_cliente;
    }

    public String getEmail() {
        return email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public String getNumero_documento() {
        return numero_documento;
    }

    public int getId_cliente() {
        return id_cliente;
    }
    
    
    
    
}
