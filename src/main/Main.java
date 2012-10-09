/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import gui.GuiPrincipal;
import gui.controlador.ControladorGuiPrincipal;
import java.awt.Point;
import javax.swing.UIManager;
import modelo.Sensor;


/**
 *
 * @author Franjav
 */
public class Main {
    
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) { }
        GuiPrincipal aplicacion = new GuiPrincipal();
        ControladorGuiPrincipal controlador = new ControladorGuiPrincipal();
        aplicacion.setControladorPrincipal(controlador);
        controlador.setGui(aplicacion);
        aplicacion.setVisible(true); 
        
        /**
        Prueba1 pb= new Prueba1();
        pb.pruebaAsignarMundo();
        pb.printWorld();
        System.out.println("= "+pb.arriba());
        System.out.println("-> "+pb.derecha());
        System.out.println("/ "+pb.abajo());
        System.out.println("<- "+pb.izquierda());
        
        */
        
        
        
    }
}




        
        
       