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
    private boolean  dep1cargado;
    private boolean  dep2cargado;
    private boolean dep2KR;
    private boolean dep3KR;
    private boolean cambiarEstado;
    public EstadoActual(int [][] mundo, int costo,int pesoBasura, Point posicionActual,
            int basuraA, boolean  dep1cargado, boolean  dep2cargado,boolean dep2kR,boolean dep3kR, boolean  cambiarEstado){

        for (int i = 0; i < mundo.length; i++) {
            System.arraycopy(mundo[i], 0, ambiente[i], 0, mundo.length);
        }
        this.costo=costo;
        this.pesoBasura=pesoBasura;
        this.posicionActual=posicionActual;
        this.basuraAcumulada=basuraA;
        this.dep1cargado=dep1cargado;
        this.dep2cargado=dep2cargado;
        this.dep2KR=dep2kR;
        this.dep3KR=dep3kR;
        this.cambiarEstado=cambiarEstado;
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

    /**
     * @return the dep1cargado
     */
    public boolean isDep1cargado() {
        return dep1cargado;
    }

    /**
     * @param dep1cargado the dep1cargado to set
     */
    public void setDep1cargado(boolean dep1cargado) {
        this.dep1cargado = dep1cargado;
    }

    /**
     * @return the dep2cargado
     */
    public boolean isDep2cargado() {
        return dep2cargado;
    }

    /**
     * @param dep2cargado the dep2cargado to set
     */
    public void setDep2cargado(boolean dep2cargado) {
        this.dep2cargado = dep2cargado;
    }

    /**
     * @return the dep2KR
     */
    public boolean isDep2KR() {
        return dep2KR;
    }

    /**
     * @param dep2KR the dep2KR to set
     */
    public void setDep2KR(boolean dep2KR) {
        this.dep2KR = dep2KR;
    }

    /**
     * @return the dep3KR
     */
    public boolean isDep3KR() {
        return dep3KR;
    }

    /**
     * @param dep3KR the dep3KR to set
     */
    public void setDep3KR(boolean dep3KR) {
        this.dep3KR = dep3KR;
    }

    /**
     * @return the cambiarEstado
     */
    public boolean isCambiarEstado() {
        return cambiarEstado;
    }

    /**
     * @param cambiarEstado the cambiarEstado to set
     */
    public void setCambiarEstado(boolean cambiarEstado) {
        this.cambiarEstado = cambiarEstado;
    }
}
