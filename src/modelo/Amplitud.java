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
             nodosBorrados.add(nodoActual);  
             int tam=nodosBorrados.size();
             if(esMeta(nodoActual)){
                 System.out.println("hasta aqui");
                 return nodoActual;
                 
             }else{
                 System.out.println("hasta aqui en  el else");
                listaNodos.remove(0);
                ArrayList<Nodo> hijos = expandirNodo(nodoActual);
                listaNodos.addAll(hijos);
             }
        }
        return null;
    }
    
    public boolean esMeta(Nodo nodo){
    
       if(nodo.getEstado().getBasuraAcumulada()==5){
           return true; 
       }
       return false;
    }
}
