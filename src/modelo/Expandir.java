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
    
    protected  ArrayList<Nodo> nodosBorrados;
    protected Nodo padre;
    Cola arbol=new Cola();
    CargarMundo cMundo;
    int peso=0;
   // String camino;
    int profundidad=0;
    int costo=0;
    Estado estado;
//    Nodo padre=listaNodos.get(0);
    
    public Expandir()
    {
        //contNodos=0;
        listaNodos=new ArrayList<Nodo>();
        nodosBorrados=new ArrayList<Nodo>();
        
    }
    
    public ArrayList<Nodo> expandirNodo(Nodo nodo){
      
        EstadoActual estadoTemp=nodo.getEstado();
        Nodo hijo=null;
        Robot Qbo=nodo.getRobot();  
        Nodo nodotemporal=nodo;
        ArrayList <Nodo> hijos=new ArrayList<Nodo>();
         
        if((nodotemporal.getEstado().getPosicionActual().x)<9){
            
           
            if((nodotemporal.robot.sensor.buscarDerecha(nodotemporal.getEstado().getPosicionActual(),nodotemporal)!=1)){
                
                if(((nodotemporal.robot.sensor.buscarDerecha(nodotemporal.getEstado().getPosicionActual(),nodotemporal))==0)||
                   ((nodotemporal.robot.sensor.buscarDerecha(nodotemporal.getEstado().getPosicionActual(),nodotemporal))==5)||
                   ((nodotemporal.robot.sensor.buscarDerecha(nodotemporal.getEstado().getPosicionActual(),nodotemporal))==2)||
                   ((nodotemporal.robot.sensor.buscarDerecha(nodotemporal.getEstado().getPosicionActual(),nodotemporal))==3)){
                       
                     
                        String  camino="→";
                        profundidad++;
                        crearCamino(camino, nodotemporal);
                        Estado estadoT=new Estado();
                        
                        hijo = new Nodo(camino, estadoT.siguienteEstado(estadoTemp, nodotemporal.getEstado().getPosicionActual(),3), Qbo, nodotemporal);                        
                        
                        if(hijo.getEstado().getBasuraAcumulada()!=0){
                           nodosBorrados.clear();
                        }
                        
                        if((evitarDevolverse(hijo))&&(hijo!=null))
                         {
                            hijos.add(hijo);
                         }
                  } 
             }
        }
        
        if((nodotemporal.getEstado().getPosicionActual().y)<9){
             
        
            if((nodotemporal.robot.sensor.buscarAbajo(nodotemporal.getEstado().getPosicionActual(),nodotemporal)!=1)){
                
            if( ((nodotemporal.robot.sensor.buscarAbajo(nodotemporal.getEstado().getPosicionActual(),nodotemporal))==0)||
            ((nodotemporal.robot.sensor.buscarAbajo(nodotemporal.getEstado().getPosicionActual(),nodotemporal))==2)||
            ((nodotemporal.robot.sensor.buscarAbajo(nodotemporal.getEstado().getPosicionActual(),nodotemporal))==5)||
            ((nodotemporal.robot.sensor.buscarAbajo(nodotemporal.getEstado().getPosicionActual(),nodotemporal))==3)){
                String  camino="↓";
                profundidad++;
                crearCamino(camino, nodotemporal);
                Estado estadoT=new Estado();
                hijo = new Nodo(camino, estadoT.siguienteEstado(estadoTemp, nodotemporal.getEstado().getPosicionActual(),1), Qbo, nodotemporal);
                 
                 if(hijo.getEstado().getBasuraAcumulada()!=0){
                   nodosBorrados.clear();
                 }
                
                if((evitarDevolverse(hijo))&&(hijo!=null))
                        {
                            hijos.add(hijo);
                        }
            }
          } 
        }
        
        
        if((nodotemporal.getEstado().getPosicionActual().x)!=0)
        {
            if((nodotemporal.robot.sensor.buscarIzquierda(nodotemporal.getEstado().getPosicionActual(),nodotemporal)!=1)){
                
                if((nodotemporal.robot.sensor.buscarIzquierda(nodotemporal.getEstado().getPosicionActual(),nodotemporal)==0)||
                (nodotemporal.robot.sensor.buscarIzquierda(nodotemporal.getEstado().getPosicionActual(),nodotemporal)==2)||
                (nodotemporal.robot.sensor.buscarIzquierda(nodotemporal.getEstado().getPosicionActual(),nodotemporal)==3)||
                (nodotemporal.robot.sensor.buscarIzquierda(nodotemporal.getEstado().getPosicionActual(),nodotemporal)==5)){
                    String   camino="←";
                    profundidad++;
                    crearCamino(camino, nodotemporal);
                    Estado estadoT=new Estado();
                    hijo = new Nodo(camino, estadoT.siguienteEstado(estadoTemp, nodotemporal.getEstado().getPosicionActual(),4), Qbo,nodotemporal);
                    if(hijo.getEstado().getBasuraAcumulada()!=0){
                      nodosBorrados.clear();
                    } 
                    
                    if((evitarDevolverse(hijo))&&(hijo!=null))
                        {
                          hijos.add(hijo);
                        }
                }
            } 
        }
        
        if((nodotemporal.getEstado().getPosicionActual().y)!=0)
        {
          if((nodotemporal.robot.sensor.buscarArriba(nodotemporal.getEstado().getPosicionActual(),nodotemporal)!=1)){
              
             if(((nodotemporal.robot.sensor.buscarArriba(nodotemporal.getEstado().getPosicionActual(),nodotemporal))==0)||
                ((nodotemporal.robot.sensor.buscarArriba(nodotemporal.getEstado().getPosicionActual(),nodotemporal))==3)||
                ((nodotemporal.robot.sensor.buscarArriba(nodotemporal.getEstado().getPosicionActual(),nodotemporal))==5)||
                ((nodotemporal.robot.sensor.buscarArriba(nodotemporal.getEstado().getPosicionActual(),nodotemporal))==2)){
                String camino="↑";
                profundidad++;
                crearCamino(camino, nodotemporal);
                Estado estadoT=new Estado();
                hijo = new Nodo(camino, estadoT.siguienteEstado(estadoTemp, nodotemporal.getEstado().getPosicionActual(),2), Qbo,nodotemporal);
                  
                  if(hijo.getEstado().getBasuraAcumulada()!=0){
                    nodosBorrados.clear();
                  }
                if((evitarDevolverse(hijo))&&(hijo!=null))
                    {
                       hijos.add(hijo);
                    }
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
    
    public boolean  evitarDevolverse(Nodo n){
      boolean devolverse = true;
//       Point para=padre.getEstado().getPosicionActual();
//       Point punt=n.getEstado().getPosicionActual();
        for(int i=0;i<listaNodos.size();i++){
        
            if((n.getEstado().getPosicionActual().equals(nodosBorrados.get(i).getEstado().getPosicionActual()))
               || (n.getEstado().getPosicionActual().equals(listaNodos.get(i).getEstado().getPosicionActual()))){
              devolverse=false;
              i=listaNodos.size();
            }else {
             devolverse=true;
            }
            
        }
        return devolverse;
    }
    
    
    public abstract Nodo ejecutar ();
}
