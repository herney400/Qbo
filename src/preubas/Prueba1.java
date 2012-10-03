/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package preubas;

import java.awt.Point;
import modelo.Sensor;

/**
 *
 * @author Franjav
 */
public class Prueba1 {
    
     private Sensor sens;
     private int[][] mundo;
    
    public Prueba1(){
        mundo = new int[12][12];
        sens = new Sensor(new Point(4,0));    
        
    }
    
    
    
    
     public void pruebaAsignarMundo(){ 
         int k=0;
         //System.out.println(">>>"+mundo.length);
        for(int i=0; i<mundo.length; i++){
            for(int j=0; j<mundo[i].length; j++){
                mundo[i][j] = k;
                k++;
            }
        } 
       sens.setMundo(mundo);
        
        
     }
     
     public void printWorld(){
         sens.imprimirMundo();
     }
     
     public int arriba(){
         return sens.buscarArriba(new Point(4,1));
     }
     
     public int derecha(){
         return sens.buscarDerecha(new Point(4,1));
     }
       
     public int abajo(){
         return sens.buscarAbajo(new Point(4,1));
     }
     
      public int izquierda(){
         return sens.buscarIzquierda(new Point(4,1));
     }
       
    
}
