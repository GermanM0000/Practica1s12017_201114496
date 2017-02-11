/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lectura;

/**
 *
 * @author German
 */
public class Dic {
    
    String palabra;
    String numero;

    public Dic() {
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Dic{" + "palabra=" + palabra + ", numero=" + numero + '}';
    }
           
    
    
}
