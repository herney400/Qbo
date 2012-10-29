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
        
        if(ambiente!=null)
        {
            for(int idy=0;idy<10;idy++)
            {
                System.arraycopy(ambiente[idy], 0, this.mapa[idy], 0, 10);
            }
        }else
        {
            System.err.println("error");
        }
    }
    
    
    public  Expandir iniciarnoInformada(String tipo){
    
        Expandir expandir=null;
        if(tipo.equals("Amplitud")){
            expandir= new Amplitud(nodoRaiz.clone(),pInicial,mapa);
        }else if(tipo.equals("Costo"))
        {
             expandir= new Costo(nodoRaiz.clone(),pInicial,mapa); 
        }else if(tipo.equals("Profundidad") )
        {
            expandir= new Profundidad(nodoRaiz.clone(),pInicial,mapa); 
        
        }else if(tipo.equals("Avara")){
//            nodoRaiz.clone().setHeuristica(1000);
             expandir= new Avara(nodoRaiz.clone(),pInicial,mapa); 
        }else if(tipo.equals("A")){ 
               expandir= new Aestrella(nodoRaiz.clone(),pInicial,mapa); 
        }
        return expandir;
    } 
}
