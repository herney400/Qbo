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
 //    int pesoBasura=0;
     private String ruta="";
     private int heuristica; 
     Expandir espan;
     private EstadoActual estado;
     private Nodo padre;
     int profundidad;
     int costoDelaRuta;
     String operadorAplicado;
     private int x;
     private int y;

     
     public Nodo(  String camino, EstadoActual estadoactual, Robot Qbo){
    
       this.estado=estadoactual;
       this.ruta=camino;
       this.robot=Qbo;
       this.x=x;
       this.y=y;
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
     
     public Nodo clone()
    {
        Nodo nodo=new Nodo(  ruta, estado, robot);
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

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }
}
