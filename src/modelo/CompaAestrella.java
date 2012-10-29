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
public class CompaAestrella extends Expandir implements Comparator<Nodo> {

    @Override
    public Nodo ejecutar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int compare(Nodo t, Nodo t1) {
      
        double h1=t.getHeuristica()+t.getEstado().getCosto();
        double h2=t1.getHeuristica()+t1.getEstado().getCosto();
       return  (((Double) h1).compareTo(h2));
        
    }
    
}
