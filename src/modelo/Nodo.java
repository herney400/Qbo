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
     
     Point posicionActual;
     int peso;
     Robot robot; 
     int pesoBasura=0;
     String ruta="";
     private int heuristica; 
     Expandir espan;
     Estado estado;
     Nodo padre;
     int profundidad;
     int costoDelaRuta;
     String operadorAplicado;
     
     /*en caso de que la heuristica la hagamos
      * con entero, que creo es lo mas viable...
     */
     
     
     public Nodo( Point posicionActual, int peso, String camino, int profundidad,int costoRut){
       //this.mundo=mundoActual;
       this.posicionActual=posicionActual;
       this.peso=peso;
       //this.robot=rob;
       this.ruta=camino;
       this.profundidad=profundidad;
       this.costoDelaRuta=costoRut;
    }
     
     
    /*constructor 2*/ 
    public Nodo() {
    
    }
    public boolean esMeta(){
    boolean meta=true;
    return meta;
    }
    
    
    public int getHeuristica() {
        return heuristica;
    }
    public Point getPosicionActual() {
        return posicionActual;
    }

    public int getPesoBasura() {
        return pesoBasura;
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
     
    
}
