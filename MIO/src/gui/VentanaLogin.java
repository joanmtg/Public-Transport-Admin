/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.sun.javafx.runtime.SystemProperties;
import controlador.ControladorEmpleado;
import controlador.ControladorEstacion;
import gui.auxiliar.*;
import gui.conductor.VentanaConductor;
import gui.directorEstacion.VentanaDirectorEstacion;
import gui.directorOperativo.VentanaDirectorOperativo;
import java.awt.event.KeyEvent;
import java.util.*;
import javax.swing.*;
import gui.gerente.*;
import logica.*;
import validaciones.Validaciones;

/**
 *
 * @author Joan
 */
public class VentanaLogin extends javax.swing.JFrame {

    JFrame ventanaAnterior;
    ControladorEmpleado controladorEmpleado = new ControladorEmpleado();
    ControladorEstacion controladorEstacion = new ControladorEstacion();
    Validaciones validaciones = new Validaciones();

    public VentanaLogin(JFrame anterior) {
        super("Acceso al sistema");
        initComponents();
        tfUser.setText("");
        pfContraseña.setText("");
        lInfoIngreso.setText("");

        setLocationRelativeTo(null);

        ventanaAnterior = anterior;

        Calendar fecha = Calendar.getInstance();

        int dia, mes, año;
        dia = fecha.get(Calendar.DATE);
        mes = fecha.get(Calendar.MONTH) + 1;
        año = fecha.get(Calendar.YEAR);

        labelFecha.setText(dia + "/" + mes + "/" + año);
    }

