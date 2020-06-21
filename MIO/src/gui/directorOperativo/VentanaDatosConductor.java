/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.directorOperativo;

import controlador.ControladorAsignacionConductor;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import logica.*;

/**
 *
 * @author Joan
 */
public class VentanaDatosConductor extends javax.swing.JFrame {

    ControladorAsignacionConductor controladorTurnos = new ControladorAsignacionConductor();
    JFrame ventanaAnterior;
    String codConductor;
    String placaBus;
    ArrayList<String> turnos;
         
        
    public VentanaDatosConductor(JFrame anterior, String codConductor, String nombreConductor, String placaConductor) {
        
        super("Datos de Conductor");
        initComponents();
        ventanaAnterior = anterior;
        this.codConductor = codConductor;
        
        setLocationRelativeTo(null);
                                       
        Calendar fecha = Calendar.getInstance();
        
        int dia, mes, año;
        dia = fecha.get(Calendar.DATE);
        mes = fecha.get(Calendar.MONTH) + 1;
        año = fecha.get(Calendar.YEAR);
        
        labelFecha.setText(dia + "/" + mes + "/" + año);
        
        lId.setText("Identificación: " + codConductor);
        lNombre.setText("Nombre: " + nombreConductor);
        
        placaBus = placaConductor;
        lPlacaBus.setText(placaBus);
        
        llenarInformacionConductor();
        
    }
    
