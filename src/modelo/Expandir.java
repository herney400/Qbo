/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dao.CargarMundo;
import estructuras.Cola;
import java.awt.Point;
//import java.awt.geom.Point2D;

/**
 *
 * @author fidelhpc
 */
public class Expandir {
    
    
    Cola arbol=new Cola();
    CargarMundo cMundo;
    int peso=0;
    String camino;
    int profundidad=0;
    int costo=0;
    Estado estado;
    public boolean expandirNodo(Nodo nodo){
        
        EstadoActual estadoTemp=nodo.getEstado();
        Robot Qbo=nodo.getRobot();  
       Nodo nodotemporal=nodo;
        if(nodotemporal.esMeta()){
           solucion();
           return true;
        }else{
              if((nodotemporal.robot.sensor.buscarDerecha(nodotemporal.robot.posicionActual)==-1)||
                 (nodotemporal.robot.sensor.buscarIzquierda(nodotemporal.robot.posicionActual)==-1)){
                  return false;
                  
              }else{
                    if( (nodotemporal.robot.sensor.buscarAbajo(nodotemporal.robot.posicionActual)==0)||
                        (nodotemporal.robot.sensor.buscarAbajo(nodotemporal.robot.posicionActual)==2)||
                        (nodotemporal.robot.sensor.buscarAbajo(nodotemporal.robot.posicionActual)==5)||
                        (nodotemporal.robot.sensor.buscarAbajo(nodotemporal.robot.posicionActual)==3)){
                        camino="abajo";
                        profundidad++;
                        arbol.agregar(new Nodo(camino,Estado.siguienteEstado(estadoTemp,nodotemporal.robot.posicionActual,1 ), Qbo));

                    }if(((nodotemporal.robot.sensor.buscarArriba(nodotemporal.robot.posicionActual))==0)||
                        ((nodotemporal.robot.sensor.buscarArriba(nodotemporal.robot.posicionActual))==3)||
                        ((nodotemporal.robot.sensor.buscarArriba(nodotemporal.robot.posicionActual))==5)||
                        ((nodotemporal.robot.sensor.buscarArriba(nodotemporal.robot.posicionActual))==2)){
                         camino="arriba";
                         profundidad++;
                        arbol.agregar(new Nodo(camino,Estado.siguienteEstado(estadoTemp, nodotemporal.robot.posicionActual,2), Qbo));

                    }if(((nodotemporal.robot.sensor.buscarDerecha(nodotemporal.robot.posicionActual))==0)||
                         ((nodotemporal.robot.sensor.buscarDerecha(nodotemporal.robot.posicionActual))==5)||
                         ((nodotemporal.robot.sensor.buscarDerecha(nodotemporal.robot.posicionActual))==2)||
                         ((nodotemporal.robot.sensor.buscarDerecha(nodotemporal.robot.posicionActual))==3)){
                        
                        camino="derecha";
                        profundidad++;
                        arbol.agregar(new Nodo(camino, Estado.siguienteEstado(estadoTemp, nodotemporal.robot.posicionActual,3), Qbo));

                   }if((nodotemporal.robot.sensor.buscarIzquierda(nodotemporal.robot.posicionActual)==0)||                  
                        (nodotemporal.robot.sensor.buscarIzquierda(nodotemporal.robot.posicionActual)==2)||
                        (nodotemporal.robot.sensor.buscarIzquierda(nodotemporal.robot.posicionActual)==3)||
                        (nodotemporal.robot.sensor.buscarIzquierda(nodotemporal.robot.posicionActual)==5)){
                        camino="izquierda";
                        profundidad++;
                        arbol.agregar(new Nodo(camino, Estado.siguienteEstado(estadoTemp, nodotemporal.robot.posicionActual,4), Qbo));           
                   }
                   return true;
              }
         }
        
    }
    public void solucion(){}
    
    
    public Expandir() {
    }
    
    
}
