/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.gerente;

import controlador.ControladorIngresoRuta;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import logica.Empleado;
import reportes.Reportes;

/**
 *
 * @author Joan
 */
public class VentanaMovilidadRutas extends javax.swing.JFrame {

    JFrame ventanaAnterior;
    ControladorIngresoRuta controladorIngRuta = new ControladorIngresoRuta();
    Empleado usuarioActual;
    
    public VentanaMovilidadRutas(JFrame anterior, Empleado usuario) {
        super("Reporte de Movilidad");
        initComponents();
        
        ventanaAnterior = anterior;
        usuarioActual = usuario;
        setLocationRelativeTo(null);
        
        Calendar fecha = Calendar.getInstance();
        
        int dia, mes, año;
        dia = fecha.get(Calendar.DATE);
        mes = fecha.get(Calendar.MONTH) + 1;
        año = fecha.get(Calendar.YEAR);
        
        labelFecha.setText(dia + "/" + mes + "/" + año);
        
        // Las siguientes 4 líneas, son para centrar la información de la tabla 
        ((DefaultTableCellRenderer)tablaMovilidad.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER); 
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer(); 
        tcr.setHorizontalAlignment(JLabel.CENTER); 
        tablaMovilidad.setDefaultRenderer(Object.class, tcr);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMovilidad = new javax.swing.JTable();
        bAtras = new javax.swing.JButton();
        lEstacion1 = new javax.swing.JLabel();
        cbDia = new javax.swing.JComboBox<String>();
        lfNacimiento3 = new javax.swing.JLabel();
        lfNacimiento2 = new javax.swing.JLabel();
        cbMes = new javax.swing.JComboBox<String>();
        lfNacimiento1 = new javax.swing.JLabel();
        cbAño = new javax.swing.JComboBox<String>();
        bConsultarVentas = new javax.swing.JButton();
        botonGenerarReporteBusesConductores = new javax.swing.JButton();

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
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
                        .addContainerGap()
                        .addComponent(labelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelSuperiorLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(labelEslogan)
                        .addGap(18, 18, 18)
                        .addComponent(labelFecha)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelInferior.setBackground(new java.awt.Color(0, 97, 147));
        panelInferior.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Reporte de pasajeros movilizados por ruta", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 3, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        panelInferior.setForeground(new java.awt.Color(255, 255, 255));

        tablaMovilidad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "<html><font size=\"3\" color=\"#006193\"><b>Código de Ruta</b></html>", "<html><font size=\"3\" color=\"#006193\"><b>Nombre de la Ruta</b></html>", "<html><font size=\"3\" color=\"#006193\"><b>Pasajeros Movilizados</b></html>"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaMovilidad);

        bAtras.setBackground(new java.awt.Color(0, 97, 147));
        bAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/bAtras.png"))); // NOI18N
        bAtras.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/bAtrasPR.png"))); // NOI18N
        bAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAtrasActionPerformed(evt);
            }
        });

        lEstacion1.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        lEstacion1.setForeground(new java.awt.Color(255, 255, 255));
        lEstacion1.setText("Fecha:");

        cbDia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        lfNacimiento3.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        lfNacimiento3.setForeground(new java.awt.Color(255, 255, 255));
        lfNacimiento3.setText("Día");

        lfNacimiento2.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        lfNacimiento2.setForeground(new java.awt.Color(255, 255, 255));
        lfNacimiento2.setText("Mes:");

        cbMes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        lfNacimiento1.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        lfNacimiento1.setForeground(new java.awt.Color(255, 255, 255));
        lfNacimiento1.setText("Año:");

        cbAño.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016" }));

        bConsultarVentas.setBackground(new java.awt.Color(0, 97, 147));
        bConsultarVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/general/bConsultar.png"))); // NOI18N
        bConsultarVentas.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/general/bConsultarPR.png"))); // NOI18N
        bConsultarVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConsultarVentasActionPerformed(evt);
            }
        });

        botonGenerarReporteBusesConductores.setBackground(new java.awt.Color(0, 97, 147));
        botonGenerarReporteBusesConductores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/bGenerarReporte.png"))); // NOI18N
        botonGenerarReporteBusesConductores.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/bGenerarReportePR.png"))); // NOI18N
        botonGenerarReporteBusesConductores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGenerarReporteBusesConductoresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelInferiorLayout = new javax.swing.GroupLayout(panelInferior);
        panelInferior.setLayout(panelInferiorLayout);
        panelInferiorLayout.setHorizontalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInferiorLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInferiorLayout.createSequentialGroup()
                        .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
                            .addGroup(panelInferiorLayout.createSequentialGroup()
                                .addComponent(lfNacimiento3)
                                .addGap(18, 18, 18)
                                .addComponent(cbDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lfNacimiento2)
                                .addGap(18, 18, 18)
                                .addComponent(cbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lfNacimiento1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbAño, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bConsultarVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(24, 24, 24))
                    .addGroup(panelInferiorLayout.createSequentialGroup()
                        .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lEstacion1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelInferiorLayout.createSequentialGroup()
                                .addComponent(bAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(botonGenerarReporteBusesConductores, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 250, Short.MAX_VALUE))))
        );
        panelInferiorLayout.setVerticalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInferiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lEstacion1)
                .addGap(13, 13, 13)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lfNacimiento3)
                    .addComponent(cbDia, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lfNacimiento2)
                    .addComponent(cbMes, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lfNacimiento1)
                    .addComponent(cbAño, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bConsultarVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInferiorLayout.createSequentialGroup()
                        .addComponent(bAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(botonGenerarReporteBusesConductores, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        
        this.dispose();
        ventanaAnterior.setVisible(true);
        ventanaAnterior.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_formWindowClosed

    private void bConsultarVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bConsultarVentasActionPerformed
        String año = (String)cbAño.getSelectedItem();
        String mes = (String)cbMes.getSelectedItem();
        String dia = (String)cbDia.getSelectedItem();

        String fecha = año+"-"+mes+"-"+dia;

        controladorIngRuta.informacionPasajerosPorRutas(tablaMovilidad, fecha);
    }//GEN-LAST:event_bConsultarVentasActionPerformed

    private void bAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAtrasActionPerformed

        this.dispose();
        ventanaAnterior.setVisible(true);
        ventanaAnterior.setLocationRelativeTo(null);

    }//GEN-LAST:event_bAtrasActionPerformed

    private void botonGenerarReporteBusesConductoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGenerarReporteBusesConductoresActionPerformed
        
        Reportes nuevoReporte = new Reportes();
        
        String año = (String)cbAño.getSelectedItem();
        String mes = (String)cbMes.getSelectedItem();
        String dia = (String)cbDia.getSelectedItem();

        String fecha = año+"-"+mes+"-"+dia;
        
        System.out.println(fecha);
        
        nuevoReporte.reporteMovilizacionRutas(usuarioActual.getId(), usuarioActual.getNombre(), fecha);
        
    }//GEN-LAST:event_botonGenerarReporteBusesConductoresActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaMovilidadRutas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaMovilidadRutas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaMovilidadRutas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaMovilidadRutas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaMovilidadRutas(null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAtras;
    private javax.swing.JButton bConsultarVentas;
    private javax.swing.JButton botonGenerarReporteBusesConductores;
    private javax.swing.JComboBox<String> cbAño;
    private javax.swing.JComboBox<String> cbDia;
    private javax.swing.JComboBox<String> cbMes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lEstacion1;
    private javax.swing.JLabel labelEslogan;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JLabel lfNacimiento1;
    private javax.swing.JLabel lfNacimiento2;
    private javax.swing.JLabel lfNacimiento3;
    private javax.swing.JPanel panelInferior;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelSuperior;
    private javax.swing.JTable tablaMovilidad;
    // End of variables declaration//GEN-END:variables
}