    public void cambiarBusAsignado(String placaBus) {
        
        this.placaBus = placaBus;
        lPlacaBus.setText(placaBus);
        
        cbTurnos.removeAllItems();
        cbTurnos.addItem("Seleccione un turno");
        
        DefaultTableModel modelo = (DefaultTableModel) tablaTurnos.getModel();
        modelo.setRowCount(0);
                        
        ArrayList<String> turnosDisponiblesBus = controladorTurnos.turnosDisponiblesBus(placaBus);
        
        for (int i = 0; i < turnosDisponiblesBus.size(); i++) {
            
            String turno = turnosDisponiblesBus.get(i);
            cbTurnos.addItem(turno);
            
        }
        
        turnos.clear();        
        
    }
      
    
    public void llenarInformacionConductor(){
                
        turnos = controladorTurnos.obtenerTurnosConductor(codConductor);
           
        DefaultTableModel modelo = (DefaultTableModel) tablaTurnos.getModel();
        modelo.setRowCount(0);
        
        for (int i = 0; i < turnos.size(); i++) {
                        
            Object []turno = new Object[1];
            turno[0] = turnos.get(i);
            modelo.addRow(turno);
        }

        actualizarComboBoxTurnos();
    }
    
    
    public void actualizarComboBoxTurnos(){
                        
        int numFilas = tablaTurnos.getRowCount();
        DefaultTableModel modelo = (DefaultTableModel) tablaTurnos.getModel();
        String objetoTabla="";
        
        for (int i = 0; i < numFilas; i++) {
            objetoTabla = modelo.getValueAt(i, 0).toString();
            cbTurnos.removeItem(objetoTabla);
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
        panelInfo = new javax.swing.JPanel();
        lId = new javax.swing.JLabel();
        bTerminar = new javax.swing.JButton();
        bAtras = new javax.swing.JButton();
        lNombre = new javax.swing.JLabel();
        lBus = new javax.swing.JLabel();
        lPlacaBus = new javax.swing.JLabel();
        lTurnos = new javax.swing.JLabel();
        bCambiarBus = new javax.swing.JButton();
        bAñadirTurno = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaTurnos = new javax.swing.JTable();
        bEliminarTurno = new javax.swing.JButton();
        cbTurnos = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
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

        javax.swing.GroupLayout panelSuperiorLayout = new javax.swing.GroupLayout(panelSuperior);
        panelSuperior.setLayout(panelSuperiorLayout);
        panelSuperiorLayout.setHorizontalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelEslogan, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelInfo.setBackground(new java.awt.Color(0, 97, 147));
        panelInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos de Conductor", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 3, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        lId.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        lId.setForeground(new java.awt.Color(255, 255, 255));
        lId.setText("Identificación:");

        bTerminar.setBackground(new java.awt.Color(0, 97, 147));
        bTerminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/general/bTerminar.png"))); // NOI18N
        bTerminar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/general/bTerminarPR.png"))); // NOI18N
        bTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTerminarActionPerformed(evt);
            }
        });

        bAtras.setBackground(new java.awt.Color(0, 97, 147));
        bAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/bAtras.png"))); // NOI18N
        bAtras.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/bAtrasPR.png"))); // NOI18N
        bAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAtrasActionPerformed(evt);
            }
        });

        lNombre.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        lNombre.setForeground(new java.awt.Color(255, 255, 255));
        lNombre.setText("Nombre:");

        lBus.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        lBus.setForeground(new java.awt.Color(255, 255, 255));
        lBus.setText("Bus Asignado:");

        lPlacaBus.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        lPlacaBus.setForeground(new java.awt.Color(255, 255, 255));
        lPlacaBus.setText("PLV-455");

        lTurnos.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        lTurnos.setForeground(new java.awt.Color(255, 255, 255));
        lTurnos.setText("Turnos:");

        bCambiarBus.setBackground(new java.awt.Color(0, 97, 147));
        bCambiarBus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventanaDirOperativo/bCambiarBus.png"))); // NOI18N
        bCambiarBus.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventanaDirOperativo/bCambiarBusPR.png"))); // NOI18N
        bCambiarBus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCambiarBusActionPerformed(evt);
            }
        });

        bAñadirTurno.setBackground(new java.awt.Color(0, 97, 147));
        bAñadirTurno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventanaDirOperativo/bAnadirTurno.png"))); // NOI18N
        bAñadirTurno.setMaximumSize(new java.awt.Dimension(169, 27));
        bAñadirTurno.setMinimumSize(new java.awt.Dimension(169, 27));
        bAñadirTurno.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventanaDirOperativo/bAnadirTurnoPR.png"))); // NOI18N
        bAñadirTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAñadirTurnoActionPerformed(evt);
            }
        });

        tablaTurnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Turno"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaTurnos);

        bEliminarTurno.setBackground(new java.awt.Color(0, 97, 147));
        bEliminarTurno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventanaDirOperativo/bEliminarTurno.png"))); // NOI18N
        bEliminarTurno.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventanaDirOperativo/bEliminarTurnoPR.png"))); // NOI18N
        bEliminarTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminarTurnoActionPerformed(evt);
            }
        });

        cbTurnos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un turno", "Manana", "Tarde", "Noche" }));

        javax.swing.GroupLayout panelInfoLayout = new javax.swing.GroupLayout(panelInfo);
        panelInfo.setLayout(panelInfoLayout);
        panelInfoLayout.setHorizontalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lId, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE))
                    .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelInfoLayout.createSequentialGroup()
                            .addComponent(bAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(29, 29, 29)
                            .addComponent(bTerminar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(bAñadirTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelInfoLayout.createSequentialGroup()
                            .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(panelInfoLayout.createSequentialGroup()
                                    .addComponent(lTurnos, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInfoLayout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lPlacaBus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelInfoLayout.createSequentialGroup()
                                    .addGap(49, 49, 49)
                                    .addComponent(cbTurnos, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInfoLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(bEliminarTurno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bCambiarBus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addComponent(lBus, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        panelInfoLayout.setVerticalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelInfoLayout.createSequentialGroup()
                        .addComponent(lId)
                        .addGap(18, 18, 18)
                        .addComponent(lNombre)
                        .addGap(24, 24, 24)
                        .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lBus, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lPlacaBus, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(bCambiarBus, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(lTurnos)
                .addGap(18, 18, 18)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInfoLayout.createSequentialGroup()
                        .addComponent(cbTurnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bAñadirTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bEliminarTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bTerminar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(bAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(panelSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

    private void bTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTerminarActionPerformed
        
        if(placaBus.equals("")){
            JOptionPane.showMessageDialog(null, "Debe seleccionar un bus", "Error", JOptionPane.WARNING_MESSAGE);
        }
        else if(turnos.isEmpty()){
            JOptionPane.showMessageDialog(null, "Debe seleccionar al menos un turno", "Error", JOptionPane.WARNING_MESSAGE);
        }
        else{
            
            ArrayList<AsignacionConductor> asignaciones = new ArrayList<>();
        
            for (int i = 0; i < turnos.size(); i++) {
                asignaciones.add(new AsignacionConductor(codConductor, placaBus, turnos.get(i)));
            }

            int resultado = controladorTurnos.guardaTurnosConductor(asignaciones);
            
            if(resultado != 0){
                JOptionPane.showMessageDialog(null, "Información del conductor modificada correctamente");
                this.dispose();
                ventanaAnterior.setVisible(true);
                ventanaAnterior.setLocationRelativeTo(null);
                
                VentanaVisualizarConductores vConductores = (VentanaVisualizarConductores) ventanaAnterior;
                vConductores.llenarTablaConductores();
            }
            
        }
        
        
          
        
    }//GEN-LAST:event_bTerminarActionPerformed

    private void bAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAtrasActionPerformed

        int cerrar = JOptionPane.showConfirmDialog(null,"Se cancelará la operación actual\n¿Está seguro de que quiere cerrar esta ventana?", "Confirmación de cierre", JOptionPane.YES_NO_OPTION);

        if(cerrar == JOptionPane.YES_OPTION){
            this.dispose();
            ventanaAnterior.setVisible(true);
            ventanaAnterior.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_bAtrasActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
        int cerrar = JOptionPane.showConfirmDialog(null,"Se cancelará la operación actual\n¿Está seguro de que quiere cerrar esta ventana?", "Confirmación de cierre", JOptionPane.YES_NO_OPTION);

        if(cerrar == JOptionPane.YES_OPTION){
            this.dispose();
            ventanaAnterior.setVisible(true);
            ventanaAnterior.setLocationRelativeTo(null);
        }
        
    }//GEN-LAST:event_formWindowClosing

    private void bCambiarBusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCambiarBusActionPerformed
        
        VentanaVisualizarBuses vBuses = new VentanaVisualizarBuses(this, true);
        vBuses.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_bCambiarBusActionPerformed

    private void bAñadirTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAñadirTurnoActionPerformed
        
        if(cbTurnos.getSelectedIndex() != 0){
            
            String turno = cbTurnos.getSelectedItem().toString();
            cbTurnos.removeItem(turno);
            cbTurnos.setSelectedIndex(0);
            
            DefaultTableModel modelo = (DefaultTableModel) tablaTurnos.getModel();
            Object[] turnoConductor = new Object[1];
            
            turnoConductor[0] = turno;            
            modelo.addRow(turnoConductor);
            turnos.add(turno);
                        
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar el turno a agregar", "Error", JOptionPane.WARNING_MESSAGE);
        }
            
        
    }//GEN-LAST:event_bAñadirTurnoActionPerformed

    private void bEliminarTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminarTurnoActionPerformed
        
        int filaSeleccionada = tablaTurnos.getSelectedRow();
        
        if(filaSeleccionada != -1){                        
            
            DefaultTableModel modelo = (DefaultTableModel) tablaTurnos.getModel();
            String turno = modelo.getValueAt(filaSeleccionada, 0).toString();                       
            modelo.removeRow(filaSeleccionada);
            
            cbTurnos.addItem(turno);
            
            turnos.remove(filaSeleccionada);
                  
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar el turno a borrar", "Error", JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_bEliminarTurnoActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaDatosConductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaDatosConductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaDatosConductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaDatosConductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaDatosConductor(null, null, null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAtras;
    private javax.swing.JButton bAñadirTurno;
    private javax.swing.JButton bCambiarBus;
    private javax.swing.JButton bEliminarTurno;
    private javax.swing.JButton bTerminar;
    private javax.swing.JComboBox<String> cbTurnos;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JLabel lBus;
    private javax.swing.JLabel lId;
    private javax.swing.JLabel lNombre;
    public javax.swing.JLabel lPlacaBus;
    public javax.swing.JLabel lTurnos;
    private javax.swing.JLabel labelEslogan;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JPanel panelInfo;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelSuperior;
    private javax.swing.JTable tablaTurnos;
    // End of variables declaration//GEN-END:variables
}
