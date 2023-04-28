/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app;

import java.awt.HeadlessException;
import java.beans.Statement;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author oscar
 */
public class Cclientes {
    
    private int cliente_id;
    private String nombre, email, telefono, direccion;
    private boolean activo;
    
    
    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    public void modificarCliente(String prenombre, JTextField nombre, JTextField email, JTextField telefono, JTextField direccion, JRadioButton activo) throws SQLException {
        try{
        String sql_id = "select cliente_id from clientes where nombre = '"+prenombre+"';";
        Cconexion conexion = new Cconexion();
        
        java.sql.Statement st = conexion.EstablecerConexion().createStatement();
        java.sql.ResultSet rs = st.executeQuery(sql_id);
        
        if(rs.next()){
            String id = rs.getString("cliente_id");
            
            setNombre(nombre.getText());
            setEmail(email.getText());
            setTelefono(telefono.getText());
            setDireccion(direccion.getText());
            setActivo(activo.isSelected());
            
            String update = "update clientes set nombre = ?, email = ?, telefono = ?, direccion = ?, activo = ? where cliente_id = "+id+";";
        java.sql.CallableStatement cs = conexion.EstablecerConexion().prepareCall(update);
            cs.setString(1, getNombre());
            cs.setString(2, getEmail());
            cs.setString(3, getTelefono());
            cs.setString(4, getDireccion());
            cs.setBoolean(5, isActivo());
            cs.execute();
        JOptionPane.showMessageDialog(null,"Se Modifico correctamente la información","MODIFICAR",JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,"No se puede agregar un registro solo modificar","Error",JOptionPane.ERROR_MESSAGE);
        }
       
        

        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,e.toString(),"Error",JOptionPane.ERROR_MESSAGE);

        }
    }
    
    public String seleccionarNombre(JTable Para_clientes) {
        String Nombre = null;
        try{
        int fila = Para_clientes.getSelectedRow();
        
        if(fila >= 0) {
                Nombre = Para_clientes.getValueAt(fila, 0).toString(); 
        } else {
            JOptionPane.showMessageDialog(null, "Fila No Seleccionada");
        }
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error:\n "+e.toString());
        }
        return Nombre;
    }
    
    public String seleccionarEmail(JTable Para_clientes) {
        String Email = null;
        try{
        int fila = Para_clientes.getSelectedRow();
        
        if(fila >= 0) {
                Email = Para_clientes.getValueAt(fila, 1).toString(); 
        } else {
            JOptionPane.showMessageDialog(null, "Fila No Seleccionada");
        }
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error:\n "+e.toString());
        }
        return Email;
    }
    
    public String seleccionarTelefono(JTable Para_clientes) {
        String Telefono = null;
        try{
        int fila = Para_clientes.getSelectedRow();
        
        if(fila >= 0) {
                Telefono = Para_clientes.getValueAt(fila, 2).toString(); 
        } else {
            JOptionPane.showMessageDialog(null, "Fila No Seleccionada");
        }
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error:\n "+e.toString());
        }
        return Telefono;
    }
    
    public String seleccionarDireccion(JTable Para_clientes) {
        String Direc = null;
        try{
        int fila = Para_clientes.getSelectedRow();
        
        if(fila >= 0) {
                Direc = Para_clientes.getValueAt(fila, 3).toString(); 
        } else {
            JOptionPane.showMessageDialog(null, "Fila No Seleccionada");
        }
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error:\n "+e.toString());
        }
        return Direc;
    }
    public String seleccionarActivo(JTable Para_clientes) {
        String Activo = null;
        try{
        int fila = Para_clientes.getSelectedRow();
        
        if(fila >= 0) {
                Activo = Para_clientes.getValueAt(fila, 4).toString(); 
        } else {
            JOptionPane.showMessageDialog(null, "Fila No Seleccionada");
        }
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error:\n "+e.toString());
        }
        return Activo;
    }
    
    public void SeleccionarClientes(JTable Para_clientes, JTextField busqueda, JComboBox campo) {
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
    
    public void BuscarClientes(JTable para_clientes, JComboBox campo, JTextField busqueda) {
        String bsq = busqueda.getText();
        String cam = campo.getSelectedItem().toString();
        
        Cconexion conexion = new Cconexion();
        DefaultTableModel modelo = new DefaultTableModel();
        String sql = "select * from clientes where "+cam+" = '"+bsq+"';";
        
        modelo.addColumn("Nombre");
        modelo.addColumn("Email");
        modelo.addColumn("Telefono");
        modelo.addColumn("Dirección");
        modelo.addColumn("Activo");
        
        String[] datos = new String[5];
        
        try{
            java.sql.Statement st = conexion.EstablecerConexion().createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                datos[0] = rs.getString(2);
                datos[1] = rs.getString(3);
                datos[2] = rs.getString(4);
                datos[3] = rs.getString(5);
                datos[4] = rs.getString(6);
                
                modelo.addRow(datos);
            }
            para_clientes.setModel(modelo);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void MostrarClientes(JTable para_clientes) {
        
        Cconexion conexion = new Cconexion();
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        String sql = "";
        
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Email");
        modelo.addColumn("Telefono");
        modelo.addColumn("Dirección");
        modelo.addColumn("Activo");
        
        sql = "select * from clientes;";
        
        String[] datos = new String[6];
        
        java.sql.Statement st;
        
        try{
            st = conexion.EstablecerConexion().createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                
                modelo.addRow(datos);
            }
            
            para_clientes.setModel(modelo);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void InsertarClientes(JTextField nombre, JTextField email, JTextField telefono, JTextField direccion, JRadioButton activo) {
        setNombre(nombre.getText());
        setEmail(email.getText());
        setTelefono(telefono.getText());
        setDireccion(direccion.getText());
        setActivo(activo.isSelected());
        
        Cconexion conexion = new Cconexion();
        
        String sql = "insert into clientes (nombre, email, telefono, direccion, activo) values(?, ?, ?, ?, ?);";
        
        try{
            java.sql.CallableStatement cs = conexion.EstablecerConexion().prepareCall(sql);
            cs.setString(1, getNombre());
            cs.setString(2, getEmail());
            cs.setString(3, getTelefono());
            cs.setString(4, getDireccion());
            cs.setBoolean(5, isActivo());
            cs.execute();
            
            JOptionPane.showMessageDialog(null,"Se ingreso correctamente la información","INSERTAR",JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
}
