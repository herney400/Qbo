/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controlador;

import dao.CargarMundo;
import gui.GuiDustCart;

/**
 *
 * @author Franjav
 */
public class ControladorGuiDustCart {
    
    private String title;
    private GuiDustCart guiDustCart;
    private CargarMundo load;
    
    public ControladorGuiDustCart(){
        guiDustCart = new GuiDustCart();
        guiDustCart.setControlador( this );
        title = "DustCart";
    }    
    
    /**
      * Retorna el titulo o nombre de la gui
      * @return el titulo de la gui
      */
     public String getTitle() {
        return this.title;
     }
     
     /**
      * Retorna la gui creada de un programa
      * @return La gui del programa
      */
     public GuiDustCart getGui() {
        return this.guiDustCart;
     }

    public void cargarMundo() {
        load = new CargarMundo();
        load.seleccionarArchivo();
    }
    
    public void setImagenMundo(){
       guiDustCart.setImagenMundoGui( load.getMundo() ); 
    }

    void seleccionarRobot(boolean isDustCart, boolean isR2D2) {
        guiDustCart.setIsDustCart(isDustCart);
        guiDustCart.setIsR2D2(isR2D2);
    }
     

    
}
