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
public class habitaciones {
    private int numero;
    private int piso;
    private String disponible;
    private int tipo;
    

    public habitaciones() {
    }

    public habitaciones(int numero, int piso, String disponible, int tipo) {
        this.numero = numero;
        this.piso = piso;
        this.disponible = disponible;
        this.tipo = tipo;
    }

    

    public int getPiso() {
        return piso;
    }

    public int getNumero() {
        return numero;
    }

    public String getDisponible() {
        return disponible;
    }

    public int getTipo() {
        return tipo;
    }
    

}