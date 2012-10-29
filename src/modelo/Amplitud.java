/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author fidelhpc
 */
public class Amplitud extends Expandir{
    private Nodo nodoRaiz;
    int mundo[][];
    int nodosexpandido=0;
     protected ArrayList<Nodo> caminos; 
    //Vector caminos;
    public  Amplitud(Nodo raiz,Point p, int mundoOriginal[][]){
         super();
         this.mundo=mundoOriginal.clone();
         this.nodoRaiz=raiz;    
      
         
    }

    @Override
    public Nodo ejecutar() {
        listaNodos.add(nodoRaiz);
       
//        padre=nodoRaiz;
        while(!(listaNodos.isEmpty())){
             
             Nodo nodoActual=listaNodos.get(0);
               if(esMeta(nodoActual)){
//                 System.out.println("hasta aqui");
                 solucion(nodoActual);
                   JOptionPane.showMessageDialog(null, "nodos expandidos"+nodosexpandido+"profundidad"+profundidad);
                 return nodoActual;
                 
             }else{
//                 System.out.println("hasta aqui en  el else");
                listaNodos.remove(0);
                ArrayList<Nodo> hijos = expandirNodo(nodoActual);
                nodosexpandido++;
                listaNodos.addAll(hijos);
             }
             System.out.println("cordenadas"+nodoActual.getEstado().getPosicionActual());
        }
        
        for(int i=0;i<listaNodos.size();i++){
             if(listaNodos.get(i).getProfundidad()==3){
                
               System.out.println(listaNodos.get(i).getEstado().getPosicionActual());
             }
        }
        
        return null;
    }
    
    public boolean nodoCiclo(Nodo hijo) {
    boolean continuar=false;
    
    padre= hijo.getPadre();
    while (padre!=null) {
        
     
      if(hijo.getRuta().equals(padre.getRuta())){
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
       
       
    }
}
