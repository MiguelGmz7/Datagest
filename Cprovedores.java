/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app;

import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author oscar
 */
public class Cprovedores {
    private int provedor_id;
    private String nombre, email, telefono;
    private boolean activo;

    public int getProvedor_id() {
        return provedor_id;
    }

    public void setProvedor_id(int provedor_id) {
        this.provedor_id = provedor_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    
    public void mostrarProvedor(JTable para_clientes){
        Cconexion conexion = new Cconexion();
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        String sql = "";
        
        modelo.addColumn("Nombre");
        modelo.addColumn("Email");
        modelo.addColumn("Telefono");
        modelo.addColumn("Activo");
        
        sql = "select * from provedores;";
        
        String[] datos = new String[4];
        
        java.sql.Statement st;
        
        try{
            st = conexion.EstablecerConexion().createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()) {
                datos[0] = rs.getString(2);
                datos[1] = rs.getString(3);
                datos[2] = rs.getString(4);
                datos[3] = rs.getString(5);
                
                modelo.addRow(datos);
            }
            
            para_clientes.setModel(modelo);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void InsertarProvedor(JTextField nombre, JTextField email, JTextField telefono, JRadioButton activo) {
        setNombre(nombre.getText());
        setEmail(email.getText());
        setTelefono(telefono.getText());
        setActivo(activo.isSelected());
        
        Cconexion conexion = new Cconexion();
        
        String sql = "insert into provedores (nombre, email, telefono, activo) values(?, ?, ?, ?);";
        
        try{
            java.sql.CallableStatement cs = conexion.EstablecerConexion().prepareCall(sql);
            cs.setString(1, getNombre());
            cs.setString(2, getEmail());
            cs.setString(3, getTelefono());
            cs.setBoolean(4, isActivo());
            cs.execute();
            
            JOptionPane.showMessageDialog(null,"Se ingreso correctamente la información","INSERTAR",JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void SeleccionarProvedor(JTable Para_clientes, JTextField busqueda, JComboBox campo) {
        try {
            int fila = Para_clientes.getSelectedRow();
            int colum = Para_clientes.getSelectedColumn();
            
            
            if(fila >= 0) {
                busqueda.setText(Para_clientes.getValueAt(fila, colum).toString());
                campo.setSelectedIndex(colum + 1);
                
            } else {
                JOptionPane.showMessageDialog(null, "Fila No Seleccionada");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error:\n "+e.toString());
        }
    }
    
    public void BuscarProvedor(JTable para_clientes, JComboBox campo, JTextField busqueda) {
        String bsq = busqueda.getText();
        String cam = campo.getSelectedItem().toString();
        
        Cconexion conexion = new Cconexion();
        DefaultTableModel modelo = new DefaultTableModel();
        String sql = "select * from provedores where "+cam+" = '"+bsq+"';";
        
        modelo.addColumn("Nombre");
        modelo.addColumn("Email");
        modelo.addColumn("Telefono");
        modelo.addColumn("Activo");
        
        String[] datos = new String[4];
        
        try{
            java.sql.Statement st = conexion.EstablecerConexion().createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                datos[0] = rs.getString(2);
                datos[1] = rs.getString(3);
                datos[2] = rs.getString(4);
                datos[3] = rs.getString(5);
                
                modelo.addRow(datos);
            }
            para_clientes.setModel(modelo);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void modificarProvedor(String prenombre, JTextField nombre, JTextField email, JTextField telefono, JRadioButton activo) throws SQLException {
        try{
        String sql_id = "select  provedor_id from provedores where nombre = '"+prenombre+"';";
        Cconexion conexion = new Cconexion();
        
        java.sql.Statement st = conexion.EstablecerConexion().createStatement();
        java.sql.ResultSet rs = st.executeQuery(sql_id);
        
        if(rs.next()){
            String id = rs.getString("provedor_id");
            
            setNombre(nombre.getText());
            setEmail(email.getText());
            setTelefono(telefono.getText());
            setActivo(activo.isSelected());
            
            String update = "update provedores set nombre = ?, email = ?, telefono = ?, activo = ? where provedor_id = "+id+";";
        java.sql.CallableStatement cs = conexion.EstablecerConexion().prepareCall(update);
            cs.setString(1, getNombre());
            cs.setString(2, getEmail());
            cs.setString(3, getTelefono());
            cs.setBoolean(4, isActivo());
            cs.execute();
        JOptionPane.showMessageDialog(null,"Se Modifico correctamente la información","MODIFICAR",JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,"No se puede agregar un registro solo modificar","Error",JOptionPane.ERROR_MESSAGE);
        }
       
        

        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,e.toString(),"Error",JOptionPane.ERROR_MESSAGE);

        }
    }
}
