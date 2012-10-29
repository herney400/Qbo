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
public class Costo extends Expandir{
       int nodoexpandidos=0;
      Nodo raiz;
      PriorityQueue<Nodo> colaPrioridad;
      ComparadorNodo compaEstado;
      protected ArrayList<Nodo> caminos;
    public Costo(Nodo raiz,Point p, int mundoOriginal[][]){
         super();
         this.mapa=mundoOriginal.clone();
         this.raiz=raiz;
         compaEstado =new ComparadorNodo();
         colaPrioridad=new PriorityQueue(1, compaEstado);
         
    } 
    
    
    @Override
    public Nodo ejecutar() {
        colaPrioridad.add(raiz);
        
        while(!colaPrioridad.isEmpty()){
           Nodo nodoactual;
           nodoactual=colaPrioridad.poll();
           
           if(esMeta(nodoactual)){
           JOptionPane.showMessageDialog(null, "nodos expandidos"+nodoexpandidos+"profundidad"+profundidad);
            solucion(nodoactual);
             return nodoactual;
           }else{
           
            ArrayList<Nodo> hijos = expandirNodo(nodoactual);           
            nodoexpandidos++;   
            
            for(int i=0; i<hijos.size(); i++)
                 {                    
                   colaPrioridad.add(hijos.get(i));
                 }           
             }
           
                   
        
        }
        return null;
    }
      
    public boolean esMeta(Nodo nodo){
    
       if((nodo.getEstado().isDep2KR()==true)&&(nodo.getEstado().isDep3KR()==true)){
           return true; 
       }
       return false;
    }
     public void solucion(Nodo nodometa){
    
//       caminos =new Vector();
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
