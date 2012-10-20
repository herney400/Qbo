/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Point;

/**
 *
 * @author palacioscuacialpud
 */
public class Nodo {
     int mundo[][];
     //Point posicionActual;
     int peso;
     Robot robot; 
     //int pesoBasura=0;
     private String ruta="";
     private int heuristica; 
     Expandir espan;
     private EstadoActual estado;
     private Nodo padre;
     int profundidad;
     int costoDelaRuta;
     String operadorAplicado;
     
    public Nodo(String camino, EstadoActual estadoactual, Robot Qbo, Nodo nodo){    
       this.estado=estadoactual;
       this.ruta=camino;
       this.robot=Qbo;
       this.padre=nodo;
    }
     
    public boolean esMeta(){
      boolean meta=true;
      return meta;
    }
        
    public Point inicializaPosicion(int mundo[][]){
       Point posicionInicial = null;
        for (int i = 0; i < mundo.length; i++) {
            for (int j = 0; j < mundo.length; j++) {
                 if(mundo[i][j]==5){
                    posicionInicial.setLocation(j, i);
                 }
            }
        }
        return posicionInicial;
    }
    
    public int getHeuristica() {
        return heuristica;
    }

    public void setMundo(int[][] mundo) {
        this.mundo = mundo;
    }

    public int[][] getMundo() {
        return mundo;
    }

    public int getPeso() {
        return peso;
    }

    public Robot getRobot() {
        return robot;
    }   

    /**
     * @return the estado
     */
    public EstadoActual getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(EstadoActual estado) {
        this.estado = estado;
    }
     
    @Override
    public Nodo clone(){
        Nodo nodo=new Nodo(  ruta, estado, robot, padre);
        return nodo;
    }

    /**
     * @return the ruta
     */
    public String getRuta() {
        return ruta;
    }

    /**
     * @param ruta the ruta to set
     */
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    /**
     * @return the padre
     */
    public Nodo getPadre() {
        return padre;
    }

    /**
     * @param padre the padre to set
     */
    public void setPadre(Nodo padre) {
        this.padre = padre;
    }
}
