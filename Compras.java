/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.app;

import java.awt.Color;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oscar
 */
public class Compras extends javax.swing.JFrame {

    compras_mod mod;
    compras_ins_plus ins;
    Ccompras view;
    compras_mod_plus modp;
    
/**
     * Creates new form Compras
     */
        private boolean material = false;
    private int Xmouse;
    private int Ymouse;
    public Compras() throws SQLException {
        this.mod = new compras_mod();
        this.ins = new compras_ins_plus();
        this.view = new Ccompras();
        this.modp = new compras_mod_plus();
        initComponents();
        new Ccompras().mostrarCompras(Tb_clientes5);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel16 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        Tb_clientes5 = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        panel_login20 = new javax.swing.JPanel();
        login_btm22 = new javax.swing.JLabel();
        panel_login21 = new javax.swing.JPanel();
        login_btm23 = new javax.swing.JLabel();
        panel_login22 = new javax.swing.JPanel();
        login_btm24 = new javax.swing.JLabel();
        Campo_combo5 = new javax.swing.JComboBox<>();
        Registro_field5 = new javax.swing.JTextField();
        panel_login23 = new javax.swing.JPanel();
        Modificar = new javax.swing.JLabel();
        panel_login24 = new javax.swing.JPanel();
        Materiales = new javax.swing.JLabel();
        selector = new javax.swing.JPanel();
        exit_panel = new javax.swing.JPanel();
        exit_label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel16.setBackground(new java.awt.Color(245, 101, 90));

        Tb_clientes5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        Tb_clientes5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tb_clientes5MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(Tb_clientes5);

        jLabel14.setFont(new java.awt.Font("Roboto", 0, 48)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Compras");

        panel_login20.setBackground(new java.awt.Color(246, 150, 143));
        panel_login20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_login20MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel_login20MouseExited(evt);
            }
        });

        login_btm22.setBackground(new java.awt.Color(247, 199, 196));
        login_btm22.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        login_btm22.setForeground(new java.awt.Color(249, 249, 249));
        login_btm22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        login_btm22.setText("INSERTAR");
        login_btm22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        login_btm22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                login_btm22MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                login_btm22MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                login_btm22MouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_login20Layout = new javax.swing.GroupLayout(panel_login20);
        panel_login20.setLayout(panel_login20Layout);
        panel_login20Layout.setHorizontalGroup(
            panel_login20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_login20Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(login_btm22, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panel_login20Layout.setVerticalGroup(
            panel_login20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_login20Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(login_btm22, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panel_login21.setBackground(new java.awt.Color(246, 150, 143));
        panel_login21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_login21MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel_login21MouseExited(evt);
            }
        });

        login_btm23.setBackground(new java.awt.Color(247, 199, 196));
        login_btm23.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        login_btm23.setForeground(new java.awt.Color(249, 249, 249));
        login_btm23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        login_btm23.setText("RECARGAR");
        login_btm23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        login_btm23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                login_btm23MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                login_btm23MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                login_btm23MouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_login21Layout = new javax.swing.GroupLayout(panel_login21);
        panel_login21.setLayout(panel_login21Layout);
        panel_login21Layout.setHorizontalGroup(
            panel_login21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(login_btm23, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
        );
        panel_login21Layout.setVerticalGroup(
            panel_login21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_login21Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(login_btm23, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panel_login22.setBackground(new java.awt.Color(246, 150, 143));
        panel_login22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_login22MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel_login22MouseExited(evt);
            }
        });

        login_btm24.setBackground(new java.awt.Color(247, 199, 196));
        login_btm24.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        login_btm24.setForeground(new java.awt.Color(249, 249, 249));
        login_btm24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        login_btm24.setText("BUSCAR");
        login_btm24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        login_btm24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                login_btm24MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                login_btm24MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                login_btm24MouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_login22Layout = new javax.swing.GroupLayout(panel_login22);
        panel_login22.setLayout(panel_login22Layout);
        panel_login22Layout.setHorizontalGroup(
            panel_login22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_login22Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(login_btm24, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panel_login22Layout.setVerticalGroup(
            panel_login22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_login22Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(login_btm24, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Campo_combo5.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        Campo_combo5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "id", "fecha", "provedor", "materiales" }));
        Campo_combo5.setToolTipText("");
        Campo_combo5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Campo_combo5ActionPerformed(evt);
            }
        });

        Registro_field5.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        Registro_field5.setBorder(null);

        panel_login23.setBackground(new java.awt.Color(246, 150, 143));
        panel_login23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_login23MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel_login23MouseExited(evt);
            }
        });

        Modificar.setBackground(new java.awt.Color(247, 199, 196));
        Modificar.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        Modificar.setForeground(new java.awt.Color(249, 249, 249));
        Modificar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Modificar.setText("MODIFICAR");
        Modificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Modificar.setEnabled(false);
        Modificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ModificarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ModificarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ModificarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_login23Layout = new javax.swing.GroupLayout(panel_login23);
        panel_login23.setLayout(panel_login23Layout);
        panel_login23Layout.setHorizontalGroup(
            panel_login23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Modificar, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
        );
        panel_login23Layout.setVerticalGroup(
            panel_login23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_login23Layout.createSequentialGroup()
                .addComponent(Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panel_login24.setBackground(new java.awt.Color(246, 150, 143));
        panel_login24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_login24MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel_login24MouseExited(evt);
            }
        });

        Materiales.setBackground(new java.awt.Color(247, 199, 196));
        Materiales.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        Materiales.setForeground(new java.awt.Color(249, 249, 249));
        Materiales.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Materiales.setText("MATERIAL");
        Materiales.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Materiales.setEnabled(false);
        Materiales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MaterialesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MaterialesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MaterialesMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_login24Layout = new javax.swing.GroupLayout(panel_login24);
        panel_login24.setLayout(panel_login24Layout);
        panel_login24Layout.setHorizontalGroup(
            panel_login24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Materiales, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        panel_login24Layout.setVerticalGroup(
            panel_login24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_login24Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Materiales, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

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

        exit_panel.setBackground(new java.awt.Color(27, 27, 27));
        exit_panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exit_panelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exit_panelMouseExited(evt);
            }
        });

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
            .addComponent(exit_label, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        exit_panelLayout.setVerticalGroup(
            exit_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exit_label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout selectorLayout = new javax.swing.GroupLayout(selector);
        selector.setLayout(selectorLayout);
        selectorLayout.setHorizontalGroup(
            selectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selectorLayout.createSequentialGroup()
                .addComponent(exit_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        selectorLayout.setVerticalGroup(
            selectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exit_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jScrollPane6)
                        .addContainerGap())
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(Campo_combo5, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Registro_field5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel_login22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(128, 128, 128))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(panel_login20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panel_login23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel_login21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel_login24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 77, Short.MAX_VALUE))))
            .addComponent(selector, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(selector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(panel_login23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panel_login20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panel_login21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(panel_login24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel_login22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Campo_combo5)
                    .addComponent(Registro_field5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Tb_clientes5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tb_clientes5MouseClicked
        // TODO add your handling code here:
        
        if(material == false){
            try {
                //Cmaquinas maquinas = new Cmaquinas();
                new Ccompras().seleccionarCompra(Tb_clientes5, Registro_field5, Campo_combo5);
                
                String idm = new Menu().seleccionarParam(Tb_clientes5, 0);
                String fecham = new Menu().seleccionarParam(Tb_clientes5, 1);
                String provedorm = new Menu().seleccionarParam(Tb_clientes5, 2);
                
                
                mod.setCompra(idm, fecham, provedorm);
                ins.setId(idm);
                view.setId(Integer.parseInt(idm));
                
                Modificar.setEnabled(true);
                Materiales.setEnabled(true);
                
                
            } catch (SQLException ex) {
                Logger.getLogger(Compras.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                new Ccompras().seleccionarCompra(Tb_clientes5, Registro_field5, Campo_combo5);
                String idm = new Menu().seleccionarParam(Tb_clientes5, 0);
                String materialm = new Menu().seleccionarParam(Tb_clientes5, 1);
                String cantidadm = new Menu().seleccionarParam(Tb_clientes5, 2);
                
                modp.setMod(idm, materialm, cantidadm);
                
            } catch (SQLException ex) {
                Logger.getLogger(Compras.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            
    }//GEN-LAST:event_Tb_clientes5MouseClicked

    private void login_btm22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login_btm22MouseClicked
        // TODO add your handling code here:
        
        if (material == false)
        { 
            try {
                new compras_insert().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Compras.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
           ins.setVisible(true);
        }
        
    }//GEN-LAST:event_login_btm22MouseClicked

    private void login_btm22MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login_btm22MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_login_btm22MouseEntered

    private void login_btm22MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login_btm22MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_login_btm22MouseExited

    private void panel_login20MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_login20MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_panel_login20MouseEntered

    private void panel_login20MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_login20MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_panel_login20MouseExited

    private void login_btm23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login_btm23MouseClicked
        // TODO add your handling code here:
        new Ccompras().mostrarCompras(Tb_clientes5);
        material = false;
    }//GEN-LAST:event_login_btm23MouseClicked

    private void login_btm23MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login_btm23MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_login_btm23MouseEntered

    private void login_btm23MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login_btm23MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_login_btm23MouseExited

    private void panel_login21MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_login21MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_panel_login21MouseEntered

    private void panel_login21MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_login21MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_panel_login21MouseExited

    private void login_btm24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login_btm24MouseClicked
        // TODO add your handling code here:
        new Ccompras().buscarCompra(Tb_clientes5, Campo_combo5, Registro_field5);
        Registro_field5.setText("");
        Campo_combo5.setSelectedIndex(0);
    }//GEN-LAST:event_login_btm24MouseClicked

    private void login_btm24MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login_btm24MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_login_btm24MouseEntered

    private void login_btm24MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login_btm24MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_login_btm24MouseExited

    private void panel_login22MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_login22MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_panel_login22MouseEntered

    private void panel_login22MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_login22MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_panel_login22MouseExited

    private void Campo_combo5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Campo_combo5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Campo_combo5ActionPerformed

    private void ModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ModificarMouseClicked
        // TODO add your handling code here:
        
        if(material == false){
            mod.setVisible(true);
        }
        else{
            modp.setVisible(true);
        }
        
    }//GEN-LAST:event_ModificarMouseClicked

    private void ModificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ModificarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_ModificarMouseEntered

    private void ModificarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ModificarMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_ModificarMouseExited

    private void panel_login23MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_login23MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_panel_login23MouseEntered

    private void panel_login23MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_login23MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_panel_login23MouseExited

    private void MaterialesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MaterialesMouseClicked
        // TODO add your handling code here:
        view.mostrarInsumo(Tb_clientes5);
        material = true;
    }//GEN-LAST:event_MaterialesMouseClicked

    private void MaterialesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MaterialesMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_MaterialesMouseEntered

    private void MaterialesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MaterialesMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_MaterialesMouseExited

    private void panel_login24MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_login24MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_panel_login24MouseEntered

    private void panel_login24MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_login24MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_panel_login24MouseExited

    private void exit_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_labelMouseClicked
        setVisible(false);
    }//GEN-LAST:event_exit_labelMouseClicked

    private void exit_labelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_labelMouseEntered
        exit_panel.setBackground(Color.red);
    }//GEN-LAST:event_exit_labelMouseEntered

    private void exit_labelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_labelMouseExited

        exit_panel.setBackground(Color.decode("#1b1b1b"));
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
            java.util.logging.Logger.getLogger(Compras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Compras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Compras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Compras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Compras().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Compras.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Campo_combo5;
    private javax.swing.JLabel Materiales;
    private javax.swing.JLabel Modificar;
    private javax.swing.JTextField Registro_field5;
    private javax.swing.JTable Tb_clientes5;
    private javax.swing.JLabel exit_label;
    private javax.swing.JPanel exit_panel;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel login_btm22;
    private javax.swing.JLabel login_btm23;
    private javax.swing.JLabel login_btm24;
    private javax.swing.JPanel panel_login20;
    private javax.swing.JPanel panel_login21;
    private javax.swing.JPanel panel_login22;
    private javax.swing.JPanel panel_login23;
    private javax.swing.JPanel panel_login24;
    private javax.swing.JPanel selector;
    // End of variables declaration//GEN-END:variables
}
