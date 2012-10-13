/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author fidelhpc
 */
public class Amplitud extends Expandir{
    private Nodo nodoRaiz;
    int mundo[][];
//    private final Nodo raiznodo;
    
    public  Amplitud(Nodo raiz,Point p, int mundoOriginal[][]){
         super();
         this.mundo=mundoOriginal.clone();
         this.nodoRaiz=raiz;
         
    }
    
    

    public Nodo ejecutar() {
        listaNodos.add(nodoRaiz);
        
        while(!(listaNodos.isEmpty())){
             
             Nodo nodoActual=listaNodos.get(0);
             if(esMeta(nodoActual)){
                 return nodoActual;
             }else{
                listaNodos.remove(0);
                ArrayList<Nodo> hijos = expandirNodo(nodoRaiz);
                listaNodos.addAll(hijos);
             }
            
            
        }
        
        
        return null;
    }
    public boolean esMeta(Nodo nodo){
    
       
        
        return true;
    }
    
    
}
