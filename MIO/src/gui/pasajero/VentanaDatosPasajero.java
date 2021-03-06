/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.pasajero;

import accesoDatos.DaoPasajero;
import controlador.*;
import java.awt.event.KeyEvent;
import java.util.*;
import javax.swing.*;
import logica.Pasajero;
import validaciones.Validaciones;

/**
 *
 * @author Joan
 */
public class VentanaDatosPasajero extends javax.swing.JFrame {

    JFrame ventanaAnterior;
    String operacion;
    ControladorPasajero controladorPasajero = new ControladorPasajero();
    ControladorTarjeta controladorTarjeta = new ControladorTarjeta();
    Validaciones validaciones = new Validaciones();
    Pasajero unPasajero;
        
    public VentanaDatosPasajero(JFrame anterior, String operacion) {
        
        super(operacion);
        initComponents();
        
        if (operacion.equals("Modificación de Datos")){
            tfidentificacion.setEnabled(false);           
        }        
        
        ventanaAnterior = anterior;
        setLocationRelativeTo(null);
        
        this.operacion = operacion;          
                    
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
        lPIN = new javax.swing.JLabel();
        tfPIN = new javax.swing.JTextField();
        bValidarPIN = new javax.swing.JButton();
        panelInfo = new javax.swing.JPanel();
        lId = new javax.swing.JLabel();
        lDir = new javax.swing.JLabel();
        lTelefono = new javax.swing.JLabel();
        lfNacimiento = new javax.swing.JLabel();
        lNombre = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        tfidentificacion = new javax.swing.JTextField();
        tfTel = new javax.swing.JTextField();
        tfDir = new javax.swing.JTextField();
        lfNacimiento1 = new javax.swing.JLabel();
        lfNacimiento2 = new javax.swing.JLabel();
        lfNacimiento3 = new javax.swing.JLabel();
        cbDia = new javax.swing.JComboBox<>();
        cbMes = new javax.swing.JComboBox<>();
        cbAño = new javax.swing.JComboBox<>();
        bTerminar = new javax.swing.JButton();
        bLimpiar = new javax.swing.JButton();
        bAtras = new javax.swing.JButton();

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

        javax.swing.GroupLayout panelSuperiorLayout = new javax.swing.GroupLayout(panelSuperior);
        panelSuperior.setLayout(panelSuperiorLayout);
        panelSuperiorLayout.setHorizontalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelEslogan, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addComponent(labelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelInferior.setBackground(new java.awt.Color(0, 97, 147));
        panelInferior.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Realizar Operación", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 3, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        panelInferior.setForeground(new java.awt.Color(255, 255, 255));

        lPIN.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        lPIN.setForeground(new java.awt.Color(255, 255, 255));
        lPIN.setText("Ingrese el PIN de su tarjeta:");

        tfPIN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfPINKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfPINKeyTyped(evt);
            }
        });

        bValidarPIN.setBackground(new java.awt.Color(0, 97, 147));
        bValidarPIN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/general/bValidar.png"))); // NOI18N
        bValidarPIN.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/general/bValidarPR.png"))); // NOI18N
        bValidarPIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bValidarPINActionPerformed(evt);
            }
        });

        panelInfo.setBackground(new java.awt.Color(0, 97, 147));
        panelInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Información Personal", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 3, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        lId.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        lId.setForeground(new java.awt.Color(255, 255, 255));
        lId.setText("Identificación:");

        lDir.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        lDir.setForeground(new java.awt.Color(255, 255, 255));
        lDir.setText("Dirección:");

        lTelefono.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        lTelefono.setForeground(new java.awt.Color(255, 255, 255));
        lTelefono.setText("Teléfono:");

        lfNacimiento.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        lfNacimiento.setForeground(new java.awt.Color(255, 255, 255));
        lfNacimiento.setText("Fecha de Nacimiento:");

        lNombre.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        lNombre.setForeground(new java.awt.Color(255, 255, 255));
        lNombre.setText("Nombre:");

        tfNombre.setEnabled(false);
        tfNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfNombreKeyTyped(evt);
            }
        });

        tfidentificacion.setEnabled(false);
        tfidentificacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfidentificacionKeyTyped(evt);
            }
        });

        tfTel.setEnabled(false);
        tfTel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfTelKeyTyped(evt);
            }
        });

        tfDir.setEnabled(false);
        tfDir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfDirKeyTyped(evt);
            }
        });

        lfNacimiento1.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        lfNacimiento1.setForeground(new java.awt.Color(255, 255, 255));
        lfNacimiento1.setText("Año:");

        lfNacimiento2.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        lfNacimiento2.setForeground(new java.awt.Color(255, 255, 255));
        lfNacimiento2.setText("Mes:");

        lfNacimiento3.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        lfNacimiento3.setForeground(new java.awt.Color(255, 255, 255));
        lfNacimiento3.setText("Día");

        cbDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        cbDia.setEnabled(false);

        cbMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cbMes.setEnabled(false);

        cbAño.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005" }));
        cbAño.setEnabled(false);

        bTerminar.setBackground(new java.awt.Color(0, 97, 147));
        bTerminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/general/bTerminar.png"))); // NOI18N
        bTerminar.setEnabled(false);
        bTerminar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/general/bTerminarPR.png"))); // NOI18N
        bTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTerminarActionPerformed(evt);
            }
        });

        bLimpiar.setBackground(new java.awt.Color(0, 97, 147));
        bLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/general/bLimpiar.png"))); // NOI18N
        bLimpiar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/general/bLimpiarPR.png"))); // NOI18N
        bLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLimpiarActionPerformed(evt);
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

        javax.swing.GroupLayout panelInfoLayout = new javax.swing.GroupLayout(panelInfo);
        panelInfo.setLayout(panelInfoLayout);
        panelInfoLayout.setHorizontalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelInfoLayout.createSequentialGroup()
                        .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelInfoLayout.createSequentialGroup()
                                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lDir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lTelefono, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lId, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                    .addComponent(tfidentificacion)
                                    .addComponent(tfTel)
                                    .addComponent(tfDir)))
                            .addGroup(panelInfoLayout.createSequentialGroup()
                                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lfNacimiento)
                                    .addGroup(panelInfoLayout.createSequentialGroup()
                                        .addComponent(lfNacimiento3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lfNacimiento2)
                                        .addGap(41, 41, 41)
                                        .addComponent(cbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(lfNacimiento1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(14, 14, 14)
                                .addComponent(cbAño, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelInfoLayout.createSequentialGroup()
                        .addComponent(bAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addComponent(bLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(bTerminar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))))
        );
        panelInfoLayout.setVerticalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInfoLayout.createSequentialGroup()
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelInfoLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bTerminar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelInfoLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lId)
                            .addComponent(tfidentificacion))
                        .addGap(18, 18, 18)
                        .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lNombre)
                            .addComponent(tfNombre))
                        .addGap(18, 18, 18)
                        .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfTel)
                            .addComponent(lTelefono))
                        .addGap(18, 18, 18)
                        .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfDir)
                            .addComponent(lDir))
                        .addGap(18, 18, 18)
                        .addComponent(lfNacimiento)
                        .addGap(30, 30, 30)
                        .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lfNacimiento3)
                            .addComponent(cbDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lfNacimiento2)
                                .addComponent(lfNacimiento1)
                                .addComponent(cbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout panelInferiorLayout = new javax.swing.GroupLayout(panelInferior);
        panelInferior.setLayout(panelInferiorLayout);
        panelInferiorLayout.setHorizontalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInferiorLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelInferiorLayout.createSequentialGroup()
                        .addComponent(lPIN)
                        .addGap(23, 23, 23)
                        .addComponent(tfPIN, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(bValidarPIN, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        panelInferiorLayout.setVerticalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInferiorLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(tfPIN, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bValidarPIN, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lPIN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(panelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelInferior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(panelSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelInferior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
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
        
        int cerrar = JOptionPane.showConfirmDialog(null,"Se cancelará la operación actual\n¿Está seguro de que quiere cerrar esta ventana?", "Confirmación de cierre", JOptionPane.YES_NO_OPTION);
        
        if(cerrar == JOptionPane.YES_OPTION){
            this.dispose();
            ventanaAnterior.setVisible(true);
            ventanaAnterior.setLocationRelativeTo(null);
        }
        
    }//GEN-LAST:event_bAtrasActionPerformed

    private void bValidarPINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bValidarPINActionPerformed
        // TODO add your handling code here:
        String pin = tfPIN.getText();
        
        if(!pin.equals("")){ //Se verifica si se va a hacer el proceso de registro o de modificación de datos de un pasajero
            
            if(operacion.equals("Modificación de Datos")){
                //En caso de que se tenga que modificar los datos de un pasajero
                boolean verificacion = controladorTarjeta.validarPinTarjeta(pin, "Modificación");
                if(verificacion){
                    //Se habilitan los campos que se pueden modificar 
                    tfDir.setEnabled(true);
                    tfNombre.setEnabled(true);
                    tfTel.setEnabled(true);
                    cbAño.setEnabled(true);
                    cbDia.setEnabled(true);
                    cbMes.setEnabled(true);
                    bTerminar.setEnabled(true);
                    tfPIN.setEnabled(false);
                    bValidarPIN.setEnabled(false);
                    
                    Pasajero unPasajero = controladorPasajero.obtenerPasajero(pin);
                    
                    //Se pone la info en los tf's correspondientes
                    tfDir.setText(unPasajero.getDireccion());
                    tfNombre.setText(unPasajero.getNombre());
                    tfTel.setText(unPasajero.getTelefono());
                    tfidentificacion.setText(unPasajero.getId());
                    //Se obtiene la fecha
                    StringTokenizer st = new StringTokenizer(unPasajero.getFechaNacimiento(), "-");
                         
                    int dia, mes, año;
                    int i = 0;
                    
                    while(st.hasMoreTokens()){
                        
                        if (i==0){
                            año = Integer.parseInt(st.nextToken());
                            cbAño.setSelectedItem(año+"");
                        }
                        else if(i==1){
                            mes = Integer.parseInt(st.nextToken());
                            cbMes.setSelectedItem(mes+"");
                        }else{
                            dia = Integer.parseInt(st.nextToken());
                            cbDia.setSelectedItem(dia+"");
                        }                      
                        i++;
                    }
                    
                }
                
            }
            else{
                //En caso de que se vaya a personalizar una tarjeta
                
                boolean verificacion = controladorTarjeta.validarPinTarjeta(pin, "Personalización");
            
                if(verificacion){
                    //En caso de que la tarjeta no la tenga nadie, se habilitan los campos para registrar el pasajero
                    tfDir.setEnabled(true);
                    tfNombre.setEnabled(true);
                    tfTel.setEnabled(true);
                    tfidentificacion.setEnabled(true);
                    cbAño.setEnabled(true);
                    cbDia.setEnabled(true);
                    cbMes.setEnabled(true);
                    bTerminar.setEnabled(true);
                    tfPIN.setEnabled(false);
                    bValidarPIN.setEnabled(false);
                }
                else{
                    tfPIN.setText("");
                }
            }
            
            
            
        }
        else{
            JOptionPane.showMessageDialog(null, "Ingrese información válida", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_bValidarPINActionPerformed

    private void bLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLimpiarActionPerformed
        // Vuelve todo como el principio
        limpiarVentana();
    }//GEN-LAST:event_bLimpiarActionPerformed

    private void bTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTerminarActionPerformed
        // Se va a guardar la info del pasajero y la tarjeta
        String identificacion = tfidentificacion.getText();
        String nombre = tfNombre.getText();
        String dir = tfDir.getText();
        String tel = tfTel.getText();
        String dia = cbDia.getSelectedItem().toString();
        String mes = cbMes.getSelectedItem().toString();
        String año = cbAño.getSelectedItem().toString();
        String fechaNac = dia+"/"+mes+"/"+año;
        String pin = tfPIN.getText();
        
        //Se verifica que no se quede nada vacío 
        if(identificacion.equals("") || nombre.equals("") || dir.equals("") || tel.equals("")){
            JOptionPane.showMessageDialog(null, "No deje ningún campo sin llenar", "Error", JOptionPane.WARNING_MESSAGE);
                
        }
        else{
            
            unPasajero = new Pasajero(identificacion, nombre, dir, tel, fechaNac, pin);
            boolean exito;
            
            if(operacion.equals("Modificación de Datos")){
                exito = controladorPasajero.modificarPasajero(unPasajero); 
            }
            else{
                
                exito = controladorPasajero.guardarPasajero(unPasajero);
            }
            
            //En caso de que se haya registrado el pasajero exitosamente 
            if(exito){
                limpiarVentana();
            }
            
        }
        
    }//GEN-LAST:event_bTerminarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
        int cerrar = JOptionPane.showConfirmDialog(null,"Se cancelará la operación actual\n¿Está seguro de que quiere cerrar esta ventana?", "Confirmación de cierre", JOptionPane.YES_NO_OPTION);
        
        if(cerrar == JOptionPane.YES_OPTION){
            this.dispose();
            ventanaAnterior.setVisible(true);
            ventanaAnterior.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_formWindowClosing

    private void tfPINKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPINKeyPressed
        
        char cTeclaPresionada = evt.getKeyChar();
        
        if(cTeclaPresionada == KeyEvent.VK_ENTER){
            bValidarPIN.doClick();
        }
        
    }//GEN-LAST:event_tfPINKeyPressed

    private void tfPINKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPINKeyTyped
        // TODO add your handling code here:
        validaciones.validarNumeros(evt);
        validaciones.validarTamano(tfPIN, evt, 5);
    }//GEN-LAST:event_tfPINKeyTyped

    private void tfidentificacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfidentificacionKeyTyped
        // TODO add your handling code here:
        validaciones.validarTamano(tfidentificacion, evt, 10);
    }//GEN-LAST:event_tfidentificacionKeyTyped

    private void tfNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNombreKeyTyped
        // TODO add your handling code here:
        validaciones.validarTamano(tfNombre, evt, 50);
    }//GEN-LAST:event_tfNombreKeyTyped

    private void tfTelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTelKeyTyped
        // TODO add your handling code here:
        validaciones.validarNumeros(evt);
        validaciones.validarTamano(tfTel, evt, 10);
    }//GEN-LAST:event_tfTelKeyTyped

    private void tfDirKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfDirKeyTyped
        // TODO add your handling code here:
        validaciones.validarTamano(tfDir, evt, 50);
    }//GEN-LAST:event_tfDirKeyTyped

    //Limpia los tf y vuelve enable false o true lo necesario
    public void limpiarVentana(){
        tfDir.setEnabled(false);
        tfDir.setText("");
        tfNombre.setEnabled(false);
        tfNombre.setText("");
        tfTel.setEnabled(false);
        tfTel.setText("");
        tfidentificacion.setEnabled(false);
        tfidentificacion.setText("");
        cbAño.setEnabled(false);
        cbAño.setSelectedItem("1950");
        cbDia.setEnabled(false);
        cbDia.setSelectedItem("1");
        cbMes.setEnabled(false);
        cbMes.setSelectedItem("1");
        bTerminar.setEnabled(false);
        tfPIN.setEnabled(true);
        tfPIN.setText("");
        bValidarPIN.setEnabled(true);
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
            java.util.logging.Logger.getLogger(VentanaDatosPasajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaDatosPasajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaDatosPasajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaDatosPasajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaDatosPasajero(null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAtras;
    private javax.swing.JButton bLimpiar;
    private javax.swing.JButton bTerminar;
    private javax.swing.JButton bValidarPIN;
    private javax.swing.JComboBox<String> cbAño;
    private javax.swing.JComboBox<String> cbDia;
    private javax.swing.JComboBox<String> cbMes;
    private javax.swing.JLabel lDir;
    private javax.swing.JLabel lId;
    private javax.swing.JLabel lNombre;
    private javax.swing.JLabel lPIN;
    private javax.swing.JLabel lTelefono;
    private javax.swing.JLabel labelEslogan;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JLabel lfNacimiento;
    private javax.swing.JLabel lfNacimiento1;
    private javax.swing.JLabel lfNacimiento2;
    private javax.swing.JLabel lfNacimiento3;
    private javax.swing.JPanel panelInferior;
    private javax.swing.JPanel panelInfo;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelSuperior;
    private javax.swing.JTextField tfDir;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JTextField tfPIN;
    private javax.swing.JTextField tfTel;
    private javax.swing.JTextField tfidentificacion;
    // End of variables declaration//GEN-END:variables
}
