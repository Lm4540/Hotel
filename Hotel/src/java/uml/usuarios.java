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
public class usuarios {
    private int id_usuario;
    private String email;
    private String tipo;
    private String contraseña;

    public usuarios() {
    }

    public usuarios(int id_usuario, String email, String tipo, String contraseña) {
        this.id_usuario = id_usuario;
        this.email = email;
        this.tipo = tipo;
        this.contraseña = contraseña;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public String getEmail() {
        return email;
    }

    public String getTipo() {
        return tipo;
    }

    public String getContraseña() {
        return contraseña;
    }
    
    
    
}