    public void limpiarCampos() {
        tfUser.setText("");
        pfContraseña.setText("");
        lInfoIngreso.setText("   ");
        tfUser.grabFocus();
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
        lUsuario = new javax.swing.JLabel();
        lPass = new javax.swing.JLabel();
        tfUser = new javax.swing.JTextField();
        lUser = new javax.swing.JLabel();
        lpass = new javax.swing.JLabel();
        bIngresarSistema = new javax.swing.JButton();
        separador = new javax.swing.JSeparator();
        lInfoIngreso = new javax.swing.JLabel();
        bOlvidoContraseña = new javax.swing.JButton();
        pfContraseña = new javax.swing.JPasswordField();
        lInfoIngreso2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelEslogan, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelFecha))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        panelInferior.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Acceso al sistema", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 3, 20), new java.awt.Color(255, 255, 255))); // NOI18N
        panelInferior.setForeground(new java.awt.Color(255, 255, 255));

        lUsuario.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        lUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lUsuario.setText("USUARIO");

        lPass.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        lPass.setForeground(new java.awt.Color(255, 255, 255));
        lPass.setText("CONTRASEÑA");

        tfUser.setCaretColor(new java.awt.Color(221, 13, 39));
        tfUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfUserKeyTyped(evt);
            }
        });

        lUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventanaLogin/user.png"))); // NOI18N

        lpass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventanaLogin/pass.png"))); // NOI18N

        bIngresarSistema.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventanaLogin/bIngresarSistema.png"))); // NOI18N
        bIngresarSistema.setPreferredSize(new java.awt.Dimension(104, 34));
        bIngresarSistema.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventanaLogin/bIngresarSistemaPR.png"))); // NOI18N
        bIngresarSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bIngresarSistemaActionPerformed(evt);
            }
        });

        lInfoIngreso.setBackground(new java.awt.Color(0, 97, 147));
        lInfoIngreso.setDisplayedMnemonic(' ');
        lInfoIngreso.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        lInfoIngreso.setForeground(new java.awt.Color(255, 255, 255));
        lInfoIngreso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lInfoIngreso.setText("    ");

        bOlvidoContraseña.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventanaLogin/bOlvidoContrasena.png"))); // NOI18N
        bOlvidoContraseña.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventanaLogin/bOlvidoContrasenaPR.png"))); // NOI18N
        bOlvidoContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOlvidoContraseñaActionPerformed(evt);
            }
        });

        pfContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pfContraseñaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pfContraseñaKeyTyped(evt);
            }
        });

        lInfoIngreso2.setBackground(new java.awt.Color(0, 97, 147));
        lInfoIngreso2.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        lInfoIngreso2.setForeground(new java.awt.Color(255, 255, 255));
        lInfoIngreso2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelInferiorLayout = new javax.swing.GroupLayout(panelInferior);
        panelInferior.setLayout(panelInferiorLayout);
        panelInferiorLayout.setHorizontalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInferiorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInferiorLayout.createSequentialGroup()
                        .addComponent(lUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(167, 167, 167))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInferiorLayout.createSequentialGroup()
                        .addComponent(lPass)
                        .addGap(160, 160, 160))))
            .addGroup(panelInferiorLayout.createSequentialGroup()
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelInferiorLayout.createSequentialGroup()
                        .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelInferiorLayout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addComponent(lUser))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInferiorLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lpass)))
                        .addGap(18, 18, 18)
                        .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfUser, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                            .addComponent(pfContraseña)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelInferiorLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInferiorLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInferiorLayout.createSequentialGroup()
                        .addComponent(bIngresarSistema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(152, 152, 152))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInferiorLayout.createSequentialGroup()
                        .addComponent(bOlvidoContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78))))
            .addComponent(lInfoIngreso2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lInfoIngreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelInferiorLayout.setVerticalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInferiorLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lUser)
                    .addComponent(tfUser, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(lPass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pfContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lpass))
                .addGap(30, 30, 30)
                .addComponent(bIngresarSistema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lInfoIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lInfoIngreso2, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bOlvidoContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelInferior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, 445, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
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
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bOlvidoContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOlvidoContraseñaActionPerformed

        lInfoIngreso.setText("Tu contraseña es codigo - año de nacimiento");
        lInfoIngreso2.setText("Ejemplo: 12340-1990");

    }//GEN-LAST:event_bOlvidoContraseñaActionPerformed

    private void pfContraseñaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pfContraseñaKeyPressed

        char cTeclaPresionada = evt.getKeyChar();

        if (cTeclaPresionada == KeyEvent.VK_ENTER) {
            bIngresarSistema.doClick();
        }


    }//GEN-LAST:event_pfContraseñaKeyPressed

    private void bIngresarSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bIngresarSistemaActionPerformed

        String idEmpleado = tfUser.getText();
        String password = pfContraseña.getText();

        if (idEmpleado.equals("") || idEmpleado.equals("")) {

            lInfoIngreso.setText("Debe ingresar su usuario y contraseña");
        } else {

            Empleado empleado = controladorEmpleado.verificarLogin(idEmpleado, password, lInfoIngreso);

            if (empleado != null) {
                String cargo = empleado.getCargo();

                System.out.println(cargo);

                if (cargo.equals("Gerente")) {

                    VentanaGerente vGerente = new VentanaGerente(this, empleado);
                    vGerente.setVisible(true);
                    this.setVisible(false);

                } else if (cargo.equals("Director Operativo")) {
                    VentanaDirectorOperativo vDirectorOP = new VentanaDirectorOperativo(this, empleado);
                    vDirectorOP.setVisible(true);
                    this.setVisible(false);

                } else if (cargo.equals("Director de Estacion")) {
                    //Obtenemos la estación del director
                    Estacion estacion = controladorEstacion.obtenerEstacion(idEmpleado);

                    if (estacion != null) {
                        //Mandar la estación correspondiente el directorr como último parámetro
                        VentanaDirectorEstacion vDirectorEst = new VentanaDirectorEstacion(this, empleado, estacion);
                        vDirectorEst.setVisible(true);
                        this.setVisible(false);
                    }

                } else if (cargo.equals("Conductor")) {

                    VentanaConductor vConductor = new VentanaConductor(this, empleado);
                    vConductor.setVisible(true);
                    this.setVisible(false);

                } else {

                    VentanaAuxiliar vAuxiliar = new VentanaAuxiliar(this, empleado);
                    vAuxiliar.setVisible(true);
                    this.setVisible(false);

                }
            }
        }


    }//GEN-LAST:event_bIngresarSistemaActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

        this.dispose();
        ventanaAnterior.setEnabled(true);
        ventanaAnterior.setVisible(true);
        ventanaAnterior.setLocationRelativeTo(null);

    }//GEN-LAST:event_formWindowClosed

    private void tfUserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfUserKeyTyped
        // Se hacen las validaciones correspondientes 
        validaciones.validarTamano(tfUser, evt, 10);
        validaciones.validarNumeros(evt);
        
    }//GEN-LAST:event_tfUserKeyTyped

    private void pfContraseñaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pfContraseñaKeyTyped
        // TODO add your handling code here:
        validaciones.validarTamano(pfContraseña, evt, 20);
        
    }//GEN-LAST:event_pfContraseñaKeyTyped

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
            java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaLogin(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bIngresarSistema;
    private javax.swing.JButton bOlvidoContraseña;
    private javax.swing.JLabel lInfoIngreso;
    private javax.swing.JLabel lInfoIngreso2;
    private javax.swing.JLabel lPass;
    private javax.swing.JLabel lUser;
    private javax.swing.JLabel lUsuario;
    private javax.swing.JLabel labelEslogan;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JLabel lpass;
    private javax.swing.JPanel panelInferior;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelSuperior;
    private javax.swing.JPasswordField pfContraseña;
    private javax.swing.JSeparator separador;
    private javax.swing.JTextField tfUser;
    // End of variables declaration//GEN-END:variables
}