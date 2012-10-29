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
 public  class Estado {
    
     
    public Estado(){
    }
    
    public EstadoActual siguienteEstado(EstadoActual estadoUpdate, Point p, int movimiento)
    {
        int matris[][]=estadoUpdate.getAmbiente();
        int costo=estadoUpdate.getCosto();
        int pesoBasura=estadoUpdate.getPesoBasura();
        boolean dep1cargado=estadoUpdate.isDep1cargado();
        boolean dep2cargado=estadoUpdate.isDep2cargado();
        boolean dep2kR=estadoUpdate.isDep2KR();
        boolean dep3kR=estadoUpdate.isDep3KR();
        boolean cambiarEstado=estadoUpdate.isCambiarEstado();
        
        Point posicionNueva = new Point();
        int x=p.x;
        int y=p.y;

        int basurAcumulada=estadoUpdate.getBasuraAcumulada();
        switch(movimiento)
        { 
            case 1://buscando abajo
               
         //             if((matris[p.y+1][ p.x ]==2)||(matris[p.y+1][ p.x ]==3)||(matris[p.y+1][ p.x ]==5)){
                    if(matris[p.y+1][ p.x ]==4){
                       if(dep1cargado){
                       costo=costo+2;
                     }else if(dep2cargado){
                        costo=costo+3;
                     }else{
                       costo=costo+1;
                     }
                   }    
                
                   if(matris[p.y+1][ p.x ]==0){
                    if(dep1cargado){
                       costo=costo+2;
                     }else if(dep2cargado){
                        costo=costo+3;
                     }else{
                       costo=costo+1;
                     }
                   }
                   
                    if((matris[p.y+1][ p.x ]==2)){
//                        matris[p.y+1][ p.x ]=0;
                        dep1cargado=true;
                        pesoBasura=pesoBasura+2; 
                        basurAcumulada=basurAcumulada+2;
                        costo=costo+2;
                        cambiarEstado=true;
                    }else if(matris[p.y+1][ p.x ]==3){
                        //matris[p.y+1][ p.x ]=0;
                        dep2cargado=true;
                        pesoBasura=pesoBasura+3;
                        basurAcumulada=basurAcumulada+3;
                        costo=costo+3; 
                        cambiarEstado=true;
                    }else if(matris[p.y+1][ p.x ]==5){
                       
                        basurAcumulada=basurAcumulada+pesoBasura;
                        pesoBasura=0;    
                        cambiarEstado=true;
                        if(dep1cargado){
                           dep2kR=true; 
                           //costo=costo-2;
                        }if(dep2cargado){
                          dep3kR=true;
                          //costo=costo-3;
                        }else{
                        
                          costo=costo+1;
                        }
                        
                    }
               //  }  
//                    matris[p.x][p.y]=0;
//                    matris[p.x][p.y+1]=4;
                   
                   // costo++;
                    posicionNueva.x=p.x;
                    posicionNueva.y=p.y+1;
//                    System.out.println("posicion nueva para abajo: "+posicionNueva+"  "+matris[posicionNueva.x][posicionNueva.y]);
                    break;
            case 2:  //buscando arriba
                 // if((matris[ p.y-1 ][ p.x ]==2)||(matris[ p.y-1 ][ p.x ]==3)||(matris[ p.y-1 ][ p.x ]==5)){
                   if(matris[ p.y-1 ][ p.x ]==4){
                    if(dep1cargado){
                       costo=costo+2;
                     }else if(dep2cargado){
                        costo=costo+3;
                     }else{
                       costo=costo+1;
                     }
                   }
                  if(matris[ p.y-1 ][ p.x ]==0){
                    if(dep1cargado){
                        costo=costo+2;
                      }else if(dep2cargado){
                         costo=costo+3;
                      }else{
                        costo=costo+1;
                     }
                  
                  }
                  if(matris[ p.y-1 ][ p.x ]==2){
                       basurAcumulada=basurAcumulada+2;
//                       matris[ p.y-1 ][ p.x ]=0;
                       dep1cargado=true;
                         costo=costo+2;
                         cambiarEstado=true;
                    }if(matris[ p.y-1 ][ p.x ]==3){
                        pesoBasura=pesoBasura+3;
                        basurAcumulada=basurAcumulada+3;
                        dep2cargado=true;
                        cambiarEstado=true;
                        //matris[ p.y-1 ][ p.x ]=0;
                        costo=costo+3;
                    }if(matris[ p.y-1 ][ p.x ]==5){
                       basurAcumulada=basurAcumulada+pesoBasura;
                        pesoBasura=0;
                        cambiarEstado=true;
                         if(dep1cargado){
                           dep2kR=true;
                          // costo=costo-2;
                        }if(dep2cargado){
                          dep3kR=true;
                          //costo=costo-3;
                        }else{
                        
                          costo=costo+1;
                        }
                    }
              //  } 
//                  matris[p.x][p.y]=0;
//                  matris[p.x][p.y-1]=4;
                
                  posicionNueva.x=p.x;
                  posicionNueva.y=p.y-1;
//                  System.out.println("posicion nueva para arriba: "+posicionNueva+"  "+matris[posicionNueva.x][posicionNueva.y]);
                   break;
            case 3://buscando a la derecha, se inicializa la nueva posicion 
                  
              //  if((matris[p.y][p.x+1]==2)||(matris[p.y][p.x+1]==3)||(matris[p.y][p.x+1]==5) ){
                     if(matris[p.y][p.x+1]==4){
                    if(dep1cargado){
                       costo=costo+2;
                     }else if(dep2cargado){
                        costo=costo+3;
                     }else{
                       costo=costo+1;
                     }
                   }
                 
                  if(matris[p.y][p.x+1]==0){
                        if(dep1cargado){
                          costo=costo+2;
                        }else if(dep2cargado){
                           costo=costo+3;
                        }else{
                          costo=costo+1;
                        }
                              
                    } 
                    if(matris[p.y][p.x+1]==2){
                      cambiarEstado=true;  
                      pesoBasura=pesoBasura+2;
                      basurAcumulada=basurAcumulada+2;
//                    matris[p.y][p.x+1]=0;
                      dep1cargado=true;
                      costo=costo+2;
                    } if(matris[p.y][p.x+1]==3){
                      pesoBasura=pesoBasura+3;
                      basurAcumulada=basurAcumulada+3;                              
//                      matris[p.y][p.x+1]=0;
                      dep2cargado=true;
                      cambiarEstado=true;
                      costo=costo+3;
                    } if(matris[p.y][p.x+1]==5){
                      cambiarEstado=true;
                        basurAcumulada=basurAcumulada+pesoBasura;  
                        pesoBasura=0;
                         if(dep1cargado){
                           dep2kR=true; 
                          // costo=costo-2;
                        }if(dep2cargado){
                          dep3kR=true;
                         // costo=costo-3;
                        }else{
                        
                          costo=costo+1;
                        }
                    }                    
                 // }
//                   matris[p.x][p.y]=0;    
//                   matris[p.x+1][p.y]=4;
                    
                   
                
                    posicionNueva.x=p.x+1;
                    posicionNueva.y=p.y;
                    
//                    System.out.println("posicion nueva para derecha: "+posicionNueva+"  "+matris[posicionNueva.x][posicionNueva.y]);
                  break;
                
            case 4: //buscando a la izquierda,  y se inicializa la nueva posicion y estado.
              
               // if((matris[ p.x - 1 ][ p.y ]==2)||(matris[ p.x - 1 ][ p.y ]==3)||(matris[ p.x - 1 ][ p.y ]==5)){
                   int encontre=matris[p.x-1][p.y];
                  if(matris[p.y][p.x-1]==4){
                   
                  if(dep1cargado){
                       costo=costo+2;
                     }else if(dep2cargado){
                        costo=costo+3;
                     }else{
                       costo=costo+1;
                     }
                   }
                
                if(matris[p.y][p.x-1]==0){
                     if(dep1cargado){
                       costo=costo+2;
                     }else if(dep2cargado){
                        costo=costo+3;
                     }else{
                       costo=costo+1;
                     }
                }
                  if(matris[p.y][p.x-1]==2){
                  basurAcumulada=basurAcumulada+2;
                      pesoBasura=pesoBasura+2;
                      //matris[p.x-1][p.y]=0;
                      dep1cargado=true;
                      cambiarEstado=true;
                      costo=costo+2;
                  }else if(matris[p.y][p.x-1]==3){
                      basurAcumulada=basurAcumulada+3;
                      pesoBasura=pesoBasura+3;
                      //matris[p.x-1][p.y]=0;
                      dep2cargado=true;
                      cambiarEstado=true;
                      costo=costo+3;
                  }else if(matris[p.y][p.x-1]==5){
                      basurAcumulada=basurAcumulada+pesoBasura;
                      pesoBasura=0;
                      cambiarEstado=true;
                       if(dep1cargado){
                           dep2kR=true;
                          // costo=costo-2;
                        }if(dep2cargado){
                          dep3kR=true;
                         // costo=costo-3;
                        }else{
                        
                          costo=costo+1;
                        }
                  }
            
               //  }
//                matris[p.x][p.y]=0;
//                matris[p.x-1][p.y]=4;
               
                posicionNueva.x=p.x-1;
                posicionNueva.y=p.y;
//                System.out.println("posicion nueva para izquierda: "+posicionNueva+"  "+matris[posicionNueva.x][posicionNueva.y]);
                break;       
        }

                EstadoActual es= new EstadoActual(matris, costo, pesoBasura, posicionNueva,
                                                  basurAcumulada,dep1cargado, dep2cargado,dep2kR, dep3kR,cambiarEstado );
        return es ;
    }
}
