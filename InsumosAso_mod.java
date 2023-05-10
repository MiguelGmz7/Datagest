/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.app;

import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author oscar
 */
public class InsumosAso_mod extends javax.swing.JFrame {
    int Xmouse, Ymouse;
    private int registro, maquina, insumo, cantidad;
    private boolean activo;
    /**
     * Creates new form Clientes
     */
    public InsumosAso_mod() throws SQLException {
        initComponents();
        setCombo();
    }
    
    public void setParam(String registro, String insumo, String cantidad, String activo) throws SQLException{
        this.registro = Integer.parseInt(registro);
        
        String sql = "select material_id from insumos_en_stock where nombre = '"+insumo+"';";
        Cconexion conexion = new Cconexion();
        java.sql.Statement st = conexion.EstablecerConexion().createStatement();
        java.sql.ResultSet rs = st.executeQuery(sql);
        int nombre = 0;
        while(rs.next())
            nombre = rs.getInt(1);
        this.insumo = nombre;
        Materiales.setSelectedItem(insumo);
        
        this.cantidad = Integer.parseInt(cantidad);
        proporcion.setText(cantidad);
        
        if(activo.equals("t")) {
            this.activo = true;
        } else {
            this.activo = false;
        }
        
        Act_rb.setSelected(this.activo);
    }
    
    public void setMaquina(int maquina) throws SQLException{
        this.maquina = maquina;
        
        String nombre = null;
        
        Cconexion conexion = new Cconexion();
        String sql = "select nombre from maquinas where id = "+maquina+";";
        java.sql.Statement st = conexion.EstablecerConexion().createStatement();
        java.sql.ResultSet rs = st.executeQuery(sql);
        
        
        while(rs.next())
            nombre = rs.getString("nombre");
        
        id.setText(nombre);
    }
    
