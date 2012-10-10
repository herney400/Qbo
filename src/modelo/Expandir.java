/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dao.CargarMundo;
import estructuras.Cola;
import java.awt.Point;
import java.util.ArrayList;
//import java.awt.geom.Point2D;

/**
 *
 * @author fidelhpc
 */
public abstract class Expandir {
    
    protected ArrayList<Nodo> listaNodos;   
    Cola arbol=new Cola();
    CargarMundo cMundo;
    int peso=0;
    String camino;
    int profundidad=0;
    int costo=0;
    Estado estado;
    public ArrayList<Nodo> expandirNodo(Nodo nodo){
      
        EstadoActual estadoTemp=nodo.getEstado();
        Nodo hijo=null;
        Robot Qbo=nodo.getRobot();  
        Nodo nodotemporal=nodo;
       ArrayList <Nodo> hijos=new ArrayList<Nodo>();
//        if(nodotemporal.esMeta()){
//           solucion();
//           return true;
    //    }else{
              if((nodotemporal.robot.sensor.buscarDerecha(nodotemporal.robot.posicionActual)==-1)||
                 (nodotemporal.robot.sensor.buscarIzquierda(nodotemporal.robot.posicionActual)==-1)){
                  
                  
              }else{
                    if( (nodotemporal.robot.sensor.buscarAbajo(nodotemporal.robot.posicionActual)==0)||
                        (nodotemporal.robot.sensor.buscarAbajo(nodotemporal.robot.posicionActual)==2)||
                        (nodotemporal.robot.sensor.buscarAbajo(nodotemporal.robot.posicionActual)==5)||
                        (nodotemporal.robot.sensor.buscarAbajo(nodotemporal.robot.posicionActual)==3)){
                        camino="abajo";
                        profundidad++;
                        
                          hijo= new Nodo(camino,Estado.siguienteEstado(estadoTemp,nodotemporal.robot.posicionActual,1 ), Qbo);
                          if(hijo!=null){
                            hijos.add(hijo);
                          }   
                             
                    }if(((nodotemporal.robot.sensor.buscarArriba(nodotemporal.robot.posicionActual))==0)||
                        ((nodotemporal.robot.sensor.buscarArriba(nodotemporal.robot.posicionActual))==3)||
                        ((nodotemporal.robot.sensor.buscarArriba(nodotemporal.robot.posicionActual))==5)||
                        ((nodotemporal.robot.sensor.buscarArriba(nodotemporal.robot.posicionActual))==2)){
                         camino="arriba";
                         profundidad++;
                        hijo = new Nodo(camino,Estado.siguienteEstado(estadoTemp, nodotemporal.robot.posicionActual,2), Qbo);
                            if(hijo!=null){
                                hijos.add(hijo);
                            }
                    }if(((nodotemporal.robot.sensor.buscarDerecha(nodotemporal.robot.posicionActual))==0)||
                         ((nodotemporal.robot.sensor.buscarDerecha(nodotemporal.robot.posicionActual))==5)||
                         ((nodotemporal.robot.sensor.buscarDerecha(nodotemporal.robot.posicionActual))==2)||
                         ((nodotemporal.robot.sensor.buscarDerecha(nodotemporal.robot.posicionActual))==3)){                        
                        camino="derecha";
                        profundidad++;
                        hijo=new Nodo(camino, Estado.siguienteEstado(estadoTemp, nodotemporal.robot.posicionActual,3), Qbo);
                            if(hijo!=null){
                              hijos.add(hijo);
                            }
                   }if((nodotemporal.robot.sensor.buscarIzquierda(nodotemporal.robot.posicionActual)==0)||                  
                        (nodotemporal.robot.sensor.buscarIzquierda(nodotemporal.robot.posicionActual)==2)||
                        (nodotemporal.robot.sensor.buscarIzquierda(nodotemporal.robot.posicionActual)==3)||
                        (nodotemporal.robot.sensor.buscarIzquierda(nodotemporal.robot.posicionActual)==5)){
                        camino="izquierda";
                        profundidad++;
                        hijo = new Nodo(camino, Estado.siguienteEstado(estadoTemp, nodotemporal.robot.posicionActual,4), Qbo);           
                          if(hijo!=null){
                            hijos.add(hijo);
                          }
                   
                   }
                  
              }
              
              
        return hijos;
        
    }
    
    public abstract Nodo ejecutar ();
    
    
    
    
    
    public Expandir() {
    }
    
    
}
