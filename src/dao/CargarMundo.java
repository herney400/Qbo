/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.awt.Point;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Expandir;
import modelo.Nodo;

/**
 * Permite cargar los datos de un archivo de texto con la abstraccion del mundo del 
 * DustCart y almacenar puntos de referencia a emplear en la solución del problema.
 * @author Franjav
 */
public class CargarMundo extends JFrame {
    private Nodo nodo;
    Expandir expandir;
    private Point pInicio;
    private Point pReciclaje;
    private Point pDeposito2k;
    private Point pDeposito3k;
    private int[][] mundo= new int[10][10];;
    private boolean mundoCargado;
    private int peso=0;
    private String inicio=" ";
    private int costoruta=0;
    private int profundidad=0;
    
    /**
     * Cargar los datos para el mundo del DustCart
     */
    public CargarMundo(){
        this.pInicio = new Point();
        this.pReciclaje = new Point();
        this.pDeposito2k = new Point();
        this.pDeposito3k = new Point();      
        mundoCargado = false;
    }
    
    /**
     * Permite seleccionar el archivo de texto que será cargado
     */
    public void seleccionarArchivo(){
        JFileChooser selectorArchivo = new JFileChooser( "./tests/" );
        //selectorArchivo.setFileSelectionMode( JFileChooser.FILES_ONLY );
        int resultado = selectorArchivo.showOpenDialog( this );
        
        //Si el usuario hizo clic en boton Cancelar del cuadro de diálogo, regresar
        if( resultado == JFileChooser.CANCEL_OPTION ){
            return;
        }
        
        if( resultado == JFileChooser.APPROVE_OPTION ){
            File fichero = selectorArchivo.getSelectedFile();
            System.out.println( fichero.getAbsolutePath() );
            leerArchivo( fichero.getAbsolutePath() );
        }
    }//seleccionarArchivo()
    
    /**
     * Carga los datos almacenados en un archivo de texto, los cuales representan 
     * el mundo del DustCart.
     * @param nombreArchivo 
     */
    public void leerArchivo( String nombreArchivo ){
        //crear el archivo de entrada y el scanner
    	Scanner entrada = null;
    	File archivo;    	
    	try{
            archivo = new File(nombreArchivo);
	    entrada = new Scanner( new FileReader( archivo ) );
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "El archivo no existe", "Error al abrir archivo", JOptionPane.ERROR_MESSAGE );
            return;
        }
        
        //Leer el archivo y cargar la abstraccion del ambiente
	for( int i = 0; i < 10; i++ ){
            for(int j = 0; j < 10; j++ ){
                try{
                    //Se cargan los datos del archivo a array que representa el ambiente
                    mundo[i][j] = entrada.nextInt();
                    //Se establecen puntos de referencia en el ambiente
                    switch( mundo[i][j] ){
                        case 2:
                            pDeposito2k.setLocation( j, i );
                            break;
                        case 3:
                            pDeposito3k.setLocation( j, i );
                            break;
                        case 4:
                            pInicio.setLocation( j, i );
                            break;
                        case 5:
                            pReciclaje.setLocation( j, i );
                            break;
                    }//switch

                }catch( Exception e ){}
                System.out.print(mundo[i][j]+ " ");
            }//for
            System.out.print("\n");
            mundoCargado = true;
        }//for		
    }//fin leerArchivo()
    
    /**
     * Permite conocer si el mundo del DustCart se ha cargado previamente
     * @return true si fue cargado, false en caso contrario
     */
    public boolean mundoFueCargado(){
        return this.mundoCargado;
    }

    public int[][] getMundo() {
        return this.mundo;
    }

    public Point getpDeposito2k() {
        return this.pDeposito2k;
    }

    public Point getpDeposito3k() {
        return this.pDeposito3k;
    }

    public Point getpInicio() {
        return this.pInicio;
    }

    public Point getpReciclaje() {
        return this.pReciclaje;
    }
    
    
    public void imprimirDatos(){
        System.out.println("Inicio > "+pInicio.toString() );
        System.out.println("P Reciclaje > "+pReciclaje.toString() );
        System.out.println("Deposito 2k > "+pDeposito2k.toString() );
        System.out.println("Deposito 3k > "+pDeposito3k.toString() );
         
    } 
}
