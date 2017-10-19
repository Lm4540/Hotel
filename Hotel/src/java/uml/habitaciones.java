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
    private String disponible;
    private int tipo;
    private int piso;

    public habitaciones() {
    }

    public habitaciones(int numero, String disponible, int tipo, int piso) {
        this.numero = numero;
        this.disponible = disponible;
        this.tipo = tipo;
        this.piso = piso;
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