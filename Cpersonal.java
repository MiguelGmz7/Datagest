/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author oscar
 */
public class Cpersonal {
    private int personal_id;
    private String nombre_1, nombre_2, apellidos, puesto, email, password, telefono;
    private boolean activo;

    public int getPersonal_id() {
        return personal_id;
    }

    public void setPersonal_id(int personal_id) {
        this.personal_id = personal_id;
    }

    public String getNombre_1() {
        return nombre_1;
    }

    public void setNombre_1(String nombre_1) {
        this.nombre_1 = nombre_1;
    }

    public String getNombre_2() {
        return nombre_2;
    }

    public void setNombre_2(String nombre_2) {
        this.nombre_2 = nombre_2;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
    
    public void mostrarPersonal(JTable para_clientes){
        Cconexion conexion = new Cconexion();
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        String sql = "";
        
        modelo.addColumn("ID");
        modelo.addColumn("Nombre_1");
        modelo.addColumn("Nombre_2");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Puesto");
        modelo.addColumn("Email");
        modelo.addColumn("Telefono");
        modelo.addColumn("Activo");
        
        sql = "select * from personal;";
        
        String[] datos = new String[8];
        
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
                datos[6] = rs.getString(8);
                datos[7] = rs.getString(9);
                
                modelo.addRow(datos);
            }
            
            para_clientes.setModel(modelo);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void insertarPersonal(JTextField nombre_1, JTextField nombre_2, JTextField apellidos, JTextField puesto, JTextField email, JTextField password, JTextField telefono, JRadioButton activo) throws NoSuchAlgorithmException {
        setNombre_1(nombre_1.getText());
        
        setNombre_2(nombre_2.getText());
        
        setApellidos(apellidos.getText());
        
        setPuesto(puesto.getText());
        
        setEmail(email.getText());
        
        String hash = new Encript().Sha1(getEmail(), password.getText());
        
        setPassword(hash);
        
        setTelefono(telefono.getText());
        
        setActivo(activo.isSelected());
        
        Cconexion conexion = new Cconexion();
        
        String sql = "insert into personal(nombre_1, nombre_2, apellidos, puesto, email, password, telefono, activo) values(?,?,?,?,?,?,?,?);";
        
        try{
            java.sql.CallableStatement cs = conexion.EstablecerConexion().prepareCall(sql);
            cs.setString(1, getNombre_1());
            cs.setString(2, getNombre_2());
            cs.setString(3, getApellidos());
            cs.setString(4, getPuesto());
            cs.setString(5, getEmail());
            cs.setString(6, getPassword());
            cs.setString(7, getTelefono());
            cs.setBoolean(8, isActivo());
            cs.execute();
            
            JOptionPane.showMessageDialog(null,"Se ingreso correctamente la información","INSERTAR",JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void SeleccionarPersonal(JTable Para_clientes, JTextField busqueda, JComboBox campo){
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
    
    public void BuscarPersonal(JTable para_clientes, JComboBox campo, JTextField busqueda) {
        String bsq = busqueda.getText();
        String cam = campo.getSelectedItem().toString();
        
        Cconexion conexion = new Cconexion();
        DefaultTableModel modelo = new DefaultTableModel();
        String sql = "select * from personal where "+cam+" = '"+bsq+"';";
        
        
        modelo.addColumn("ID");
        modelo.addColumn("Nombre_1");
        modelo.addColumn("Nombre_2");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Puesto");
        modelo.addColumn("Email");
        modelo.addColumn("Telefono");
        modelo.addColumn("Activo");
        
        String[] datos = new String[8];
        
        try{
            java.sql.Statement st = conexion.EstablecerConexion().createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(8);
                datos[7] = rs.getString(9);
                modelo.addRow(datos);
            }
            para_clientes.setModel(modelo);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public String seleccionarParam(JTable Para_clientes,int index) {
        String Activo = null;
        try{
        int fila = Para_clientes.getSelectedRow();
        
        if(fila >= 0) {
                Activo = Para_clientes.getValueAt(fila, index).toString(); 
        } else {
            JOptionPane.showMessageDialog(null, "Fila No Seleccionada");
        }
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error:\n "+e.toString());
        }
        return Activo;
    }
    
     public void modificarPersonal(String prenombre, JTextField nombre_1, JTextField nombre_2, JTextField apellidos, JTextField puesto, JTextField email, JTextField telefono, JRadioButton activo) throws NoSuchAlgorithmException {
        try{
        String sql_id = "select personal_id from personal where nombre_1 = '"+prenombre+"';";
        Cconexion conexion = new Cconexion();
        
        java.sql.Statement st = conexion.EstablecerConexion().createStatement();
        java.sql.ResultSet rs = st.executeQuery(sql_id);
        
        if(rs.next()){
            String id = rs.getString("personal_id");
            
            setNombre_1(nombre_1.getText());
        
            setNombre_2(nombre_2.getText());
        
            setApellidos(apellidos.getText());
        
            setPuesto(puesto.getText());
        
            setEmail(email.getText());
        
        
            setTelefono(telefono.getText());
        
            setActivo(activo.isSelected());
            
            String update = "update personal set nombre_1 = ?, nombre_2 = ?, apellidos = ?, puesto = ?, email = ?, telefono = ?, activo = ? where personal_id = "+id+";";
            
        java.sql.CallableStatement cs = conexion.EstablecerConexion().prepareCall(update);
            cs.setString(1, getNombre_1());
            cs.setString(2, getNombre_2());
            cs.setString(3, getApellidos());
            cs.setString(4, getPuesto());
            cs.setString(5, getEmail());
            cs.setString(6, getTelefono());
            cs.setBoolean(7, isActivo());
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
