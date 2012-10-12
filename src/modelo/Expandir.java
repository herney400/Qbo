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
   // String camino;
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
                        String  camino="↓";
                        profundidad++;
                        crearCamino(camino, nodotemporal);
                          hijo= new Nodo(camino,Estado.siguienteEstado(estadoTemp,nodotemporal.robot.posicionActual,1 ), Qbo);
                          
                          if(hijo!=null){
                            hijos.add(hijo);
                          }   
                             
                    }if(((nodotemporal.robot.sensor.buscarArriba(nodotemporal.robot.posicionActual))==0)||
                        ((nodotemporal.robot.sensor.buscarArriba(nodotemporal.robot.posicionActual))==3)||
                        ((nodotemporal.robot.sensor.buscarArriba(nodotemporal.robot.posicionActual))==5)||
                        ((nodotemporal.robot.sensor.buscarArriba(nodotemporal.robot.posicionActual))==2)){
                        String camino="↑";
                         profundidad++;
                          crearCamino(camino, nodotemporal);
                        hijo = new Nodo(camino,Estado.siguienteEstado(estadoTemp, nodotemporal.robot.posicionActual,2), Qbo);
                            if(hijo!=null){
                                hijos.add(hijo);
                            }
                    }if(((nodotemporal.robot.sensor.buscarDerecha(nodotemporal.robot.posicionActual))==0)||
                         ((nodotemporal.robot.sensor.buscarDerecha(nodotemporal.robot.posicionActual))==5)||
                         ((nodotemporal.robot.sensor.buscarDerecha(nodotemporal.robot.posicionActual))==2)||
                         ((nodotemporal.robot.sensor.buscarDerecha(nodotemporal.robot.posicionActual))==3)){                        
                         String  camino="→";
                        profundidad++;
                         crearCamino(camino, nodotemporal);
                        hijo=new Nodo(camino, Estado.siguienteEstado(estadoTemp, nodotemporal.robot.posicionActual,3), Qbo);
                            if(hijo!=null){
                              hijos.add(hijo);
                            }
                   }if((nodotemporal.robot.sensor.buscarIzquierda(nodotemporal.robot.posicionActual)==0)||                  
                        (nodotemporal.robot.sensor.buscarIzquierda(nodotemporal.robot.posicionActual)==2)||
                        (nodotemporal.robot.sensor.buscarIzquierda(nodotemporal.robot.posicionActual)==3)||
                        (nodotemporal.robot.sensor.buscarIzquierda(nodotemporal.robot.posicionActual)==5)){
                       String   camino="←";
                        profundidad++;
                       crearCamino(camino, nodotemporal);
                        hijo = new Nodo(camino, Estado.siguienteEstado(estadoTemp, nodotemporal.robot.posicionActual,4), Qbo);           
                          if(hijo!=null){
                            hijos.add(hijo);
                          }
                   
                   }
                  
              }
              
              
        return hijos;
        
    }
    
    public String crearCamino(String operador,Nodo nodo){
     //Ruta que guardara la ruta del padre y al padre
        String ruta;
        //Costo guardará el costo de avanzar al hijo
        double costo;
        //Nodo estado que se va a retornar
     
        try{

        //Si la cadenas estan vacias no usar comas
        if(nodo.getRuta().equals(""))
            operador=nodo.getRuta()+operador;
        else operador=nodo.getRuta()+","+operador;
       
        if(nodo.getRuta().equals(""))
            ruta="("+nodo.getEstado().getPosicionActual().x+","+nodo.getEstado().getPosicionActual().y+")";
        else 
            ruta=nodo.getRuta()+",("+nodo.getEstado().getPosicionActual().x+","+nodo.getEstado().getPosicionActual().y+")";
        }catch(OutOfMemoryError exc)
        {
            System.err.println("LLego al limite de memoria de java este nodo no se expande");
            System.err.println("Nodo: "+nodo.getEstado().getPosicionActual().x+","+nodo.getEstado().getPosicionActual().y);
//            System.err.println("Profundidad: "+nodo.getEstado().get);
//            System.out.println("Operadores: "+padre.getOperador());
//            return null;
        }
    return operador;
    }
    
    public abstract Nodo ejecutar ();
    
    
    
    
    
    public Expandir() {
    }
    
    
}
