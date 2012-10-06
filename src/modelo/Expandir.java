/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dao.CargarMundo;
import estructuras.Cola;
import java.awt.Point;
import java.awt.geom.Point2D;

/**
 *
 * @author fidelhpc
 */
public class Expandir {
    Robot Qbo=new Robot();
    Nodo temporal;
    Cola arbol=new Cola();
    CargarMundo cMundo;
    int peso=0;
    String camino;
    int profundidad=0;
    int costo=0;
    Estado estado;
    public void expandirNodo(Nodo nodo){
        
        
        if(temporal.esMeta()){
           solucion();
           
        }else{
           if((temporal.robot.sensor.buscarAbajo(temporal.robot.posicionActual))==0){
               camino="abajo";
               profundidad++;
               arbol.agregar(new Nodo( new Point(temporal.robot.posicionActual.x+1, temporal.robot.posicionActual.y),peso,camino,profundidad,costo,
                       estado.siguienteEstado(nodo.getMundo(), costo, peso)));
           
           }if((temporal.robot.sensor.buscarArriba(temporal.robot.posicionActual))==0){
               camino="arriba";
               profundidad++;
               arbol.agregar(new Nodo( new Point(temporal.robot.posicionActual.x-1, temporal.robot.posicionActual.y),peso,camino,profundidad,costo ));
           
           }if((temporal.robot.sensor.buscarDerecha(temporal.robot.posicionActual))==0){
               camino="derecha";
               profundidad++;
               arbol.agregar(new Nodo( new Point(temporal.robot.posicionActual.x, temporal.robot.posicionActual.y+1),peso,camino,profundidad,costo ));
           
          }if(temporal.robot.sensor.buscarDerecha(temporal.robot.posicionActual)==0){
               camino="izquierda";
               profundidad++;
               arbol.agregar(new Nodo( new Point(temporal.robot.posicionActual.x, temporal.robot.posicionActual.y+1),peso,camino,profundidad,costo ));
           
          
          }
            
            
            
            
            
            
            
        }
        
        
        
        
      
    
    }
    public void solucion(){}
    
    
    public Expandir() {
    }
    
    
}
