/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.auxiliar;

import java.util.Calendar;
import javax.swing.JFrame;
import logica.Empleado;
import controlador.ControladorTarjeta;
import javax.swing.JOptionPane;

/**
 *
 * @author Joan
 */
public class VentanaModificarTarjeta extends javax.swing.JFrame {

    JFrame ventanaAnterior;
    ControladorTarjeta tarjeta;
        
    public VentanaModificarTarjeta(JFrame anterior) {
        
        super("Modificación de Tarjeta");
        initComponents();
        ventanaAnterior = anterior;
        tarjeta = new ControladorTarjeta();
        
        setLocationRelativeTo(null);
                                       
        Calendar fecha = Calendar.getInstance();
        
        int dia, mes, año;
        dia = fecha.get(Calendar.DATE);
        mes = fecha.get(Calendar.MONTH) + 1;
        año = fecha.get(Calendar.YEAR);
        
        labelFecha.setText(dia + "/" + mes + "/" + año);
        
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
        bEliminarTarjeta = new javax.swing.JButton();
        bAtras = new javax.swing.JButton();
        lPIN = new javax.swing.JLabel();
        tfPINTarjeta = new javax.swing.JTextField();
        lPasajes = new javax.swing.JLabel();
        bBuscarPIN = new javax.swing.JButton();
        cbEstado = new javax.swing.JComboBox<>();
        bGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelEslogan, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelFecha))
                .addContainerGap())
        );
        panelSuperiorLayout.setVerticalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperiorLayout.createSequentialGroup()
                .addGroup(panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSuperiorLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(labelEslogan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelFecha))
                    .addGroup(panelSuperiorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        panelInferior.setBackground(new java.awt.Color(0, 97, 147));
        panelInferior.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Modificar Tarjeta", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 3, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        panelInferior.setForeground(new java.awt.Color(255, 255, 255));

        bEliminarTarjeta.setBackground(new java.awt.Color(0, 97, 147));
        bEliminarTarjeta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/general/bEliminar.png"))); // NOI18N
        bEliminarTarjeta.setEnabled(false);
        bEliminarTarjeta.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/general/bEliminarPR.png"))); // NOI18N
        bEliminarTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminarTarjetaActionPerformed(evt);
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

        lPIN.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        lPIN.setForeground(new java.awt.Color(255, 255, 255));
        lPIN.setText("PIN de Tarjeta:");

        lPasajes.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        lPasajes.setForeground(new java.awt.Color(255, 255, 255));
        lPasajes.setText("Estado:");

        bBuscarPIN.setBackground(new java.awt.Color(0, 97, 147));
        bBuscarPIN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/general/bBuscar.png"))); // NOI18N
        bBuscarPIN.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/general/bBuscarPR.png"))); // NOI18N
        bBuscarPIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarPINActionPerformed(evt);
            }
        });

        cbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un estado", "Activar", "Bloquear" }));
        cbEstado.setEnabled(false);

        bGuardar.setBackground(new java.awt.Color(0, 97, 147));
        bGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/general/bGuardar.png"))); // NOI18N
        bGuardar.setEnabled(false);
        bGuardar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/general/bGuardarPR.png"))); // NOI18N
        bGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelInferiorLayout = new javax.swing.GroupLayout(panelInferior);
        panelInferior.setLayout(panelInferiorLayout);
        panelInferiorLayout.setHorizontalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInferiorLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelInferiorLayout.createSequentialGroup()
                        .addComponent(lPIN, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tfPINTarjeta))
                    .addGroup(panelInferiorLayout.createSequentialGroup()
                        .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lPasajes, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bEliminarTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bBuscarPIN, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );
        panelInferiorLayout.setVerticalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInferiorLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lPIN)
                    .addComponent(tfPINTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bBuscarPIN, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lPasajes)
                    .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bEliminarTarjeta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
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
                .addGap(18, 18, 18)
                .addComponent(panelInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bEliminarTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminarTarjetaActionPerformed

        String pin = tfPINTarjeta.getText();
        
        int elimTarjeta = JOptionPane.showConfirmDialog(null,"¿Está seguro que desea eliminar esta tarjeta?", "Confirmación de eliminación de tarjeta", JOptionPane.YES_NO_OPTION);

        if(elimTarjeta == JOptionPane.YES_OPTION){
            
            tarjeta.eliminarTarjeta(pin);
        
            bGuardar.setEnabled(false);
            cbEstado.setEnabled(false);
            bEliminarTarjeta.setEnabled(false);
            tfPINTarjeta.setText("");
            tfPINTarjeta.setEditable(true);            
        }
        
        
        
        
        
    }//GEN-LAST:event_bEliminarTarjetaActionPerformed

    private void bAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAtrasActionPerformed

        this.dispose();
        ventanaAnterior.setVisible(true);
        ventanaAnterior.setLocationRelativeTo(null);

    }//GEN-LAST:event_bAtrasActionPerformed

    private void bBuscarPINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarPINActionPerformed
        
        //Cuando se ingrese un pin válido:
        String pin = tfPINTarjeta.getText();        
        boolean validar = tarjeta.validarPIN(pin);
        boolean eliminada = tarjeta.tarjetaEliminada(pin);
        
        if(validar == true){
            if(eliminada == false){
            
                bGuardar.setEnabled(true);
                cbEstado.setEnabled(true);
                bEliminarTarjeta.setEnabled(true);
                tfPINTarjeta.setEditable(false);
            
            }else{
            
                JOptionPane.showMessageDialog(null, "La tarjeta con pin "+pin + " se encuentra eliminada", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            
            JOptionPane.showMessageDialog(null, "No existe la tarjeta con pin "+pin, "Error", JOptionPane.ERROR_MESSAGE);            
        }
        
        
    }//GEN-LAST:event_bBuscarPINActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        
        this.dispose();
        ventanaAnterior.setVisible(true);
        ventanaAnterior.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_formWindowClosed

    private void bGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGuardarActionPerformed
        // TODO add your handling code here:
        
        String pin = tfPINTarjeta.getText();        
        String estadoT = (String) cbEstado.getSelectedItem();        
        String estado = "";
        boolean modificar;
        
        if(estadoT.equals("")){
            
            JOptionPane.showMessageDialog(null, "Debe seleccionar un estado", "Aviso", JOptionPane.WARNING_MESSAGE);
            
        }else{
            
            estado = tarjeta.estadoTarjeta(pin);
            
            if(estado.equals("Bloqueada") && estadoT.equals("Activar")){
                
                modificar = tarjeta.modfEstadoTarjeta(pin, "Activa");
                
                if(modificar == false){
                    
                    JOptionPane.showMessageDialog(null, "No se pudo modificar la informacion", "Error", JOptionPane.ERROR_MESSAGE);
                    
                }else{
                    
                    JOptionPane.showMessageDialog(null, "La información de la tarjeta se modificó exitosamente", "Modificación exitosa", JOptionPane.PLAIN_MESSAGE);   
                    
                    bGuardar.setEnabled(false);
                    cbEstado.setEnabled(false);
                    bEliminarTarjeta.setEnabled(false);
                    tfPINTarjeta.setText("");
                    tfPINTarjeta.setEditable(true);
                }
                            
            }
            else if(estado.equals("Activa") && estadoT.equals("Bloquear")){
                
                modificar = tarjeta.modfEstadoTarjeta(pin, "Bloqueada");
                
                if(modificar == false){
                    
                    JOptionPane.showMessageDialog(null, "No se pudo modificar la informacion", "Error", JOptionPane.ERROR_MESSAGE);
                    
                }else{
                    
                    JOptionPane.showMessageDialog(null, "La información de la tarjeta se modificó exitosamente", "Modificación exitosa", JOptionPane.PLAIN_MESSAGE);
                    
                    bGuardar.setEnabled(false);
                    cbEstado.setEnabled(false);
                    bEliminarTarjeta.setEnabled(false);
                    tfPINTarjeta.setText("");
                    tfPINTarjeta.setEditable(true);
                }
                
            }
            else if(estado.equals("Bloqueada") && estadoT.equals("Bloquear")){
                
                JOptionPane.showMessageDialog(null, "La tarjeta ya está bloqueada", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
            else if(estado.equals("Activa") && estadoT.equals("Activar")){
                
                JOptionPane.showMessageDialog(null, "La tarjeta ya está activa", "Aviso", JOptionPane.WARNING_MESSAGE);
            }            
            
        }
        
        
        
       
    }//GEN-LAST:event_bGuardarActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaModificarTarjeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaModificarTarjeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaModificarTarjeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaModificarTarjeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaModificarTarjeta(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAtras;
    private javax.swing.JButton bBuscarPIN;
    private javax.swing.JButton bEliminarTarjeta;
    private javax.swing.JButton bGuardar;
    private javax.swing.JComboBox<String> cbEstado;
    public javax.swing.JLabel lPIN;
    public javax.swing.JLabel lPasajes;
    private javax.swing.JLabel labelEslogan;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JPanel panelInferior;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelSuperior;
    private javax.swing.JTextField tfPINTarjeta;
    // End of variables declaration//GEN-END:variables
}