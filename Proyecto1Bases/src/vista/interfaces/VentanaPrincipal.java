/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.interfaces;

import controller.Controller;
import java.sql.ResultSet;
import java.awt.event.WindowEvent;
import Model.expresiones.ExpresionRelacional;

/**
 * @author Kristin
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    //Constructor de la ventana
    public VentanaPrincipal() {
        initComponents();
        //this.setLocation(null); Buscar centrar
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(WindowEvent winEvt) {
                try{
                    Controller.cerrarConexion();
                }catch(Exception e){
                    Controller.mostrarMensaje(null,
                            new Exception("Ocurrión un problema al cerrar la conexion."));
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelOperacion = new javax.swing.JLabel();
        cbOperacion = new javax.swing.JComboBox();
        labelTabla1 = new javax.swing.JLabel();
        tfTabla1 = new javax.swing.JTextField();
        labelPredicado = new javax.swing.JLabel();
        tfPredicado = new javax.swing.JTextField();
        labelTR = new javax.swing.JLabel();
        tfTablaResultante = new javax.swing.JTextField();
        buttonResultado = new javax.swing.JButton();
        buttonCS = new javax.swing.JButton();
        labelTabla2 = new javax.swing.JLabel();
        tfTabla2 = new javax.swing.JTextField();
        checkboxCrearTabla = new javax.swing.JCheckBox();
        buttonMostrarTablas = new javax.swing.JButton();
        buttonVerInfoTabla = new javax.swing.JButton();
        ImagenFondo = new javax.swing.JLabel();
        Menu = new javax.swing.JMenuBar();
        Opciones = new javax.swing.JMenu();
        Acerca_de = new javax.swing.JMenuItem();
        Limpiar_casillas = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Interprete de Algebra Relacional");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(510, 420));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelOperacion.setFont(new java.awt.Font("Vani", 1, 14)); // NOI18N
        labelOperacion.setText("Operacion:");
        getContentPane().add(labelOperacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 84, -1));

        cbOperacion.setFont(new java.awt.Font("Vani", 0, 14)); // NOI18N
        cbOperacion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selección", "Proyección generalizada", "Unión", "Diferencia de conjuntos", "Producto cartesiano", "Intersección", "División", "Renombrar un relación y sus atributos", "Concatenación (join)", "Concatenación natural (natural join)", "Agregación", "Agrupación" }));
        cbOperacion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbOperacionItemStateChanged(evt);
            }
        });
        getContentPane().add(cbOperacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 290, 28));

        labelTabla1.setFont(new java.awt.Font("Vani", 1, 14)); // NOI18N
        labelTabla1.setText("Tabla 1:");
        getContentPane().add(labelTabla1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, -1, -1));

        tfTabla1.setFont(new java.awt.Font("Vani", 0, 12)); // NOI18N
        getContentPane().add(tfTabla1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 188, -1));

        labelPredicado.setFont(new java.awt.Font("Vani", 1, 14)); // NOI18N
        labelPredicado.setText("Predicado:");
        getContentPane().add(labelPredicado, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, -1, -1));

        tfPredicado.setFont(new java.awt.Font("Vani", 0, 12)); // NOI18N
        getContentPane().add(tfPredicado, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 188, -1));

        labelTR.setFont(new java.awt.Font("Vani", 1, 14)); // NOI18N
        labelTR.setText("Tabla Resultante:");
        labelTR.setEnabled(false);
        getContentPane().add(labelTR, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, -1, -1));

        tfTablaResultante.setFont(new java.awt.Font("Vani", 0, 12)); // NOI18N
        tfTablaResultante.setEnabled(false);
        getContentPane().add(tfTablaResultante, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, 155, -1));

        buttonResultado.setFont(new java.awt.Font("Vani", 0, 14)); // NOI18N
        buttonResultado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/tick.png"))); // NOI18N
        buttonResultado.setText("Resultado");
        buttonResultado.setContentAreaFilled(false);
        buttonResultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonResultadoActionPerformed(evt);
            }
        });
        getContentPane().add(buttonResultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, -1, 40));

        buttonCS.setFont(new java.awt.Font("Vani", 1, 14)); // NOI18N
        buttonCS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/exit.png"))); // NOI18N
        buttonCS.setText("Cerrar Sesion");
        buttonCS.setContentAreaFilled(false);
        buttonCS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCSActionPerformed(evt);
            }
        });
        getContentPane().add(buttonCS, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, 25));

        labelTabla2.setFont(new java.awt.Font("Vani", 1, 14)); // NOI18N
        labelTabla2.setText("Tabla 2:");
        labelTabla2.setEnabled(false);
        getContentPane().add(labelTabla2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, -1, -1));

        tfTabla2.setFont(new java.awt.Font("Vani", 0, 12)); // NOI18N
        tfTabla2.setEnabled(false);
        getContentPane().add(tfTabla2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 188, -1));

        checkboxCrearTabla.setFont(new java.awt.Font("Vani", 1, 14)); // NOI18N
        checkboxCrearTabla.setText("Crear una tabla resultante");
        checkboxCrearTabla.setContentAreaFilled(false);
        checkboxCrearTabla.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                checkboxCrearTablaStateChanged(evt);
            }
        });
        getContentPane().add(checkboxCrearTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, -1, -1));

        buttonMostrarTablas.setFont(new java.awt.Font("Vani", 0, 14)); // NOI18N
        buttonMostrarTablas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/clipboard.png"))); // NOI18N
        buttonMostrarTablas.setText("Mostrar Tablas");
        buttonMostrarTablas.setContentAreaFilled(false);
        buttonMostrarTablas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMostrarTablasActionPerformed(evt);
            }
        });
        getContentPane().add(buttonMostrarTablas, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 370, -1, 40));

        buttonVerInfoTabla.setText("Ver Info de Tablas");
        buttonVerInfoTabla.setContentAreaFilled(false);
        buttonVerInfoTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVerInfoTablaActionPerformed(evt);
            }
        });
        getContentPane().add(buttonVerInfoTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 330, -1, -1));

        ImagenFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/bitmap.png"))); // NOI18N
        getContentPane().add(ImagenFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 420));

        Opciones.setText("Opciones");

        Acerca_de.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        Acerca_de.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/info.png"))); // NOI18N
        Acerca_de.setText("Acerca de");
        Acerca_de.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Acerca_deActionPerformed(evt);
            }
        });
        Opciones.add(Acerca_de);

        Limpiar_casillas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_LEFT, java.awt.event.InputEvent.ALT_MASK));
        Limpiar_casillas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/eraser.png"))); // NOI18N
        Limpiar_casillas.setText("Limpiar  casillas");
        Limpiar_casillas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Limpiar_casillasActionPerformed(evt);
            }
        });
        Opciones.add(Limpiar_casillas);

        Menu.add(Opciones);

        setJMenuBar(Menu);

        setSize(new java.awt.Dimension(510, 468));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCSActionPerformed
        this.setVisible(false);
        
        InicioSesion IS = new InicioSesion();
        IS.setVisible(true);
    }//GEN-LAST:event_buttonCSActionPerformed

    private void buttonResultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonResultadoActionPerformed
        // TODO add your handling code here:
        String tabla1 = tfTabla1.getText();
        String tabla2 = tfTabla2.getText();
        String predicado = tfPredicado.getText();
        String operacion = (String)cbOperacion.getSelectedItem();
        String tablaResultante = tfTablaResultante.getText();
        
        try{
            ExpresionRelacional relacion = 
                    Controller.obtenerOperacion(operacion, tabla1, tabla2, 
                            predicado, tablaResultante);
            
            ResultSet resQuery = Controller.realizarOperacion(relacion);
            
            Resultado res = new Resultado(resQuery, relacion);
            res.setVisible(true);
        }catch(Exception e){
            //Crea un messageBox con mensaje de error
            Controller.mostrarMensaje(this, e);
        }
    }//GEN-LAST:event_buttonResultadoActionPerformed

    private void cbOperacionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbOperacionItemStateChanged
        // TODO add your handling code here:
        String operacion = (String)cbOperacion.getSelectedItem();
        tfPredicado.setText("");
        tfTabla2.setText("");
        tfTablaResultante.setText("");
        labelTabla2.setText("Tabla2");
        
        if(operacion.equals("Unión") || operacion.equals("Diferencia de conjuntos") ||
                operacion.equals("Producto cartesiano") || operacion.equals("Intersección") ||
                operacion.equals("División") || 
                operacion.equals("Concatenación natural (natural join)")){
            
            labelTabla2.setEnabled(true);
            tfTabla2.setEnabled(true);
            
            labelPredicado.setEnabled(false);
            tfPredicado.setEnabled(false);
        }
        
        else if(operacion.equals("Concatenación (join)")){
            labelTabla2.setEnabled(true);
            tfTabla2.setEnabled(true);
            
            labelPredicado.setEnabled(true);
            tfPredicado.setEnabled(true);
        }
        else if(operacion.equals("Agrupación")){
            labelTabla2.setText("Atributos");
            labelTabla2.setEnabled(true);
            
            tfTabla2.setEnabled(true);
            
            labelPredicado.setEnabled(true);
            tfPredicado.setEnabled(true);
        }
        else{
            labelTabla2.setEnabled(false);
            tfTabla2.setEnabled(false);
            
            labelPredicado.setEnabled(true);
            tfPredicado.setEnabled(true);
        }
    }//GEN-LAST:event_cbOperacionItemStateChanged

    private void checkboxCrearTablaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_checkboxCrearTablaStateChanged
        tfTablaResultante.setEnabled(checkboxCrearTabla.isSelected());
        labelTR.setEnabled(checkboxCrearTabla.isSelected());
        tfTablaResultante.setText("");
    }//GEN-LAST:event_checkboxCrearTablaStateChanged

    private void buttonMostrarTablasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMostrarTablasActionPerformed
        // TODO add your handling code here:
        try{
            Tablas ventanaTablas = new Tablas(Controller.obtenerTodaInformacion());
            ventanaTablas.setVisible(true);
        }catch(Exception e){
            Controller.mostrarMensaje(this, e);
        }
    }//GEN-LAST:event_buttonMostrarTablasActionPerformed

    private void Acerca_deActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Acerca_deActionPerformed
        // TODO add your handling code here:
        Acerca_de AC = new Acerca_de();
        AC.setVisible(true);
    }//GEN-LAST:event_Acerca_deActionPerformed

    private void Limpiar_casillasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Limpiar_casillasActionPerformed
        // TODO add your handling code here:
        this.tfTabla1.setText("");
        this.tfPredicado.setText("");
        this.tfTabla2.setText("");
        this.tfTablaResultante.setText("");
    }//GEN-LAST:event_Limpiar_casillasActionPerformed

    private void buttonVerInfoTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVerInfoTablaActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_buttonVerInfoTablaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Acerca_de;
    private javax.swing.JLabel ImagenFondo;
    private javax.swing.JMenuItem Limpiar_casillas;
    private javax.swing.JMenuBar Menu;
    private javax.swing.JMenu Opciones;
    private javax.swing.JButton buttonCS;
    private javax.swing.JButton buttonMostrarTablas;
    private javax.swing.JButton buttonResultado;
    private javax.swing.JButton buttonVerInfoTabla;
    private javax.swing.JComboBox cbOperacion;
    private javax.swing.JCheckBox checkboxCrearTabla;
    private javax.swing.JLabel labelOperacion;
    private javax.swing.JLabel labelPredicado;
    private javax.swing.JLabel labelTR;
    private javax.swing.JLabel labelTabla1;
    private javax.swing.JLabel labelTabla2;
    private javax.swing.JTextField tfPredicado;
    private javax.swing.JTextField tfTabla1;
    private javax.swing.JTextField tfTabla2;
    private javax.swing.JTextField tfTablaResultante;
    // End of variables declaration//GEN-END:variables
}