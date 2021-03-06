/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.directorOperativo;

import controlador.ControladorBus;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import logica.*;

/**
 *
 * @author Joan
 */
public class VentanaVisualizarBuses extends javax.swing.JFrame {

    JFrame ventanaAnterior;
    ControladorBus controladorBus = new ControladorBus();
    TableRowSorter trsFiltro;
                
    public VentanaVisualizarBuses(JFrame anterior, boolean seleccionDeBus) {
        
        super("Buses del sistema");
        initComponents();
        
        ventanaAnterior = anterior;
        setLocationRelativeTo(null);
        
        Calendar fecha = Calendar.getInstance();
        
        int dia, mes, año;
        dia = fecha.get(Calendar.DATE);
        mes = fecha.get(Calendar.MONTH) + 1;
        año = fecha.get(Calendar.YEAR);
        
        labelFecha.setText(dia + "/" + mes + "/" + año);               
                
        llenarTablaBuses("Todos");
        
        bSeleccionarBus.setVisible(seleccionDeBus);  
        
        if(seleccionDeBus){
            bAgregarBus.setVisible(false);
            bModificarBus.setVisible(false);
            llenarTablaBuses("Disponibles");
        }
        
        //Se añade el filtro a la tabla
        
        trsFiltro = new TableRowSorter(tablaBuses.getModel());
        tablaBuses.setRowSorter(trsFiltro);        
                        
        
        // Las siguientes 4 líneas, son para centrar la información de la tabla 
        ((DefaultTableCellRenderer)tablaBuses.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER); 
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer(); 
        tcr.setHorizontalAlignment(JLabel.CENTER); 
        tablaBuses.setDefaultRenderer(Object.class, tcr);
    }
    
    
    public void llenarTablaBuses(String tipo){
        
        ArrayList<Bus> buses = new ArrayList<>();
        
        if(tipo.equals("Todos")){
            buses = controladorBus.obtenerBuses();            
        }
        else{//Si tipo = "Disponibles" se traen sólo los buses con al menos un turno disponible
            buses = controladorBus.busesDisponibles();
        }        
        
        DefaultTableModel modelo = (DefaultTableModel)tablaBuses.getModel();
        modelo.setRowCount(0);               
        
        if(buses != null){
            
            for (int i = 0; i < buses.size(); i++) {
                Bus busActual = buses.get(i);
                
                Object fila[] = new Object[4];
                
                fila[0]= busActual.getPlaca();
                fila[1]= busActual.getTipo();
                fila[2]= busActual.getCapacidad();
                fila[3]= busActual.getCod_ruta();
                
                modelo.addRow(fila);
                
            }  
            
        }
        else{
            JOptionPane.showMessageDialog(null, "No hay buses registrados en la base de datos");
        }     
        
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        panelSuperior = new javax.swing.JPanel();
        labelLogo = new javax.swing.JLabel();
        labelEslogan = new javax.swing.JLabel();
        labelFecha = new javax.swing.JLabel();
        panelInferior = new javax.swing.JPanel();
        bAtras = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaBuses = new javax.swing.JTable();
        bAgregarBus = new javax.swing.JButton();
        bModificarBus = new javax.swing.JButton();
        bSeleccionarBus = new javax.swing.JButton();
        lBuscar = new javax.swing.JLabel();
        tfFiltrarPlaca = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        panelPrincipal.setBackground(new java.awt.Color(0, 97, 147));

        panelSuperior.setBackground(new java.awt.Color(0, 97, 147));
        panelSuperior.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoMio.png"))); // NOI18N

        labelEslogan.setFont(new java.awt.Font("Arial", 3, 16)); // NOI18N
        labelEslogan.setForeground(new java.awt.Color(255, 255, 255));
        labelEslogan.setText("EL MIO ES TUYO");

        labelFecha.setFont(new java.awt.Font("Arial", 3, 16)); // NOI18N
        labelFecha.setForeground(new java.awt.Color(255, 255, 255));
        labelFecha.setText("20/11/2016");

        javax.swing.GroupLayout panelSuperiorLayout = new javax.swing.GroupLayout(panelSuperior);
        panelSuperior.setLayout(panelSuperiorLayout);
        panelSuperiorLayout.setHorizontalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelEslogan, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelFecha))
                .addGap(20, 20, 20))
        );
        panelSuperiorLayout.setVerticalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperiorLayout.createSequentialGroup()
                .addGroup(panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSuperiorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelSuperiorLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(labelEslogan)
                        .addGap(18, 18, 18)
                        .addComponent(labelFecha)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelInferior.setBackground(new java.awt.Color(0, 97, 147));
        panelInferior.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Lista de Buses", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 3, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        panelInferior.setForeground(new java.awt.Color(255, 255, 255));

        bAtras.setBackground(new java.awt.Color(0, 97, 147));
        bAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/bAtras.png"))); // NOI18N
        bAtras.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/bAtrasPR.png"))); // NOI18N
        bAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAtrasActionPerformed(evt);
            }
        });

        tablaBuses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "<html><font size=\"3\" color=\"#006193\"><b>Placa</b></html>", "<html><font size=\"3\" color=\"#006193\"><b>Tipo</b></html>", "<html><font size=\"3\" color=\"#006193\"><b>Capacidad</b></html>", "<html><font size=\"3\" color=\"#006193\"><b>Ruta</b></html>"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaBuses);

        bAgregarBus.setBackground(new java.awt.Color(0, 97, 147));
        bAgregarBus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/general/bRegistrar.png"))); // NOI18N
        bAgregarBus.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/general/bRegistrarPR.png"))); // NOI18N
        bAgregarBus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAgregarBusActionPerformed(evt);
            }
        });

        bModificarBus.setBackground(new java.awt.Color(0, 97, 147));
        bModificarBus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/general/bModificar.png"))); // NOI18N
        bModificarBus.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/general/bModificarPR.png"))); // NOI18N
        bModificarBus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModificarBusActionPerformed(evt);
            }
        });

        bSeleccionarBus.setBackground(new java.awt.Color(0, 97, 147));
        bSeleccionarBus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/general/bSeleccionar.png"))); // NOI18N
        bSeleccionarBus.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/general/bSeleccionarPR.png"))); // NOI18N
        bSeleccionarBus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSeleccionarBusActionPerformed(evt);
            }
        });

        lBuscar.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        lBuscar.setForeground(new java.awt.Color(255, 255, 255));
        lBuscar.setText("Filtrar por placa:");

        tfFiltrarPlaca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfFiltrarPlacaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout panelInferiorLayout = new javax.swing.GroupLayout(panelInferior);
        panelInferior.setLayout(panelInferiorLayout);
        panelInferiorLayout.setHorizontalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInferiorLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInferiorLayout.createSequentialGroup()
                        .addComponent(lBuscar)
                        .addGap(18, 18, 18)
                        .addComponent(tfFiltrarPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelInferiorLayout.createSequentialGroup()
                        .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelInferiorLayout.createSequentialGroup()
                                .addComponent(bAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bSeleccionarBus, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bAgregarBus, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(bModificarBus, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE))
                        .addGap(20, 20, 20))))
        );
        panelInferiorLayout.setVerticalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInferiorLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lBuscar)
                    .addComponent(tfFiltrarPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bAgregarBus, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bSeleccionarBus, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bModificarBus, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bAtras, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelInferior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(panelSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAtrasActionPerformed

        this.dispose();
        ventanaAnterior.setVisible(true);
        ventanaAnterior.setLocationRelativeTo(null);

    }//GEN-LAST:event_bAtrasActionPerformed

    private void bAgregarBusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAgregarBusActionPerformed
                        
        VentanaDatosBus vBus = new VentanaDatosBus(this, "Registro", null);
        vBus.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_bAgregarBusActionPerformed

    private void bModificarBusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModificarBusActionPerformed
        
        int filaSeleccionada = tablaBuses.getSelectedRow();
        DefaultTableModel modelo = (DefaultTableModel) tablaBuses.getModel();   
             
        if(filaSeleccionada != -1){
            
            filaSeleccionada = tablaBuses.getRowSorter().convertRowIndexToModel(filaSeleccionada);
            
            String placa = modelo.getValueAt(filaSeleccionada, 0).toString();
            String tipo = modelo.getValueAt(filaSeleccionada, 1).toString();
            int capacidad = Integer.parseInt(modelo.getValueAt(filaSeleccionada, 2).toString());
            String codRuta = modelo.getValueAt(filaSeleccionada, 3).toString();
                  
            Bus busSeleccionado = new Bus(placa, capacidad, tipo, codRuta);
            
            VentanaDatosBus vBus = new VentanaDatosBus(this, "Modificacion", busSeleccionado);
            vBus.setVisible(true);
            this.setVisible(false);      
            
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar un bus para modificarlo", "Error", JOptionPane.WARNING_MESSAGE);
        }
        
        
        
        
    }//GEN-LAST:event_bModificarBusActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        
        this.dispose();
        ventanaAnterior.setVisible(true);
        ventanaAnterior.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_formWindowClosed

    private void bSeleccionarBusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSeleccionarBusActionPerformed
        
        int filaSeleccionada = tablaBuses.getSelectedRow();
        DefaultTableModel modelo = (DefaultTableModel) tablaBuses.getModel();
                
        filaSeleccionada = tablaBuses.getRowSorter().convertRowIndexToModel(filaSeleccionada);
        
        if(filaSeleccionada != -1){
            
            String placa = modelo.getValueAt(filaSeleccionada, 0).toString();
        
            JOptionPane.showMessageDialog(null, "Bus de placa " + placa + " seleccionado");
            this.dispose();
            ventanaAnterior.setVisible(true);
            ventanaAnterior.setLocationRelativeTo(null);

            //Cambiar a placa seleccionada
            VentanaDatosConductor ventana = (VentanaDatosConductor) ventanaAnterior;
            ventana.cambiarBusAsignado(placa);   
            
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar un bus para continuar", "Error", JOptionPane.WARNING_MESSAGE);
        }
        
             
        
    }//GEN-LAST:event_bSeleccionarBusActionPerformed

    private void tfFiltrarPlacaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfFiltrarPlacaKeyReleased
        
        int columna = 0;
        
        trsFiltro.setRowFilter(RowFilter.regexFilter(tfFiltrarPlaca.getText(), columna));       
        
    }//GEN-LAST:event_tfFiltrarPlacaKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaVisualizarBuses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaVisualizarBuses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaVisualizarBuses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaVisualizarBuses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaVisualizarBuses(null, false).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAgregarBus;
    private javax.swing.JButton bAtras;
    private javax.swing.JButton bModificarBus;
    private javax.swing.JButton bSeleccionarBus;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lBuscar;
    private javax.swing.JLabel labelEslogan;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JPanel panelInferior;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelSuperior;
    private javax.swing.JTable tablaBuses;
    private javax.swing.JTextField tfFiltrarPlaca;
    // End of variables declaration//GEN-END:variables
}
