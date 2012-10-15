/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author palacioscuacialpud
 */
public class NodoyEstado {
    private String ruta ="";
    private double costo; // Costo  busquedas NO informadas
    private double costoEstimado; // Costo para implementar en las busquedas Informadas
    private String operador;   
    private int basura;    
    private int x,y;
    private int ambiente[][];
    public NodoyEstado(String ruta, double costo, String operador, int basura, int x, int y, int ambiente[][]){
    
        this.ruta=ruta;
        this.costo=costo;
        this.costoEstimado=costoEstimado;
        this.operador=operador;
        this.basura=basura;
        this.x=x;
        this.y=y;
    }
    
    
    /**
     * @return the ruta
     */
    public String getRuta() {
        return ruta;
    }

    /**
     * @param ruta the ruta to set
     */
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    /**
     * @return the costo
     */
    public double getCosto() {
        return costo;
    }

    /**
     * @param costo the costo to set
     */
    public void setCosto(double costo) {
        this.costo = costo;
    }

    /**
     * @return the costoEstimado
     */
    public double getCostoEstimado() {
        return costoEstimado;
    }

    /**
     * @param costoEstimado the costoEstimado to set
     */
    public void setCostoEstimado(double costoEstimado) {
        this.costoEstimado = costoEstimado;
    }

    /**
     * @return the operador
     */
    public String getOperador() {
        return operador;
    }

    /**
     * @param operador the operador to set
     */
    public void setOperador(String operador) {
        this.operador = operador;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }
    
     public NodoyEstado copia()
    {
        NodoyEstado nodo=new NodoyEstado(ruta, costo, operador, basura, x, y,ambiente);
        return nodo;
    }
}
