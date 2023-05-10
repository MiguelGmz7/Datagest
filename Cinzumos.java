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
public class Cinzumos {
    private int material_id;
    private String nombre, cantidad;
    private boolean activo;
    
    public int getMaterial_id() {
        return material_id;
    }

    public void setMaterial_id(int material_id) {
        this.material_id = material_id;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    public void MostrarInzumos(JTable para_clientes) {
        
        Cconexion conexion = new Cconexion();
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        String sql = "";
        
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Activo");
        
        sql = "select * from insumos_en_stock;";
        
        String[] datos = new String[4];
        
        java.sql.Statement st;
        
        try{
            st = conexion.EstablecerConexion().createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                
                modelo.addRow(datos);
            }
            
            para_clientes.setModel(modelo);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void InsertarInsumos(JTextField nombre, JTextField cantidad, JRadioButton activo) {
        setNombre(nombre.getText());
        
        setCantidad(cantidad.getText());
        
        setActivo(activo.isSelected());
        
        Cconexion conexion = new Cconexion();
        
        String sql = "insert into insumos_en_stock (nombre, cantidad, activo) values(?, ?, ?);";
        
        try{
            java.sql.CallableStatement cs = conexion.EstablecerConexion().prepareCall(sql);
            cs.setString(1, getNombre());
            cs.setInt(2, Integer.parseInt(getCantidad()));
            cs.setBoolean(3, isActivo());
            cs.execute();
            
            JOptionPane.showMessageDialog(null,"Se ingreso correctamente la información","INSERTAR",JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void BuscarInsumo(JTable para_clientes, JComboBox campo, JTextField busqueda){
        String bsq = busqueda.getText();
        String cam = campo.getSelectedItem().toString();
        
        Cconexion conexion = new Cconexion();
        DefaultTableModel modelo = new DefaultTableModel();
        String sql = "select * from insumos_en_stock where "+cam+" = '"+bsq+"';";
        
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Activo");
        
        String[] datos = new String[4];
        
        try{
            java.sql.Statement st = conexion.EstablecerConexion().createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                
                modelo.addRow(datos);
            }
            para_clientes.setModel(modelo);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void SeleccionarInsumos(JTable Para_clientes, JTextField busqueda, JComboBox campo){
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
    
    public String seleccionarActivo(JTable Para_clientes) {
        String Activo = null;
        try{
        int fila = Para_clientes.getSelectedRow();
        
        if(fila >= 0) {
                Activo = Para_clientes.getValueAt(fila, 2).toString(); 
        } else {
            JOptionPane.showMessageDialog(null, "Fila No Seleccionada");
        }
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "3Error:\n "+e.toString());
        }
        return Activo;
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
            JOptionPane.showMessageDialog(null, "1Error:\n "+e.toString());
        }
        return Nombre;
    }
    public String seleccionarCantidad(JTable Para_clientes) {
        String Cantidad = null;
        try{
        int fila = Para_clientes.getSelectedRow();
        
        if(fila >= 0) {
                Cantidad = Para_clientes.getValueAt(fila, 1).toString(); 
        } else {
            JOptionPane.showMessageDialog(null, "Fila No Seleccionada");
        }
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "2Error:\n "+e.toString());
        }
        return Cantidad;
    }
    
    public void modificarInzumo(String prenombre, JTextField nombre, JTextField cantidad, JRadioButton activo) {
        try{
        String sql_id = "select material_id from insumos_en_stock where nombre = '"+prenombre+"';";
        Cconexion conexion = new Cconexion();
        
        java.sql.Statement st = conexion.EstablecerConexion().createStatement();
        java.sql.ResultSet rs = st.executeQuery(sql_id);
        
        if(rs.next()){
            String id = rs.getString("material_id");
            
            setNombre(nombre.getText());
            setCantidad(cantidad.getText());
            setActivo(activo.isSelected());
            
            String update = "update insumos_en_stock set nombre = ?, cantidad = ?, activo = ? where material_id = "+id+";";
            
        java.sql.CallableStatement cs = conexion.EstablecerConexion().prepareCall(update);
            cs.setString(1, getNombre());
            cs.setString(2, getCantidad());
            cs.setBoolean(3, isActivo());
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
