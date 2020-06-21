/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.gerente;

import gui.VentanaDatosPersonales;
import gui.VentanaLogin;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import logica.Empleado;

/**
 *
 * @author Joan
 */
public class VentanaGerente extends javax.swing.JFrame {

    JFrame ventanaAnterior;
    Empleado usuarioActual;
        
    public VentanaGerente(JFrame anterior, Empleado empleado) {
        super("Ventana de Gerente");
        initComponents();
        
        usuarioActual = empleado;
        ventanaAnterior = anterior;
        setLocationRelativeTo(null);
        
        lIDusuario.setText("Identificación: " + usuarioActual.getId());
        lNombreUsuario.setText("Nombre: " + usuarioActual.getNombre());
        lCargoUsuario.setText("Cargo: " +usuarioActual.getCargo());
                       
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
        panelDatosTrabajadorVendedor1 = new javax.swing.JPanel();
        lNombreUsuario = new javax.swing.JLabel();
        lIDusuario = new javax.swing.JLabel();
        lCargoUsuario = new javax.swing.JLabel();
        panelInferior = new javax.swing.JPanel();
        bCerrarSesion = new javax.swing.JButton();
        bGestionarEmpleados = new javax.swing.JButton();
        bRutasXpersona = new javax.swing.JButton();
        bListarPasajeros = new javax.swing.JButton();
        bReporteQuejas = new javax.swing.JButton();
        bVentasTarjetas = new javax.swing.JButton();
        bMovilizacionPasajeros = new javax.swing.JButton();
        bListarBusesConductores = new javax.swing.JButton();
        bListarRutas = new javax.swing.JButton();
        bQuejasComunes = new javax.swing.JButton();
        bModificarDatos1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
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
        labelFecha.setText("20/11/2016");

        javax.swing.GroupLayout panelSuperiorLayout = new javax.swing.GroupLayout(panelSuperior);
        panelSuperior.setLayout(panelSuperiorLayout);
        panelSuperiorLayout.setHorizontalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperiorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelEslogan, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelFecha))
                .addGap(36, 36, 36))
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

        panelDatosTrabajadorVendedor1.setBackground(new java.awt.Color(0, 97, 147));
        panelDatosTrabajadorVendedor1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos trabajador", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 3, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        panelDatosTrabajadorVendedor1.setForeground(new java.awt.Color(15, 59, 90));
        panelDatosTrabajadorVendedor1.setPreferredSize(new java.awt.Dimension(275, 22));

        lNombreUsuario.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        lNombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lNombreUsuario.setText("Nombre:");

        lIDusuario.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        lIDusuario.setForeground(new java.awt.Color(255, 255, 255));
        lIDusuario.setText("Identificación:");

        lCargoUsuario.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        lCargoUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lCargoUsuario.setText("Cargo:");

        javax.swing.GroupLayout panelDatosTrabajadorVendedor1Layout = new javax.swing.GroupLayout(panelDatosTrabajadorVendedor1);
        panelDatosTrabajadorVendedor1.setLayout(panelDatosTrabajadorVendedor1Layout);
        panelDatosTrabajadorVendedor1Layout.setHorizontalGroup(
            panelDatosTrabajadorVendedor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosTrabajadorVendedor1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosTrabajadorVendedor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lIDusuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lNombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lCargoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelDatosTrabajadorVendedor1Layout.setVerticalGroup(
            panelDatosTrabajadorVendedor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosTrabajadorVendedor1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lIDusuario)
                .addGap(19, 19, 19)
                .addComponent(lNombreUsuario)
                .addGap(18, 18, 18)
                .addComponent(lCargoUsuario)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        panelInferior.setBackground(new java.awt.Color(0, 97, 147));
        panelInferior.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Seleccione una opción", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 3, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        panelInferior.setForeground(new java.awt.Color(255, 255, 255));

        bCerrarSesion.setBackground(new java.awt.Color(0, 97, 147));
        bCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/bCerrarSesion.png"))); // NOI18N
        bCerrarSesion.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/bCerrarSesionPR.png"))); // NOI18N
        bCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCerrarSesionActionPerformed(evt);
            }
        });

        bGestionarEmpleados.setBackground(new java.awt.Color(0, 97, 147));
        bGestionarEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventanaGerente/bGestionEmpleados.png"))); // NOI18N
        bGestionarEmpleados.setPreferredSize(new java.awt.Dimension(207, 34));
        bGestionarEmpleados.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventanaGerente/bGestionEmpleadosPR.png"))); // NOI18N
        bGestionarEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGestionarEmpleadosActionPerformed(evt);
            }
        });

        bRutasXpersona.setBackground(new java.awt.Color(0, 97, 147));
        bRutasXpersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventanaGerente/bRutasPersona.png"))); // NOI18N
        bRutasXpersona.setPreferredSize(new java.awt.Dimension(207, 34));
        bRutasXpersona.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventanaGerente/bRutasPersonaPR.png"))); // NOI18N
        bRutasXpersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRutasXpersonaActionPerformed(evt);
            }
        });

        bListarPasajeros.setBackground(new java.awt.Color(0, 97, 147));
        bListarPasajeros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventanaGerente/bListarPasajeros.png"))); // NOI18N
        bListarPasajeros.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventanaGerente/bListarPasajerosPR.png"))); // NOI18N
        bListarPasajeros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bListarPasajerosActionPerformed(evt);
            }
        });

        bReporteQuejas.setBackground(new java.awt.Color(0, 97, 147));
        bReporteQuejas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventanaGerente/bReporteQuejas.png"))); // NOI18N
        bReporteQuejas.setPreferredSize(new java.awt.Dimension(207, 34));
        bReporteQuejas.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventanaGerente/bReporteQuejasPR.png"))); // NOI18N
        bReporteQuejas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bReporteQuejasActionPerformed(evt);
            }
        });

        bVentasTarjetas.setBackground(new java.awt.Color(0, 97, 147));
        bVentasTarjetas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventanaGerente/bReporteTarjetasVendidas.png"))); // NOI18N
        bVentasTarjetas.setPreferredSize(new java.awt.Dimension(234, 34));
        bVentasTarjetas.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventanaGerente/bReporteTarjetasVendidasPR.png"))); // NOI18N
        bVentasTarjetas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVentasTarjetasActionPerformed(evt);
            }
        });

        bMovilizacionPasajeros.setBackground(new java.awt.Color(0, 97, 147));
        bMovilizacionPasajeros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventanaGerente/bReportePasajerosM.png"))); // NOI18N
        bMovilizacionPasajeros.setPreferredSize(new java.awt.Dimension(269, 34));
        bMovilizacionPasajeros.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventanaGerente/bReportePasajerosMPR.png"))); // NOI18N
        bMovilizacionPasajeros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMovilizacionPasajerosActionPerformed(evt);
            }
        });

        bListarBusesConductores.setBackground(new java.awt.Color(0, 97, 147));
        bListarBusesConductores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventanaGerente/blistarBusesConductores.png"))); // NOI18N
        bListarBusesConductores.setPreferredSize(new java.awt.Dimension(207, 34));
        bListarBusesConductores.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventanaGerente/blistarBusesConductoresPR.png"))); // NOI18N
        bListarBusesConductores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bListarBusesConductoresActionPerformed(evt);
            }
        });

        bListarRutas.setBackground(new java.awt.Color(0, 97, 147));
        bListarRutas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventanaGerente/bListarRutas.png"))); // NOI18N
        bListarRutas.setPreferredSize(new java.awt.Dimension(207, 34));
        bListarRutas.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventanaGerente/bListarRutasPR.png"))); // NOI18N
        bListarRutas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bListarRutasActionPerformed(evt);
            }
        });

        bQuejasComunes.setBackground(new java.awt.Color(0, 97, 147));
        bQuejasComunes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventanaGerente/bQuejasComunes.png"))); // NOI18N
        bQuejasComunes.setPreferredSize(new java.awt.Dimension(207, 34));
        bQuejasComunes.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventanaGerente/bQuejasComunesPR.png"))); // NOI18N
        bQuejasComunes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bQuejasComunesActionPerformed(evt);
            }
        });

        bModificarDatos1.setBackground(new java.awt.Color(0, 97, 147));
        bModificarDatos1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/bMisDatos.png"))); // NOI18N
        bModificarDatos1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/bMisDatosPR.png"))); // NOI18N
        bModificarDatos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModificarDatos1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelInferiorLayout = new javax.swing.GroupLayout(panelInferior);
        panelInferior.setLayout(panelInferiorLayout);
        panelInferiorLayout.setHorizontalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInferiorLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInferiorLayout.createSequentialGroup()
                        .addComponent(bCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(bModificarDatos1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(panelInferiorLayout.createSequentialGroup()
                        .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bRutasXpersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bVentasTarjetas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bGestionarEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelInferiorLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelInferiorLayout.createSequentialGroup()
                                        .addComponent(bListarBusesConductores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(53, 53, 53))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInferiorLayout.createSequentialGroup()
                                        .addComponent(bListarRutas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(67, 67, 67)))
                                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bReporteQuejas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bListarPasajeros, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29))
                            .addGroup(panelInferiorLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(bMovilizacionPasajeros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(bQuejasComunes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(28, Short.MAX_VALUE))))))
        );
        panelInferiorLayout.setVerticalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInferiorLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bGestionarEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bListarRutas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bReporteQuejas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bListarPasajeros, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bRutasXpersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bListarBusesConductores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bMovilizacionPasajeros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bVentasTarjetas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bQuejasComunes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bModificarDatos1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelInferior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(panelSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelDatosTrabajadorVendedor1, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelDatosTrabajadorVendedor1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
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

    private void bCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCerrarSesionActionPerformed
        
        int cerrar = JOptionPane.showConfirmDialog(null,"¿Está seguro de que quiere cerrar sesión?", "Confirmación de cierre de sesión", JOptionPane.YES_NO_OPTION);
        
        if(cerrar == JOptionPane.YES_OPTION){
            this.dispose();
            ventanaAnterior.setVisible(true);
            ventanaAnterior.setLocationRelativeTo(null);
            
            VentanaLogin ventana = (VentanaLogin) ventanaAnterior;
            ventana.limpiarCampos();
        }
        
    }//GEN-LAST:event_bCerrarSesionActionPerformed

    private void bGestionarEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGestionarEmpleadosActionPerformed
        
        VentanaVisualizacionEmpleados vVisualizarEmpleados = new VentanaVisualizacionEmpleados(this, usuarioActual);
        vVisualizarEmpleados.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_bGestionarEmpleadosActionPerformed

    private void bListarRutasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bListarRutasActionPerformed
        
        VentanaVisualizacionRutas vVisualizarRutas = new VentanaVisualizacionRutas(this, usuarioActual);
        vVisualizarRutas.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_bListarRutasActionPerformed

    private void bReporteQuejasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bReporteQuejasActionPerformed
        
        VentanaReporteQuejas vQuejas = new VentanaReporteQuejas(this);
        vQuejas.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_bReporteQuejasActionPerformed

    private void bRutasXpersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRutasXpersonaActionPerformed
        
        VentanaRutasPersona vRutasPersona = new VentanaRutasPersona(this);
        vRutasPersona.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_bRutasXpersonaActionPerformed

    private void bListarBusesConductoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bListarBusesConductoresActionPerformed
        
        VentanaBusesConductores vBusesConductores = new VentanaBusesConductores(this);
        vBusesConductores.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_bListarBusesConductoresActionPerformed

    private void bListarPasajerosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bListarPasajerosActionPerformed
         
        VentanaVisualizarPasajeros vPasajeros = new VentanaVisualizarPasajeros(this);
        vPasajeros.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_bListarPasajerosActionPerformed

    private void bVentasTarjetasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVentasTarjetasActionPerformed
        
        VentanaVentasTarjetas vVentas = new VentanaVentasTarjetas(this);
        vVentas.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_bVentasTarjetasActionPerformed

    private void bMovilizacionPasajerosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMovilizacionPasajerosActionPerformed
        
        VentanaMovilidadRutas vMovilidad = new VentanaMovilidadRutas(this, usuarioActual);
        vMovilidad.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_bMovilizacionPasajerosActionPerformed

    private void bQuejasComunesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bQuejasComunesActionPerformed
        
        VentanaQuejasComunes vQuejasComunes = new VentanaQuejasComunes(this);
        vQuejasComunes.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_bQuejasComunesActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
        int cerrar = JOptionPane.showConfirmDialog(null,"¿Está seguro de que quiere cerrar sesión?", "Confirmación de cierre de sesión", JOptionPane.YES_NO_OPTION);
        
        if(cerrar == JOptionPane.YES_OPTION){
            this.dispose();
            ventanaAnterior.setVisible(true);
            ventanaAnterior.setLocationRelativeTo(null);
            
            VentanaLogin ventana = (VentanaLogin) ventanaAnterior;
            ventana.limpiarCampos();
        }
        
    }//GEN-LAST:event_formWindowClosing

    private void bModificarDatos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModificarDatos1ActionPerformed

        VentanaDatosPersonales vDatos = new VentanaDatosPersonales(this, usuarioActual);
        vDatos.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bModificarDatos1ActionPerformed

    /*
    Este método se encarga de actualizar los datos del usuarioActual después de modificarlos en VentanaDatosPersonales
    */
    public void actualizarDatos(ArrayList<String> info){
        
        String telefono = info.get(0);
        String dir = info.get(1);
        String pwd = info.get(2);
        
        usuarioActual.setDireccion(dir);
        usuarioActual.setTelefono(telefono);
        usuarioActual.setPassword(pwd);
        
    }    
    
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
            java.util.logging.Logger.getLogger(VentanaGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaGerente(null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCerrarSesion;
    private javax.swing.JButton bGestionarEmpleados;
    private javax.swing.JButton bListarBusesConductores;
    private javax.swing.JButton bListarPasajeros;
    private javax.swing.JButton bListarRutas;
    private javax.swing.JButton bModificarDatos1;
    private javax.swing.JButton bMovilizacionPasajeros;
    private javax.swing.JButton bQuejasComunes;
    private javax.swing.JButton bReporteQuejas;
    private javax.swing.JButton bRutasXpersona;
    private javax.swing.JButton bVentasTarjetas;
    public javax.swing.JLabel lCargoUsuario;
    public javax.swing.JLabel lIDusuario;
    public javax.swing.JLabel lNombreUsuario;
    private javax.swing.JLabel labelEslogan;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JPanel panelDatosTrabajadorVendedor1;
    private javax.swing.JPanel panelInferior;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelSuperior;
    // End of variables declaration//GEN-END:variables
}