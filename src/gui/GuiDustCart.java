/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.CargarMundo;
import gui.controlador.ControladorGuiDustCart;
import java.awt.Point;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.CrearBusqueda;
import modelo.EstadoActual;
import modelo.Expandir;
import modelo.Nodo;
import modelo.Profundidad;
import modelo.Robot;


/**
 *
 * @author fidelhpc
 * 
 * 
 * 
 * 
 */
public class GuiDustCart extends javax.swing.JInternalFrame {
    
    private ControladorGuiDustCart controlador;
    private Celda[][] mundo;
    private ImageIcon[] imagenes = new ImageIcon[6];
    private boolean isDustCart;
    private boolean isR2D2;
    
    int widthLabel;
    int heightLabel;
    int xInicial;
    int anchoTablero;
    int yInicial;
    
     /**
     * Creates new form Gui
     */ 
    public GuiDustCart() {
        widthLabel = 50;
        heightLabel = 50;
        isDustCart = true;
        mundo = new Celda[10][10];
        initComponents();
        dibujarMundo();
    }
    
    
    public void setControlador(ControladorGuiDustCart controlador) {
        this.controlador = controlador;
    }
    
   /*
    Otro comentario
    */

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelControles = new javax.swing.JPanel();
        jButtonCargar = new javax.swing.JButton();
        jPanelBusquedas = new javax.swing.JPanel();
        jComboBoxTipoBusqueda = new javax.swing.JComboBox();
        jComboBoxNoinformada = new javax.swing.JComboBox();
        jPanelBotones = new javax.swing.JPanel();
        jButtonEjecutar = new javax.swing.JButton();
        jButtonResetear = new javax.swing.JButton();
        jPanelResultados = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelProfundidad = new javax.swing.JLabel();
        jLabelNodosExpandidos = new javax.swing.JLabel();
        jLabelTiempoComputo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jButtonVerSolucion = new javax.swing.JButton();
        jPanelAmbiente = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanelControles.setBorder(javax.swing.BorderFactory.createTitledBorder("Controles"));

        jButtonCargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/resources/load.png"))); // NOI18N
        jButtonCargar.setText("Cargar Ambiente");
        jButtonCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCargarActionPerformed(evt);
            }
        });

        jPanelBusquedas.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Busquedas"))));

        jComboBoxTipoBusqueda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tipo de búsqueda", "Informada", "No informada" }));
        jComboBoxTipoBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoBusquedaActionPerformed(evt);
            }
        });

        jComboBoxNoinformada.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Amplitud", "Costo", "Profundidad", "Avara", "A" }));

        javax.swing.GroupLayout jPanelBusquedasLayout = new javax.swing.GroupLayout(jPanelBusquedas);
        jPanelBusquedas.setLayout(jPanelBusquedasLayout);
        jPanelBusquedasLayout.setHorizontalGroup(
            jPanelBusquedasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBusquedasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBusquedasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxTipoBusqueda, 0, 208, Short.MAX_VALUE)
                    .addComponent(jComboBoxNoinformada, 0, 146, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelBusquedasLayout.setVerticalGroup(
            jPanelBusquedasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBusquedasLayout.createSequentialGroup()
                .addComponent(jComboBoxTipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBoxNoinformada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jPanelBotones.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jButtonEjecutar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/resources/ejecutar.png"))); // NOI18N
        jButtonEjecutar.setText("Ejecutar");
        jButtonEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEjecutarActionPerformed(evt);
            }
        });

        jButtonResetear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/resources/restart.png"))); // NOI18N
        jButtonResetear.setText("Reiniciar");

        javax.swing.GroupLayout jPanelBotonesLayout = new javax.swing.GroupLayout(jPanelBotones);
        jPanelBotones.setLayout(jPanelBotonesLayout);
        jPanelBotonesLayout.setHorizontalGroup(
            jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonResetear, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                    .addComponent(jButtonEjecutar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelBotonesLayout.setVerticalGroup(
            jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonEjecutar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonResetear)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelResultados.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultados"));

        jLabel1.setText("Profundidad árbol:");

        jLabel2.setText("Tiempo de cómputo:");

        jLabel3.setText("Nodos expandidos:");

        jLabelProfundidad.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabelProfundidad.setForeground(new java.awt.Color(17, 67, 210));
        jLabelProfundidad.setText("0");

        jLabelNodosExpandidos.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabelNodosExpandidos.setForeground(new java.awt.Color(17, 67, 210));
        jLabelNodosExpandidos.setText("0");

        jLabelTiempoComputo.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabelTiempoComputo.setForeground(new java.awt.Color(17, 67, 210));
        jLabelTiempoComputo.setText("0");

        javax.swing.GroupLayout jPanelResultadosLayout = new javax.swing.GroupLayout(jPanelResultados);
        jPanelResultados.setLayout(jPanelResultadosLayout);
        jPanelResultadosLayout.setHorizontalGroup(
            jPanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelResultadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(jLabelProfundidad, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelResultadosLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addComponent(jLabelNodosExpandidos))
                    .addGroup(jPanelResultadosLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addComponent(jLabelTiempoComputo)))
                .addContainerGap())
        );
        jPanelResultadosLayout.setVerticalGroup(
            jPanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelResultadosLayout.createSequentialGroup()
                .addGroup(jPanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelResultadosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanelResultadosLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabelProfundidad)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelResultadosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addGroup(jPanelResultadosLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabelNodosExpandidos)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelResultadosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addGroup(jPanelResultadosLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabelTiempoComputo))))
        );

        jButtonVerSolucion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/resources/android.png"))); // NOI18N
        jButtonVerSolucion.setText("Ver Solución");
        jButtonVerSolucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerSolucionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelControlesLayout = new javax.swing.GroupLayout(jPanelControles);
        jPanelControles.setLayout(jPanelControlesLayout);
        jPanelControlesLayout.setHorizontalGroup(
            jPanelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelControlesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonVerSolucion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                    .addComponent(jPanelBusquedas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelResultados, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelBotones, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonCargar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelControlesLayout.setVerticalGroup(
            jPanelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelControlesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonCargar)
                .addGap(11, 11, 11)
                .addComponent(jPanelBusquedas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jPanelResultados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonVerSolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        jPanelAmbiente.setBorder(javax.swing.BorderFactory.createTitledBorder("Ambiente"));
        jPanelAmbiente.setLayout(new java.awt.GridLayout(10, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelControles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelAmbiente, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelAmbiente, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
                    .addComponent(jPanelControles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCargarActionPerformed

        controlador.cargarMundo();
        cargarImagenes();
        controlador.setImagenMundo();
        
        int m[][]=controlador.getMundo();
        Point p=controlador.getpInicio();
        
        EstadoActual esta= new EstadoActual(m, 0, 0, p, 0,false ,false,false, false,false);
        Robot Qbo=new Robot(m, p);
        Nodo raiz= new Nodo("", esta, Qbo, null,0);
        crearbusqueda=new CrearBusqueda(raiz, p, m);  
        
    }//GEN-LAST:event_jButtonCargarActionPerformed

    private void jButtonEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEjecutarActionPerformed
       String  selec=(String) jComboBoxNoinformada.getSelectedItem();
        Expandir expandir=null;
        expandir=crearbusqueda.iniciarnoInformada(selec);
        if(expandir!=null){
            long tiempoinicio=System.currentTimeMillis();
            Nodo respuesta=expandir.ejecutar();
            long tiempo=System.currentTimeMillis()-tiempoinicio;
        }  
    }//GEN-LAST:event_jButtonEjecutarActionPerformed

    private void jComboBoxTipoBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxTipoBusquedaActionPerformed

    private void jButtonVerSolucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerSolucionActionPerformed
    Profundidad p=new Profundidad();
      pintarSolucion(p.solucion());
    }//GEN-LAST:event_jButtonVerSolucionActionPerformed

   private void dibujarMundo(){
        for(int i = 0; i < 10; i++ ){
            for(int j = 0; j < 10; j++ ){
                mundo[i][j] = new Celda();
    		mundo[i][j].setSize( 60, 60 );
    		mundo[i][j].setBorder( BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED) );
    		jPanelAmbiente.add( mundo[i][j] );
            }//for j
        }//for i          
    }
    
   
    public void cargarImagenes(){
        imagenes[0] = null;
        imagenes[1] = new ImageIcon("./images/muro.png");
        imagenes[2] = new ImageIcon("./images/deposito_2k.png");
        imagenes[3] = new ImageIcon("./images/deposito_3k.png");
        if( isDustCart ){ imagenes[4] = new ImageIcon("./images/DustCart.png"); }
        if( isR2D2 ){ imagenes[4] = new ImageIcon("./images/R2D2.png"); }        
        imagenes[5] = new ImageIcon("./images/puntoReciclaje.png");
    }
    
    public void setImagenMundoGui(int [][]mundoTmp ){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                mundo[i][j].setImagen( imagenes[ mundoTmp[i][j] ] );
            }//for j
        }//for i
        repaint();
    }
    
    public void pintarSolucion(Vector solucion){
         for(int i=0;i<solucion.size();i++){
            mundo[ ((Point)solucion.elementAt(i)).x][((Point)solucion.elementAt(i)).y].setImagen(new ImageIcon("./images/R2D2.png"));
           
         
         }
         repaint();
    }

    public void setIsDustCart(boolean isDustCart) {
        this.isDustCart = isDustCart;
    }

    public void setIsR2D2(boolean isR2D2) {
        this.isR2D2 = isR2D2;
    }
    
       
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCargar;
    private javax.swing.JButton jButtonEjecutar;
    private javax.swing.JButton jButtonResetear;
    private javax.swing.JButton jButtonVerSolucion;
    private javax.swing.JComboBox jComboBoxNoinformada;
    private javax.swing.JComboBox jComboBoxTipoBusqueda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelNodosExpandidos;
    private javax.swing.JLabel jLabelProfundidad;
    private javax.swing.JLabel jLabelTiempoComputo;
    private javax.swing.JPanel jPanelAmbiente;
    private javax.swing.JPanel jPanelBotones;
    private javax.swing.JPanel jPanelBusquedas;
    private javax.swing.JPanel jPanelControles;
    private javax.swing.JPanel jPanelResultados;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables

    private  CrearBusqueda crearbusqueda;
}
