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
public class Casillas {
    
    
    String x;
    String y;
    String valor;

    public Casillas() {
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Casillas{" + "x=" + x + ", y=" + y + ", valor=" + valor + '}';
    }
    
}
