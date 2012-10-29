/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Comparator;

/**
 *
 * @author palacioscuacialpud
 */
public class ComparadorNodo implements Comparator<Nodo> {
    
   

    @Override
    public int compare(Nodo t, Nodo t1) {
       
        if(t.getEstado().getCosto()==t1.getEstado().getCosto()){
          return 0;
        
        }else if(t.getEstado().getCosto()>t1.getEstado().getCosto()){
        
          return 1;
        }else if(t.getEstado().getCosto()<t1.getEstado().getCosto()){
          return -1;        
        }           
        return 3;
    }
    
    
}
