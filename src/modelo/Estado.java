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
    
    public EstadoActual siguienteEstado(EstadoActual estadoUpdate, Point p, int movimiento)
    {
        int matris[][]=estadoUpdate.getAmbiente();
        int costo=estadoUpdate.getCosto();
        int pesoBasura=estadoUpdate.getPesoBasura();
        
        Point posicionNueva = new Point();
        int x=p.x;
        int y=p.y;

        int basurAcumulada=estadoUpdate.getBasuraAcumulada();
        switch(movimiento)
        { //buscando abajo
            case 1:
                if((matris[p.x][p.y+1]==2)||(matris[p.x][p.y+1]==3)||(matris[p.x][p.y+1]==5)){
                   
                    if((matris[p.x][p.y+1]==2)){
                        pesoBasura=pesoBasura+2;
                        costo=costo+2;
                    }else if(matris[p.x][p.y+1]==3){
                        pesoBasura=pesoBasura+3;
                        costo=costo+3; 
                    }else if(matris[p.x][p.y+1]==5){
                           basurAcumulada=basurAcumulada+pesoBasura;
                           pesoBasura=0;          
                    }
                 }  
//                    matris[p.x][p.y]=0;
//                    matris[p.x][p.y+1]=4;
                    
                    costo++;
                    posicionNueva.x=p.x;
                    posicionNueva.y=p.y+1;
                    System.out.println("posicion nueva para abajo: "+posicionNueva+"  "+matris[posicionNueva.x][posicionNueva.y]);
                    break;
            case 2:  //buscando arriba
                if((matris[p.x][p.y-1]==2)||(matris[p.x][p.y-1]==3)||(matris[p.x][p.y-1]==5)){
                    if((matris[p.x][p.y-1]==2)){
                        pesoBasura=pesoBasura+2;
                         costo=costo+2;
                    }if(matris[p.x][p.y-1]==3){
                        pesoBasura=pesoBasura+3;
                        costo=costo+3;
                    }if(matris[p.x][p.y-1]==5){
                       basurAcumulada=basurAcumulada+pesoBasura;
                        pesoBasura=0;
                    }
                } 
//                  matris[p.x][p.y]=0;
//                  matris[p.x][p.y-1]=4;
                
                  posicionNueva.x=p.x;
                  posicionNueva.y=p.y-1;
                  System.out.println("posicion nueva para arriba: "+posicionNueva+"  "+matris[posicionNueva.x][posicionNueva.y]);
                   break;
            case 3://buscando a la derecha, se inicializa la nueva posicion 
                if((matris[p.x+1][p.y]==2)||(matris[p.x+1][p.y]==3)||(matris[p.x+1][p.y]==5) ){
                    if(matris[p.x+1][p.y]==2){
                        
                      pesoBasura=pesoBasura+2;
                      costo=costo+2;
                    }else if(matris[p.x+1][p.y]==3){
                      pesoBasura=pesoBasura+3;
                      costo=costo+3;
                    }else if(matris[p.x+1][p.y]==5){
                      basurAcumulada=basurAcumulada+pesoBasura;  
                     pesoBasura=0;
                    }                    
                      }
//                   matris[p.x][p.y]=0;    
//                   matris[p.x+1][p.y]=4;
                    
                    posicionNueva.x=p.x+1;
                    posicionNueva.y=p.y;
                    System.out.println("posicion nueva para derecha: "+posicionNueva+"  "+matris[posicionNueva.x][posicionNueva.y]);
                  break;
                
            case 4: //buscando a la izquierda,  y se inicializa la nueva posicion y estado.
                if((matris[p.x-1][p.y]==2)||(matris[p.x-1][p.y]==3)||(matris[p.x-1][p.y]==5)){
                
                  if(matris[p.x-1][p.y]==2){
                  
                    pesoBasura=pesoBasura+2;
                    costo=costo+2;
                  }else if(matris[p.x-1][p.y]==3){
                    pesoBasura=pesoBasura+3;
                    costo=costo+3;
                  }else if(matris[p.x-1][p.y]==5){
                      basurAcumulada=basurAcumulada+pesoBasura;
                    pesoBasura=0;
                  }
            
                 }
//                matris[p.x][p.y]=0;
//                matris[p.x-1][p.y]=4;
               
                posicionNueva.x=p.x-1;
                posicionNueva.y=p.y;
                System.out.println("posicion nueva para izquierda: "+posicionNueva+"  "+matris[posicionNueva.x][posicionNueva.y]);
                break;        
        }

        EstadoActual es= new EstadoActual(matris, costo, pesoBasura, posicionNueva);
        return es ;
    }
}