    private void setCombo() throws SQLException{
        Cconexion conexion = new Cconexion();
        
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        
        String lista = "select nombre from insumos_en_stock;";
        
        java.sql.Statement st = conexion.EstablecerConexion().createStatement();
        
        String datos;
        
        
        java.sql.ResultSet rs = st.executeQuery(lista);
        
        while(rs.next()){
            datos = rs.getString("nombre");
            modelo.addElement(datos);
        }
        
        Materiales.setModel(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        selector = new javax.swing.JPanel();
        exit_panel = new javax.swing.JPanel();
        exit_label = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        label_c1 = new javax.swing.JLabel();
        proporcion = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        label_c4 = new javax.swing.JLabel();
        Act_rb = new javax.swing.JRadioButton();
        panel_login = new javax.swing.JPanel();
        login_btm2 = new javax.swing.JLabel();
        panel_reset = new javax.swing.JPanel();
        reset_btm = new javax.swing.JLabel();
        panel_reset1 = new javax.swing.JPanel();
        reset_btm3 = new javax.swing.JLabel();
        Materiales = new javax.swing.JComboBox<>();
        label_c2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);

        Fondo.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));

        selector.setOpaque(false);
        selector.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                selectorMouseDragged(evt);
            }
        });
        selector.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                selectorMousePressed(evt);
            }
        });

        exit_panel.setBackground(new java.awt.Color(255, 102, 102));
        exit_panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exit_panelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exit_panelMouseExited(evt);
            }
        });

        exit_label.setBackground(new java.awt.Color(255, 102, 102));
        exit_label.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        exit_label.setForeground(new java.awt.Color(255, 255, 255));
        exit_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exit_label.setText("X");
        exit_label.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exit_label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exit_labelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exit_labelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exit_labelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout exit_panelLayout = new javax.swing.GroupLayout(exit_panel);
        exit_panel.setLayout(exit_panelLayout);
        exit_panelLayout.setHorizontalGroup(
            exit_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exit_label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        exit_panelLayout.setVerticalGroup(
            exit_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exit_label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Roboto Black", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Modificar Maquina");

        id.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        id.setForeground(new java.awt.Color(255, 255, 255));
        id.setText("jLabel2");

        javax.swing.GroupLayout selectorLayout = new javax.swing.GroupLayout(selector);
        selector.setLayout(selectorLayout);
        selectorLayout.setHorizontalGroup(
            selectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selectorLayout.createSequentialGroup()
                .addComponent(exit_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(selectorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(selectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(selectorLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        selectorLayout.setVerticalGroup(
            selectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selectorLayout.createSequentialGroup()
                .addComponent(exit_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(selector, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(selector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        label_c1.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        label_c1.setText("Proporción");

        proporcion.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        proporcion.setBorder(null);
        proporcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proporcionActionPerformed(evt);
            }
        });

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        label_c4.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        label_c4.setText("Activo");

        Act_rb.setBackground(new java.awt.Color(255, 255, 255));
        Act_rb.setText("jRadioButton1");
        Act_rb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Act_rbActionPerformed(evt);
            }
        });

        panel_login.setBackground(new java.awt.Color(246, 150, 143));
        panel_login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_loginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel_loginMouseExited(evt);
            }
        });

        login_btm2.setBackground(new java.awt.Color(247, 199, 196));
        login_btm2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        login_btm2.setForeground(new java.awt.Color(249, 249, 249));
        login_btm2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        login_btm2.setText("ACEPTAR");
        login_btm2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        login_btm2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                login_btm2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                login_btm2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                login_btm2MouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_loginLayout = new javax.swing.GroupLayout(panel_login);
        panel_login.setLayout(panel_loginLayout);
        panel_loginLayout.setHorizontalGroup(
            panel_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_loginLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(login_btm2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panel_loginLayout.setVerticalGroup(
            panel_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_loginLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(login_btm2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panel_reset.setBackground(new java.awt.Color(246, 150, 143));
        panel_reset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_resetMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel_resetMouseExited(evt);
            }
        });

        reset_btm.setBackground(new java.awt.Color(247, 199, 196));
        reset_btm.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        reset_btm.setForeground(new java.awt.Color(249, 249, 249));
        reset_btm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        reset_btm.setText("RESET");
        reset_btm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reset_btm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reset_btmMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                reset_btmMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                reset_btmMouseExited(evt);
            }
        });

        panel_reset1.setBackground(new java.awt.Color(246, 150, 143));
        panel_reset1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_reset1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel_reset1MouseExited(evt);
            }
        });

        reset_btm3.setBackground(new java.awt.Color(247, 199, 196));
        reset_btm3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        reset_btm3.setForeground(new java.awt.Color(249, 249, 249));
        reset_btm3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        reset_btm3.setText("RESET");
        reset_btm3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reset_btm3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reset_btm3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                reset_btm3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                reset_btm3MouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_reset1Layout = new javax.swing.GroupLayout(panel_reset1);
        panel_reset1.setLayout(panel_reset1Layout);
        panel_reset1Layout.setHorizontalGroup(
            panel_reset1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 122, Short.MAX_VALUE)
            .addGroup(panel_reset1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel_reset1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(reset_btm3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        panel_reset1Layout.setVerticalGroup(
            panel_reset1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
            .addGroup(panel_reset1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel_reset1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(reset_btm3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout panel_resetLayout = new javax.swing.GroupLayout(panel_reset);
        panel_reset.setLayout(panel_resetLayout);
        panel_resetLayout.setHorizontalGroup(
            panel_resetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_resetLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(reset_btm, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panel_resetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel_resetLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panel_reset1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        panel_resetLayout.setVerticalGroup(
            panel_resetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_resetLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(reset_btm, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panel_resetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel_resetLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panel_reset1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        Materiales.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Materiales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaterialesActionPerformed(evt);
            }
        });

        label_c2.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        label_c2.setText("Material");

        javax.swing.GroupLayout FondoLayout = new javax.swing.GroupLayout(Fondo);
        Fondo.setLayout(FondoLayout);
        FondoLayout.setHorizontalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(FondoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Materiales, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_c2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(label_c1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addComponent(proporcion, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_c4)
                    .addComponent(Act_rb, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(FondoLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(panel_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(panel_reset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_c1)
                    .addComponent(label_c4)
                    .addComponent(label_c2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(proporcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Act_rb)
                    .addComponent(Materiales, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel_reset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void proporcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proporcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_proporcionActionPerformed

    private void Act_rbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Act_rbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Act_rbActionPerformed

    private void login_btm2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login_btm2MouseClicked

        try {
            new Cmaquinas().insumoModificar(registro, Materiales, proporcion, Act_rb);
            setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(InsumosAso_mod.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_login_btm2MouseClicked

    private void login_btm2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login_btm2MouseEntered
        panel_login.setBackground(Color.decode("#f5655a"));
    }//GEN-LAST:event_login_btm2MouseEntered

    private void login_btm2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login_btm2MouseExited
        panel_login.setBackground(Color.decode("#f6968f"));
    }//GEN-LAST:event_login_btm2MouseExited

    private void panel_loginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_loginMouseEntered
        panel_login.setBackground(Color.decode("#f5655a"));
    }//GEN-LAST:event_panel_loginMouseEntered

    private void panel_loginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_loginMouseExited
        panel_login.setBackground(Color.decode("#f6968f"));
    }//GEN-LAST:event_panel_loginMouseExited

    private void exit_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_labelMouseClicked
        setVisible(false);
    }//GEN-LAST:event_exit_labelMouseClicked

    private void exit_labelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_labelMouseEntered
        exit_panel.setBackground(Color.red);
    }//GEN-LAST:event_exit_labelMouseEntered

    private void exit_labelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_labelMouseExited

        exit_panel.setBackground(Color.decode("#ff6666"));
    }//GEN-LAST:event_exit_labelMouseExited

    private void exit_panelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_panelMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_exit_panelMouseEntered

    private void exit_panelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_panelMouseExited
        exit_panel.setBackground(Color.black);
    }//GEN-LAST:event_exit_panelMouseExited

    private void selectorMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectorMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - Xmouse, y - Ymouse);
    }//GEN-LAST:event_selectorMouseDragged

    private void selectorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectorMousePressed
        Xmouse = evt.getX();
        Ymouse = evt.getY();

    }//GEN-LAST:event_selectorMousePressed

    private void MaterialesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaterialesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MaterialesActionPerformed

    private void panel_resetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_resetMouseExited
        panel_reset.setBackground(Color.decode("#f6968f"));
    }//GEN-LAST:event_panel_resetMouseExited

    private void panel_resetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_resetMouseEntered
        panel_reset.setBackground(Color.decode("#f5655a"));
    }//GEN-LAST:event_panel_resetMouseEntered

    private void panel_reset1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_reset1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_panel_reset1MouseExited

    private void panel_reset1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_reset1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_panel_reset1MouseEntered

    private void reset_btm3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reset_btm3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_reset_btm3MouseExited

    private void reset_btm3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reset_btm3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_reset_btm3MouseEntered

    private void reset_btm3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reset_btm3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_reset_btm3MouseClicked

    private void reset_btmMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reset_btmMouseExited
        panel_reset.setBackground(Color.decode("#f6968f"));
    }//GEN-LAST:event_reset_btmMouseExited

    private void reset_btmMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reset_btmMouseEntered
        panel_reset.setBackground(Color.decode("#f5655a"));
    }//GEN-LAST:event_reset_btmMouseEntered

    private void reset_btmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reset_btmMouseClicked
        //Nombre_field.setText(null);
        proporcion.setText(null);
        Act_rb.setSelected(false);
    }//GEN-LAST:event_reset_btmMouseClicked

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
            java.util.logging.Logger.getLogger(InsumosAso_mod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InsumosAso_mod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InsumosAso_mod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InsumosAso_mod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new InsumosAso_mod().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(InsumosAso_mod.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Act_rb;
    private javax.swing.JPanel Fondo;
    private javax.swing.JComboBox<String> Materiales;
    private javax.swing.JLabel exit_label;
    private javax.swing.JPanel exit_panel;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel label_c1;
    private javax.swing.JLabel label_c2;
    private javax.swing.JLabel label_c4;
    private javax.swing.JLabel login_btm2;
    private javax.swing.JPanel panel_login;
    private javax.swing.JPanel panel_reset;
    private javax.swing.JPanel panel_reset1;
    private javax.swing.JTextField proporcion;
    private javax.swing.JLabel reset_btm;
    private javax.swing.JLabel reset_btm3;
    private javax.swing.JPanel selector;
    // End of variables declaration//GEN-END:variables
}
