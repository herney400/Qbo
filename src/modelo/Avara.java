/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Point;
import java.util.ArrayList;
import java.util.PriorityQueue;
import javax.swing.JOptionPane;

/**
 *
 * @author palacioscuacialpud
 */
public class Avara extends Expandir{
    int nodoexpandidos=0;
//    PriorityQueue<Nodo> colaPrioridad;
      private Nodo padre;
      private Nodo nodoRaiz;
      int mundo[][];
      protected ArrayList<Nodo> caminos; 
//      CompaAvara comparador;
       private PriorityQueue<Nodo> colaPrioridad=new PriorityQueue<Nodo>(100,new CompaAvara());
        ArrayList<Nodo> nodosHijos;
    public  Avara(Nodo raiz,Point p, int mundoOriginal[][]){
         super();
         this.mundo=mundoOriginal.clone();
         this.nodoRaiz=raiz;  

      
    }
    
    
    
    
    @Override
    public Nodo ejecutar() {
            double heuristica;

        colaPrioridad.add(nodoRaiz);
        boolean control=true;
      while(control)
        {
            Nodo nodoActual, nodoT;
          
//            colaPrioridad.clear();
            nodoActual= colaPrioridad.poll();
            //Detecto el nodo como un ciclo y salto si sí es luego verifico meta
//            if(nodoCiclo(nodoActual))
//            {
//               
//                continue;
//            }            
////            
//              if(colaPrioridad.isEmpty()){
//                
//               JOptionPane.showMessageDialog(null, "cola vacia");
//              }
//               
//                
////              if(nodoCiclo(nodoActual)){
////                  System.out.print("entro en ciclo");
////                 continue; 
////              }  
//              if(esMeta(nodoActual)){
//                solucion(nodoActual);
//                control=false;
//              }
//                nodosHijos=expandirNodo(nodoActual);
//                System.out.println(nodoActual.getEstado().getPosicionActual()+"  "+nodoActual.getHeuristica());
//                        
//               for(int x=0; x<nodosHijos.size(); x++)
//                    {
//                        nodoT = nodosHijos.get(x);
//                        heuristica = AplicarHeristica(nodoT);                      
//
//                        nodoT.setHeuristica(heuristica);
//                        colaPrioridad.add(nodoT);
//                        
//                    }
//              
            
            if (esMeta(nodoActual)) {
                
                solucion(nodoActual);
                JOptionPane.showMessageDialog(null, "nodos expandidos"+nodoexpandidos+"profundidad"+profundidad);
                 int con=0;
                return nodoActual;
                 }
                else
                {
                    nodoexpandidos++;
                    nodosHijos= expandirNodo(nodoActual);
                    System.out.println(nodoActual.getEstado().getPosicionActual()+"  "+nodoActual.getHeuristica());
//                  
                    
//                    caminos.add(nodoActual);
                    for(int x=0; x<nodosHijos.size(); x++)
                    {
                        nodoT = nodosHijos.get(x);
                        heuristica = AplicarHeristica(nodoT);                      

                        nodoT.setHeuristica(heuristica);
                        colaPrioridad.add(nodoT);
                        
//                    }
                }
        }
     
      
        }   
        return null;
    }
      public boolean nodoCiclo(Nodo hijo) {
    boolean continuar=false;
    
    padre= hijo.getPadre();
    while (padre!=null) {
        
     
      if((hijo.getEstado().getPosicionActual().equals(padre.getEstado().getPosicionActual()))&&
              (hijo.getRuta().equals(padre.getRuta()))){
        continuar=true;
   
      }
         
      
        padre=padre.getPadre();
    }

    return continuar;
   }
    public boolean esMeta(Nodo nodo){
    
       if((nodo.getEstado().isDep2KR()==true)&&(nodo.getEstado().isDep3KR()==true)){
           return true; 
       }
       return false;
    }
     public void solucion(Nodo nodometa){
  
          caminos =new ArrayList<Nodo>();
       Nodo meta=nodometa;
       caminos.add(meta);
       
       while(meta.getPadre()!=null){
          meta=meta.getPadre();
          caminos.add(meta);
       }
      for(int i=0;i<caminos.size();i++){
       System.out.println( "Esto es la ruta"+  caminos.get(i).getEstado().getPosicionActual());
       JOptionPane.showMessageDialog(null, "("+ caminos.get(i).getEstado().getPosicionActual().x +")"+"("+caminos.get(i).getEstado().getPosicionActual().y+")");
      }
       
       
    }
}
