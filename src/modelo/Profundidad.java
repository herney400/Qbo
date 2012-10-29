/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import gui.GuiDustCart;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author palacioscuacialpud
 */
public class Profundidad extends Expandir{
     int nodoexpandidos=0;
      Vector vecotCamino=new Vector();
      private Nodo padre;
      private Nodo nodoRaiz;
      int mundo[][];
      protected ArrayList<Nodo> caminos; 
    //Vector caminos;
    public  Profundidad(Nodo raiz,Point p, int mundoOriginal[][]){
         super();
         this.mundo=mundoOriginal.clone();
         this.nodoRaiz=raiz;    
      
         
    }
    public Profundidad(){}
      
      
      
      
    @Override
    public Nodo ejecutar() {
      
       //caraga nodo raiz en cola
        listaNodos.add(nodoRaiz);
        //nodo almacenado temporalmente
        Nodo nodoActual;
        //cola de hijos producto de aplicar ops
        ArrayList <Nodo> cola;
        
        NODO:while(!(listaNodos.isEmpty()))
        {
            nodoActual=listaNodos.get(0);
            listaNodos.remove(0);
            //Detecto el nodo como un ciclo y salto si sí es luego verifico meta
            if(nodoCiclo(nodoActual))
            {
                
//                System.out.println("Es Ciclo: "+nodoActual.getOperador());
                continue NODO;
            }
            else if(esMeta(nodoActual)){
            solucion(nodoActual);
            JOptionPane.showMessageDialog(null, "nodos expandidos"+nodoexpandidos+"profundidad"+profundidad);
                return nodoActual;
            }
            //Expando Nodo
            cola=expandirNodo(nodoActual);
            nodoexpandidos++;
            for(int i=0;i<cola.size();i++)
            {
                Nodo temporal=cola.get(i);
                cola.set(i, temporal);
                
            }
            //Armo cola general
            cola.addAll(listaNodos);
            listaNodos=(ArrayList <Nodo>)cola.clone();
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
     
       for(int i=0;i<caminos.size();i++){

      
           vecotCamino.add(caminos.get(i).getEstado().getPosicionActual());
       }
       //solucion(vecotCamino);
    }
    
    public  Vector solucion(){
    
      return vecotCamino;
    }
}
