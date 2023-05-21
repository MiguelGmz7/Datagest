/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class Cproyectos {
    private int id;
    private String nombre, fecha_i, fecha_f, cliente_id, maquina;
    private boolean activo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha_i() {
        return fecha_i;
    }

    public void setFecha_i(String fecha_i) {
        this.fecha_i = fecha_i;
    }

    public String getFecha_f() {
        return fecha_f;
    }

    public void setFecha_f(String fecha_f) {
        this.fecha_f = fecha_f;
    }

    public String getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(String cliente_id) {
        this.cliente_id = cliente_id;
    }

    public String getMaquina() {
        return maquina;
    }

    public void setMaquina(String maquina) {
        this.maquina = maquina;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    
    
    public void mostrarProyecto(JTable para_clientes){
        Cconexion conexion = new Cconexion();
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        String sql = "";
        
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Fecha inicial");
        modelo.addColumn("Fecha final");
        modelo.addColumn("Cliente");
        modelo.addColumn("Maquina");
        modelo.addColumn("Activo");
        
        sql = "select * from vista_proyectos;";
        
        String[] datos = new String[7];
        
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
                datos[6] = rs.getString(7);
                
                modelo.addRow(datos);
            }
            
            para_clientes.setModel(modelo);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void InsertarProyecto(JTextField nombre, JTextField fecha_i, JTextField fecha_f, JComboBox cliente, JComboBox maquina, JRadioButton activo) throws ParseException {
        setNombre(nombre.getText());
        
        setActivo(activo.isSelected());
        
        Cconexion conexion = new Cconexion();
        
        try{
        String sql = "insert into proyectos (nombre, fecha_i, fecha_f, cliente_id, maquina_id, activo) values(?, ?, ?, ?, ?, ?);";
        
        String id_c = "select cliente_id from clientes where nombre = '"+cliente.getSelectedItem().toString()+"';";
        String id_m = "select id from maquinas where nombre = '"+maquina.getSelectedItem().toString()+"';";
        
        java.sql.Statement stc = conexion.EstablecerConexion().createStatement();
        java.sql.ResultSet rsc = stc.executeQuery(id_c);
        
        java.sql.Statement stm= conexion.EstablecerConexion().createStatement();
        java.sql.ResultSet rsm = stm.executeQuery(id_m);
        int num_c = 0;
        int num_m = 0;
        while(rsc.next()){
        num_c = rsc.getInt(1);
        }
        while(rsm.next())
        num_m = rsm.getInt(1);
        
         

            java.sql.CallableStatement cs = conexion.EstablecerConexion().prepareCall(sql);
            cs.setString(1, nombre.getText());
            cs.setString(2, fecha_i.getText());
            cs.setString(3, fecha_f.getText());
            cs.setInt(4, num_c);
            cs.setInt(5, num_m);
            cs.setBoolean(6, isActivo());
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
        
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Email");
        modelo.addColumn("Telefono");
        modelo.addColumn("Activo");
        
        String[] datos = new String[5];
        
        try{
            java.sql.Statement st = conexion.EstablecerConexion().createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                
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
            
            setActivo(activo.isSelected());
            
            String update = "update provedores set nombre = ?, email = ?, telefono = ?, activo = ? where provedor_id = "+id+";";
        java.sql.CallableStatement cs = conexion.EstablecerConexion().prepareCall(update);
            cs.setString(1, getNombre());
            
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
