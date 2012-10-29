/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dao.CargarMundo;
import estructuras.Cola;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JOptionPane;
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
    
    protected int [][] mapa;
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
        int pro=nodo.getProfundidad()+1;
        
        ArrayList <Nodo> hijos=new ArrayList<Nodo>();
         
        if((nodotemporal.getEstado().getPosicionActual().x)<9){
            
            if((nodotemporal.robot.sensor.buscarDerecha(nodotemporal.getEstado().getPosicionActual(),nodotemporal)!=1)){
   
                        String  camino="der";
                       // profundidad++;
                        crearCamino(camino, nodotemporal);
                        Estado estadoT=new Estado();
                       
                        hijo = new Nodo(camino, estadoT.siguienteEstado(estadoTemp, nodotemporal.getEstado().getPosicionActual(),3), Qbo, nodotemporal,pro);                        
                       
                     if(hijo.getPadre().getPadre()!=null){  
                        
                        if((hijo.getPadre().getPadre().getEstado().getPosicionActual().equals( hijo.getEstado().getPosicionActual()))){
                            
                               if(hijo.getRuta().equals(hijo.getPadre().getPadre().getRuta())){
                                
                                ///nada
                               }else{
                                   hijos.add(hijo);
                               
                               } 
                            }else{
                              hijos.add(hijo);
                            }
                      }else{
                        hijos.add(hijo);
                      
                      }                 
             }
        }
        
        if((nodotemporal.getEstado().getPosicionActual().y)<9){
             
        
            if((nodotemporal.robot.sensor.buscarAbajo(nodotemporal.getEstado().getPosicionActual(),nodotemporal)!=1)){             
                String  camino="aba";
               // profundidad++;
                crearCamino(camino, nodotemporal);
                Estado estadoT=new Estado();
              
                hijo = new Nodo(camino, estadoT.siguienteEstado(estadoTemp, nodotemporal.getEstado().getPosicionActual(),1), Qbo, nodotemporal, pro);
                
                if(hijo.getPadre().getPadre()!=null){  
                        
                        if((hijo.getPadre().getPadre().getEstado().getPosicionActual().equals( hijo.getEstado().getPosicionActual()))){
                            
                               if(hijo.getRuta().equals(hijo.getPadre().getPadre().getRuta())){
                                
                                ///nada
                               }else{
                                   hijos.add(hijo);
                               
                               } 
                            }else {
                              hijos.add(hijo);
                            }
                      }else{
                        hijos.add(hijo);
                      
                      }
                      
            } 
        }
        
        
        if((nodotemporal.getEstado().getPosicionActual().x)!=0)
        {
            if((nodotemporal.robot.sensor.buscarIzquierda(nodotemporal.getEstado().getPosicionActual(),nodotemporal)!=1)){
   
                    String   camino="izq";
                   // profundidad++;
                    crearCamino(camino, nodotemporal);
                    Estado estadoT=new Estado();
                   
                    hijo = new Nodo(camino, estadoT.siguienteEstado(estadoTemp, nodotemporal.getEstado().getPosicionActual(),4), Qbo,nodotemporal, pro);
                
                  
                 
                      if(hijo.getPadre().getPadre()!=null){  
                        
                        if((hijo.getPadre().getPadre().getEstado().getPosicionActual().equals( hijo.getEstado().getPosicionActual()))){
                            
                               if(hijo.getRuta().equals(hijo.getPadre().getPadre().getRuta())){
                                
                                ///nada
                               }else{
                                   hijos.add(hijo);
                               
                               } 
                            }else{
                              hijos.add(hijo);
                            }
                      }else{
                        hijos.add(hijo);
                      
                      }
            } 
        }
        
        if((nodotemporal.getEstado().getPosicionActual().y)!=0)
        {
          if((nodotemporal.robot.sensor.buscarArriba(nodotemporal.getEstado().getPosicionActual(),nodotemporal)!=1)){
     
                String camino="arr";
               // profundidad++;
                crearCamino(camino, nodotemporal);
                Estado estadoT=new Estado();
         
                hijo = new Nodo(camino, estadoT.siguienteEstado(estadoTemp, nodotemporal.getEstado().getPosicionActual(),2), Qbo,nodotemporal, pro);
                
                
                  if(hijo.getPadre().getPadre()!=null){  
                        
                        if((hijo.getPadre().getPadre().getEstado().getPosicionActual().equals( hijo.getEstado().getPosicionActual()))){
                            
                               if(hijo.getRuta().equals(hijo.getPadre().getPadre().getRuta())){
                                
                                ///nada
                               }else{
                                   hijos.add(hijo);
                               
                               } 
                            }else{
                              hijos.add(hijo);
                            }
                      }else{
                        hijos.add(hijo);
                      
                      }

          }  
        }
        profundidad++;
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
    
    public double AplicarHeristica(Nodo nodo){
    
        
     int matriz[][]=nodo.getEstado().getAmbiente().clone();
     Point posicionActual=nodo.getEstado().getPosicionActual();
     double distanciaA3k=0.0, distanciaA2k=0.0, distanciaP=0.0, distancia3kP=0.0;
     Point dosk = new  Point();
     Point tresk = new  Point();
     Point Pr = new  Point();
     double h3k=0.0, h2k=0.0;
     
     //Funcion para ubicar los costos
     for(int i=0;i<10;i++){
       for(int j=0;j<10;j++){
         if(matriz[i][j]==2){
           dosk.x=i;
           dosk.y=j;
         }if(matriz[i][j]==3){
           tresk.x=i;
           tresk.y=j;
         }if(matriz[i][j]==5){
           Pr.x=i;
           Pr.y=j;
         
         } 
     
       }
     }
         
                  distanciaA2k=Math.abs(posicionActual.y-dosk.x)+Math.abs(posicionActual.x-dosk.y);            
                  distanciaA3k=Math.abs(posicionActual.x-tresk.y)+Math.abs(posicionActual.y-tresk.x);
                  
                  distanciaP=Math.abs(dosk.y-Pr.y)+Math.abs(dosk.x-Pr.x);
                  distancia3kP=Math.abs(tresk.y-Pr.y)+Math.abs(tresk.x-Pr.x);     
                  
                  h3k=distancia3kP+distanciaA3k; 
                  h2k=distanciaA2k+distanciaP; 
    if(h2k>h3k ){
    return h3k;    
    }else{
    return h2k;
    }              
                  
                  
                   
    
    }
    
    public double hnueva(Nodo n){
            double h1=0.0;
            double hfin=0;
            Point p = n.getEstado().getPosicionActual();
            int x=p.x;
            int y=p.y;
            h1= (x+y )-1;
            int con=0;
            Nodo padre=n.getPadre();
           while(padre!=null){

                 padre=padre.getPadre();
                 con++;
           }

           hfin=h1+con;


            return  hfin;
        }
    
    
    
    
    public abstract Nodo ejecutar ();
}
