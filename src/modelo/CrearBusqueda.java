/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Point;

/**
 *
 * @author palacioscuacialpud
 */
public class CrearBusqueda {
    private Nodo nodoRaiz;
    private Point pInicial;
    private int [][]mapa;
    
    public CrearBusqueda(Nodo nodoRoot, Point pinicial, int ambiente[][]){
        
        nodoRaiz=nodoRoot;
        pInicial=pinicial;
        mapa =new int[ambiente.length][ambiente.length];
        
        if(ambiente!=null){
        for(int idy=0;idy<10;idy++)
            {
                for(int idx=0;idx<10;idx++)
                {
                    this.mapa[idx][idy]=ambiente[idx][idy];
                }
            }
        
        }else{
        
        System.err.println("error");
        }
    
    }
    
    
    public  Expandir iniciarnoInformada(String tipo){
    
     Expandir expandir=null;
        if(tipo.equals("Amplitud")){
          expandir= new Amplitud(nodoRaiz.clone(),pInicial,mapa   );
        
        }else
        {
        System.out.print("paila");
        }
        
     
     
     return expandir;
    
    }
    
}
