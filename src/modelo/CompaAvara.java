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
public class CompaAvara extends Expandir implements Comparator<Nodo> {

    @Override
    public int compare(Nodo t, Nodo t1) {
        return ((Double) (t.getHeuristica())).compareTo(t1.getHeuristica());
    }

    @Override
    public Nodo ejecutar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
