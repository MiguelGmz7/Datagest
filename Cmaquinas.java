/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app;

import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author oscar
 */
public class Cmaquinas {
    
    private int maquina_id, materiales;
    private String nombre, proporcion;
    private boolean activo;

    public int getMaquina_id() {
        return maquina_id;
    }

    public void setMaquina_id(int maquina_id) {
        this.maquina_id = maquina_id;
    }

    public int getMateriales() {
        return materiales;
    }

    public void setMateriales(int materiales) {
        this.materiales = materiales;
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
    
    public void mostrarMaquinas(JTable para_maquinas){
    Cconexion conexion = new Cconexion();
        
    DefaultTableModel modelo = new DefaultTableModel();
        
    String sql = "select * from vista_maquinas;";
        
    modelo.addColumn("ID");
    modelo.addColumn("Nombre");
    modelo.addColumn("Materiales");
    modelo.addColumn("Proporción");
    modelo.addColumn("Activo");
    
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
    
    public void insertartMaquina(JTextField nombre, JTextField proporcion, JRadioButton activo) {
        
        setNombre(nombre.getText());
        setProporcion(proporcion.getText());
        setActivo(activo.isSelected());
        
        Cconexion conexion = new Cconexion();
        
        String sql = "insert into maquinas (nombre, proporcion, activo) values(?, ?, ?);";
        
        try{
            java.sql.CallableStatement cs = conexion.EstablecerConexion().prepareCall(sql);
            cs.setString(1, getNombre());
            cs.setString(2, getProporcion());;
            cs.setBoolean(3, isActivo());
            cs.execute();
            
            JOptionPane.showMessageDialog(null,"Se ingreso correctamente la información","INSERTAR",JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void seleccionarMaquina(JTable Para_clientes, JTextField busqueda, JComboBox campo) {
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
    
    public void modificarMaquina(String id, JTextField nombre, JTextField proporcion, JRadioButton activo){
        try{
        //String sql_id = "select  provedor_id from provedores where nombre = '"+prenombre+"';";
        Cconexion conexion = new Cconexion();
        
        //java.sql.Statement st = conexion.EstablecerConexion().createStatement();
        //java.sql.ResultSet rs = st.executeQuery(sql_id);
        
            //String id = rs.getString("provedor_id");
            
            setNombre(nombre.getText());
            setProporcion(proporcion.getText());
            setActivo(activo.isSelected());
            
            String update = "update maquinas set nombre = ?, proporcion = ?, activo = ? where id = "+id+";";
        java.sql.CallableStatement cs = conexion.EstablecerConexion().prepareCall(update);
            cs.setString(1, getNombre());
            cs.setString(2, getProporcion());
            cs.setBoolean(3, isActivo());
            cs.execute();
        JOptionPane.showMessageDialog(null,"Se Modifico correctamente la información","MODIFICAR",JOptionPane.INFORMATION_MESSAGE);
        
       
        

        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,e.toString(),"Error",JOptionPane.ERROR_MESSAGE);

        }
    }
}
