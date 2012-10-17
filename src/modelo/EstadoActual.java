/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Point;

/**
 *
 * @author fidelhpc
 */
public class EstadoActual {
    
    
    private int ambiente[][]= new int[10][10];
    private int costo=0;
    private int pesoBasura=0;
    private Estado estado;
    private Point posicionActual;
    private int basuraAcumulada;
       
    public EstadoActual(int [][] mundo, int costo,int pesoBasura, Point posicionActual){

        for (int i = 0; i < mundo.length; i++) {
            System.arraycopy(mundo[i], 0, ambiente[i], 0, mundo.length);
        }
        this.costo=costo;
        this.pesoBasura=pesoBasura;
        this.posicionActual=posicionActual;
    }

    /**
     * @return the ambiente
     */
    public int[][] getAmbiente() {
        return ambiente;
    }

    /**
     * @param ambiente the ambiente to set
     */
    public void setAmbiente(int[][] ambiente) {
        this.ambiente = ambiente;
    }

    /**
     * @return the costo
     * 
     */
    public int getCosto() {
        return costo;
    }

    /**
     * @param costo the costo to set
     */
    public void setCosto(int costo) {
        this.costo = costo;
    }

    /**
     * @return the pesoBasura
     */
    public int getPesoBasura() {
        return pesoBasura;
    }

    /**
     * @param pesoBasura the pesoBasura to set
     */
    public void setPesoBasura(int pesoBasura) {
        this.pesoBasura = pesoBasura;
    }

    /**
     * @return the posicionActual
     */
    public Point getPosicionActual() {
        return posicionActual;
    }

    /**
     * @param posicionActual the posicionActual to set
     */
    public void setPosicionActual(Point posicionActual) {
        this.posicionActual = posicionActual;
    }

    /**
     * @return the basuraAcumulada
     * 
     */
    public int getBasuraAcumulada() {
        return basuraAcumulada;
    }

    /**
     * @param basuraAcumulada the basuraAcumulada to set
     */
    public void setBasuraAcumulada(int basuraAcumulada) {
        this.basuraAcumulada = basuraAcumulada;
    }    
}
