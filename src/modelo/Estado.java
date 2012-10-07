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
    
    public static EstadoActual siguienteEstado( EstadoActual estadoUpdate, Point p, int movimiento){
      
         
        int matris[][]=estadoUpdate.getAmbiente();
        int costo=estadoUpdate.getCosto();
        int pesoBasura=estadoUpdate.getPesoBasura();
        Point posicionNueva = p;
     
        switch(movimiento){
            case 1:
                if((matris[p.x+1][p.y]==2)||(matris[p.x+1][p.y]==3)||(matris[p.x+1][p.y]==5)){
                   
                    if((matris[p.x+1][p.y]==2)){
                        pesoBasura=pesoBasura+2;
                        costo=costo+2;
                    }if(matris[p.x+1][p.y]==3){
                        pesoBasura=pesoBasura+3;
                        costo=costo+3; 
                    }if(matris[p.x+1][p.y]==5){
                        pesoBasura=0;                    
                    }
                 } 
                    matris[p.x+1][p.y]=4;
                    matris[p.x][p.y]=0;
                    costo++;
                    posicionNueva.x=p.x+1;
                    posicionNueva.y=p.y;        

            case 2:
                if((matris[p.x-1][p.y]==2)||(matris[p.x-1][p.y]==3)||(matris[p.x-1][p.y]==5)){
                    if((matris[p.x-1][p.y]==2)){
                        pesoBasura=pesoBasura+2;
                         costo=costo+2;
                    }if(matris[p.x-1][p.y]==3){
                        pesoBasura=pesoBasura+3;
                        costo=costo+3;
                    }if(matris[p.x-1][p.y]==5){
                        pesoBasura=0;
                    }
                } 
                  matris[p.x-1][p.y]=4;
                  matris[p.x][p.y]=0;
                  posicionNueva.x=p.x-1;
                  posicionNueva.x=p.y;
                
            case 3://buscando a la derecha, se inicializa la nueva posicion 
                if((matris[p.x][p.y+1]==2)||(matris[p.x][p.y+1]==3)||(matris[p.x][p.y+1]==5) ){
                    if(matris[p.x][p.y+1]==2){
                      pesoBasura=pesoBasura+2;
                      costo=costo+2;
                    }if(matris[p.x][p.y+1]==3){
                      pesoBasura=pesoBasura+3;
                      costo=costo+3;
                    }if(matris[p.x][p.y+1]==5){
                     pesoBasura=0;
                    }                    
                      }
                    matris[p.x][p.y+1]=4;
                    matris[p.x][p.y]=0;
                    posicionNueva.x=p.x;
                    posicionNueva.y=p.y+1;
                
                
            case 4: //buscando a la izquierda, se inicializa la nueva posicion y estado.
                if((matris[p.x][p.y-1]==2)||(matris[p.x][p.y-1]==3)||(matris[p.x][p.y-1]==5)){
                
                  if(matris[p.x][p.y-1]==2){
                  
                    pesoBasura=pesoBasura+2;
                    costo=costo+2;
                  }if(matris[p.x][p.y-1]==3){
                    pesoBasura=pesoBasura+3;
                    costo=costo+3;
                  }if(matris[p.x][p.y-1]==5){
                    pesoBasura=0;
                  }
            
                 }
                matris[p.x][p.y-1]=4;
                matris[p.x][p.y]=0;
                posicionNueva.x=p.x;
                posicionNueva.y=p.y;
                
        }
        
      
        
            EstadoActual es= new EstadoActual(matris, costo, pesoBasura, posicionNueva);
            return es ;
        
        
        
    }
}
