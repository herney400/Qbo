/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Point;

/**
 * Actua como un sensor el cual le permite explorar el mundo al robot
 * Entrga informacion de las Celdas que se hayan alrededor del DustCart
 * @author Franjav
 */
public class Sensor {
    
    /** Representacion del mundo en el que opera el DustCart */
    private int[][] mundo;
    /** Valor encontrado en las celdas vecinas a la posición acutal del DustCart */
    private int valorEncontrado;
    /** Representa un punto de coordenadas x e y que reflejan la posicion del robot en el mundo */
    private Point posicionActual;
    
    /**
     * Constructor parametrizado, crea un sensor indicando la posicion inical del robot
     * @param posicionInicial La posicion en la que inicia el robot
     */
    public Sensor( Point posicionInicial ){
        mundo = new int[12][12];
        posicionActual = new Point( posicionInicial );
    }//Sensor
    
    /**
     * Asigna una matriz que representa el mundo en el que el DustCart interactua
     * @param mundo Representacion del mundo cargado de un archivo txt
     */
    public void setMundo( int[][] mundo ){
        if ( mundo != null ){
            this.mundo = mundo;
        }
        else{
            System.out.println("Error, no se ha asignado el mundo para DustCart");
        }
    }//setMundo
    
    /**
     * Busca en la direccion arriba de la posicion actual del robot
     * @param posicion Posicion en la que se halla el robot
     * @return data Dato encontrado por el sensor en la posicion arriba
     */
    public int buscarArriba(Point posicion){
        valorEncontrado = mundo[ posicion.x - 1 ][ posicion.y ];
        System.out.println(""+posicion);
        return valorEncontrado;
    }//buscarArriba
    
    /**
     * Busca en la direccion derecha de la posicion actual del robot
     * @param posicion Posicion en la que se halla el robot
     * @return data Dato encontrado por el sensor en la posicion derecha
     */
    public int buscarDerecha(Point posicion){
        valorEncontrado = mundo[ posicion.x ][ posicion.y + 1 ];
        return valorEncontrado;
    }//buscarDerecha
    
    /**
     * Busca en la direccion abajo de la posicion actual del robot
     * @param posicion Posicion en la que se halla el robot
     * @return data Dato encontrado por el sensor en la posicion abajo
     */
    public int buscarAbajo(Point p){
        valorEncontrado = mundo[p.x + 1 ][ p.y ];
        return valorEncontrado;
    }//buscarAbajo
    
    /**
     * Busca en la direccion izquierda de la posicion actual del robot
     * @param posicion Posicion en la que se halla el robot
     * @return data Dato encontrado por el sensor en la posicion izquierda
     */
    public int buscarIzquierda(Point posicion){
        valorEncontrado = mundo[ posicion.x ][ posicion.y - 1 ];
        return valorEncontrado;
    }//buscarIzquierda
            
    public void imprimirMundo(){
        for(int i=0; i<mundo.length; i++){
            for(int j=0; j<mundo[i].length; j++){
                System.out.print(mundo[i][j]+" ");
            }
            System.out.println();
        }
        
    }
        
}
