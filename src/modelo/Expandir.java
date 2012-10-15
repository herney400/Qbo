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
    
    
    public Expandir()
    {
        //contNodos=0;
        listaNodos=new ArrayList<Nodo>();
    }
    public ArrayList<Nodo> expandirNodo(Nodo nodo){
      
        EstadoActual estadoTemp=nodo.getEstado();
        Nodo hijo=null;
        Robot Qbo=nodo.getRobot();  
        Nodo nodotemporal=nodo;
          Estado estNuevo=null; 
       ArrayList <Nodo> hijos=new ArrayList<Nodo>();
            
         int variDesic=nodotemporal.getEstado().getPosicionActual().y;
         
           if(!(( nodotemporal.getEstado().getPosicionActual().y+1)==11)){
               
                 if(((nodotemporal.robot.sensor.buscarDerecha(nodotemporal.getEstado().getPosicionActual()))==0)||
                         ((nodotemporal.robot.sensor.buscarDerecha(nodotemporal.getEstado().getPosicionActual()))==5)||
                         ((nodotemporal.robot.sensor.buscarDerecha(nodotemporal.getEstado().getPosicionActual()))==2)||
                         ((nodotemporal.robot.sensor.buscarDerecha(nodotemporal.getEstado().getPosicionActual()))==3)){                        
                          String  camino="→";
                          profundidad++;
                         crearCamino(camino, nodotemporal);
                        hijo=new Nodo(camino, siguientEstado(estadoTemp, nodotemporal.getEstado().getPosicionActual(),3), Qbo);
                            if(hijo!=null){
                              hijos.add(hijo);
                            }
                   }
           
           } if(!((nodotemporal.getEstado().getPosicionActual().x+1)==11)){
               
                   
                    if( ((nodotemporal.robot.sensor.buscarAbajo(nodotemporal.getEstado().getPosicionActual()))==0)||
                        ((nodotemporal.robot.sensor.buscarAbajo(nodotemporal.getEstado().getPosicionActual()))==2)||
                        ((nodotemporal.robot.sensor.buscarAbajo(nodotemporal.getEstado().getPosicionActual()))==5)||
                        ((nodotemporal.robot.sensor.buscarAbajo(nodotemporal.getEstado().getPosicionActual()))==3)){
                        String  camino="↓";
                        profundidad++;
                        crearCamino(camino, nodotemporal);                        
                        hijo= new Nodo(camino, siguientEstado(estadoTemp,nodotemporal.getEstado().getPosicionActual(),1 ), Qbo);                         
                          if(hijo!=null){
                            hijos.add(hijo);
                          } 
                    } 
           
           } if(!((nodotemporal.getEstado().getPosicionActual().y)==1)){
                         if((nodotemporal.robot.sensor.buscarIzquierda(nodotemporal.getEstado().getPosicionActual())==0)||                  
                        (nodotemporal.robot.sensor.buscarIzquierda(nodotemporal.getEstado().getPosicionActual())==2)||
                        (nodotemporal.robot.sensor.buscarIzquierda(nodotemporal.getEstado().getPosicionActual())==3)||
                        (nodotemporal.robot.sensor.buscarIzquierda(nodotemporal.getEstado().getPosicionActual())==5)){
                       String   camino="←";
                        profundidad++;
                       crearCamino(camino, nodotemporal);
                        hijo = new Nodo(camino, siguientEstado(estadoTemp, nodotemporal.getEstado().getPosicionActual(),4), Qbo);           
                          if(hijo!=null){
                            hijos.add(hijo);
                          }
                   
                   }   
           
           
           } if(!((nodotemporal.getEstado().getPosicionActual().x)==1)){
                      if(((nodotemporal.robot.sensor.buscarArriba(nodotemporal.getEstado().getPosicionActual()))==0)||
                        ((nodotemporal.robot.sensor.buscarArriba(nodotemporal.getEstado().getPosicionActual()))==3)||
                        ((nodotemporal.robot.sensor.buscarArriba(nodotemporal.getEstado().getPosicionActual()))==5)||
                        ((nodotemporal.robot.sensor.buscarArriba(nodotemporal.getEstado().getPosicionActual()))==2)){
                        String camino="↑";
                         profundidad++;
                          crearCamino(camino, nodotemporal);
                        hijo = new Nodo(camino,siguientEstado(estadoTemp, nodotemporal.getEstado().getPosicionActual(),2), Qbo);
                            if(hijo!=null){
                                hijos.add(hijo);
                            }
                    }  
                  
           
           }
       
       /*
              if((nodotemporal.robot.sensor.buscarDerecha(nodotemporal.getEstado().getPosicionActual())==-1)||
                 (nodotemporal.robot.sensor.buscarIzquierda(nodotemporal.getEstado().getPosicionActual())==-1)){
                   
                  System.out.print("paila");
              }else{
                    if( ((nodotemporal.robot.sensor.buscarAbajo(nodotemporal.getEstado().getPosicionActual()))==0)||
                        ((nodotemporal.robot.sensor.buscarAbajo(nodotemporal.getEstado().getPosicionActual()))==2)||
                        ((nodotemporal.robot.sensor.buscarAbajo(nodotemporal.getEstado().getPosicionActual()))==5)||
                        ((nodotemporal.robot.sensor.buscarAbajo(nodotemporal.getEstado().getPosicionActual()))==3)){
                        String  camino="↓";
                        profundidad++;
                        crearCamino(camino, nodotemporal);
                        
                        hijo= new Nodo(camino, siguientEstado(estadoTemp,nodotemporal.getEstado().getPosicionActual(),1 ), Qbo);
                          
                          if(hijo!=null){
                            hijos.add(hijo);
                          }   

                    } if(((nodotemporal.robot.sensor.buscarArriba(nodotemporal.getEstado().getPosicionActual()))==0)||
                        ((nodotemporal.robot.sensor.buscarArriba(nodotemporal.getEstado().getPosicionActual()))==3)||
                        ((nodotemporal.robot.sensor.buscarArriba(nodotemporal.getEstado().getPosicionActual()))==5)||
                        ((nodotemporal.robot.sensor.buscarArriba(nodotemporal.getEstado().getPosicionActual()))==2)){
                        String camino="↑";
                         profundidad++;
                          crearCamino(camino, nodotemporal);
                        hijo = new Nodo(camino,siguientEstado(estadoTemp, nodotemporal.getEstado().getPosicionActual(),2), Qbo);
                            if(hijo!=null){
                                hijos.add(hijo);
                            }
                    } if(((nodotemporal.robot.sensor.buscarDerecha(nodotemporal.getEstado().getPosicionActual()))==0)||
                         ((nodotemporal.robot.sensor.buscarDerecha(nodotemporal.getEstado().getPosicionActual()))==5)||
                         ((nodotemporal.robot.sensor.buscarDerecha(nodotemporal.getEstado().getPosicionActual()))==2)||
                         ((nodotemporal.robot.sensor.buscarDerecha(nodotemporal.getEstado().getPosicionActual()))==3)){                        
                         String  camino="→";
                        profundidad++;
                         crearCamino(camino, nodotemporal);
                        hijo=new Nodo(camino, siguientEstado(estadoTemp, nodotemporal.getEstado().getPosicionActual(),3), Qbo);
                            if(hijo!=null){
                              hijos.add(hijo);
                            }
                   } if((nodotemporal.robot.sensor.buscarIzquierda(nodotemporal.getEstado().getPosicionActual())==0)||                  
                        (nodotemporal.robot.sensor.buscarIzquierda(nodotemporal.getEstado().getPosicionActual())==2)||
                        (nodotemporal.robot.sensor.buscarIzquierda(nodotemporal.getEstado().getPosicionActual())==3)||
                        (nodotemporal.robot.sensor.buscarIzquierda(nodotemporal.getEstado().getPosicionActual())==5)){
                       String   camino="←";
                        profundidad++;
                       crearCamino(camino, nodotemporal);
                        hijo = new Nodo(camino, siguientEstado(estadoTemp, nodotemporal.getEstado().getPosicionActual(),4), Qbo);           
                          if(hijo!=null){
                            hijos.add(hijo);
                          }
                   
                   }
                  
              }
              */
              
        return hijos;
        
    }
    
    
    public EstadoActual  siguientEstado( EstadoActual estadoUpdate, Point p, int movimiento){
    
      int matris[][]=estadoUpdate.getAmbiente();
        int costo=estadoUpdate.getCosto();
        int pesoBasura=estadoUpdate.getPesoBasura();
        
        Point posicionNueva = new Point();
        int x=p.x;
        int y=p.y;
        
        
        int basurAcumulada=estadoUpdate.getBasuraAcumulada();
        switch(movimiento){ //buscando abajo
            case 1:
                if((matris[p.x+1][p.y]==2)||(matris[p.x+1][p.y]==3)||(matris[p.x+1][p.y]==5)||(matris[p.x+1][p.y])==0){
                   
                    if((matris[p.x+1][p.y]==2)){
                        pesoBasura=pesoBasura+2;
                        costo=costo+2;
                    }else if(matris[p.x+1][p.y]==3){
                        pesoBasura=pesoBasura+3;
                        costo=costo+3; 
                    }else if(matris[p.x+1][p.y]==5){
                           basurAcumulada=basurAcumulada+pesoBasura;
                           pesoBasura=0;          
                    }
                 }  matris[p.x][p.y]=0;
                    matris[p.x+1][p.y]=4;
                    
                    costo++;
                    posicionNueva.x=p.x+1;
                    posicionNueva.y=p.y;   
//                    System.out.println("poscion nueva para abajos"+posicionNueva+"  "+matris[posicionNueva.x][posicionNueva.y]);
                    break;
            case 2:  //buscando arriba
                if((matris[p.x-1][p.y]==2)||(matris[p.x-1][p.y]==3)||(matris[p.x-1][p.y]==5)||(matris[p.x-1][p.y])==0){
                    if((matris[p.x-1][p.y]==2)){
                        pesoBasura=pesoBasura+2;
                         costo=costo+2;
                    }if(matris[p.x-1][p.y]==3){
                        pesoBasura=pesoBasura+3;
                        costo=costo+3;
                    }if(matris[p.x-1][p.y]==5){
                       basurAcumulada=basurAcumulada+pesoBasura;
                        pesoBasura=0;
                    }
                } 
                  matris[p.x][p.y]=0;
                  matris[p.x-1][p.y]=4;
                
                  posicionNueva.x=p.x-1;
                  posicionNueva.y=p.y;
                  System.out.println("poscion nueva para arriba"+posicionNueva);
                   break;
            case 3://buscando a la derecha, se inicializa la nueva posicion 
                if((matris[p.x][p.y+1]==2)||(matris[p.x][p.y+1]==3)||(matris[p.x][p.y+1]==5)||(matris[p.x][p.y+1])==0 ){
                    if(matris[p.x][p.y+1]==2){
                        
                      pesoBasura=pesoBasura+2;
                      costo=costo+2;
                    }else if(matris[p.x][p.y+1]==3){
                      pesoBasura=pesoBasura+3;
                      costo=costo+3;
                    }else if(matris[p.x][p.y+1]==5){
                      basurAcumulada=basurAcumulada+pesoBasura;  
                     pesoBasura=0;
                    }                    
                      }
                   matris[p.x][p.y]=0;    
                   matris[p.x][p.y+1]=4;
                    
                    posicionNueva.x=p.x;
                    posicionNueva.y=p.y+1;
                     System.out.println("poscion nueva para derecxha"+posicionNueva);
                  break;
                
            case 4: //buscando a la izquierda,  y se inicializa la nueva posicion y estado.
                if((matris[p.x][p.y-1]==2)||(matris[p.x][p.y-1]==3)||(matris[p.x][p.y-1]==5)||(matris[p.x][p.y-1])==0){
                
                  if(matris[p.x][p.y-1]==2){
                  
                    pesoBasura=pesoBasura+2;
                    costo=costo+2;
                  }else if(matris[p.x][p.y-1]==3){
                      pesoBasura=pesoBasura+3;
                      costo=costo+3;
                  }else if(matris[p.x][p.y-1]==5){
                      basurAcumulada=basurAcumulada+pesoBasura;
                      pesoBasura=0;
                  }else if((matris[p.x][p.y-1])==0){
                  
                  }
            
                 }
                 matris[p.x][p.y]=0;
                matris[p.x][p.y-1]=4;
               
               posicionNueva.x=p.x;
                posicionNueva.y=p.y-1;
                 System.out.println("poscion nueva para izquierda"+posicionNueva);
                break;
                
        }
        
      
        
            EstadoActual es= new EstadoActual(matris, costo, pesoBasura, posicionNueva);
            return es ;
        
    
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
    
    
    
    
    
    
    
}
