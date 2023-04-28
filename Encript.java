/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 *
 * @author Oscar Miguel Gómez López
 */
public class Encript {
    
    //String password;
    
    public String Sha1(String user, String password) throws NoSuchAlgorithmException{
        
        String union = user + password;
        
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] hash = md.digest(union.getBytes());
        
        String salida = String.valueOf(bytesToHex(hash));
         
        return salida;
    }
    
    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
