/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Point;

/**
 *
 * @author fidelhpc
 */
public class Estado {
    
     
    public Estado(){
    
    
    
    }
    
    public static EstadoActual siguienteEstado( EstadoActual estadoUpdate, Point p){
        int matris[][]=estadoUpdate.getAmbiente();
        int costo=estadoUpdate.getCosto();
        int pesoBasura=estadoUpdate.getPesoBasura();
        
        
        //return new EstadoActual ;
        
        
        
    }
}
