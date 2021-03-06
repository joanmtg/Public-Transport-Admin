/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.gerente;

import controlador.ControladorPasajero;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import reportes.Reportes;

/**
 *
 * @author Joan
 */
public class VentanaRutasPersona extends javax.swing.JFrame {

    JFrame ventanaAnterior;
    ControladorPasajero controladorPas = new ControladorPasajero();
    
    public VentanaRutasPersona(JFrame anterior) {
        super("Rutas por persona");
        initComponents();
        
        ventanaAnterior = anterior;
        setLocationRelativeTo(null);
        
        Calendar fecha = Calendar.getInstance();
        
        int dia, mes, año;
        dia = fecha.get(Calendar.DATE);
        mes = fecha.get(Calendar.MONTH) + 1;
        año = fecha.get(Calendar.YEAR);
        
        labelFecha.setText(dia + "/" + mes + "/" + año);
        
        
        // Las siguientes 4 líneas, son para centrar la información de la tabla 
        ((DefaultTableCellRenderer)tablaRutas.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER); 
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer(); 
        tcr.setHorizontalAlignment(JLabel.CENTER); 
        tablaRutas.setDefaultRenderer(Object.class, tcr);
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
        lIDpasajero = new javax.swing.JLabel();
        bAtras = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaRutas = new javax.swing.JTable();
        lTitulo = new javax.swing.JLabel();
        bConsultarRutasPersona = new javax.swing.JButton();
        tfIDpasajero = new javax.swing.JTextField();
        botonGenerarReporteRutasPasajero = new javax.swing.JButton();

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
        panelInferior.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Rutas por Persona", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 3, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        panelInferior.setForeground(new java.awt.Color(255, 255, 255));

        lIDpasajero.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        lIDpasajero.setForeground(new java.awt.Color(255, 255, 255));
        lIDpasajero.setText("Identificación del pasajero:");

        bAtras.setBackground(new java.awt.Color(0, 97, 147));
        bAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/bAtras.png"))); // NOI18N
        bAtras.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/bAtrasPR.png"))); // NOI18N
        bAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAtrasActionPerformed(evt);
            }
        });

        tablaRutas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "<html><font size=\"3\" color=\"#006193\"><b>Código</b></html>", "<html><font size=\"3\" color=\"#006193\"><b>Nombre</b></html>"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaRutas);

        lTitulo.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        lTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lTitulo.setText("Rutas Frecuentadas");

        bConsultarRutasPersona.setBackground(new java.awt.Color(0, 97, 147));
        bConsultarRutasPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/general/bConsultar.png"))); // NOI18N
        bConsultarRutasPersona.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/general/bConsultarPR.png"))); // NOI18N
        bConsultarRutasPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConsultarRutasPersonaActionPerformed(evt);
            }
        });

        botonGenerarReporteRutasPasajero.setBackground(new java.awt.Color(0, 97, 147));
        botonGenerarReporteRutasPasajero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/bGenerarReporte.png"))); // NOI18N
        botonGenerarReporteRutasPasajero.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/bGenerarReportePR.png"))); // NOI18N
        botonGenerarReporteRutasPasajero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGenerarReporteRutasPasajeroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelInferiorLayout = new javax.swing.GroupLayout(panelInferior);
        panelInferior.setLayout(panelInferiorLayout);
        panelInferiorLayout.setHorizontalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInferiorLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                    .addComponent(lTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelInferiorLayout.createSequentialGroup()
                        .addComponent(bAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(botonGenerarReporteRutasPasajero, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelInferiorLayout.createSequentialGroup()
                        .addComponent(lIDpasajero)
                        .addGap(18, 18, 18)
                        .addComponent(tfIDpasajero, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bConsultarRutasPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16))
        );
        panelInferiorLayout.setVerticalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInferiorLayout.createSequentialGroup()
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelInferiorLayout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addComponent(bConsultarRutasPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInferiorLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(tfIDpasajero, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lIDpasajero, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lTitulo)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonGenerarReporteRutasPasajero, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(25, 25, 25))
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
                .addContainerGap(26, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(panelSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        
        this.dispose();
        ventanaAnterior.setVisible(true);
        ventanaAnterior.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_formWindowClosed

    private void bConsultarRutasPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bConsultarRutasPersonaActionPerformed
        
        String id_pasajero = tfIDpasajero.getText();
        
        if(id_pasajero.equals("")){
            JOptionPane.showMessageDialog(null, "Debe ingresar la identificación del pasajero a consultar", "Warning", JOptionPane.WARNING_MESSAGE);
        }else{
            controladorPas.informacionRutasPasajeros(tablaRutas, id_pasajero);
        }
    }//GEN-LAST:event_bConsultarRutasPersonaActionPerformed

    private void botonGenerarReporteRutasPasajeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGenerarReporteRutasPasajeroActionPerformed
        String id_pasajero = tfIDpasajero.getText();
        
        if(id_pasajero.equals("")){
            JOptionPane.showMessageDialog(null, "Debe ingresar la identificación del pasajero para generar el reporte", "Warning", JOptionPane.WARNING_MESSAGE);
        }else{
            Reportes nuevoReporte = new Reportes();
            nuevoReporte.reporteRutasPasajero(id_pasajero);
        }
    }//GEN-LAST:event_botonGenerarReporteRutasPasajeroActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaRutasPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaRutasPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaRutasPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaRutasPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaRutasPersona(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAtras;
    private javax.swing.JButton bConsultarRutasPersona;
    private javax.swing.JButton botonGenerarReporteRutasPasajero;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lIDpasajero;
    private javax.swing.JLabel lTitulo;
    private javax.swing.JLabel labelEslogan;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JPanel panelInferior;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelSuperior;
    private javax.swing.JTable tablaRutas;
    private javax.swing.JTextField tfIDpasajero;
    // End of variables declaration//GEN-END:variables
}
