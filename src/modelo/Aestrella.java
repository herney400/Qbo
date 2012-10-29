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
public class Aestrella extends Expandir{
    int nodoexpandidos=0,profundidadAr;
    PriorityQueue<Nodo> colaPrioridad=new PriorityQueue(100,new CompaAestrella());
      private Nodo padre;
      private Nodo nodoRaiz;
      int mundo[][];
      protected ArrayList<Nodo> caminos; 
      ComparadorNodo comparador;
    public  Aestrella(Nodo raiz,Point p, int mundoOriginal[][]){
         super();
         this.mundo=mundoOriginal.clone();
         this.nodoRaiz=raiz;  
//         comparador=new ComparadorNodo();
       
    }
    
    
    
    
    
    @Override
    public Nodo ejecutar() {
       double h;
        
        colaPrioridad.add(nodoRaiz);
         Nodo nx = null;
        while(!colaPrioridad.isEmpty())
        {
            Nodo nodoActual, nodoTmp;
            nodoActual= colaPrioridad.poll();
             

            if (esMeta(nodoActual)) {
                JOptionPane.showMessageDialog(null, "nodos expandidos"+nodoexpandidos+"profundidad"+profundidad);
                solucion(nodoActual);
                 int t=colaPrioridad.size();
                  while(!colaPrioridad.isEmpty()){
                   nx=colaPrioridad.poll();
                  
                  }
                  double ht=nx.getHeuristica();
                
                
                return nodoActual;
            }
            else
            {         nodoexpandidos++;
                ArrayList<Nodo> nodosHijos= expandirNodo(nodoActual);
//                System.out.println("exp===>"+nodoActual.getEstado().getPosicionActual());
                
                
                for(int x=0; x<nodosHijos.size(); x++)
                {
                    nodoTmp = nodosHijos.get(x);
                    //dependiendo de la heuristica a aplicar asigno h
                    
                    h= AplicarHeristica(nodoTmp);
                    
                    nodoTmp.setHeuristica(h);
                    colaPrioridad.add(nodoTmp);
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
