/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app;

import java.beans.Statement;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author oscar
 */
public class Cmanten {
    
    private int id, material, cantidad;
    private String nombre, proporcion;
    private boolean activo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaterial() {
        return material;
    }

    public void setMaterial(int material) {
        this.material = material;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProporcion() {
        return proporcion;
    }

    public void setProporcion(String proporcion) {
        this.proporcion = proporcion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    public void buscarInsumo(JTable para_clientes, JComboBox campo, JTextField busqueda) {
        String bsq = busqueda.getText();
        String cam = campo.getSelectedItem().toString();
        
        Cconexion conexion = new Cconexion();
        DefaultTableModel modelo = new DefaultTableModel();
        String sql = "select * from compra_plus where "+cam+" = '"+bsq+"';";
        
        modelo.addColumn("ID");
        modelo.addColumn("Material");
        modelo.addColumn("Cantidad");
        
        String[] datos = new String[3];
        
        try{
            java.sql.Statement st = conexion.EstablecerConexion().createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                
                modelo.addRow(datos);
            }
            para_clientes.setModel(modelo);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void insumoModificar(JLabel compra, JComboBox material, JTextField cantidad) throws SQLException{
        Cconexion conexion = new Cconexion();
        try{
        String id_insumo = "select material_id from insumos_en_stock where nombre = '"+material.getSelectedItem().toString()+"';";
        java.sql.Statement st = conexion.EstablecerConexion().createStatement();
        java.sql.ResultSet rs = st.executeQuery(id_insumo);
        int num = 0;
        while(rs.next())
        num = rs.getInt(1);
        
        String update = "update compra_materiales set material = ?, cantidad = ? where id = "+compra.getText()+";";
        
            java.sql.CallableStatement cs = conexion.EstablecerConexion().prepareCall(update);
            cs.setInt(1, num);
            cs.setInt(2, Integer.parseInt(cantidad.getText()));
            cs.execute();
            
            JOptionPane.showMessageDialog(null,"Se modfico correctamente la información","INSERTAR",JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void insumoInsertar(JLabel compra, JComboBox material, JTextField cantidad) throws SQLException{
        Cconexion conexion = new Cconexion();
        try{
        String id_insumo = "select material_id from insumos_en_stock where nombre = '"+material.getSelectedItem().toString()+"';";
        java.sql.Statement st = conexion.EstablecerConexion().createStatement();
        java.sql.ResultSet rs = st.executeQuery(id_insumo);
        int num = 0;
        while(rs.next())
        num = rs.getInt(1);
        String sql = "insert into compra_materiales(compra, material, cantidad) values(?,?,?);";
        
        
            java.sql.CallableStatement cs = conexion.EstablecerConexion().prepareCall(sql);
            cs.setInt(1, Integer.parseInt(compra.getText()));
            cs.setInt(2, num);
            cs.setInt(3, Integer.parseInt(cantidad.getText()));
            cs.execute();
            
            JOptionPane.showMessageDialog(null,"Se ingreso correctamente la información","INSERTAR",JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void mostrarInsumo(JTable para_maquinas){
    Cconexion conexion = new Cconexion();
        
    DefaultTableModel modelo = new DefaultTableModel();
    
    String sql = "select id,nombre,cantidad from compra_plus where compra = "+getId()+";";
        
    modelo.addColumn("ID");
    modelo.addColumn("Material");
    modelo.addColumn("Cantidad");
    
    String[] datos = new String[3];
        
    java.sql.Statement st;
    
    try{
            st = conexion.EstablecerConexion().createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                
                modelo.addRow(datos);
            }
            
            para_maquinas.setModel(modelo);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void mostrarManten(JTable para_maquinas){
    Cconexion conexion = new Cconexion();
        
    DefaultTableModel modelo = new DefaultTableModel();
        
    String sql = "select * from vista_mantenimientos;";
        
    modelo.addColumn("ID");
    modelo.addColumn("Proyecto");
    modelo.addColumn("Fecha inicial");
    modelo.addColumn("Fecha final");
    modelo.addColumn("Personal");
    
    String[] datos = new String[5];
        
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
                
                modelo.addRow(datos);
            }
            
            para_maquinas.setModel(modelo);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void insertarCompra(JTextField fecha, JComboBox provedor) {
        
        Cconexion conexion = new Cconexion();
        try{
            
        String id_p = "select provedor_id from provedores where nombre = '"+provedor.getSelectedItem().toString()+"';";
        java.sql.Statement stp = conexion.EstablecerConexion().createStatement();
        java.sql.ResultSet rsp = stp.executeQuery(id_p);
        int num_p = 0;
        while(rsp.next()){
        num_p = rsp.getInt(1);
        }
            
        String sql = "insert into compras (fecha, provedor) values('"+fecha.getText()+"','"+num_p+"');";
        java.sql.Statement st = conexion.EstablecerConexion().createStatement();
        st.execute(sql);
            JOptionPane.showMessageDialog(null,"Se ingreso correctamente la información","INSERTAR",JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void seleccionarCompra(JTable Para_clientes, JTextField busqueda, JComboBox campo) {
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
    
    public void modificarCompra(JLabel id, JTextField fecha, JComboBox provedores){
        Cconexion conexion = new Cconexion();
        
        int idp = 0;
        
        try{
        String sql_id = "select provedor_id from provedores where nombre = '"+provedores.getSelectedItem()+"';";
        java.sql.Statement st = conexion.EstablecerConexion().createStatement();
        java.sql.ResultSet rs = st.executeQuery(sql_id);
        
        while(rs.next())
        idp = rs.getInt(1);
            
        String update = "update compras set fecha = '"+fecha.getText()+"', provedor = "+idp+" where id = "+id.getText()+";";
        java.sql.Statement stm = conexion.EstablecerConexion().createStatement();
        stm.execute(update); 
        
        JOptionPane.showMessageDialog(null,"Se Modifico correctamente la información","MODIFICAR",JOptionPane.INFORMATION_MESSAGE);

        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,e.toString(),"Error",JOptionPane.ERROR_MESSAGE);

        }
    }
    
    public void buscarCompra(JTable para_clientes, JComboBox campo, JTextField busqueda) {
        String bsq = busqueda.getText();
        String cam = campo.getSelectedItem().toString();
        
        Cconexion conexion = new Cconexion();
        DefaultTableModel modelo = new DefaultTableModel();
        String sql = "select * from vista_compras where "+cam+" = '"+bsq+"';";
        
        modelo.addColumn("ID");
        modelo.addColumn("Fecha");
        modelo.addColumn("Proveedor");
        modelo.addColumn("Materiales");
        
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
}
