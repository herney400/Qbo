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
     
   //  Point posicionActual;
     int peso;
     Robot robot; 
     int pesoBasura=0;
     String ruta="";
     private int heuristica; 
     Expandir espan;
     private EstadoActual estado;
     Nodo padre;
     int profundidad;
     int costoDelaRuta;
     String operadorAplicado;
     

     
     public Nodo(  String camino, EstadoActual estadoactual, Robot Qbo){
    
       this.estado=estadoactual;
       
     }
     
    /*constructor 2 elaborado para crear el nodo padre y a partir de el 
      empezar el expandir 
     */ 
    public Nodo(int mundo[][]) {
    
        estado.setAmbiente(mundo);
        estado.setCosto(peso);
        estado.setPesoBasura(pesoBasura);
        estado.setPosicionActual(inicializaPosicion(mundo));
        
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
                    posicionInicial.setLocation(i, j);
                 }
            }
        }
        return posicionInicial;
    }
    
    public int getHeuristica() {
        return heuristica;
    }
//    public Point getPosicionActual() {
//        return posicionActual;
//    }

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
     
    
}
